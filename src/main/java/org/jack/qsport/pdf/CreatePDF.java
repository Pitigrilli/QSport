package org.jack.qsport.pdf;

import com.itextpdf.kernel.colors.ColorConstants;
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

import org.jack.qsport.modell.Student;
import org.jack.qsport.modell.Kurs;
import org.jack.qsport.modell.QSport;
import org.jack.qsport.db.DBAnbindung;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.Desktop;
import java.sql.Statement;


/**
 * 
 * @author kiesel.christoph
 */

public class CreatePDF {
    
    private ArrayList<Student> studentList = new ArrayList<Student>();
    Statement statement;
    
    
    public CreatePDF(){
        printJahrgangsWahl();
    }
    
    public void zeigePDF(String DEST){
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
    
    
    
/*    public void printUebersicht(){
        String DEST = "results/Jahrgang/Uebersicht.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try{
         //Initialize PDF writer
        PdfWriter writer = new PdfWriter(DEST);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);
        document.add(new Paragraph("Übersicht über die Wahl der Kurse"));
        Table t1 = new Table(3);
        t1.addCell("Semester"); t1.addCell("Sportart"); t1.addCell("Anzahl");
        t1.addCell("11/1"); t1.addCell("Badminton");
        t1.addCell(" "+kv.getBadminton111Anzahl());
        t1.addCell("11/1");t1.addCell("Basketball");
        t1.addCell(" "+kv.getBasketball111Anzahl());
        t1.addCell("11/1"); t1.addCell("Schwimmen");
        t1.addCell(" "+ kv.getSchwimmen111Anzahl());
        t1.addCell("11/1"); t1.addCell("Gymnastik&Tanz");
        t1.addCell(" "+ kv.getGymnastikTanz111Anzahl());
        t1.addCell("11/1"); t1.addCell("Volleyball");
        t1.addCell(" "+kv.getVolleyball111Anzahl());
        t1.addCell("11/2"); t1.addCell("Badminton");
        t1.addCell(" "+kv.getBadminton112Anzahl());
        t1.addCell("11/2"); t1.addCell("Basketball");
        t1.addCell(" "+kv.getBasketball112Anzahl());
        t1.addCell("11/2"); t1.addCell("Schwimmen");
        t1.addCell(" "+kv.getSchwimmen112Anzahl());
        t1.addCell("11/2");t1.addCell("Leichtathletik");
        t1.addCell(" "+kv.getLeichtathletik112Anzahl());
        t1.addCell("11/2"); t1.addCell("Fußball");
        t1.addCell(" "+kv.getFussball112Anzahl());
        t1.addCell("11/2");t1.addCell("Gymnastik&Tanz");
        t1.addCell(" "+kv.getGymnastikTanz112Anzahl());
        t1.addCell("11/2"); t1.addCell("Volleyball");
        t1.addCell(" "+kv.getVolleyball112Anzahl());
        t1.addCell("12/1");t1.addCell("Badminton");
        t1.addCell(" "+ kv.getBadminton121Anzahl());
        t1.addCell("12/1"); t1.addCell("Basketball");
        t1.addCell(" "+ kv.getBasketball121Anzahl());
        t1.addCell("12/1");t1.addCell("Schwimmen");
        t1.addCell(" "+ kv.getSchwimmen121Anzahl());
        t1.addCell("12/1");t1.addCell("Gymnastik&Tanz");
        t1.addCell(" "+kv.getGymnastikTanz121Anzahl());
        t1.addCell("12/1");t1.addCell("Volleyball");
        t1.addCell(" "+ kv.getVolleyball121Anzahl());
        t1.addCell("12/2");t1.addCell("Basketball");
        t1.addCell(" "+ kv.getBasketball122Anzahl());
        t1.addCell("12/2");t1.addCell("Schwimmen");
        t1.addCell(" "+ kv.getSchwimmen122Anzahl());
        t1.addCell("12/2");t1.addCell("Leichtathletik");
        t1.addCell(" "+kv.getLeichtathletik122Anzahl());
        t1.addCell("12/2");t1.addCell("Fußball");
        t1.addCell(" "+kv.getFussball122Anzahl());
        t1.addCell("12/2");t1.addCell("Volleyball");
        t1.addCell(" "+ kv.getVolleyball122Anzahl());
        
        } catch(Exception ex) {
           Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
       }
    }*/
    
    public void printJahrgang(ArrayList<Student> studentList){
        String DEST = "results/Jahrgang/Jahrgang.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try{
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
        for(int i=0;i<studentList.size();i++){
          aktuellerStudent=studentList.get(i);
         t1.addCell(aktuellerStudent.getName());
         t1.addCell(aktuellerStudent.getVorname());
         t1.addCell(DateToString(aktuellerStudent.getDatum()));
         
        }
        document.add(t1);

        //Close document
        document.close();
        zeigePDF(DEST);
       } catch(Exception ex) {
           Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
       }
    }   
    public void printJahrgangsWahl(){
        String DEST = "results/Jahrgang/Jahrgangswahl.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try{
         //Initialize PDF writer
        PdfWriter writer = new PdfWriter(DEST);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.add(new Paragraph("Aktueller Jahrgang"));
        Table t1 = new Table(8);
        
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
        Cell kopf4 = new Cell();       
        kopf4.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        kopf4.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
        kopf4.add(new Paragraph("Wahl 1"));
        t1.addCell(kopf4);
        Cell kopf5 = new Cell();       
        kopf5.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        kopf5.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
        kopf5.add(new Paragraph("Wahl 2"));
        t1.addCell(kopf5);
        Cell kopf6 = new Cell();       
        kopf6.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        kopf6.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
        kopf6.add(new Paragraph("Wahl 3"));
        t1.addCell(kopf6);
        Cell kopf7 = new Cell();       
        kopf7.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        kopf7.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
        kopf7.add(new Paragraph("Wahl 4"));
        t1.addCell(kopf7);
        Cell kopf8 = new Cell();       
        kopf8.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        kopf8.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
        kopf8.add(new Paragraph("Wahl 5"));
        t1.addCell(kopf8);
        
//        for(int i=0;i<studentList.size();i++){
//         t1.addCell();
//         t1.addCell();
//         t1.addCell(DateToString());
//         
//         t1.addCell();
//         t1.addCell();
//         t1.addCell();
//         t1.addCell();
//         t1.addCell();
//         
//         
//        }
        document.add(t1);

        //Close document
        document.close();
        zeigePDF(DEST);
       } catch(Exception ex) {
           Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void main(String[] args) {
        CreatePDF pdf = new CreatePDF();
        DBAnbindung db = new DBAnbindung("jsg-kg.fortiddns.com","q11","q11");
    }
    
    public void printKurs(Kurs k){
        String DEST = "results/Jahrgang/"+k.getSemester()+" "+k.getSportart()+".pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try{
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);
        
        document.add(new Paragraph("Kursausgabe"));
        document.add(new Paragraph(k.getSemester()+" "+k.getSportart()));
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
        ArrayList<Student> studentList= k.getStudentList();
        Student aktuellerStudent;
        for(int i=0;i<studentList.size();i++){
        aktuellerStudent=studentList.get(i);
         t1.addCell(aktuellerStudent.getName());
         t1.addCell(aktuellerStudent.getVorname());
         t1.addCell(DateToString(aktuellerStudent.getDatum()));
        }
        document.add(t1);
        document.close();
        zeigePDF(DEST);
        }catch(Exception ex) {
           Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    public String DateToString(Date indate)
{
   String dateString = null;
   DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
   
   try{
	dateString = df.format( indate );
   }catch (Exception ex ){
	System.out.println(ex);
   }
   return dateString;
}
    
    




public void printKursVerteilung(QSport qsp, String semester){
    String DEST = "results/Jahrgang/KursVerteilung.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try{
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);
        document.add(new Paragraph("Kursverteilung"));
        document.add(new Paragraph("Semester: "+semester));
        
        ArrayList<Kurs> kurse=qsp.getKurse();
        for(int h=0;h<kurse.size(); h++){
        if(kurse.get(h).getSemester().equals(semester)){
        Kurs k=kurse.get(h);
        document.add(new Paragraph(k.getSemester()+" "+k.getSportart()));
        document.add(new Paragraph(k.getSportart().toString()));
        Table t1 = new Table(3);
        ArrayList<Student> studentList= k.getStudentList();
        Student aktuellerStudent;
        for(int i=0;i<studentList.size();i++){
        aktuellerStudent=studentList.get(i);
         t1.addCell(aktuellerStudent.getName());
         t1.addCell(aktuellerStudent.getVorname());
         t1.addCell(DateToString(aktuellerStudent.getDatum()));
        }
        document.add(t1);
            }
        
        }
        
        document.close();
        zeigePDF(DEST);
        }catch(Exception ex) {
           Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }    
    
    
    
    
    }