package pckg;

import java.util.ArrayList;
import java.util.List;

public class VytvorenieTest {
    public static void filmTest(List<Film> seznamFilmu) {
    	
        // vytvorenie noveho hraneho filmu
        String nazevT1 = "The Dark Knight";
        String reziserT1 = "Christopher Nolan";
        int rokVydaniT1 = 2008;
        HodnotenieDivakov hodnoceniDivakuT1 = new HodnotenieDivakov(9);
        ArrayList<String> seznamHercuT1 = new ArrayList<String>();
        seznamHercuT1.add("Christian Bale");
        seznamHercuT1.add("Heath Ledger");
        seznamHercuT1.add("Aaron Eckhart");
        HranyF darkKnight = new HranyF(nazevT1, reziserT1, rokVydaniT1, hodnoceniDivakuT1, seznamHercuT1);
        seznamFilmu.add(darkKnight); //pridanie filmu do seznamFilmu list

        
       //vytvorenie noveho animovaneho filmu
        String nazev = "Spirited Away";
        String reziser = "Hayao Miyazaki";
        int rokVydani = 2001;
        HodnotenieDivakov hodnoceniDivaku = new HodnotenieDivakov(9);
        ArrayList<String> seznamAnimatoru = new ArrayList<String>();
        seznamAnimatoru.add("Hayao Miyazaki");
        int doporucenyVek = 10;
        AnimovanyF spiritedAway = new AnimovanyF(nazev, reziser, rokVydani, hodnoceniDivaku, seznamAnimatoru, doporucenyVek);
        seznamFilmu.add(spiritedAway); //pridanie filmu do seznamFilmu list

    }
}

