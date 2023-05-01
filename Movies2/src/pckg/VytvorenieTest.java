package pckg;

import java.util.ArrayList;
import java.util.List;

public class VytvorenieTest {
    public static void filmTest(List<Film> seznamFilmu) {

    	String nazevT1 = "El Camino";
    	String reziserT1 = "Vince Gilligan";
    	int rokVydaniT1 = 2019;
    	ArrayList<String> seznamHercuT1 = new ArrayList<String>();
    	seznamHercuT1.add("Aaron Paul");
    	seznamHercuT1.add("Bryan Cranston");
    	seznamHercuT1.add("Jonathan Banks");
    	HranyF ElCamino = new HranyF(nazevT1, reziserT1, rokVydaniT1, seznamHercuT1);
    	seznamFilmu.add(ElCamino); 

        String nazevT2 = "The SpongeBob Movie";
        String reziserT2 = "Tim Hill";
        int rokVydaniT2 = 2020;
        ArrayList<String> seznamAnimatoruT2 = new ArrayList<String>();
        seznamAnimatoruT2.add("Keanu Reeves");
        seznamAnimatoruT2.add("Snoop Dogg");
        seznamAnimatoruT2.add("Tom Kenny");
        int doporucenyVekT2 = 8;
        AnimovanyF SpongeBob = new AnimovanyF(nazevT2, reziserT2, rokVydaniT2, seznamAnimatoruT2, doporucenyVekT2);
        seznamFilmu.add(SpongeBob); 

        String nazevT3 = "John Wick 4";
        String reziserT3 = "Chad Stahelski";
        int rokVydaniT3 = 2023;
        ArrayList<String> seznamHercuT3 = new ArrayList<String>();
        seznamHercuT3.add("Keanu Reeves");
        seznamHercuT3.add("Scott Adkins");
        seznamHercuT3.add("Lance Reddick");
        HranyF JohnWick4 = new HranyF(nazevT3, reziserT3, rokVydaniT3, seznamHercuT3);
        seznamFilmu.add(JohnWick4); 

    }
}