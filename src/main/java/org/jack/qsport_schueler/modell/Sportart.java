/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport_schueler.modell;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jack.qsport_schueler.db.DBAnbindung;
/**
 *
 * @author kiesel.christoph
 */
public class Sportart {
    
    private String nameSportart;
    private String art;     // Einzel-/Mannschaftssportart? Sonstige?
    private int anzahl;
    private ArrayList<Student> listeStudent = new ArrayList<Student>();
    
    private ResultSet result;
    private Statement statement;
    private Connection connection;
    
    public Sportart(String name){    
       this.nameSportart = name;
    }
    
    
    public void setNameSporart(String n){
        nameSportart = n;
    }
    
    public String getNameSportart(){
        return nameSportart;
    }
    
    public void setArt(String a){
        art = a;
    }
    
    public String getArt(){
        return art;
    }
    
    public static void main(String[] args){
        DBAnbindung anbindung = new DBAnbindung();
    }
       
}












