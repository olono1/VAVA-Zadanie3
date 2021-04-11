/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DADO
 */
public class Reservation implements Serializable{
    private static final long serialVersionUID = 12324L;
    
    Date from;
    Date to;
    Room room;
    Customer cust;

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCust() {
        return cust;
    }
    
    
}
