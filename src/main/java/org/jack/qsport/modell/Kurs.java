package org.jack.qsport.modell;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Marius Schmück, Kilian Borst
 */
public class Kurs implements Serializable, Comparable {

    private final Sportart sportart;
    private final Semester semester;
    private final ArrayList<Student> studentList;
    private final int maxAnzahl;
    private final int minAnzahl;

    public Kurs(Sportart sportart, Semester sem, int maxAnzahl, int minAnzahl) {
        this.semester = sem;
        this.sportart = sportart;
        this.maxAnzahl = maxAnzahl;
        this.minAnzahl = minAnzahl;
        studentList = new ArrayList<>();
    }

    public int getMaxAnzahl() {
        return maxAnzahl;
    }

    public int getMinAnzahl() {
        return minAnzahl;
    }

    public Semester getSemester() {
        return semester;
    }

    public Sportart getSportart() {
        return sportart;
    }

    public int getAnzahlStudent() {
        return studentList.size();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    
    public void add(Student s){
        studentList.add(s);
    }
    
    public String toString(){
        return semester.toString()+": "+sportart.toString();
    }
    
    static Kurs getKleinsterKurs(ArrayList<Kurs> kurse){
        Kurs kleinsterKurs = kurse.get(0);
        for(Kurs k: kurse){
            if(k.getAnzahlStudent()<kleinsterKurs.getAnzahlStudent()){
                kleinsterKurs = k;
            }
        }
        return kleinsterKurs;
    }

    @Override
    public int compareTo(Object arg0) {
        Kurs k = (Kurs) arg0;
        int anzahl = k.getAnzahlStudent();
        return this.getAnzahlStudent()-anzahl;
    }
    
    public boolean isInKurs(Student s){
        return studentList.contains(s);
    }

}
