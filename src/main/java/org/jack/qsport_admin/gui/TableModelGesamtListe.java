/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport_admin.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.jack.qsport_admin.modell.Kurs;
import org.jack.qsport_admin.modell.Student;

/**
 *
 * @author claus
 */
public class TableModelGesamtListe extends AbstractTableModel {

    ArrayList<Student> liste;

    public TableModelGesamtListe(ArrayList<Student> l) {
        liste = l;
    }

    @Override
    public int getRowCount() {
        return liste.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int col) {
        String colName="";
        switch(col){
            case 0: colName="Name";break;
            case 1: colName="Wahl1";break;
            case 2: colName="Wahl2";break;
            case 3: colName="Wahl3";break;
            case 4: colName="Wahl4";break;
            case 5: colName="Wahl5";break;
        }
        return colName;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Student s = liste.get(row);
        Object o = new Object();
        switch(col){
            case 0: o=s.getName()+" "+s.getVorname();break;
            default: o=s.getWahl(col-1);
        }
        return o;
    }
}

