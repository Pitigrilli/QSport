package org.jack.qsport_schueler.db;

import java.sql.*;
import java.text.SimpleDateFormat;

import org.jack.qsport.modell.Sportart;
import org.jack.qsport.modell.Student;

/**
 *
 * @author kiesel.christoph
 */
public class DBAnbindung {

    private Connection connect = null;
    private Statement statement;
    private ResultSet resultSet;

    public DBAnbindung() {

        String url = "jdbc:mysql://jsg-kg.fortiddns.com:3306?useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin&useSSL=false";
        String username = "q11";
        String password = "q11";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
                Date gebDatum = resultSet.getDate("Geburtsdatum");

                a = new Student(name, vorname, gebDatum);

                for (int i = 1; i < 6; i++) {
                    Sportart k;
                    String sK = resultSet.getString("Wahl" + i);
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
            for(int i=1; i<6;i++){
                resultSet.updateString("Wahl"+i, s.getWahl(i).name());
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
        DBAnbindung a = new DBAnbindung();
    }
}
