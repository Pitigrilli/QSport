/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport_admin.modell;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author bastian und jannik 
 */
public class Student implements Serializable
{
    private String name;
    private Date geburtsdatum;
    private String vorname;
    private Sportart[] wahl = new Sportart[5];
    
    private boolean[] belegt = new boolean[5];

    public void setBelegt(int i) {
        this.belegt[i] = true;
    }

    public boolean isBelegt(int i) {
        return belegt[i];
    }
    
    private int semester;
    private String klasse;
    
    
    //Konstruktor
    
    public Student(String name, String vorname, Date gebdate)
    {
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = gebdate;
        for(int i=0; i < 5;i++){
            wahl[i] = Sportart.Unbekannt;
        }
    }
   
    public void setKlasse(String klasse){
        this.klasse = klasse;
    }
    
    public String getKlasse(){
        return klasse;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getVorname() 
    {
        return vorname;
    }

    public void setVorname(String vorname) 
    {
        this.vorname = vorname;
    }
    
    public Date getDatum() 
    {
        return geburtsdatum;
    }

    public void setDatum(Date gebdate) 
    {
        this.geburtsdatum = gebdate;
    }

    

   public Sportart getWahl(int i){
       return wahl[i];
   } 
    
    
    public void setWahl(int i, Sportart s){
        wahl[i] = s;
    }
   
    
    public boolean equals(Student andererStudent)
    {
        if(this.getName().equalsIgnoreCase(andererStudent.getName()))
        {
            if(this.getVorname().equalsIgnoreCase(andererStudent.getName()))
            {
                if(this.getDatum().equals(andererStudent.getDatum()))
                {
                    return true;
                }else
                    
                {
                    return false;
                }
            }else
            {
                return false;
            }
        }else
        {
            return false;
        }
    } 
     
    
    //@Override
    public String toString()
    {
      String ausgabe = name+" "+vorname+" "
                +geburtsdatum.toString();
      for(Sportart s: wahl){
          ausgabe = ausgabe+" "+s.toString();
      }
      
        return ausgabe;
    }
    
}







