package org.jack.qsport_admin.db;

import java.util.ArrayList;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jack.qsport_admin.modell.QSport;
import org.jack.qsport_admin.modell.Student;

/**
 *
 * @author kiesel.christoph
 */
public class Import {

    ArrayList<String> lines;
    ArrayList<Student> studentListe;
    File csvFile;
    DBAnbindung db;
    
    public Import (DBAnbindung db){
        this.db = db;
    }

    private void setcsvFile() {
        JFileChooser chooser = new JFileChooser();

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            csvFile = chooser.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(null, "Keine Datei ausgewählt.");
        }
    }

    private ArrayList<String> readLines(File f) {
        BufferedReader br;
        ArrayList<String> tempLines = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(f), "UTF-8"));

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                tempLines.add(line);
//                System.out.println(line);
            }

        } catch (IOException e) {

        }
        return tempLines;
    }

    private ArrayList<Student> parseLines(ArrayList<String> lines) {
        ArrayList<Student> tempStudentListe = new ArrayList<>();
        for (String line : lines) {
            System.out.println(line);
            line = line.replaceAll("\"", "");

            String[] teile = line.split(",");

            Date geburtsdatum;
            String vorname;
            String name;
            String klasse;

            geburtsdatum = stringToDate(teile[0]);

            name = teile[1];
            vorname = teile[2];
            klasse = teile[3];
            Student s = new Student(name, vorname, geburtsdatum);
            s.setKlasse(klasse);
            tempStudentListe.add(s);
        }
        return tempStudentListe;
    }

    private Date stringToDate(String s) {

        Date result = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            result = dateFormat.parse(s);
        } catch (ParseException e) {
            System.out.println("Fehler beim Parsen des Date-Strings");
            e.printStackTrace();
        }
        return result;
    }
   
    private ArrayList<Student> gibtListe(){
        setcsvFile();
     return parseLines(readLines(csvFile));
    }
    
    public void schreibeInDB(){
        QSport qsp = new QSport();
        qsp.setListeStudent(gibtListe());
       
        db.writeToDB(qsp);
        
        System.out.println("fertig");
    }

    public static void main(String[] args) {
        Import imp = new Import(new DBAnbindung("jsg-kg.fortiddns.com","q11","q11"));
        imp.setcsvFile();
        imp.lines = imp.readLines(imp.csvFile);
//        for (String s : imp.lines) {
//            System.out.println(s);
//        }
        imp.studentListe = imp.parseLines(imp.lines);

        for (Student s : imp.studentListe) {
            System.out.println(s);
            System.out.println(s.getKlasse());
        }
    }
}
