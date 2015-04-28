package logic;

import converter.*;
import domain.ContactsEntity;
import domain.SpeaksEntity;
import domain.TelnumbersEntity;
import net.fortuna.ical4j.model.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.ContactRepository;
import repositories.LanguageRepository;
import repositories.OrganisationRepository;
import repositories.PLZRepository;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Lukas on 21.04.2015.
 */
@Component
public class FileParser {

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PLZRepository plzRepository;


    public void run() throws FileNotFoundException, NoSuchMethodException, UnsupportedEncodingException {
        boolean skipFirstLine = false;
        String csvFile = "C:\\Users\\Lukas\\Downloads\\fsimport\\contacts.csv";
        String outputFile = "C:\\Users\\Lukas\\Downloads\\fsimport\\garbages.csv";
        BufferedWriter bw = null;
        BufferedReader br = null;
        OrganisationConverter organisationConverter = new OrganisationConverter(organisationRepository.findAll());
        String line = "";
        String cvsSplitBy = ";";
        HashMap<Integer, String> columnMapping = new HashMap<Integer, String>();
        HashMap<Integer, AbstractConverter> converterMapping = new HashMap<Integer, AbstractConverter>();
        TelnumberConverter numberConverter = new TelnumberConverter();
        AbstractConverter emailConverter = new EmailConverter();
        SpeaksConverter speaksConverter = new SpeaksConverter(languageRepository.findAll());
        AbstractConverter<String> standardConverter = new GeneralStringConverter();
        PLZConverter plzConverter = new PLZConverter(plzRepository.findAll());
        columnMapping.put(0, "Surname");
        columnMapping.put(1, "Name");
        columnMapping.put(2, "OrganisationsByOrganisationsId");
        converterMapping.put(2, organisationConverter);
        columnMapping.put(3, null);
        converterMapping.put(3, emailConverter);
        columnMapping.put(4, null);
        columnMapping.put(5, null);
        columnMapping.put(6, null);
        columnMapping.put(7, "Title");
        converterMapping.put(7, new MaxLengthConverter(45));
        columnMapping.put(8, "State");
        converterMapping.put(8, new StateConverter());
        columnMapping.put(9, null);
        columnMapping.put(10, null);
        columnMapping.put(11, "Emails");
        converterMapping.put(11, emailConverter);
        columnMapping.put(12, null);
        columnMapping.put(13, null);
        columnMapping.put(14, "Hompage");
        columnMapping.put(15, "Info");
        columnMapping.put(16, null);
        columnMapping.put(17, null);
        converterMapping.put(17, numberConverter);
        columnMapping.put(18, null);
        columnMapping.put(19, null);
        columnMapping.put(20, "PostleitzahlByPlz");
        converterMapping.put(20, plzConverter);
        columnMapping.put(21, null);
        columnMapping.put(22, "SpeaksesById");
        converterMapping.put(22, speaksConverter);
        columnMapping.put(23, "Address");
        columnMapping.put(24, null);
        columnMapping.put(25, "Telnumbers");
        converterMapping.put(25, numberConverter);
        columnMapping.put(26, null);
        columnMapping.put(27, "AcademicDegreeBefore");

        br = new BufferedReader(new InputStreamReader(
                new FileInputStream(csvFile), "ISO-8859-15"));
        int lines = 0;
        DecimalFormat df = new DecimalFormat("###0.0");
        try {
            while (br.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(
                new FileInputStream(csvFile), "ISO-8859-15"));
        File file = new File(outputFile);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputFile), "ISO-8859-15"
        ));

        //GET FIRST LINE
        line = getLine(br);
        int currentLine = 0;


        //FOR EVERY LINE IN THE FILE
        while (line != null) {
            boolean failed = false;
            //IF YOU WANT TO SKIP THE FIRST LINE
            if (skipFirstLine) {
                skipFirstLine = false;
                line = getLine(br);
                currentLine++;
                continue;
            }


            //MAKE SURE YOU GET ALL THE LINES THAT MATTERS IN ONE DATASET (INDECATED BY ")
            String[] columns;
            columns = line.split(cvsSplitBy);
            while (columns[columns.length - 1].startsWith("\"")){
                line += getLine(br);
                columns = line.split(cvsSplitBy);
            }

            //NOW WE SHOULD HAVE A COMPLETE LINE AND THE SPLITTED COLUMNS ALREADY
            List<String> values = Arrays.asList(columns);

            if(columnMapping.size() < values.size()) {
                System.out.println("The mapping does not match with the lines");
                System.out.println(line);
                System.out.println(columnMapping.size() + " - " + columns.length);
                toGarbage(bw, line);
                line = getLine(br);
                currentLine++;
                continue;
            }

            //CREATE A NEW CONTACT ENTITY
            ContactsEntity c = new ContactsEntity();

            //MAKE AN ITERATOR OF COURSE
            Iterator<String> columnIterator = Arrays.asList(columns).iterator();
            //INDEX
            int index = -1;
            //ITERATE
            while (columnIterator.hasNext()) {
                index++;
                //THIS IS THE COLUMN VALUE
                String value = columnIterator.next().trim();
                //IF THE MAPPING SHOWS NULL, IT WON'T BE SET IN THE ENTITY
                if (columnMapping.get(index) == null) {
                    continue;
                }
                //OTHERWISE WE MAKE THE SETTER NAME
                String setter = "set" + columnMapping.get(index);
                //IF WE MAPPED A CONVERTER WE USE IT; OTHERWISE WE USE THE STANDARD MAPPER
                AbstractConverter converter = converterMapping.containsKey(index) ? converterMapping.get(index) : standardConverter;
                Class<? extends ContactsEntity> contactClass = c.getClass();
                Class returntype = converter.getClass().getDeclaredMethod("build").getReturnType();
                try {
                    contactClass.getDeclaredMethod(setter, returntype).invoke(c, converter.addValue(value).build());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (CriticalConvertFailException e) {
                    failed = true;
                    break;
                }

            }
            if(failed){
                failed = false;
                toGarbage(bw, line);
                line = getLine(br);
                currentLine++;
                continue;
            }

            c.setCreateDate(new Timestamp(new DateTime().getTime()));
            try {
                if(c.getOrganisationsByOrganisationsId() != null){
                    organisationRepository.save(c.getOrganisationsByOrganisationsId());
                }
                if (c.getSpeaksesById() != null) {
                    for(SpeaksEntity speaksEntity : c.getSpeaksesById()){
                        speaksEntity.getPk().setContactsByContactsPersonId(c);
                    }
                }
                contactRepository.save(c);
            }catch (Exception e){
                toGarbage(bw, line);
                e.printStackTrace();
            }

            line = getLine(br);
            currentLine++;

            System.out.println(df.format( ((double)currentLine/lines) *100) +"% completed");

        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private String getLine(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e1) {
            return null;
        }
    }

    private void toGarbage(BufferedWriter bw, String line){
        try {
            bw.write(line);
            bw.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}


