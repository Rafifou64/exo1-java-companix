import java.time.LocalDate;

public class Analyste extends Salarie {
	
	private int deplacementClient;

	Analyste(String code, String nom, String prenom, LocalDate dateEmbauche, int deplacementClient) {
		super(code, nom, prenom, dateEmbauche);
		
		this.deplacementClient = deplacementClient;		
	}
	
	@Override 
	public String toString()
	{
		return super.toString() + " | Deplacement client: " + Integer.toString(deplacementClient);			
	}
	
	//#region Getters/Setters
	public int getDeplacementClient() {
		return deplacementClient;
	}

	public void setDeplacementClient(int deplacementClient) {
		this.deplacementClient = deplacementClient;
	}
	//#end region

}
