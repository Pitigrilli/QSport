package org.jack.qsport.modell;

import java.io.Serializable;
import java.util.ArrayList;

public class Sportart implements Serializable{
    
    private static ArrayList<Sportart> sportarten = new ArrayList<>();
    
    public static Sportart Unbekannt = new Sportart("Unbekannt", 0, Art.SONSTIGE);
    public static Sportart Basketball = new Sportart("Basketball", 1, Art.TEAM);
    public static Sportart Fußball = new Sportart("Fußball", 2, Art.TEAM);
    public static Sportart Volleyball = new Sportart("Volleyball", 3, Art.TEAM);
    public static Sportart GymnastikTanz = new Sportart("GymnastikTanz", 3, Art.EINZEL);
    public static Sportart Schwimmen = new Sportart("Schwimmen", 4, Art.EINZEL);
    public static Sportart Leichtathletik = new Sportart("Leichtathletik", 5, Art.EINZEL);
    public static Sportart Mountainbiking = new Sportart("Mountainbiking", 6, Art.SONSTIGE);
    public static Sportart Badminton = new Sportart("Badminton", 7, Art.SONSTIGE);


    private int ordinal;
    private Art art;
    private String name;

    

    protected Sportart(String name, int ordinal, Art a) {
        this.name = name;
        this.ordinal = ordinal;
        art = a;
        sportarten.add(this);
    }

    public static Sportart[] values() {
        return sportarten.toArray(new Sportart[0]);
    }

    public static Sportart valueOf(String name) {
        Sportart sportart = null;
        for (Sportart s : sportarten) {
            if (s.name.equals(name)) {
                sportart = s;
                break;
            }
        }
        return sportart;
    }

    public Art getArt() {
        return art;
    }

    public String name() {
        return name;
    }
    
    public String toString(){
        return name;
    }
    
    public boolean equals(Sportart s){
        return name.equals(s.name);
    }


    public static void main(String[] args) {
        System.out.println("Ausgabe von toString der enum SportNamen:");
        for (Sportart s : Sportart.values()) {
            System.out.println(s.name());
        }
    }
}
