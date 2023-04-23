package pckg;

public class Film {
    private String nazov;
    private String reziser;
    private int rokVydania;
    private HodnotenieDivakov hodnotenieDivakov;
    
    public Film(String nazov, String reziser, int rokVydania, HodnotenieDivakov hodnotenieDivakov) {
        this.nazov = nazov;
        this.reziser = reziser;
        this.rokVydania = rokVydania;
        this.hodnotenieDivakov = hodnotenieDivakov;
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

    public HodnotenieDivakov getHodnotenieDivakov() {
        return hodnotenieDivakov;
    }
    
    public void setHodnotenieDivakov(HodnotenieDivakov hodnotenieDivakov) {
        this.hodnotenieDivakov = hodnotenieDivakov;
    }
    
    @Override
    
    public String toString() {
        return "Nazov: " + nazov + "\nReziser: " + reziser + "\nRok vydania: " + rokVydania + "\nHodnotenie divakov: " + hodnotenieDivakov + "\n";
    }

}

