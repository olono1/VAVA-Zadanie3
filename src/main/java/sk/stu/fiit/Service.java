/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author DADO
 */
@XmlRootElement(name = "service")
@XmlType(propOrder = {
    "name",
    "price",
    "description"
})
public class Service implements Serializable{
    
    private static final long serialVersionUID = 12324L;
    
    @XmlElement
    private String name;
    @XmlElement
    private double price;
    @XmlElement
    private String description;
    
}
