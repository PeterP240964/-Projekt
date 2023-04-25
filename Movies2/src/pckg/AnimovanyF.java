package pckg;

import java.util.ArrayList;

public class AnimovanyF extends Film {
 private ArrayList<String> zoznamAnimatorov;
 private int doporucenyVek;
 
 public AnimovanyF(String nazov, String reziser, int rokVydania, Hodnotenie hodnotenie, ArrayList<String> zoznamAnimatorov, int doporucenyVek) {
     super(nazov, reziser, rokVydania, hodnotenie); //tento konstruktor vola z konstruktoru Film
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
             ", hodnotenie=" + getHodnotenie() +
             ", zoznamAnimatorov=" + zoznamAnimatorov +
             ", doporucenyVek=" + doporucenyVek +
             '}';
 }
}
