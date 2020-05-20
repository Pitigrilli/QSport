/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport.modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author bastian und jannik 
 */
public class QSport implements Serializable
{
    private ArrayList<Kurs> kurse;//
    //maximale Kurse Pro Halbjahr
    private int anzahlKurse;
    //private Kursverwalter k; 
    private ArrayList<Student> listeStudent;
    
    public QSport()
    {
        kurse = new ArrayList<>();
        listeStudent = new ArrayList<>();
    }

    public void setListeStudent(ArrayList<Student> listeStudent) {
        this.listeStudent = listeStudent;
    }

    public ArrayList<Student> getListeStudent() {
        return listeStudent;
    }
    
    public void setKurse(ArrayList kurse) {
        this.kurse = kurse;
    }


    public ArrayList<Kurs> getKurse() {
        return kurse;
    }

    public void kursHinzufügen(Kurs k)
    {
        kurse.add(k);
    }
    
    public void setAnzahlKurse(int anzahlKurse)
    {
        this.anzahlKurse=anzahlKurse;
    }
    
    public int getAnzahlKurse()
    {
        return anzahlKurse;
    }
    
        
    /*
        Gibt ein Feld mit Kursen zurück, dass im gewünschten Semester liegt. 
        @param sem
    */
    public ArrayList<Kurs> getKurse(Semester sem){
        ArrayList<Kurs> ausgewaehlt = new ArrayList<>();
        for(Kurs k: kurse){
            if(k.getSemester().equals(sem)){
                ausgewaehlt.add(k);
            }
        }
        return ausgewaehlt;
    }
            
    
    /*
        Fügt jeden Student in einen Kurs des ersten Semester ein.
    */
    public void einteilung(Semester sem)
    {   
      ArrayList<Kurs> semesterKurse = getKurse(sem);
      for(Student s: this.getListeStudent()){
//          System.out.println("* "+s+" *");
        Collections.sort(semesterKurse); // sortieren der Kurse nach anzahlStudent aufsteigend
        gefunden:
        for(Kurs k: semesterKurse){ // Der Reihe nach werden die Kurse durchgegangen
            /*
                Passt die Sportart des Kurse zu dem Wunsch des Studenten, so wird der Student 
                eingetragen. es muss auch gemerkt werden, dass dieser Wunsch bereits vergeben ist.
            */
            for(int i=0; i<5; i++){
                Sportart sa = s.getWahl(i);
                //System.out.println(""+k.getSportart()+" "+sa+" "+s.isBelegt(i));
                if(!s.isBelegt(i) && k.getSportart().equals(sa)){
                    k.getStudentList().add(s);
                    s.setBelegt(i);
                    break gefunden;
                }
                
            }
            //System.out.println("kein Wunsch gefunden");
            
            
        }
          
      }
      System.out.println("*******"+sem+"*******");
      for(Kurs k: semesterKurse){
          System.out.println("** "+k.getSportart()+": "+k.getAnzahlStudent());
          for(Student s: k.getStudentList()){
              System.out.println(s.getName()+", "+s.getVorname());
          }
      }
    }

}

