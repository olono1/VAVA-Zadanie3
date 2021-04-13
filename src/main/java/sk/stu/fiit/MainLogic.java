/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DADO
 * 
 * TODO: WORK ON SERIALIZATION
 */
public class MainLogic implements Serializable{
    
    private static final long serialVersionUID = 12324L;
    
    private static ArrayList<Accomodation> accd;
    private static ArrayList<Customer> cust;
    private static ArrayList<Reservation> resv;
    
    @XmlElementWrapper(name = "roomList")
    @XmlElement(name = "room")
    private static ArrayList<Room> rooms;
    


    //FIX with Json seriallization
    private File programDataFile;
    
    private MainLogic thisLogic;
    
    private static final Logger logger = Logger.getLogger(MainLogic.class);
    private static Locale progLocale;
    private static ResourceBundle languageBundle;

    public MainLogic(String dataFileName) {
               
        loadOrInicialise(dataFileName);
        
    }
    
    public static void setLocaleAndRBundle(String lang){
        
    }
    
    public static void setLocaleAndRBundle(Locale lang){
        progLocale = lang;
        languageBundle = ResourceBundle.getBundle("localBundle", lang);
    }
    
    
    private void loadOrInicialise(String dateFileName){
        this.programDataFile = new File(dateFileName);
        
        try {
            FileInputStream dataAndSettingImport = new FileInputStream(programDataFile);
            ObjectInputStream MainLogicObjectImport = new ObjectInputStream(dataAndSettingImport);
            MainLogic importedMainLogic = (MainLogic) MainLogicObjectImport.readObject();
            
            
            //MainLogic.accd = importedMainLogic.accd;
            //MainLogic.cust = importedMainLogic.cust;
            //MainLogic.resv = importedMainLogic.resv;
            
            
                    
        } catch (Exception e) {
            
            this.logger.info("Created new Collections - reason: No file found");
            MainLogic.accd = new ArrayList<Accomodation>();
            MainLogic.cust = new ArrayList<>();
            MainLogic.resv = new ArrayList<>();

        }
        

        
    }
    
    
    
    public static void addRoom(Room roomToAdd){
        rooms.add(roomToAdd);
    }
    
    
    
    private void saveData(){
        	
		 try {
			FileOutputStream dataSave = new FileOutputStream(this.programDataFile);
			ObjectOutputStream dataHotelSave = new ObjectOutputStream(dataSave);
			dataHotelSave.writeObject(this);
			dataHotelSave.close();
		} catch (FileNotFoundException e) {
			logger.fatal("File was deleted during app running process. Future data will not be saved. Please restart app.");
			e.printStackTrace();
		} catch (IOException e) {
			logger.fatal("Unknown error while saving file.");
			e.printStackTrace();
		}
	
    }
    
    public static ResourceBundle getLanguageSetting(){
        return languageBundle;
                
    }
    
    
    
    
}
