package pckg;

import java.util.List;
import java.util.ArrayList;

public class Film {
    private String nazov;
    private String reziser;
    private int rokVydania;
    private Hodnotenie hodnotenie;
    private ArrayList<String> zoznamHercovAAnimatorov;
    
    public Film(String nazov, String reziser, int rokVydania, Hodnotenie hodnotenie) {
        this.nazov = nazov;
        this.reziser = reziser;
        this.rokVydania = rokVydania;
        this.hodnotenie = hodnotenie;
    }
    
    public String getNazov() {
        return nazov;
    }
    
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getReziser() {
        return reziser;
    }
    
    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public int getRokVydania() {
        return rokVydania;
    }
    
    public void setRokVydania(int rokVydania) {
        this.rokVydania = rokVydania;
    }

    public Hodnotenie getHodnotenie() {
        return hodnotenie;
    }
    
    public void setHodnotenie(Hodnotenie hodnotenie) {
        this.hodnotenie = hodnotenie;
    }
    
    public List<String> zoznamHercovAAnimatorov() {
        List<String> zoznamHercovAAnimatorov = new ArrayList<>();
        for (String herecAleboAnimator : this.zoznamHercovAAnimatorov) {
        	zoznamHercovAAnimatorov.add(herecAleboAnimator);
        }
        return zoznamHercovAAnimatorov;
    }

    
    @Override
    
    public String toString() {
        return "Nazov: " + nazov + "\nReziser: " + reziser + "\nRok vydania: " + rokVydania + "\nHodnotenie: " + hodnotenie + "\n";
    }

}

