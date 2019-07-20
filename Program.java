/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Train;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author User
 */
public class Program {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Program.class);
    
    public static void main(String[] args) {
        FileInputStream ip=null;
        try {
            Properties prop=new Properties();
            ip = new FileInputStream("C:\\omer\\programing\\exercise\\src\\main\\java\\Train\\config.properties");
            prop.load(ip);

            Animal firstAnimal = AnimalFactory.getAnimal(prop.getProperty("firstAnimal"));
            firstAnimal.printName();
            firstAnimal.printSound();
            
            
        } catch (IOException ex) {
           logger.debug("This is debug");
        } finally {
            try {
                ip.close();
            } catch (IOException ex) {
               logger.debug("This is debug");
            }
        }
    }
 
}
