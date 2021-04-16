/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author DADO
 */
@XmlRootElement(name = "reservation")
@XmlType(propOrder = {
    "from",
    "to",
    "room",
    "cust"
})
public class Reservation implements Serializable{
    private static final long serialVersionUID = 12324L;
    
    @XmlElement(name = "date-from")
    String from;
    @XmlElement(name="date-to")
    String to;
    @XmlElement
    Room room;
    @XmlElement
    Customer cust;

    public static Reservation getInstance(LocalDateTime from, LocalDateTime to, Room room, Customer cust){
        Reservation reservation = new Reservation();
        reservation.setAttributes(from, to, room, cust);
        return reservation;
    }
    
    private void setAttributes(LocalDateTime from, LocalDateTime to, Room room, Customer cust)
    {
        this.from = from.format(MainLogic.getDateFormat());
        this.to=to.format(MainLogic.getDateFormat());
        this.room = room;
        this.cust = cust;
    }
    
    public LocalDate dateFromGet() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateToReturn = LocalDate.parse(from, dtf);
        
        return dateToReturn;
    }

    public LocalDate dateToGet() {
        LocalDate dateToReturn = LocalDate.parse(to, MainLogic.getDateFormat());
        
        return dateToReturn;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCust() {
        return cust;
    }
    
    
}
