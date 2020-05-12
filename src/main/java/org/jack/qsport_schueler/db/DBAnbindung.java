/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport_schueler.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import org.jack.qsport_schueler.modell.Sportart;
import org.jack.qsport_schueler.modell.Student;

/**
 *
 * @author kiesel.christoph
 */
public class DBAnbindung {
    
    private Connection connect = null;
    private Statement statement;
    private ResultSet resultSet;
    
    public DBAnbindung(){
        
        String url = "jdbc:mysql://jsg-kg.fortiddns.com:3306?useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin&useSSL=false";
        String username = "q11";
        String password = "q11";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            connect = DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
 
    
    public Student searchStudent(Student s){
        Student a;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            String dateString = dateFormat.format(s.getDate());
            String sql = "SELECT * FROM qsport.student " + "Where Name=" + "'" + s.getName() + "' and Vorname='" + s.getVorname() + "' and Geburtsdatum='" + dateString + "'";
            System.out.println(sql);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sql);
            
            if(!resultSet.isBeforeFirst()){
                System.out.println("No date");
                a = null;
            }else{
                resultSet.next();
                System.out.println(s.getName() + " gefunden");
                String name = resultSet.getString("Name");
                String vorname = resultSet.getString("Vorname");
                Date gebDatum = resultSet.getDate("Geburtsdatum");
                
                Sportart k1;
                Sportart k2;
                Sportart k3;
                Sportart k4;
                Sportart k5;
                
                String sK1 = resultSet.getString("Wahl1");
                if(resultSet.wasNull()){
                    k1 = null;
                }else{
                    k1 = new Sportart(sK1);
                }
                
                String sK2 = resultSet.getString("Wahl2");
                if(resultSet.wasNull()){
                    k2 = null;
                }else{
                    k2 = new Sportart(sK2);
                }
                
                String sK3 = resultSet.getString("Wahl3");
                if(resultSet.wasNull()){
                    k3 = null;
                }else{
                    k3 = new Sportart(sK3);
                }
                
                String sK4 = resultSet.getString("Wahl4");
                if(resultSet.wasNull()){
                    k4 = null;
                }else{
                    k4 = new Sportart(sK4);
                }
                
                String sK5 = resultSet.getString("Wahl5");
                if(resultSet.wasNull()){
                    k5 = null;
                }else{
                    k5 = new Sportart(sK5);
                }
                
                a = new Student(name, vorname, gebDatum);
                a.setWahl1(k1);
                a.setWahl2(k2);
                a.setWahl3(k3);
                a.setWahl4(k4);
                a.setWahl5(k5);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
            a=null;
        }catch(Exception e){
            e.printStackTrace();
            a=null;
        }
        
        return a;
    }

    public void updateStudent(Student s){
        try{
            statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM `qsport`.`student`" + "Where Name=" + "'" + s.getName() + "' and Vorname='" + s.getVorname() + "' and Geburtsdatum='" + s.getDate() + "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            resultSet.first();
            resultSet.updateString("Wahl1", s.getWahl1().getNameSportart());
            resultSet.updateString("Wahl2", s.getWahl2().getNameSportart());
            resultSet.updateString("Wahl3", s.getWahl3().getNameSportart());
            resultSet.updateString("Wahl4", s.getWahl4().getNameSportart());
            resultSet.updateString("Wahl5", s.getWahl5().getNameSportart());
            resultSet.updateRow();
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DBAnbindung a = new DBAnbindung();
    }
}











