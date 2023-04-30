package pckg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

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

			    case 1:	// Pridanie noveho filmu
			        System.out.println("Zadajte nazov filmu:");
			        sc.nextLine(); // Clear newline characters
			        String nazov = sc.nextLine();
			        System.out.println("Zadajte meno rezisera:");
			        String reziser = sc.nextLine();
			        System.out.println("Zadajte rok vydania:");
			        int rok = sc.nextInt();

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
			            Film hranyFilm = new HranyF(nazov, reziser, rok, zoznamHercov);
			            zoznamFilmov.add(hranyFilm);
			        } else if (typ == 2) {
			            System.out.println("Zadajte zoznam animatorov oddelenych ciarkou:");
			            String[] animatori = sc.nextLine().split(",");
			            ArrayList<String> zoznamAnimatorov = new ArrayList<>();
			            for (String animator : animatori) {
			                zoznamAnimatorov.add(animator.trim());
			            }
			            System.out.println("Zadajte doporuceny vek:");
			            int doporucenyVek = sc.nextInt();
			            sc.nextLine();
			            Film animFilm = new AnimovanyF(nazov, reziser, rok, zoznamAnimatorov, doporucenyVek);
			            zoznamFilmov.add(animFilm);
			        }
			        break;
			        
			    case 2: //Upravenie filmu podla nazvu
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
			    			System.out.println("4 - Zoznam hercov/animatorov");
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
			        
			    case 3: //Zmazanie filmu podla nazvu
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
			        
				case 4: //Pridanie hodnotenia filmu podla nazvu
			    	boolean nasielSaUprava = false;
			    	System.out.println("Zadajte nazov upravovaneho filmu:");
			    	sc.nextLine(); // Clear newline characters
			    	String pridanieHodnotenia = sc.nextLine();
			    	for (Film film : zoznamFilmov) {
						if (film.getNazov().equals(pridanieHodnotenia)) {
			    			nasielSaUprava = true;	    					
			    					if (film instanceof HranyF) {
			    						System.out.println("Zadajte bodove hodnotenie (1-5):");
				    					int bodoveHodnotenie = sc.nextInt();
				    					sc.nextLine();
				    					System.out.println("Zadajte slovne hodnotenie:");
				    					String slovneHodnotenie = sc.nextLine();
				    					Hodnotenie noveHodnotenie1 = new Hodnotenie(bodoveHodnotenie, slovneHodnotenie, 1, 5);
				    					List<Hodnotenie> hodnotenia = film.getHodnotenia();
				    					hodnotenia.add(noveHodnotenie1);
				    					film.setHodnotenia(hodnotenia);			    						

			    					} else if (film instanceof AnimovanyF) {
			    						System.out.println("Zadajte bodove hodnotenie (1-10):");
				    					int bodoveHodnotenie = sc.nextInt();
				    					sc.nextLine();
				    					System.out.println("Zadajte slovne hodnotenie:");
				    					String slovneHodnotenie = sc.nextLine();
				    					Hodnotenie noveHodnotenie2 = new Hodnotenie(bodoveHodnotenie, slovneHodnotenie, 1, 10);
				    					List<Hodnotenie> hodnotenia = film.getHodnotenia();
				    					hodnotenia.add(noveHodnotenie2);
				    					film.setHodnotenia(hodnotenia);	   						
				    					}	
			    					}
						}
			    	if (!nasielSaUprava) {
			    		System.out.println("Film s názvom " + pridanieHodnotenia + " nebol nájdený.");
			    	}
			    	break; 


			    case 5: //Vypis vsetkych filmov
			        System.out.println("Vybrali jste vypsání všech filmů.");
			        for (Film film : zoznamFilmov) {
			            System.out.println(film.toString());
			        }
			        break;
			        
			    //-------------------------------------------------------------------------Dorobit este vypisanie vsetkych informaci
			    case 6: //Vyhladanie filmu a vypisanie vsetkych informaci + hodnotenia
			        boolean nasielSaFilm = false;
			        sc.nextLine(); // Clear newline characters
			        System.out.println("Zadajte nazov filmu:");
			        String nazovFilmu1 = sc.nextLine();
			        for (Film film : zoznamFilmov) {
			            if (film.getNazov().equals(nazovFilmu1)) {
			                nasielSaFilm = true;
			                List<Hodnotenie> hodnotenia = film.getHodnotenia();
			                if (hodnotenia.size() == 0) {
			                    System.out.println("Pre tento film nie sú dostupné žiadne hodnotenia.");
			                } else {
			                    Collections.sort(hodnotenia, Collections.reverseOrder());
			                    System.out.println("Hodnotenia pre film " + nazovFilmu1 + ":");
			                    for (Hodnotenie hodnotenie : hodnotenia) {
			                        System.out.println(hodnotenie);
			                    }
			                }
			            }
			        }
			        if (!nasielSaFilm) {
			            System.out.println("Film s názvom " + nazovFilmu1 + " nebol nájdený.");
			        }
			        break;

			       
			    case 7: // Vypis hercov / animatorov hrajucich na vsetkych filmoch
			        Map<String, Set<String>> herciAanimatori = new HashMap<>();
			        for (Film film : zoznamFilmov) {
			            if (film instanceof HranyF) {
			                for (String herec : ((HranyF) film).getZoznamHercov()) {
			                    herciAanimatori.computeIfAbsent(herec, k -> new HashSet<>()).add(film.getNazov());
			                }
			            } else if (film instanceof AnimovanyF) {
			                for (String animator : ((AnimovanyF) film).getZoznamAnimatorov()) {
			                    herciAanimatori.computeIfAbsent(animator, k -> new HashSet<>()).add(film.getNazov());
			                }
			            }
			        }
			        boolean suDuplikaty = false;
			        for (Map.Entry<String, Set<String>> entry : herciAanimatori.entrySet()) {
			            if (entry.getValue().size() > 1) {
			                suDuplikaty = true;
			                System.out.println(entry.getKey() + " hral /a v tychto filmoch: ");
			                for (String nazov1 : entry.getValue()) {
			                    System.out.println("    " + nazov1);
			                }
			            }
			        }
			        if (!suDuplikaty) {
			            System.out.println("Ziadni herci / animatori nehrali v rovnakych filmoch.");
			        }
			        break;
			        
			    case 8: // Vypis filmov s konkretnym hercom / animatorom
			        Scanner scanner = new Scanner(System.in);
			        System.out.print("Zadaj hladaneho herca / animatora: ");
			        String hladany = scanner.nextLine();
			        
			        Map<String, Set<String>> herciAanimatori1Filmy = new HashMap<>();
			        for (Film film : zoznamFilmov) {
			            if (film instanceof HranyF) {
			                for (String herec : ((HranyF) film).getZoznamHercov()) {
			                    if (herec.toLowerCase().contains(hladany.toLowerCase())) {
			                        herciAanimatori1Filmy.computeIfAbsent(herec, k -> new HashSet<>()).add(film.getNazov());
			                    }
			                }
			            } else if (film instanceof AnimovanyF) {
			                for (String animator : ((AnimovanyF) film).getZoznamAnimatorov()) {
			                    if (animator.toLowerCase().contains(hladany.toLowerCase())) {
			                        herciAanimatori1Filmy.computeIfAbsent(animator, k -> new HashSet<>()).add(film.getNazov());
			                    }
			                }
			            }
			        }
			        boolean suDuplikaty1 = false;
			        for (Map.Entry<String, Set<String>> entry : herciAanimatori1Filmy.entrySet()) {
			            if (entry.getValue().size() > 0) {
			                suDuplikaty1 = true;
			                System.out.println(entry.getKey() + " hral /a v tychto filmoch: ");
			                for (String nazov1 : entry.getValue()) {
			                    System.out.println("    " + nazov1);
			                }
			            }
			        }
			        if (!suDuplikaty1) {
			            System.out.println("Nenasiel sa ziadny film s hladanym hercom / animatorom.");
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
