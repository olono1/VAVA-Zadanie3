/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DADO
 */
public class Accomodation  implements Serializable{
    private static final long serialVersionUID = 12324L;
    
    Customer cust;
    Room room;
    ArrayList<Payment> payments;
    Date from;
    Date to;
    double price;
    boolean isPayed;

    public Accomodation(Customer cust, Room room, ArrayList<Payment> payments, Date from, Date to, double price, boolean isPayed) {
        this.cust = cust;
        this.room = room;
        this.payments = payments;
        this.from = from;
        this.to = to;
        this.price = price;
    }



    public Accomodation(Customer cust, Room room, Date from, Date to) {
        this.cust = cust;
        this.room = room;
        this.from = from;
        this.to = to;
        
        this.payments = new ArrayList<Payment>();
        
        
    }
    
    

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }
    
    
    
    
    public static Accomodation getInstanceFromReservation(Reservation r){
        Accomodation accdToReturn = new Accomodation(r.getCust(), r.getRoom(), r.getFrom(), r.getTo());
        
        return accdToReturn;
    }
}
