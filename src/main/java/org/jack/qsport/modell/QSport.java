package org.jack.qsport.modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author bastian und jannik
 */
public class QSport implements Serializable {

    private ArrayList<Kurs> kurse;//
    //maximale Kurse Pro Halbjahr
    private int anzahlKurse;

    private ArrayList<Student> listeStudent;

    public QSport() {
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

    public void kursHinzufügen(Kurs k) {
        kurse.add(k);
    }

    public void setAnzahlKurse(int anzahlKurse) {
        this.anzahlKurse = anzahlKurse;
    }

    public int getAnzahlKurse() {
        return anzahlKurse;
    }

    public void sortiereKurse() {
        /* 
            Code zum sortieren der Kurse in der Liste der Kurse:
                1. Semester
                2. Sportart-Name
         */
        Collections.sort(kurse, new KursComparator());
    }

    public void sortiereSchüler() {
        /*
        Sortiert nach der Anzahl der Belegungen
         */
        Collections.sort(listeStudent, new StudentComparatorSemBelegt());
    }

    /*
        Gibt ein Feld mit Kursen zurück, dass im gewünschten Semester liegt. 
        @param sem
     */
    public ArrayList<Kurs> getKurseImSemester(Semester sem) {
        ArrayList<Kurs> ausgewaehlt = new ArrayList<>();
        for (Kurs k : kurse) {
            if (k.getSemester().equals(sem)) {
                ausgewaehlt.add(k);
            }
        }
        return ausgewaehlt;
    }

    /*
        Fügt jeden Student in einen Kurs des ersten Semester ein.
     */
    public void einteilung(Semester sem) {
        ArrayList<Kurs> semesterKurse = getKurseImSemester(sem);

        for (Student s : this.getListeStudent()) {
            // System.out.println("* "+s+" *");
            Collections.sort(semesterKurse); // sortieren der Kurse nach anzahlStudent aufsteigend
            gefunden:
            for (Kurs k : semesterKurse) { // Der Reihe nach werden die Kurse durchgegangen
                /*
                Passt die Sportart des Kurse zu dem Wunsch des Studenten, so wird der Student 
                eingetragen. es muss auch gemerkt werden, dass dieser Wunsch bereits vergeben ist.
                 */
                if (k.getAnzahlStudent() >= k.getMaxAnzahl()) {
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    Sportart sa = s.getWahl(i);
                    // System.out.print(""+k.getSportart()+" "+sa+" "+s.istWunschBelegt(i));
                    if (!s.istWunschBelegt(i) && k.getSportart().equals(sa)) {
                        k.getStudentList().add(s);
                        s.setWunschBelegt(i);
                        s.belegeSemester(k.getSemester());
                        break gefunden;
                    } else {
                        //System.out.println(" ungleich");
                    }

                }
                //  System.out.println("kein Wunsch gefunden");
            }
        }
        // Ausgabe aller Kurse im Semester
        System.out.println("*******" + sem + "*******");
        for (Kurs k : semesterKurse) {
            System.out.println("** " + k.getSportart() + ": " + k.getAnzahlStudent());
            for (Student s : k.getStudentList()) {
                System.out.println(s.getName() + ", " + s.getVorname());
            }
        }

    }

    public void einteilung2() {

        //Alle  Kurse holen
        ArrayList<Kurs> kurse = getKurse();
        //************************    Individualsportart erfüllen ***********************************
        for (Student s : this.getListeStudent()) {
            // System.out.println("* "+s+" *");
            Collections.sort(kurse); // sortieren der Kurse nach anzahlStudent aufsteigend
            gefunden:
            for (Kurs k : kurse) { // Der Reihe nach werden die Kurse durchgegangen
                // Ist der Kurs nicht Individualsportart oder voll, so wird der nächste probiert
                if (!k.getSportart().getArt().equals(Art.EINZEL) || k.getAnzahlStudent() >= k.getMaxAnzahl()) {
                    continue;
                }
                /*
                Passt die Sportart des Kurse zu dem Wunsch des Studenten, so wird der Student 
                eingetragen. 
                 */
                for (int i = 0; i < 5; i++) {
                    Sportart sa = s.getWahl(i);
                    // System.out.print(""+k.getSportart()+" "+sa+" "+s.istWunschBelegt(i));
                    if (k.getSportart().equals(sa)) {
                        k.getStudentList().add(s);
                        s.setWunschBelegt(i);
                        s.belegeSemester(k.getSemester());
                        s.getMeineKurse().add(k);
                        break gefunden;
                    }
                }
            }

        }

     
        System.out.println("******* Ausgabe der Zuteilung Individualsportart **************");
        for (Student s : listeStudent) {
            System.out.print(s.getName() + ", " + s.getVorname() + " ");
            for (Kurs k : s.getMeineKurse()) {
                System.out.print(k.toString() + "; ");
            }
            System.out.println();
        }
        
        //************************    Mannschaftssportart erfüllen ***********************************
        for (Student s : this.getListeStudent()) {
            // System.out.println("* "+s+" *");
            Collections.sort(kurse); // sortieren der Kurse nach anzahlStudent aufsteigend
            gefunden:
            for (Kurs k : kurse) { // Der Reihe nach werden die Kurse durchgegangen
                // Ist der Kurs nicht Mannschaftssportart, oder das Semester des Kurses schon belegt
                // oder voll, so wird der nächste probiert

                
                /************
                 * In der nächsten Bedinmgung muss ein Fehler sein, weil kein Schüler, der schon einen 
                 * Kurs belegt hat, einen weiteren zugewiesen bekommt.
                 */
                if (!k.getSportart().getArt().equals(Art.TEAM) || s.istImSemester(k.getSemester()) || k.getAnzahlStudent() >= k.getMaxAnzahl()) {
                    continue;
                }
                /*
                Passt die Sportart des Kurse zu dem Wunsch des Studenten und ist dieser Wunsch noch nicht erfüllt,
                so wird der Student  eingetragen. 
                 */
                for (int i = 1; i < 5; i++) {
                    if(s.istWunschBelegt(i)){
                        continue;
                    }
                    Sportart sa = s.getWahl(i);
                    // System.out.print(""+k.getSportart()+" "+sa+" "+s.istWunschBelegt(i));
                    if (k.getSportart().equals(sa)) {
                        k.getStudentList().add(s);
                        s.setWunschBelegt(i);
                        s.belegeSemester(k.getSemester());
                        s.getMeineKurse().add(k);
                        break gefunden;
                    }
                }
            }

        }

 
        System.out.println("******* Ausgabe der Zuteilung Mannschaftssportart **************");
        for (Student s : listeStudent) {
            System.out.print(s.getName() + ", " + s.getVorname() + " ");
            for (Kurs k : s.getMeineKurse()) {
                System.out.print(k.toString() + "; ");
            }
            System.out.println();
        }

        

 
        System.out.println("******* Ausgabe der Zuteilung Mannschaftssportart **************");
        for (Student s : listeStudent) {
            System.out.print(s.getName() + ", " + s.getVorname() + " ");
            for (Kurs k : s.getMeineKurse()) {
                System.out.print(k.toString() + "; ");
            }
            System.out.println();
        }
        
        //Restliche Wünsche erfüllen

        for (Student s : this.getListeStudent()) {
            // System.out.println("* "+s+" *");
            Collections.sort(kurse); // sortieren der Kurse nach anzahlStudent aufsteigend
            gefunden:
            for (Kurs k : kurse) { // Der Reihe nach werden die Kurse durchgegangen
                /*
                Passt die Sportart des Kurse zu dem Wunsch des Studenten, so wird der Student 
                eingetragen. es muss auch gemerkt werden, dass dieser Wunsch bereits vergeben ist.
                 */
                if (s.istImSemester(k.getSemester()) || k.getAnzahlStudent() >= k.getMaxAnzahl()) {
                    continue;
                }
                for (int i = 2; i < 5; i++) {
                    Sportart sa = s.getWahl(i);
                    // System.out.print(""+k.getSportart()+" "+sa+" "+s.istWunschBelegt(i));
                    if (!s.istWunschBelegt(i) && k.getSportart().equals(sa)) {
                        k.getStudentList().add(s);
                        s.setWunschBelegt(i);
                        s.belegeSemester(k.getSemester());
                        break gefunden;
                    } else {
                        //System.out.println(" ungleich");
                    }

                }
                //  System.out.println("kein Wunsch gefunden");

            }

        }

//        // Ausgabe aller Kurse 
//        System.out.println("******* Ausgabe *******");
//        for (Kurs k : kurse) {
//            System.out.println("***** " + k.getSemester() + "  " + k.getSportart() + ": " + k.getAnzahlStudent());
//            for (Student s : k.getStudentList()) {
//                System.out.println(s.getName() + ", " + s.getVorname());
//            }
//        }
    }

    public void printBelegung() {
        for (Student s : listeStudent) {
            System.out.print(s.getName() + ", " + s.getVorname() + ";");
            for (Kurs k : s.getMeineKurse()) {
                System.out.print(k.getSemester() + " " + k.getSportart() + ";");
            }
            System.out.println();
        }
    }

}

class KursComparator implements Comparator<Kurs> {

    // override the compare() method
    public int compare(Kurs k1, Kurs k2) {
        return k1.getSemester().compareTo(k2.getSemester());
    }
}

class StudentComparatorSemBelegt implements Comparator<Student> {

    // override the compare() method
    public int compare(Student s1, Student s2) {
        return s1.getAnzahlSemBelegt() - (s2.getAnzahlSemBelegt());
    }
}
