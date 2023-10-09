import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Salarie {
	private String code;
	private String nom;
	private String prenom;
	private LocalDate dateEmbauche;
	
	Salarie(String code, String nom, String prenom, LocalDate dateEmbauche) {
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;		
		this.dateEmbauche = dateEmbauche;	
	}
	
	public String toString()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String dateEmbaucheString = dateEmbauche.format(formatter);
		
		String typeSalarie = "";
		if(this instanceof Concepteur)
		{
			typeSalarie = "Concepteur";
		}
		else if(this instanceof Analyste)
		{
			typeSalarie = "Analyste";
		}
		
		return "Code: " + code + " | Nom: "+ nom + " | Prenom: " + prenom + " | dateEmbauche: " 
				+ dateEmbaucheString + " | typeSalarie: " + typeSalarie;
	}

	//#region Getters/Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	//#end region
}
