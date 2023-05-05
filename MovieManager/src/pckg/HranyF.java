package pckg;

import java.io.Serializable;
import java.util.ArrayList;

public class HranyF extends Film implements Serializable {
    private ArrayList<String> zoznamHercov;
    
    public HranyF(String nazov, String reziser, int rokVydania, ArrayList<String> zoznamHercov) {
        super(nazov, reziser, rokVydania); //tento konstruktor vola z konstruktoru Film
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
                ", zoznamHercov=" + zoznamHercov +
                '}';
    }
}

