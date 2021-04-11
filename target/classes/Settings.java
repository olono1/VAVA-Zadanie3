/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author DADO
 */
public class Settings implements Serializable{
    
    private static final long serialVersionUID = 12324L;
    
    private Locale progLocale;
    private ResourceBundle languageBundle;
    

    public Settings() {
        progLocale = new Locale("sk", "SK");
        languageBundle = ResourceBundle.getBundle("localBundle", progLocale);
    }

    public void setProgLocale(Locale progLocale) {
        this.progLocale = progLocale;
    }
    
    public ResourceBundle getRBLanguage(){
        return ResourceBundle.getBundle("localBundle", this.progLocale);
    }
    
    
    
    
    
    
    
}
