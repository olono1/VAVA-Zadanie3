/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author DADO
 */
@XmlRootElement(name = "accomodation")
@XmlType(propOrder = {
    "cust",
    "room",
    "payments",
    "serv",
    "xmlFrom",
    "xmlTo",
    "price",
    "isPayed",
    "isEnded",
    "isActive"
        
        
})
public class Accomodation  implements Serializable{
    private static final long serialVersionUID = 12324L;
    
    
    private Customer cust;
  
    private Room room;
    @XmlElementWrapper(name = "payments")
    @XmlElement(name = "payment")
    private ArrayList<Payment> payments;
    @XmlElementWrapper(name = "services")
    @XmlElement(name="service")
    private ArrayList<Service> serv;
    
    //private LocalDateTime from;
    @XmlElement(name = "date-from")
    private String xmlFrom;
    
    
    //private LocalDateTime to;
    @XmlElement(name = "date-to")
    private String xmlTo;
    @XmlElement
    private double price;
    
    private boolean isPayed;
    
    private boolean isEnded;
   
    private boolean isActive;

    
    public static Accomodation getInstance(Customer cust, Room room, LocalDate from, LocalDate to, double price, boolean isPayed){
        Accomodation accomodation = new Accomodation();
        accomodation.setParameters(cust, room, from, to, price, isPayed);
        return accomodation;
        
    }
    
    public void setParameters(Customer cust, Room room, LocalDate from, LocalDate to, double price, boolean isPayed){
        this.cust = cust;
        this.room = room;
        this.payments = new ArrayList<Payment>();
        
        
        this.xmlFrom = from.format(MainLogic.getDateFormat());
        this.xmlTo = to.format(MainLogic.getDateFormat());
        this.price = price;
    }
    
    public Accomodation(){
        
    }
    
    public void recordPayment(Payment p){
        payments.add(p);
        
    }

    private Accomodation(Customer cust, Room room, LocalDate from, LocalDate to) {
        this.cust = cust;
        this.room = room;
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.xmlFrom = from.format(dtf);
        this.xmlTo = to.format(dtf);
        
        this.payments = new ArrayList<Payment>();
        
        
    }
    
    public double calculateAccmPrice(boolean includeDiscount){
        LocalDate start = dateFromGet();
        LocalDate end = dateToGet();
        
        Period stayTime = Period.between(start, end);
        int dayOfStay = stayTime.getDays();
        
        double pricePerNight = room.getRoomCtg().getPricePerNight();
        double finalPrice = dayOfStay*pricePerNight;
        
        if(includeDiscount == true){
            finalPrice = cust.getDiscountedPrice(finalPrice);
        }
        
        return finalPrice;
        
    }
    
    

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public void setIsEnded(boolean isEnded) {
        this.isEnded = isEnded;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    
    
    
    public static Accomodation getInstanceFromReservation(Reservation r){
        Accomodation accdToReturn = new Accomodation(r.getCust(), r.getRoom(), r.dateFromGet(), r.dateToGet());
        
        return accdToReturn;
    }

    public Customer getCust() {
        return cust;
    }

    public Room getRoom() {
        return room;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public LocalDate dateFromGet() {
        LocalDate dateToReturn = LocalDate.parse(xmlFrom, MainLogic.getDateFormat());
        
        return dateToReturn;
    }

    public LocalDate dateToGet() {
        LocalDate dateToReturn = LocalDate.parse(xmlTo, MainLogic.getDateFormat());
        
        return dateToReturn;
    }

    public double getPrice() {
        return price;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public boolean isIsEnded() {
        return isEnded;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public ArrayList<Service> getServ() {
        return serv;
    }
    
    
    
}
