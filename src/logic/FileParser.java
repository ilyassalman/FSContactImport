package logic;

import builder.ContactBuilder;
import converter.AbstractConverter;
import converter.ArrayConverter;
import converter.LimitedArrayConverter;
import converter.OrganisationConverter;
import converter.StateConverter;
import domain.Organisation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lukas on 21.04.2015.
 */
public class FileParser {

    public void run() throws NoSuchMethodException {

        String csvFile = "/Users/mkyong/Downloads/GeoIPCountryWhois.csv";
        BufferedReader br = null;
        List<Organisation> organisationList = new ArrayList<Organisation>();
        OrganisationConverter organisationConverter = new OrganisationConverter(organisationList);
        String line = "";
        String cvsSplitBy = ";";
        HashMap<Integer, String> columnMapping = new HashMap<Integer, String>();
        HashMap<Integer, AbstractConverter> converterMapping = new HashMap<Integer, AbstractConverter>();
        LimitedArrayConverter numberConverter = new LimitedArrayConverter(2);
        LimitedArrayConverter emailConverter = new LimitedArrayConverter(2);
        columnMapping.put(0, "Surname");
        columnMapping.put(1, "Name");
        columnMapping.put(2, "Organisation");
        converterMapping.put(2, organisationConverter);
        columnMapping.put(3, "Email");
        converterMapping.put(3, emailConverter);
        columnMapping.put(4, null);
        columnMapping.put(5, null);
        columnMapping.put(6, null);
        columnMapping.put(7, "Title");
        columnMapping.put(8, "State");
        converterMapping.put(8, new StateConverter());
        columnMapping.put(9, null);
        columnMapping.put(10, null);
        columnMapping.put(11, "Email");
        converterMapping.put(11, emailConverter);
        columnMapping.put(12, null);
        columnMapping.put(13, null);
        columnMapping.put(14, "Homepage");
        columnMapping.put(15, "Info");
        columnMapping.put(16, "Number");
        converterMapping.put(16, numberConverter);
        columnMapping.put(17, "Number");
        converterMapping.put(17, numberConverter);
        columnMapping.put(18, null);
        columnMapping.put(19, "Town");
        columnMapping.put(20, "PLZ");
        columnMapping.put(21, null);
        columnMapping.put(22, "Languages");
        columnMapping.put(23, "Address");
        columnMapping.put(24, null);
        columnMapping.put(25, null);
        columnMapping.put(26, null);
        columnMapping.put(27, "AcademicDegreeBefore");


            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4]
                        + " , name=" + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }
}
