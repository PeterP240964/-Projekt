package pckg;

import java.io.Serializable;
import java.util.ArrayList;

public class AnimovanyF extends Film implements Serializable{
 private ArrayList<String> zoznamAnimatorov;
 private int doporucenyVek;
 
 public AnimovanyF(String nazov, String reziser, int rokVydania, ArrayList<String> zoznamAnimatorov, int doporucenyVek) {
     super(nazov, reziser, rokVydania); //tento konstruktor vola z konstruktoru Film
     this.zoznamAnimatorov = zoznamAnimatorov;
     this.doporucenyVek = doporucenyVek;
 }

 public ArrayList<String> getZoznamAnimatorov() {
     return zoznamAnimatorov;
 }
 
 public void setZoznamAnimatorov(ArrayList<String> zoznamAnimatorov) {
	    this.zoznamAnimatorov = zoznamAnimatorov;
	}

 public int getDoporucenyVek() {
     return doporucenyVek;
 }
 
 public void setDoporucenyVek(int doporucenyVek) {
	    this.doporucenyVek = doporucenyVek;
	}

 @Override
 public String toString() {
     return "AnimovanyFilm{" +
             "nazov='" + getNazov() + '\'' +
             ", reziser='" + getReziser() + '\'' +
             ", rokVydania=" + getRokVydania() +
             ", zoznamAnimatorov=" + zoznamAnimatorov +
             ", doporucenyVek=" + doporucenyVek +
             '}';
 }
}
