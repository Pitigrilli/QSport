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
public class TableModelEinteilung extends AbstractTableModel {

     ArrayList<Student> liste;

    public TableModelEinteilung(ArrayList<Student> l) {
        liste = l;
    }

    @Override
    public int getRowCount() {
        return liste.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int col) {
        return "Name";
    }

    @Override
    public Object getValueAt(int row, int col) {
        Student s = liste.get(row);
        return s.getName()+" "+s.getVorname();
    }
}
