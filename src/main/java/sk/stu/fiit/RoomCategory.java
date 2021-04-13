/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DADO
 */
@XmlRootElement(name = "category")
public class RoomCategory {
    private double pricePerNight;
    private String note;

    public RoomCategory(double pricePerNight, String note) {
        this.pricePerNight = pricePerNight;
        this.note = note;
    }
    
    
}
