/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DADO
 */
@XmlRootElement(name = "payment")
public class Payment implements Serializable{
    private static final long serialVersionUID = 12324L;
    
    @XmlElement
    boolean isCash;
    @XmlElement
    private double value;
    @XmlElement
    LocalDateTime dateOfPayment;

    public double getValue() {
        return value;
    }
    
    
    
    
    
}
