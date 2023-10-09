import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Salarie> lstSalarie = getInitListeSalarie();
		
		menuChoix(lstSalarie);

	}
	
	private static void menuChoix(ArrayList<Salarie> lstSalarie)
	{
		int choice = 0;
		
		System.out.println("Bonjour et bienvenue sur Companix");
		System.out.println("Faites votre choix parmi ces propositions (1, 2, 3, 4, 5, 6) :");
		System.out.println("1- Ajouter un concepteur");
		System.out.println("2- Supprimer un concepteur");
		System.out.println("3- Lister les concepteurs existants");
		System.out.println("4- Ajouter un analyste");
		System.out.println("5- Supprimer un analyste");
		System.out.println("6- Lister les salariés existants");	
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			choice = Integer.parseInt(in.readLine());			
		} catch (Exception e) {
			System.out.println("Entrez bien un chiffre entre 0 et 6");
			menuChoix(lstSalarie);
		}
		
		switch(choice){
		   
	       case 1: 
	    	   Salarie nouveauSalarie = createSalarie(true, lstSalarie);
	    	   if(nouveauSalarie != null)
	    	   {
	    		   lstSalarie.add(nouveauSalarie);	   
	    	   }
	           break;
	   
	       case 2:
	    	   deleteSalarie(lstSalarie, true);
	           break;
	   
	       case 3:
	    	   showListSalarie(true, false, lstSalarie);
	           break;
	           
	       case 4: 
	    	   lstSalarie.add(createSalarie(false, lstSalarie));
	           break;
	   
	       case 5:
	    	   deleteSalarie(lstSalarie, false);
	           break;
	   
	       case 6:
	    	   showListSalarie(true, true, lstSalarie);
	           break;
	           
	       default:
	           System.out.println("Choix incorrect");
	           break;
	   }
		
		if(choice != 0)
		{
			menuChoix(lstSalarie);			
		}
	}

	private static ArrayList<Salarie> getInitListeSalarie()
	{
		ArrayList<Salarie> lstSalarieReturn = new ArrayList<Salarie>();
		Concepteur cyril = new Concepteur("0002", "PESTANA", "Cyril", LocalDate.parse("2014-12-27"), 2);
		lstSalarieReturn.add(cyril);
		Analyste jacques = new Analyste("0003", "DUPONT", "Jacques", LocalDate.parse("2016-12-27"), 7);
		lstSalarieReturn.add(jacques);
		Concepteur marceline = new Concepteur("0004", "DUPOND", "Marceline", LocalDate.parse("2018-12-27"), 1);
		lstSalarieReturn.add(marceline);
		
		return lstSalarieReturn;
	}

	private static Salarie createSalarie(boolean isConcepteur, ArrayList<Salarie> lstSalarie)
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String code = "";
		String nom = "";
		String prenom = "";
		String dateEmbauche = "";
		Salarie salarie = null;
		LocalDate localDateEmbauche = null;
		
		
		System.out.println("Entrez le code :");
		try {
			code = in.readLine();
			final String codeCompare = code;
				
			if(lstSalarie.stream().filter(s -> codeCompare.equals(s.getCode())).findFirst().isPresent())
			{
				System.out.println("Code salarie déjà présent, veuillez recommencer");
				return null;
			}						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Entrez le nom :");
		try {
			nom = in.readLine();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Entrez le prenom :");
		try {
			prenom = in.readLine();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Entrez le dateEmbauche dans le format (yyyy-mm-dd) :");
		try {
			dateEmbauche = in.readLine();
			
			localDateEmbauche = LocalDate.parse(dateEmbauche);
		} catch (Exception e) {
			System.out.println("Veuillez bien respecter le format de la date");
			menuChoix(lstSalarie);
		}
		
		if(isConcepteur)
		{
			salarie = createConcepteur(code, nom, prenom, localDateEmbauche, lstSalarie);
		}
		else
		{
			salarie = createAnalyste(code, nom, prenom, localDateEmbauche, lstSalarie);
		}
		
		return salarie;
	}
	
	private static Concepteur createConcepteur(String code, String nom, String prenom, LocalDate dateEmbauche, ArrayList<Salarie> lstSalarie)
	{	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int nbAnneeDev = 0;
		System.out.println("Entrez le nombre d'annee de developpement :");
		try {
			nbAnneeDev = Integer.parseInt(in.readLine());	
		} catch (Exception e) {
			System.out.println("Veuillez saisir un nombre entier valide");
			menuChoix(lstSalarie);
		}	
		
		Concepteur concepteur = new Concepteur(code, nom, prenom, dateEmbauche, nbAnneeDev);
		
		return concepteur;
	}
	
	private static Analyste createAnalyste(String code, String nom, String prenom, LocalDate dateEmbauche, ArrayList<Salarie> lstSalarie)
	{	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int nbDeplacementClient = 0;
		System.out.println("Entrez le nombre de deplacement client :");
		try {
			nbDeplacementClient = Integer.parseInt(in.readLine());	
		} catch (Exception e) {
			System.out.println("Veuillez saisir un nombre entier valide");
			menuChoix(lstSalarie);
		}
		
		Analyste analyste = new Analyste(code, nom, prenom, dateEmbauche, nbDeplacementClient);
		
		return analyste;
	}
	
	private static void deleteSalarie(ArrayList<Salarie> lstSalarie, boolean isConcepteur)
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String codeDelete = "";
		Salarie salarieDelete = null;
		System.out.println("Entrez le code salarie a supprimer :");
		try {
			codeDelete= in.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		final String codeCompare = codeDelete;
		
		Optional<Salarie> salarieOpt = lstSalarie.stream().filter(salarie -> codeCompare.equals(salarie.getCode())).findFirst();
		if(salarieOpt.isPresent())
		{
			salarieDelete = salarieOpt.get();
			
			if(salarieDelete instanceof Concepteur && isConcepteur == true)
			{
				lstSalarie.remove(salarieDelete);			
			}
			else if(salarieDelete instanceof Analyste && isConcepteur == false)
			{
				lstSalarie.remove(salarieDelete);				
			}			
		}
		else
		{
			System.out.println("Le code salarie est introuvable");
		}
	}

	private static void showListSalarie(boolean showConcepteur, boolean showAnalyste, ArrayList<Salarie> lstSalarie)
	{		
		for (int i = 0; i < lstSalarie.size(); i++) {
			
			if((showConcepteur == true && showAnalyste == false && lstSalarie.get(i) instanceof Concepteur) ||
				(showConcepteur == false && showAnalyste == true && lstSalarie.get(i) instanceof Analyste) ||
				(showConcepteur == true && showAnalyste == true))
			{
				Collections.sort(lstSalarie, (o1, o2) -> o1.getCode().compareTo(o2.getCode()));
				System.out.println(lstSalarie.get(i).toString());
			}
		}
	}
	
	/*private static ArrayList<Salarie> filterListeConcepteur(ArrayList<Salarie> lstSalarie)
	{
		for (int i = 0; i < lstSalarie.size(); i++) {
			Salarie salarie = lstSalarie.get(i);
			
			if(salarie instanceof Analyste)
			{
				lstSalarie.remove(i);				
			}
		}
		
		return lstSalarie;
	}
	
	private static ArrayList<Salarie> filterListeAnalyste(ArrayList<Salarie> lstSalarie)
	{
		for (int i = 0; i < lstSalarie.size(); i++) {
			Salarie salarie = lstSalarie.get(i);
			
			if(salarie instanceof Concepteur)
			{
				lstSalarie.remove(i);				
			}
		}
		
		return lstSalarie;
	}*/
}
