/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DADO
 */
@XmlRootElement(name = "category")
public class RoomCategory {
    @XmlElement
    private double pricePerNight;
    @XmlElement
    private String note;

    public RoomCategory() {
       
    }
    
    private void setAttributes(double pricePerNight, String note){
        this.pricePerNight = pricePerNight;
        this.note = note;
    }
    
    public static RoomCategory getRoomCategoryInstance(double pricePerNight, String note){
        RoomCategory roomCategory = new RoomCategory();
        roomCategory.setAttributes(pricePerNight, note);
        return roomCategory;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
    
    
    
}
