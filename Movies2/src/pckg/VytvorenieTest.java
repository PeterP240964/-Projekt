package pckg;

import java.util.ArrayList;
import java.util.List;

public class VytvorenieTest {
    public static void filmTest(List<Film> seznamFilmu) {
    	
        // vytvorenie noveho hraneho filmu
        String nazevT1 = "The Dark Knight";
        String reziserT1 = "Christopher Nolan";
        int rokVydaniT1 = 2008;
        Hodnotenie hodnotenieT1 = new Hodnotenie(4,1,5); // hodnotenie 8, povolene 1 - 5
        ArrayList<String> seznamHercuT1 = new ArrayList<String>();
        seznamHercuT1.add("Christian Bale");
        seznamHercuT1.add("Heath Ledger");
        seznamHercuT1.add("Hayao Miyazaki");
        HranyF darkKnight = new HranyF(nazevT1, reziserT1, rokVydaniT1, hodnotenieT1, seznamHercuT1);
        seznamFilmu.add(darkKnight); //pridanie filmu do seznamFilmu list
        
        // vytvorenie noveho hraneho filmu
        String nazevT3 = "The Dark Knight2";
        String reziserT3 = "Christopher Nolan";
        int rokVydaniT3 = 2008;
        Hodnotenie hodnotenieT3 = new Hodnotenie(4,1,5); // hodnotenie 8, povolene 1 - 5
        ArrayList<String> seznamHercuT3 = new ArrayList<String>();
        seznamHercuT3.add("Christian Bale");
        seznamHercuT3.add("Michal Bej");
        seznamHercuT3.add("Peter Panisz");
        HranyF darkKnight2 = new HranyF(nazevT3, reziserT3, rokVydaniT3, hodnotenieT3, seznamHercuT3);
        seznamFilmu.add(darkKnight2); //pridanie filmu do seznamFilmu list
                
       //vytvorenie noveho animovaneho filmu
        String nazev = "Spirited Away";
        String reziser = "Hayao Miyazaki";
        int rokVydani = 2001;
        Hodnotenie hodnotenieT2 = new Hodnotenie(8,1,10); // hodnotenie 8, povolene 1 - 10
        ArrayList<String> seznamAnimatoru = new ArrayList<String>();
        seznamAnimatoru.add("Hayao Miyazaki");
        int doporucenyVek = 10;
        AnimovanyF spiritedAway = new AnimovanyF(nazev, reziser, rokVydani, hodnotenieT2, seznamAnimatoru, doporucenyVek);
        seznamFilmu.add(spiritedAway); //pridanie filmu do seznamFilmu list

    }
}

