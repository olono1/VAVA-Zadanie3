/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author DADO
 */
@XmlRootElement(name = "customer")
public class Customer implements Serializable{
    
    private static final long serialVersionUID = 12324L;
    

    @XmlElement
    private String name;
    @XmlElement
    private double totalSpent;
    
    public static Customer getInstance(String name){
        Customer customer = new Customer();
        customer.setAttributes(name);
        return customer;
        
    }
    
    private void setAttributes(String name){
        this.name = name;
        this.totalSpent = 0.0;
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }
    
    public void addToTotal(Payment p){
        this.totalSpent += p.getValue();
    }
    
    
    public double getDiscountedPrice(double total){
        total = total - (this.totalSpent*0.01);
        if(total < 0.0){
            total = 0.0;
        }
        return total;
    }
    
    
    
}
