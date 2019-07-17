package util;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {


    public Properties getProperties() {
       String propertyFilePath = "config/data.properties";
        Properties properties = new Properties ( );
        try {
            // TODO: Add logic to throw error if property is invalid?
            properties.load (new FileInputStream (propertyFilePath));
            properties.putAll (System.getProperties ( ));
        } catch (java.io.IOException e) {
            e.printStackTrace ( );
        }
        return properties;
    }




//    private static void initConfig() {
//        Properties config = null;
//      Properties env ;
//
//       Properties data ;
//       FileInputStream ip ;
//
//        if (config == null) {
//            try {
//                //initialize env properties file
//                env = new Properties();
//                String fileName = "env"+".properties";;
//                fileName = "env" + ".properties";
//                ip = new FileInputStream(System.getProperty("user.dir")+ File.separator + "config" + File.separator+ fileName);
//                env.load(ip);
//              //  log.info("Environment = "+ env.getProperty("Environment"));
//
//                //initialize config properties file
//                config = new Properties ( );
//                String config_fileName = "config.properties";
//                String config_path = System.getProperty ("user.dir") + File.separator + "config" + File.separator + config_fileName;
//                FileInputStream config_ip = new FileInputStream (config_path);
//                config.load (config_ip);
////				log.info("Config file initialized for environment = "+ env.getProperty("Environment"));
//
//                //initialize data properties file
//                data = new Properties ( );
//                String data_fileName = "data.properties";
//                String data_path = System.getProperty ("user.dir") + File.separator + "config" + File.separator + data_fileName;
//                FileInputStream data_ip = new FileInputStream (data_path);
//                data.load (data_ip);
////				log.info("Data file initialized for environment = "+ env.getProperty("Environment"));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace ( );
//            } catch (IOException e) {
//                e.printStackTrace ( );
//            }
//

   //     }
    }































