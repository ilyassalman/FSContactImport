package logic;

import converter.*;
import domain.ContactsEntity;
import domain.TelnumbersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.LanguageRepository;
import repositories.OrganisationRepository;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lukas on 21.04.2015.
 */
@Component
public class FileParser {

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    LanguageRepository languageRepository;


    public void run() throws FileNotFoundException, NoSuchMethodException, UnsupportedEncodingException {
        boolean skipFirstLine = true;
        String csvFile = "C:\\Users\\Lukas\\Downloads\\kontakte.csv";
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
        columnMapping.put(20, "PLZ");
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
        line = getLine(br);
        while (line != null) {
            if (skipFirstLine) {
                skipFirstLine = false;
                line = getLine(br);
                continue;
            }
            ContactsEntity c = new ContactsEntity();
            String[] columns;
            do {
                columns = line.split(cvsSplitBy);
                if (columns[columns.length - 1].startsWith("\"")) {
                    line += getLine(br);
                }
            }
            while (columns[columns.length - 1].startsWith("\""));
            List<String> columnList = Arrays.asList(columns);
            Iterator<String> columnIterator = columnList.iterator();
            int index = -1;
            while (columnIterator.hasNext()) {
                index++;
                String value = columnIterator.next().trim();
                if (columnMapping.get(index) == null) {
                    continue;
                }
                String setter = "set" + columnMapping.get(index);
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
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            line = getLine(br);

        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\Lukas\\Downloads\\org.csv"), "UTF-8"));
        organisationRepository.save(organisationConverter.getOrganisationList());

    }

    private String getLine(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e1) {
            return null;
        }
    }
}


