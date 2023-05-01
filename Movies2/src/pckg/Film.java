package pckg;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private String nazov;
    private String reziser;
    private int rokVydania;
    private ArrayList<String> zoznamHercovAAnimatorov;
    private ArrayList<Hodnotenie> zoznamHodnoteni;

    public Film(String nazov, String reziser, int rokVydania) {
        this.nazov = nazov;
        this.reziser = reziser;
        this.rokVydania = rokVydania;
        this.zoznamHodnoteni = new ArrayList<>();
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

    public List<Hodnotenie> getHodnotenia() {
        return zoznamHodnoteni;
    }

    public void setHodnotenia(List<Hodnotenie> zoznamHodnoteni) {
        this.zoznamHodnoteni = new ArrayList<>(zoznamHodnoteni);
    }

    public void noveHodnotenia(Hodnotenie zoznamHodnoteni) 
    {
    	this.zoznamHodnoteni.add(zoznamHodnoteni);
    }

    public List<String> getZoznamHercovAAnimatorov() {
        return zoznamHercovAAnimatorov;
    }

    public void setZoznamHercovAAnimatorov(ArrayList<String> zoznamHercovAAnimatorov) {
        this.zoznamHercovAAnimatorov = zoznamHercovAAnimatorov;
    }

    @Override
    public String toString() {
        return "Nazov: " + nazov + "\nReziser: " + reziser + "\nRok vydania: " + rokVydania + "\nHodnotenia: " + zoznamHodnoteni + "\n";
    }
}