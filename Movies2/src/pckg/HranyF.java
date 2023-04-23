package pckg;

import java.util.ArrayList;

public class HranyF extends Film {
    private ArrayList<String> zoznamHercov;
    
    public HranyF(String nazov, String reziser, int rokVydania, HodnotenieDivakov hodnotenieDivakov, ArrayList<String> zoznamHercov) {
        super(nazov, reziser, rokVydania, hodnotenieDivakov); //tento konstruktor vola z konstruktoru Film
        this.zoznamHercov = zoznamHercov;
    }

    public ArrayList<String> getZoznamHercov() {
        return zoznamHercov;
    }
    
    public void setZoznamHercov(ArrayList<String> zoznamHercov) {
        this.zoznamHercov = zoznamHercov;
    }

    @Override
    public String toString() {
        return "HranyFilm{" +
                "nazov='" + getNazov() + '\'' +
                ", reziser='" + getReziser() + '\'' +
                ", rokVydania=" + getRokVydania() +
                ", HodnotenieDivakov=" + getHodnotenieDivakov() +
                ", zoznamHercov=" + zoznamHercov +
                '}';
    }
}

