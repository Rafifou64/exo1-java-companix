import java.time.LocalDate;

public class Concepteur extends Salarie {
	
	private int anneeExperience;

	Concepteur(String code, String nom, String prenom, LocalDate dateEmbauche, int anneeExperience) {
		super(code, nom, prenom, dateEmbauche);
		
		this.anneeExperience = anneeExperience;		
	}
	
	@Override 
	public String toString()
	{
		return super.toString() + " | Année de déveleoppement: " + Integer.toString(anneeExperience);
	}

	//#region Getters/Setters
	public int getAnneeExperience() {
		return anneeExperience;
	}

	public void setAnneeExperience(int anneeExperience) {
		this.anneeExperience = anneeExperience;
	}
	//#end region

}
