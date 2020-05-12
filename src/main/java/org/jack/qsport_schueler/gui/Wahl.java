/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport_schueler.gui;

import org.jack.qsport_schueler.db.DBAnbindung;
import org.jack.qsport_schueler.modell.Sportart;
import org.jack.qsport_schueler.modell.Student;

/**
 *
 * @author kiesel.christoph
 */
public class Wahl extends javax.swing.JFrame {
    
    Student s;

    /**
     * Creates new form Wahl
     */
    public Wahl(Student std) {
        s = std;
        initComponents();
        this.setTitle(std.getName() + ", " + std.getVorname());
        
        if (std.getWahl1() != null){
            String wahl1 = std.getWahl1().getNameSportart();
            auswahl1.setSelectedItem(wahl1);
        }
        
        if (std.getWahl2() != null) {
            String wahl2 = std.getWahl2().getNameSportart();
            auswahl2.setSelectedItem(wahl2);

        }
        if (std.getWahl3() != null) {
            String wahl3 = std.getWahl3().getNameSportart();
            auswahl3.setSelectedItem(wahl3);
        }
        if (std.getWahl4() != null) {
            String wahl4 = std.getWahl4().getNameSportart();
            auswahl4.setSelectedItem(wahl4);

        }
        if (std.getWahl5() != null) {
            String wahl5 = std.getWahl5().getNameSportart();
            auswahl5.setSelectedItem(wahl5);

        }
    }
    
    private Wahl(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        auswahl1 = new javax.swing.JComboBox<>();
        auswahl3 = new javax.swing.JComboBox<>();
        auswahl2 = new javax.swing.JComboBox<>();
        auswahl4 = new javax.swing.JComboBox<>();
        BFestlegen = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        auswahl5 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");
        jPanel1.setName("QSport"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(445, 360));

        jLabel1.setText("QSport-Belegung");

        jLabel2.setText("Wahl 1");

        jLabel3.setText("Wahl 4");

        jLabel5.setText("Wahl 2");

        jLabel6.setText("Wahl 3");

        auswahl1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gymnastik/Tanz", "Leichtathletik", "Schwimmen" }));
        auswahl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auswahl1ActionPerformed(evt);
            }
        });

        auswahl3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Badminton", "Basketball", "Fußball", "Gymnastik/Tanz", "Leichtathletik", "Schwimmen", "Volleyball" }));
        auswahl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auswahl3ActionPerformed(evt);
            }
        });

        auswahl2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basketball", "Fußball", "Volleyball" }));
        auswahl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auswahl2ActionPerformed(evt);
            }
        });

        auswahl4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basketball", "Fußball", "Gymnastik/Tanz", "Leichtathletik", "Schwimmen", "Volleyball" }));
        auswahl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auswahl4ActionPerformed(evt);
            }
        });

        BFestlegen.setText("Festsetzen");
        BFestlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFestlegenActionPerformed(evt);
            }
        });

        jLabel7.setText("Wahl 5");

        auswahl5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basketball", "Fußball", "Gymnastik/Tanz", "Leichtathletik", "Schwimmen", "Volleyball" }));
        auswahl5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auswahl5ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Alle Wahlen besitzen die\ngleiche Priorität.\nJede Sportart darf max.\n2x gewählt werden.\nBesonderheiten wie\nBadminton und Mountain-\nbiking können nur 1x\ngewählt werden.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BFestlegen)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(auswahl1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(auswahl2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(auswahl4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(auswahl3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(auswahl5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(auswahl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(auswahl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(auswahl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(auswahl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(auswahl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BFestlegen)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void auswahl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auswahl1ActionPerformed
        // TODO add your handling code here:
        String wahl1 = auswahl1.getSelectedItem().toString();
        s.setWahl1(new Sportart(wahl1));
    }//GEN-LAST:event_auswahl1ActionPerformed

    private void auswahl3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auswahl3ActionPerformed
        // TODO add your handling code here:
        String wahl2 = auswahl2.getSelectedItem().toString();
        s.setWahl2(new Sportart(wahl2));
    }//GEN-LAST:event_auswahl3ActionPerformed

    private void auswahl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auswahl2ActionPerformed
        // TODO add your handling code here:
        String wahl3 = auswahl3.getSelectedItem().toString();
        s.setWahl3(new Sportart(wahl3));
    }//GEN-LAST:event_auswahl2ActionPerformed

    private void auswahl4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auswahl4ActionPerformed
        // TODO add your handling code here:
        String wahl4 = auswahl4.getSelectedItem().toString();
        s.setWahl4(new Sportart(wahl4));
    }//GEN-LAST:event_auswahl4ActionPerformed

    private void BFestlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFestlegenActionPerformed
        String wahl1 = auswahl1.getSelectedItem().toString();
        s.setWahl1(new Sportart(wahl1));
        String wahl2 = auswahl2.getSelectedItem().toString();
        s.setWahl2(new Sportart(wahl2));
        String wahl3 = auswahl3.getSelectedItem().toString();
        s.setWahl3(new Sportart(wahl3));
        String wahl4 = auswahl4.getSelectedItem().toString();
        s.setWahl4(new Sportart(wahl4));
        String wahl5 = auswahl5.getSelectedItem().toString();
        s.setWahl5(new Sportart(wahl5));
        if (s.istWahlErlaubt()) {
            DBAnbindung vb = new DBAnbindung();
            vb.updateStudent(s);

            WahlBestaetigung w1 = new WahlBestaetigung(s);
            w1.setVisible(true);
            this.setVisible(false);
        }
        else {
            System.out.println("gibt false zurück");
        }
    }//GEN-LAST:event_BFestlegenActionPerformed

    private void auswahl5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auswahl5ActionPerformed
        // TODO add your handling code here:
        String wahl5 = auswahl5.getSelectedItem().toString();
        s.setWahl5(new Sportart(wahl5));
    }//GEN-LAST:event_auswahl5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Wahl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wahl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wahl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wahl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wahl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFestlegen;
    private javax.swing.JComboBox<String> auswahl1;
    private javax.swing.JComboBox<String> auswahl2;
    private javax.swing.JComboBox<String> auswahl3;
    private javax.swing.JComboBox<String> auswahl4;
    private javax.swing.JComboBox<String> auswahl5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
