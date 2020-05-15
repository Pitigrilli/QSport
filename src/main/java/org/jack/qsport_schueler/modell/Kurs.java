package org.jack.qsport_schueler.modell;

import java.util.ArrayList;


/**
 *
 * @author kiesel.christoph
 */
public class Kurs {
    
    private String kursname, semester, sportart;
    private int anzahlStudent, maxAnzahl;
    private ArrayList<Student> studentList;
    
    public Kurs(String kursname, String semester, String sportart, int maxAnzahl){
        this.kursname = kursname;
        this.semester = semester;
        this.sportart = sportart;
        this.maxAnzahl = maxAnzahl;
        anzahlStudent = 0;
        studentList = new ArrayList<Student>();
    }
    
    public void setMaxAnzahl(int maxAnzahl){
        this.maxAnzahl = maxAnzahl;
    }
    
    public int getMaxAnzahl(){
        return maxAnzahl;
    }
    
    public void setKursname(String kursname){
        this.kursname = kursname;
    }
    
    public String getKursname(){
        return kursname;
    }
    
    public void setSemester(String semester){
        this.semester = semester;
    }
    
    public String getSemester(){
        return semester;
    }
    
    public void setSportart(String sportart){
        this.sportart = sportart;
    }
    
    public String getSportart(){
        return sportart;
    }
    
    public void setAnzahlStudent(int anzahlStudent){
        this.anzahlStudent = anzahlStudent;
    }
    
    public int getAnzahlStudent(){
        return anzahlStudent;
    }
    
    public void setStudentList(ArrayList studentList){
        this.studentList = studentList;
    }
    
    public ArrayList getStudentList(){
        return studentList;
    }
    
    @Override
    public String toString(){
        return semester + sportart;
    }
}



