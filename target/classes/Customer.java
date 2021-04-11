/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DADO
 */
public class Customer implements Serializable{
    
    private static final long serialVersionUID = 12324L;
    
    ArrayList<Service> serv;
    
    String name;
    
}
