package pckg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	        
    	List<Film> zoznamFilmov = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            int volba = 0;
            boolean run = true;
            int iteration = 0;
			
			VytvorenieTest.filmTest(zoznamFilmov); //pridanie testovacich filmov

		    while (run) {
		        if (iteration == 0)
		          iteration++;
		        else
			        System.out.println(System.lineSeparator());	
				    System.out.println("Vyberte pozadovanou cinnost:");
				    System.out.println("1 (a) - Pridanie noveho filmu (hrany / animovany)");
				    System.out.println("2 (b) - Upravenie filmu podla nazvu");
				    System.out.println("3 (c) - Zmazanie filmu podla nazvu");
				    System.out.println("4 (d) - Pridanie hodnotenia filmu");
				    System.out.println("5 (e) - Vypis filmov");
				    System.out.println("6 (f) - Vyhladanie filmu");
				    System.out.println("7 (g) - Vypis hercov / animatorov hrajucich na vsetkych filmoch");
				    System.out.println("8 (h) - Vypis vsetkych filmov kde hra konkretny herec / animator");
				    System.out.println("9 (i) - Uložení informace o vybraném filmu (dle jeho názvu) do souboru");
				    System.out.println("10 (j) - Načtení všech informací o daném filmu ze souboru (soubor obsahuje vždy jeden film)");
				    System.out.println("0 - Koniec");
				    volba = ConsoleInputCheck.readNumberInputFromConsole(sc);

			    switch (volba) {
			    
			    case 0:
			        run = false;
			        break;

			    case 1:	
			        System.out.println("Zadajte nazov filmu:");
			        sc.nextLine(); // Clear newline characters
			        String nazov = sc.nextLine();
			        System.out.println("Zadajte meno rezisera:");
			        String reziser = sc.nextLine();
			        System.out.println("Zadajte rok vydania:");
			        int rok = sc.nextInt();
			        System.out.println("Zadajte hodnotenie divakov (1-10):");
			        int hodnotenie = sc.nextInt();
			        sc.nextLine();

			        System.out.println("Vyberte typ filmu:");
			        System.out.println("1 - Hrany film");
			        System.out.println("2 - Animovany film");
			        int typ = sc.nextInt();
			        sc.nextLine();

			        if (typ == 1) {
			            System.out.println("Zadajte zoznam hercov oddelenych ciarkou:");
			            String[] herci = sc.nextLine().split(",");
			            ArrayList<String> zoznamHercov = new ArrayList<>();
			            for (String herec : herci) {
			            	zoznamHercov.add(herec.trim());
			            }
			            HodnotenieDivakov hodnotenie1 = new HodnotenieDivakov(hodnotenie);
			            Film hranyFilm = new HranyF(nazov, reziser, rok, hodnotenie1, zoznamHercov);
			            zoznamFilmov.add(hranyFilm);
			        } else if (typ == 2) {
			            System.out.println("Zadajte zoznam animatorov oddelenych ciarkou:");
			            String[] animatori = sc.nextLine().split(",");
			            ArrayList<String> zoznamAnimatorov = new ArrayList<>();
			            for (String animator : animatori) {
			            	zoznamAnimatorov.add(animator.trim());
			            }
			            HodnotenieDivakov hodnotenie2 = new HodnotenieDivakov(hodnotenie);
			            System.out.println("Zadajte doporuceny vek:");
			            int doporucenyVek = sc.nextInt();
			            sc.nextLine();
			            Film animFilm = new AnimovanyF(nazov, reziser, rok, hodnotenie2, zoznamAnimatorov, doporucenyVek);
			            zoznamFilmov.add(animFilm);
			        }
			        break;
			        
			    case 2:
			    	boolean nasielSa = false;
			    	System.out.println("Zadajte nazov upravovaneho filmu:");
			    	sc.nextLine(); // Clear newline characters
			    	String nazovUpravovanehoFilmu = sc.nextLine();
			    	for (Film film : zoznamFilmov) {
			    		if (film.getNazov().equals(nazovUpravovanehoFilmu)) {
			    			nasielSa = true;
			    			System.out.println("Vyberte, co chcete upravit:");
			    			System.out.println("1 - Nazov");
			    			System.out.println("2 - Rezisera");
			    			System.out.println("3 - Rok vydania");
			    			System.out.println("4 - Hodnotenie divakov");
			    			System.out.println("5 - Zoznam hercov/animatorov");
			    			int volbaUpravy = sc.nextInt();
			    			sc.nextLine();

			    			switch (volbaUpravy) {
			    				case 1:
			    					System.out.println("Zadajte novy nazov:");
			    					String novyNazov = sc.nextLine();
			    					film.setNazov(novyNazov);
			    					break;

			    				case 2:
			    					System.out.println("Zadajte nove meno rezisera:");
			    					String novyReziser = sc.nextLine();
			    					film.setReziser(novyReziser);
			    					break;

			    				case 3:
			    					System.out.println("Zadajte novy rok vydania:");
			    					int novyRok = sc.nextInt();
			    					sc.nextLine();
			    					film.setRokVydania(novyRok);
			    					break;

			    				case 4:
			    					System.out.println("Zadajte nove hodnotenie divakov (1-10):");
			    					int noveHodnotenie = sc.nextInt();
			    					sc.nextLine();
			    					HodnotenieDivakov noveHodnotenie1 = new HodnotenieDivakov(noveHodnotenie);
			    					film.setHodnotenieDivakov(noveHodnotenie1);
			    					break;

			    				case 5:
			    					if (film instanceof HranyF) {
			    						System.out.println("Zadajte zoznam hercov oddelenych ciarkou:");
			    						String[] herci = sc.nextLine().split(",");
			    						ArrayList<String> seznamHercu = new ArrayList<>();
			    						for (String herec : herci) {
			    							seznamHercu.add(herec.trim());
			    						}
			    						((HranyF) film).setZoznamHercov(seznamHercu);
			    					} else if (film instanceof AnimovanyF) {
			    						System.out.println("Zadajte zoznam animatorov oddelenych ciarkou:");
			    						String[] animatori = sc.nextLine().split(",");
			    						ArrayList<String> zoznamAnimatorov = new ArrayList<>();
			    						for (String animator : animatori) {
			    							zoznamAnimatorov.add(animator.trim());
			    						}
			    						((AnimovanyF) film).setZoznamAnimatorov(zoznamAnimatorov);
			    					}
			    					break;

			    	        default:
			    	            System.out.println("Neplatna volba!");
			    	            break;
			    	        }
			    	        break;
			    	    }
			    	}
			    	if (!nasielSa) {
			    		System.out.println("Film s názvom " + nazovUpravovanehoFilmu + " nebol nájdený.");
			    	}
			    	break;
			        
			    case 3:
			        System.out.println("Zadajte názov filmu, ktorý chcete zmazať:");
			        sc.nextLine(); // Clear newline characters
			        String nazovMazanehoFilmu = sc.nextLine();
			        boolean bolVymazany = false;
			        for (int i = 0; i < zoznamFilmov.size(); i++) {
			            Film film = zoznamFilmov.get(i);
			            if (film.getNazov().equals(nazovMazanehoFilmu)) {
			                zoznamFilmov.remove(i);
			                bolVymazany = true;
			                break;
			            }
			        }
			        if (bolVymazany) {
			            System.out.println("Film bol zmazaný.");
			        } else {
			            System.out.println("Film s názvom " + nazovMazanehoFilmu + " nebol nájdený.");
			        }
			        break;
			        
			    case 5:
			        System.out.println("Vybrali jste vypsání všech filmů.");
			        for (Film film : zoznamFilmov) {
			            System.out.println(film.toString());
			        }
			        break;

			    default:
			        System.out.println("Takato volba neexistuje.");
			        break;

			    }
			}
		}
    }
}
