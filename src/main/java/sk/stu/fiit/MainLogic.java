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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DADO
 * 
 * TODO: WORK ON SERIALIZATION
 */

@XmlRootElement(name = "hoteldata")
public class MainLogic implements Serializable{
    
    private static final long serialVersionUID = 12324L;
    
    @XmlElementWrapper(name = "Accomodations")
    @XmlElement(name = "accomod")
    private static ArrayList<Accomodation> accd;
    
    @XmlElementWrapper(name = "Customers")
    @XmlElement(name = "customer")
    private static ArrayList<Customer> cust;
    
    @XmlElementWrapper(name = "Rezervations")
    @XmlElement(name = "rezervation")
    private static ArrayList<Reservation> resv;
    
    @XmlElementWrapper(name = "roomList")
    @XmlElement(name = "room")
    private static ArrayList<Room> rooms;
    
    private static LocalDate currentDate;
    private static DateTimeFormatter dateFormat;

    //FIX with Json seriallization
    private File programDataFile;
    
    private MainLogic thisLogic;
    private static String datePatern;

    public static DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    
    
    
    
    private static final Logger logger = Logger.getLogger(MainLogic.class);
    private static Locale progLocale;
    private static ResourceBundle languageBundle;

    public MainLogic() {
        dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        currentDate = LocalDate.now();
        loadOrInicialise();
        
    }
    
    public static LocalDate getCurrentDate(){
        return currentDate;
    }
    
    public static void nextDay(){
        currentDate.plusDays(1);
        updateAccomodations();
    }
    
    public static void prevDay(){
        currentDate.minusDays(1);
        updateAccomodations();
    }
    
    
    public static void addCustomer(Customer c){
        for (Customer customer : cust) {
            if(customer.getName().equals(c.getName())){
                logger.warn("Customer with specified name already exists");
            }
        }
        cust.add(c);
    }
    
    private static void updateAccomodations() {
        for (Accomodation accomodation : accd) {
            //Check if active
            if(currentDate.compareTo(accomodation.dateFromGet()) >= 0){
                accomodation.setIsActive(true);
                
            }else{
                accomodation.setIsActive(false);
                accomodation.setIsEnded(false);
            }
                
            //Check if ended
            if(currentDate.compareTo(accomodation.dateToGet()) > 0 ){
                accomodation.setIsActive(false);
                accomodation.setIsEnded(true);
            }
        }
    }
    
    public static void setLocaleAndRBundle(String lang){
        
    }
    
    public static void setLocaleAndRBundle(Locale lang){
        progLocale = lang;
        languageBundle = ResourceBundle.getBundle("localBundle", lang);
    }
    
    
    private void loadOrInicialise(){
        
            
            this.logger.info("Created new Collections - reason: No file found");
            MainLogic.accd = new ArrayList<Accomodation>();
            MainLogic.cust = new ArrayList<>();
            MainLogic.resv = new ArrayList<>();
            MainLogic.rooms = new ArrayList<>();
        
    }
    
    
    
    public static void addRoom(Room roomToAdd){
        rooms.add(roomToAdd);
    }
    
    public static void addAccomodation(Accomodation a){
        accd.add(a);
    }
    
    public static void addResv(Reservation r){
        resv.add(r);
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

    public static ArrayList<Room> getRooms() {
        return rooms;
    }
    
    public void startDashboard(MainLogic m){
        Dashboard hotelDash = new Dashboard(m,languageBundle);
        hotelDash.setVisible(true);
        
    }

    public static ArrayList<Customer> getCustomersList() {
        return cust;
    }

    public static ArrayList<Reservation> getReservationsList() {
        return resv;
    }

    public static ArrayList<Accomodation> getAccommodation() {
        return accd;
    }
    
    
    
    
    
}
