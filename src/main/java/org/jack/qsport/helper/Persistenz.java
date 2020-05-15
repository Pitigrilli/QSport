/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import org.jack.qsport.modell.Kurs;
import org.jack.qsport.modell.QSport;

/**
 *
 * @author kiesel.christoph
 */
public class Persistenz {

    QSport qsp;

    public Persistenz(QSport qsport) {
        qsp = qsport;
    }

    public void save() {
        FileOutputStream fos;

        ObjectOutputStream out;

        try {
            fos = new FileOutputStream(chooseFile());
            out = new ObjectOutputStream(fos);
            out.writeObject(qsp);
            out.close();
            fos.close();
            System.out.println("Objekte gespeichert");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public File chooseFile() {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }

    public QSport read() {
        QSport qsport = new QSport();
        FileInputStream fis;
        ObjectInputStream in;

        try {
            fis = new FileInputStream(chooseFile());
            in = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked")
            Object obj = in.readObject();
            qsport = (QSport) obj;

            in.close();
            System.out.println("Objekte wiederhergestellt");
            System.out.println("Vorhandene Kurse:");

            for (Kurs kurs : qsport.getKurse()) {
                System.out.println(kurs);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return qsport;
    }
}
