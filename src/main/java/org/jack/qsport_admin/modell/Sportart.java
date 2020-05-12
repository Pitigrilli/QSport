package org.jack.qsport_admin.modell;

/**
 *
 * @author claus
 */
public enum Sportart {
    Unbekannt(Art.SONSTIGE), Basketball(Art.TEAM), Fußball(Art.TEAM), Volleyball(Art.TEAM), GymnastikTanz(Art.EINZEL), 
    Schwimmen(Art.EINZEL), Leichtathletik(Art.EINZEL), Mountainbiking(Art.SONSTIGE), Badminton(Art.SONSTIGE);
    
    Art art;
    
    Sportart(Art a){
        art = a;
    }
    
    public Art getArt(){
        return art;
    }
    
    public static void main(String[] args){
        System.out.println("Ausgabe von toString der enum SportNamen:");
        for(Sportart s: Sportart.values()){
            System.out.println(s.toString());
        }
    }
}
