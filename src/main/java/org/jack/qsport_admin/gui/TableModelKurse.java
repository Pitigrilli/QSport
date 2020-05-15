/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport_admin.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.jack.qsport.modell.Kurs;

/**
 *
 * @author claus
 */
public class TableModelKurse extends AbstractTableModel {
    ArrayList<Kurs> kurse;
    
    public TableModelKurse( ArrayList<Kurs> kurse){
         this.kurse = kurse;
    }

    @Override
    public int getRowCount() {
        return kurse.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String  getColumnName(int col){
        String s="";
        if(col==0){
            s="Semester";
        }
        if(col==1){
            s="Sportart";
        }
        return s;
    }

    @Override
    public Object getValueAt(int row, int col) {
      Object o = new Object();
      Kurs k = kurse.get(row);
      if(col==0){
          o = k.getSemester();
      }
      if(col==1){
          o = k.getSportart();
      }
      return o;
    }
    
}
