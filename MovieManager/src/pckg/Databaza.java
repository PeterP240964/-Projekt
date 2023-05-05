package pckg;


import java.util.*;
import java.io.*;


public class Databaza implements Serializable
{
	private static final long serialVersionUID = 1L; //osetrenie warningu 
	
	public Databaza() 
	{
		komponentyDatabazy=new HashMap<String, Film>();
	}
	
	private HashMap<String, Film> komponentyDatabazy;
	
	public void addHranyF(String nazov, String reziser, int rokVydania, ArrayList<String> zoznamHercov) 
	{
		HranyF hranyf = new HranyF(nazov, reziser, rokVydania, zoznamHercov);
		this.komponentyDatabazy.put(nazov, hranyf);
	}
	
	public void addAnimovanyF(String nazov, String reziser, int rokVydania, ArrayList<String> zoznamAnimatorov, int doporucenyVek) 
	{
		AnimovanyF animovanyf = new AnimovanyF(nazov, reziser, rokVydania, zoznamAnimatorov, doporucenyVek);
		this.komponentyDatabazy.put(nazov, animovanyf);
	}

	public Film getFilm(String nazov)
	{
		return komponentyDatabazy.get(nazov);
		
	}
	
	public void addHodnotenie(String nazov, Hodnotenie zoznamHodnotenia)
	{
		if (komponentyDatabazy.containsKey(nazov)) 
		{
			komponentyDatabazy.get(nazov).noveHodnotenia(zoznamHodnotenia);
		} else
			{
				System.out.println("Film: " + nazov +" neexistuje");
			}
	}
	
	public boolean deleteFilm(String nazov)
	{
		if(komponentyDatabazy.containsKey(nazov))
		{
			Film temporary = this.getFilm(nazov);
			komponentyDatabazy.remove(nazov);
			return true;
		}
		return false;
	}
		
	//public void FilmPodlaHodnotenia()
	//{
		//ArrayList<Film> hranyF = new ArrayList<>();
		//ArrayList<Film> animovanyF = new ArrayList<>();
		//Iterator<String> iter = komponentyDatabazy.keySet().iterator();
		 //while (iter.hasNext()) 
		 //{

	            //String key = iter.next();
	            //Film temp = komponentyDatabazy.get(key);
	            //if (temp instanceof HranyF) //pre hrane filmy
	            //{ 
	                //hranyF.add(temp);
	            //} 
	            	//else if (temp instanceof AnimovanyF) //pre animovane filmy
	            		//{ 
	                		//animovanyF.add(temp);
	            		//}
		 //}
		//Collections.sort(hranyF);
	    //Collections.sort(animovanyF); 
	    
	//}
	public void SaveToFile() throws IOException
	{
		File directory = new File(System.getProperty("user.dir") + File.separator +"database");
		if (directory.exists())
		{
			
			for (String item : komponentyDatabazy.keySet()) {
				FileWriter fw = null; BufferedWriter out = null;
				
				File file = new File(directory.getName()+ File.separator + komponentyDatabazy.get(item).getNazov().trim() +".txt");
				fw = new FileWriter(file);
				out = new BufferedWriter(fw);
				
				try {
				 	out.write(new String( "Nazev: "+ komponentyDatabazy.get(item).getNazov() + "\n"
				 			+ "Reziser: "+ komponentyDatabazy.get(item).getReziser() + "\n"
				 			+ "Rok: "+ komponentyDatabazy.get(item).getRokVydania() + "\n"));
				 	
				 	if (komponentyDatabazy.get(item) instanceof AnimovanyF) {
				 		AnimovanyF animovanyF = (AnimovanyF) komponentyDatabazy.get(item);
				 		out.write("Doporuceny vek: " + animovanyF.getDoporucenyVek() + "\n"); }
				 	
				 	out.write(new String("Ucinkujici: "));
				 	for (String actor : komponentyDatabazy.get(item).getZoznamHercovAAnimatorov()) {
				 		
						out.write(actor + ", ");
						
					}
				 	
					 	out.write(new String("\nHodnotenie: "));
					 	for (Hodnotenie hodnotenie : komponentyDatabazy.get(item).getHodnotenia()) {
						out.write(new String(  "\n" + hodnotenie.getBodoveHodnotenie() + " - " + hodnotenie.getSlovneHodnotenie()));
					}
				 	}
				
				catch (IOException e) {
				System.out.println("Soubor nelze otevøít");
				} 
				
				finally {
				out.close(); fw.close();
				}
				
			}
		}
		else 
		{
			directory.mkdir();
			SaveToFile();
		}
		
	}
	
	public HashSet<Film> getHranyF() //ziskava hrany film z databazy
	   {
	        HashSet<Film> result = new HashSet<>();
	        Iterator<String> iter = komponentyDatabazy.keySet().iterator();
	        while (iter.hasNext())
	        {
	            String key = iter.next();
	            Film temp = komponentyDatabazy.get(key);
	            if (temp instanceof HranyF) {
	                result.add(temp);
	            }
	        }
	        return result;
	    }

	public HashSet<Film> getAnimovanyF() //ziskava animovany film z databazy
	    {
	        HashSet<Film> result = new HashSet<>();
	        Iterator<String> iter = komponentyDatabazy.keySet().iterator();
	        while (iter.hasNext())
	        {
	            String key = iter.next();
	            Film temp = komponentyDatabazy.get(key);
	            if (temp instanceof AnimovanyF) {
	                result.add(temp);
	            }
	        }
	        return result;
	    }

	public void readFromFile(String loadname) throws IOException, ClassNotFoundException 
	{
        try (FileInputStream in = new FileInputStream(loadname);
               ObjectInputStream s = new ObjectInputStream(in)) 
        			{
        				komponentyDatabazy = (HashMap<String, Film>) s.readObject();
        			}
    }
	
	public void ulozitDoSuboru(String savename)throws IOException
	{
		try (FileOutputStream f = new FileOutputStream(savename);
			ObjectOutput s =new ObjectOutputStream(f))
		{
			s.writeObject(komponentyDatabazy);
		}
	}
	
	  public void vymazanieDatabazy(){  //funkcia na premazanie db
	        this.komponentyDatabazy = new HashMap<String, Film>();
	    }

}
