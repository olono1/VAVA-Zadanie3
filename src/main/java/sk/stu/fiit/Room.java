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

@XmlRootElement(name = "room")
@XmlType(propOrder = {
    "roomId",
    "roomCtg",
    "note",
    "imagesPaths"
})
public class Room {
    
    private RoomCategory roomCtg;
    private String roomId;
    private String note;
    
    @XmlElementWrapper(name = "roomImages")
    @XmlElement(name = "image")
    private ArrayList<String> imagesPaths;
    
    private static final long serialVersionUID = 12324L;

    public RoomCategory getRoomCtg() {
        return roomCtg;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getNote() {
        return note;
    }

    public ArrayList<String> getImagesPaths() {
        return imagesPaths;
    }

    public Room(RoomCategory roomCtg, String roomId, String note) {
        this.roomCtg = roomCtg;
        this.roomId = roomId;
        this.note = note;
    }
    
    public void addImagePath(String path){
        this.imagesPaths.add(path);
    }
    
    
}
