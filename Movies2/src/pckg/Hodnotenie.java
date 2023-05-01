package pckg;

import java.util.Comparator;

public class Hodnotenie implements Comparable<Hodnotenie> {
private int bodoveHodnotenie;
private String slovneHodnotenie;

	public Hodnotenie(int bodoveHodnotenie, String slovneHodnotenie, int minHodnota, int maxHodnota) {
	    if (bodoveHodnotenie < minHodnota || bodoveHodnotenie > maxHodnota) {
	        throw new IllegalArgumentException("Hodnota bodového hodnotenia musí byť medzi " + minHodnota + " a " + maxHodnota);
	    }
	    this.bodoveHodnotenie = bodoveHodnotenie;
	    this.slovneHodnotenie = slovneHodnotenie;
	}

	public int getBodoveHodnotenie() {
	    return bodoveHodnotenie;
	}

	public void setBodoveHodnotenie(int bodoveHodnotenie) {
	    this.bodoveHodnotenie = bodoveHodnotenie;
	}

	public String getSlovneHodnotenie() {
	    return slovneHodnotenie;
	}

	public void setSlovneHodnotenie(String slovneHodnotenie) {
	    this.slovneHodnotenie = slovneHodnotenie;
	}

	@Override
	public String toString() {
	    return bodoveHodnotenie + " - " + slovneHodnotenie;
	}

	@Override
	public int compareTo(Hodnotenie other) {
	    return Integer.compare(this.bodoveHodnotenie, other.bodoveHodnotenie);
	}

	public static Comparator<Hodnotenie> HodnotenieComparator = new Comparator<Hodnotenie>() {
	    public int compare(Hodnotenie hodnotenie1, Hodnotenie hodnotenie2) {
	        return Integer.compare(hodnotenie2.getBodoveHodnotenie(), hodnotenie1.getBodoveHodnotenie());
	    }
	};
}