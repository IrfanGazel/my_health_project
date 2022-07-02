package utilities;

import pojos.Registrant;

import java.io.FileWriter;

public class TXTWriter {

    public static void saveUiRegistrant(Registrant registrant) {
        try{
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("application_data") , true);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
