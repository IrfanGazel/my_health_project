package utilities;

import pages.DoctorAppointment;
import pojos.US_01_Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class US_001_TXTWriter {

    public static void saveUiRegistrantData(DoctorAppointment US01Registrant) {
        try {
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.append(US01Registrant.toString() + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUiRegistrantsData(US_01_Registrant[] US01Registrant) {
        try {
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.append(US01Registrant.toString() + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveApiAllRegistrantData(US_01_Registrant[] US01Registrants) {
        try {
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("api_all_registrant_data"), true);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < US01Registrants.length; i++) {
                bw.append(US01Registrants[i].toString() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void saveApiNewRegistrantData(US_01_Registrant[] US01Registrants) {
        try {
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("api_new_registrant_data"), true);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < US01Registrants.length; i++) {
                bw.append(US01Registrants[i].toString() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void saveApiAllPatientsData(List<Object> us15patients) throws IOException {
        try {
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("api_all_patients_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < us15patients.size(); i++) {
                bw.append(us15patients.get(i).toString() + "\n");
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveApiListPatientsData(List<Object> US015Patients) throws IOException {
        try {
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("us_015_patients_data"), true);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < US015Patients.size(); i++) {

                bw.append(US015Patients.get(i) + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}



