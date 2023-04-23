package pckg;

public class HodnotenieDivakov {
 private int bodoveHodnotenie;
 private String slovneHodnotenie;

 public HodnotenieDivakov(int bodoveHodnotenie) {
     this.bodoveHodnotenie = bodoveHodnotenie;
     this.slovneHodnotenie = null;
 }

 public HodnotenieDivakov(int bodoveHodnotenie, String slovneHodnotenie) {
     this.bodoveHodnotenie = bodoveHodnotenie;
     this.slovneHodnotenie = slovneHodnotenie;
 }

 public int getBodoveHodnotenie() {
     return bodoveHodnotenie;
 }

 public String getSlovneHodnotenie() {
     return slovneHodnotenie;
 }

 @Override
 public String toString() {
     if (slovneHodnotenie != null) {
         return bodoveHodnotenie + " (" + slovneHodnotenie + ")";
     } else {
         return Integer.toString(bodoveHodnotenie);
     }
 }
}
