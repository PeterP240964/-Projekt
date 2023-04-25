package pckg;

public class Hodnotenie implements Comparable<Hodnotenie> { // triedu Hodnotenie je mozne porovnavat s inymi objektami v tejto triede
 private int hodnotenie;

 public Hodnotenie(int hodnotenie, int minHodnota, int maxHodnota) {
	    if (hodnotenie < minHodnota || hodnotenie > maxHodnota) {
	        throw new IllegalArgumentException("Hodnota hodnotenia musí byť medzi " + minHodnota + " a " + maxHodnota);
	    }
	    this.setHodnotenie(hodnotenie);
	}

	public int getHodnotenie() {
		return hodnotenie;
	}
	
	
	public void setHodnotenie(int hodnotenie) {
		this.hodnotenie = hodnotenie;
	}
	
	 @Override
	 public String toString() {
	         return Integer.toString(hodnotenie);
	     }
	 
	 @Override
	 public int compareTo(Hodnotenie other) {
	     return Integer.compare(this.hodnotenie, other.hodnotenie);
	 }
}
