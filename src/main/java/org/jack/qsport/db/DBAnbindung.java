/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jack.qsport.modell.QSport;
import org.jack.qsport.modell.Student;
import org.jack.qsport.modell.Sportart;
import org.jack.qsport.modell.Kurs;
import org.jack.qsport.modell.Semester;

/**
 *
 * @author kiesel.christoph
 */
public class DBAnbindung {

    private Connection connect = null;
    private Statement statement;
    private ResultSet resultSet;
    private String host;
    String username;
    String password;

    public DBAnbindung(String h, String u, String p) {
        host = h;
        username = u;
        password = p;
        String url = "jdbc:mysql://" + host + ":3306?useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, username, password);
            DatabaseMetaData dbmd = connect.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables("qsport", null, "%", types);
            String ausgabe = "Die Verbindung konnte erstellt werden.\nFolgende Tabellen sind angelegt:\n";
            while (rs.next()) {
                ausgabe = ausgabe + rs.getString("TABLE_NAME") + "\n";
            }
            System.out.println(ausgabe);
        } catch (SQLException e) {
            e.printStackTrace();
            String ausgabe = e.getMessage();
            JOptionPane.showMessageDialog(null, "Keine Verbindung!!\n" + ausgabe);
        } catch (Exception e) {
            e.printStackTrace();
            String ausgabe = e.getMessage();
            JOptionPane.showMessageDialog(null, "Keine Verbindung!!\n" + ausgabe);
        }
    }

    public void selectAll() {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM qsport.student;");
            writeResultSet(resultSet);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
    
    public ArrayList<Student> holeStudenten(Sportart sa) {
        String sportname;
        sportname = sa.toString();
        /*
        Die folgende Änderung kann gelöscht werden, wenn der Name der Sportart auch im Schülerprogramm geändert wurde.
         */
        if (sportname.equals("GymnastikTanz")) {
            sportname = "Gymnastik/Tanz";
        }

        ArrayList<Student> liste = new ArrayList();

        try {
            //statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("Select * FROM qsport.student WHERE Wahl1 = '" + sportname + "' OR Wahl2 = '" + sportname + "' OR Wahl3 = '" + sportname + "' OR Wahl4 = '" + sportname + "' OR Wahl5 = '" + sportname + "'");

            while (resultSet.next()) {
                String vorname = resultSet.getString("Vorname");
                String name = resultSet.getString("Name");
                Date gbdatum = resultSet.getDate("Geburtsdatum");
                Student s = new Student(name, vorname, gbdatum);
                liste.add(s);
            }
            System.out.println();
        } catch (Exception e) {
        }
        for (Student s : liste) {
            System.out.println(s);
        }
        return liste;
    }

    public ArrayList<Kurs> holeKurse() {
        ArrayList<Kurs> liste = new ArrayList();
        try {
            //statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM qsport.kurse");

            while (resultSet.next()) {
                String semester = resultSet.getString("semester");
                String sportart = resultSet.getString("sportart");
                int max = resultSet.getInt("max");
                Kurs k  = new Kurs(Sportart.valueOf(sportart),Semester.get(semester), max,0);
                System.out.println(semester+" "+sportart+" ");
                liste.add(k);
            }
            
        } catch (Exception e) {
        }
        
        return liste;
    }

    public ArrayList<Student> holeAlleStudenten() {

        ArrayList<Student> liste = new ArrayList();

        try {
            //statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("Select * FROM qsport.student");

            while (resultSet.next()) {
                String vorname = resultSet.getString("Vorname");
                String name = resultSet.getString("Name");
                Date gbdatum = resultSet.getDate("Geburtsdatum");
                Student s = new Student(name, vorname, gbdatum);
                String klasse = resultSet.getString("Klasse");
                s.setKlasse(klasse);
                for (int i = 0; i < 5; i++) {
                    int j = i + 1;
                    String wahl = "Wahl" + j;
                    String sportname = resultSet.getString(wahl);
                    sportname = sportname.replace("/", "");
                    if(sportname.isEmpty()){
                        s.setWahl(i, Sportart.Unbekannt);
                    } else {
                        s.setWahl(i, Sportart.valueOf(sportname));
                    }
                }
                liste.add(s);
                System.out.println(s);
            }

            
        } catch (Exception e) {
        }

        return liste;
    }

    public void writeToDB(QSport qsp) {
        ArrayList<Student> liste = qsp.getListeStudent();
        try {
            statement = connect.createStatement();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            statement.executeUpdate("TRUNCATE TABLE `qsport`.`student`");
            for (Student s : liste) {
                String gebDatum = dateformat.format(s.getDatum());
                statement.executeUpdate("INSERT INTO `qsport`.`student` "
                        + "(`Name`, `Vorname`, `Geburtsdatum`, `Klasse`, `Wahl1`, `Wahl2`, `Wahl3`, `Wahl4`, `Wahl5`, `score`) "
                        + "VALUES ('" + s.getName() + "', '" + s.getVorname() + "', '" + gebDatum + "', '" + s.getKlasse() + "', '', '', '', '', '', '0');");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            String vorname = resultSet.getString("Vorname");
            Date gebDatum = resultSet.getDate("Geburtsdatum");
            String wahl1 = resultSet.getString("Wahl1");
            String wahl2 = resultSet.getString("Wahl2");
            String wahl3 = resultSet.getString("Wahl3");
            String wahl4 = resultSet.getString("Wahl4");
            String wahl5 = resultSet.getString("Wahl5");
            int score = resultSet.getInt("Score");
            int id = resultSet.getInt("ID");

            System.out.println("Nachname: " + name);
            System.out.println("Vorname: " + vorname);
            System.out.println("Geburtsdatum: " + gebDatum);
            System.out.println("Wahl11_1: " + wahl1);
            System.out.println("Wahl11_2: " + wahl2);
            System.out.println("Wahl12_1: " + wahl3);
            System.out.println("Wahl12_2: " + wahl4);
            System.out.println("Ersatz: " + wahl5);
            System.out.println("Score: " + score);
            System.out.println("ID: " + id);
        }
    }
    
    public Student searchStudent(Student s) {
        Student a;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String dateString = dateFormat.format(s.getDatum());
            String sql = "SELECT * FROM qsport.student " + "Where Name=" + "'" + s.getName() + "' and Vorname='" + s.getVorname() + "' and Geburtsdatum='" + dateString + "'";
            System.out.println(sql);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sql);

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No result");
                a = null;
            } else {
                resultSet.next();
                System.out.println(s.getName() + " gefunden");
                String name = resultSet.getString("Name");
                String vorname = resultSet.getString("Vorname");
                java.sql.Date gebDatum = resultSet.getDate("Geburtsdatum");

                a = new Student(name, vorname, gebDatum);

                for (int i = 0; i < 5; i++) {
                    Sportart k;
                    String sK = resultSet.getString("Wahl" + (i+1));
                    if (resultSet.wasNull()) {
                        k = null;
                    } else {
                        k = Sportart.valueOf(sK);
                    }

                    a.setWahl(i, k);
                }

            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            a = null;
        } catch (Exception e) {
            e.printStackTrace();
            a = null;
        }

        return a;
    }

    public void updateStudent(Student s) {
        try {
            statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM `qsport`.`student`" + "Where Name=" + "'" + s.getName() + "' and Vorname='" + s.getVorname() + "' and Geburtsdatum='" + s.getDatum() + "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            resultSet.first();
            for(int i=0; i<5;i++){
                resultSet.updateString("Wahl"+(i+1), s.getWahl(i).name());
            }
            

            resultSet.updateRow();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        DBAnbindung anbindung = new DBAnbindung("jsg-kg.fortiddns.com", "q11", "q11");
        anbindung.selectAll();
    }

    public void testeVerbindung() {
        try {
            DatabaseMetaData dbmd = connect.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables("qsport", null, "%", types);
            String ausgabe = "Die Verbindung konnte erstellt werden.\nFolgende Tabellen sind angelegt:\n";
            while (rs.next()) {
                ausgabe = ausgabe + rs.getString("TABLE_NAME") + "\n";
            }
            JOptionPane.showMessageDialog(null, ausgabe);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            String ausgabe = e.getMessage();
            JOptionPane.showMessageDialog(null, "Keine Verbindung!!\n" + ausgabe);
        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
    }
}
