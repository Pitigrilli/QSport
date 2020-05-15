package org.jack.qsport_schueler.modell;

import java.io.Serializable;
import java.util.Date;
import org.jack.qsport.modell.Sportart;

public class Student implements Serializable {
    
    private String name, vorname, klasse;
    private Date geburtsdatum;
    private Sportart wahl1, wahl2, wahl3, wahl4, wahl5;
    private int score;

    
    
    public Student(String name, String vorname, Date gebdate){
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = gebdate;
    }
 
    
            
    public void setKlasse(String klasse){
        this.klasse = klasse;
    }
    
    public String getKlasse(){
        return klasse;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setVorname(String vorname){
        this.vorname = vorname;
    }
    
    public String getVorname(){
        return vorname;
    }
    
    public void setDatum(Date gebdate){
        this.geburtsdatum = gebdate;
    }
    
    public Date getDatum(){
        return geburtsdatum;
    }
    
    public void setWahl1(Sportart wahl1){
        this.wahl1 = wahl1;
    }
    
    public Sportart getWahl1(){
        return wahl1;
    }
    
    public void setWahl2(Sportart wahl2){
        this.wahl2 = wahl2;
    }
    
    public Sportart getWahl2(){
        return wahl2;
    }
    
    public void setWahl3(Sportart wahl3){
        this.wahl3 = wahl3;
    }
    
    public Sportart getWahl3(){
        return wahl3;
    }
    
    public void setWahl4(Sportart wahl4){
        this.wahl4 = wahl4;
    }
    
    public Sportart getWahl4(){
        return wahl4;
    }
    
    public void setWahl5(Sportart wahl5){
        this.wahl5 = wahl5;
    }
    
    public Sportart getWahl5(){
        return wahl5;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public boolean istWahlErlaubt(){
        boolean i = false;
        if(this.getWahl1() != null && this.getWahl2() != null && this.getWahl3() != null && this.getWahl4() != null && this.getWahl5() != null){
            i = true;
        }
        
        return i;
    }
    
    
    public String toString(){
        return name.toString()+" "+vorname.toString()+" "+geburtsdatum.toString()+" "+wahl1.toString()+" "+wahl2.toString()+" "+wahl3.toString()+" "+wahl4.toString()+" "+wahl5.toString();
    }
}








