package org.jack.qsport.pdf;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.Desktop;

import org.jack.qsport.modell.Student;
import org.jack.qsport.modell.Kurs;
import org.jack.qsport.modell.QSport;
import org.jack.qsport.modell.Semester;

public class CreatePDF {

    private QSport qsp;

    public CreatePDF(QSport qsp) {
        this.qsp = qsp;
    }

    /*
        Gibt die verschiedene Kurse nach Sem, Sportart, Anzahl aus
     */
    public void printUebersicht() {
        String DEST = "results/Uebersicht.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try {
            //Initialize PDF writer
            PdfWriter writer = new PdfWriter(DEST);

            //Initialize PDF document
            PdfDocument pdf = new PdfDocument(writer);

            // Initialize document
            Document document = new Document(pdf);
            document.add(new Paragraph("Übersicht über die Wahl der Kurse"));
            Table table = new Table(3);
            table.addCell("Semester");
            table.addCell("Sportart");
            table.addCell("Anzahl");

            for (Kurs k : qsp.getKurse()) {
                table.addCell(k.getSemester().toString());
                table.addCell(k.getSportart().toString());
                table.addCell(" " + k.getAnzahlStudent());
            }

            document.add(table);

            //Close document
            document.close();
            zeigePDF(DEST);
        } catch (Exception ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printJahrgang(ArrayList<Student> studentList) {
        String DEST = "results/Jahrgang.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try {
            //Initialize PDF writer
            PdfWriter writer = new PdfWriter(DEST);

            //Initialize PDF document
            PdfDocument pdf = new PdfDocument(writer);

            // Initialize document
            Document document = new Document(pdf);
            document.add(new Paragraph("Aktueller Jahrgang"));
            Table t1 = new Table(3);
            Cell kopf = new Cell();
            kopf.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf.setBorder(new SolidBorder(1));
            kopf.add(new Paragraph("Name"));
            t1.addCell(kopf);
            Cell kopf2 = new Cell();
            kopf2.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf2.setBorder(new SolidBorder(1));
            kopf2.add(new Paragraph("Vorname"));
            t1.addCell(kopf2);
            Cell kopf3 = new Cell();
            kopf3.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf3.setBorder(new SolidBorder(1));
            kopf3.add(new Paragraph("Geburtsdatum"));
            t1.addCell(kopf3);
            Student aktuellerStudent;
            for (int i = 0; i < studentList.size(); i++) {
                aktuellerStudent = studentList.get(i);
                t1.addCell(aktuellerStudent.getName());
                t1.addCell(aktuellerStudent.getVorname());
                t1.addCell(DateToString(aktuellerStudent.getDatum()));

            }
            document.add(t1);

            //Close document
            document.close();
            zeigePDF(DEST);
        } catch (Exception ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printJahrgangsWahl() {
        String DEST = "results/Jahrgangswahl.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try {
            //Initialize PDF writer
            PdfWriter writer = new PdfWriter(DEST);

            //Initialize PDF document
            PdfDocument pdf = new PdfDocument(writer);

            // Initialize document
            Document document = new Document(pdf, PageSize.A4.rotate());
            document.add(new Paragraph("Aktueller Jahrgang"));
            Table table = new Table(8);

            Cell kopf = new Cell();
            kopf.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf.add(new Paragraph("Name"));
            table.addCell(kopf);
            Cell kopf2 = new Cell();
            kopf2.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf2.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf2.add(new Paragraph("Vorname"));
            table.addCell(kopf2);
            Cell kopf3 = new Cell();
            kopf3.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf3.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf3.add(new Paragraph("Geburtsdatum"));
            table.addCell(kopf3);
            Cell kopf4 = new Cell();
            kopf4.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf4.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf4.add(new Paragraph("Wahl 1"));
            table.addCell(kopf4);
            Cell kopf5 = new Cell();
            kopf5.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf5.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf5.add(new Paragraph("Wahl 2"));
            table.addCell(kopf5);
            Cell kopf6 = new Cell();
            kopf6.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf6.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf6.add(new Paragraph("Wahl 3"));
            table.addCell(kopf6);
            Cell kopf7 = new Cell();
            kopf7.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf7.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf7.add(new Paragraph("Wahl 4"));
            table.addCell(kopf7);
            Cell kopf8 = new Cell();
            kopf8.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf8.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf8.add(new Paragraph("Wahl 5"));
            table.addCell(kopf8);

            for (Student s: qsp.getListeStudent()) {
                table.addCell(s.getName());
                table.addCell(s.getVorname());
                table.addCell(DateToString(s.getDatum()));
                for(int i = 0; i < 5; i++)
                    table.addCell(s.getWahl(i).toString());
                

            }
            document.add(table);

            //Close document
            document.close();
            zeigePDF(DEST);
        } catch (Exception ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printKurs(Kurs k) {
        String DEST = "results/Jahrgang/" + k.getSemester() + " " + k.getSportart() + ".pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try {
            PdfWriter writer = new PdfWriter(DEST);
            PdfDocument pdf = new PdfDocument(writer);

            Document document = new Document(pdf);

            document.add(new Paragraph("Kursausgabe"));
            document.add(new Paragraph(k.getSemester() + " " + k.getSportart()));
            document.add(new Paragraph(k.getSemester().toString()));
            document.add(new Paragraph(k.getSportart().toString()));
            Table t1 = new Table(3);
            Cell kopf = new Cell();
            kopf.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf.add(new Paragraph("Name"));
            t1.addCell(kopf);
            Cell kopf2 = new Cell();
            kopf2.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf2.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf2.add(new Paragraph("Vorname"));
            t1.addCell(kopf2);
            Cell kopf3 = new Cell();
            kopf3.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            kopf3.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
            kopf3.add(new Paragraph("Geburtsdatum"));
            t1.addCell(kopf3);
            ArrayList<Student> studentList = k.getStudentList();
            Student aktuellerStudent;
            for (int i = 0; i < studentList.size(); i++) {
                aktuellerStudent = studentList.get(i);
                t1.addCell(aktuellerStudent.getName());
                t1.addCell(aktuellerStudent.getVorname());
                t1.addCell(DateToString(aktuellerStudent.getDatum()));
            }
            document.add(t1);
            document.close();
            zeigePDF(DEST);
        } catch (Exception ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void printKursVerteilung(Semester semester) {
        String DEST = "results/KursVerteilung-"+semester+".pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try {
            PdfWriter writer = new PdfWriter(DEST);
            PdfDocument pdf = new PdfDocument(writer);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            Document document = new Document(pdf, PageSize.A4.rotate());
            document.add(new Paragraph("Kursverteilung"));
            document.add(new Paragraph("Semester: " + semester));

            Table table = new Table(5);
            ArrayList<Kurs> kurse = qsp.getKurse();
            for (Kurs k: kurse) {
                if (k.getSemester().equals(semester)) {
                    Table t1 = new Table(2);
                    t1.setFontSize(8);
                    t1.addHeaderCell(k.getSportart().toString());
                    t1.addHeaderCell(""+k.getAnzahlStudent());
                    ArrayList<Student> studentList = k.getStudentList();
                    for (Student s: studentList) {
                        t1.addCell(s.getName());
                        t1.addCell(s.getVorname());
                    }
                table.addCell(t1);    
                }
                
            }
            document.add(table);

            document.close();
            zeigePDF(DEST);
        } catch (Exception ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
        Ausgabe eines Strings zum Objekt der Date-Klasse 
     */
    public String DateToString(Date indate) {
        String dateString = null;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        try {
            dateString = df.format(indate);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dateString;
    }

    /*
        Zeigt die pdf-Datei im System-Viewer
     */
    public void zeigePDF(String DEST) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(new File(DEST));
            } else {
                System.err.println("PDF-Datei kann nicht angezeigt werden!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /*
        Testen der pdf-Klasse
     */
    public static void main(String[] args) {
        CreatePDF pdf = new CreatePDF(new QSport());
        pdf.printJahrgangsWahl();
    }
}
