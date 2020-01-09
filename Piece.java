
public abstract class Piece{

	protected String couleur;
	protected String nom;
	
	public Piece() {
		
	}
	
	public Piece(String couleur,String nom){
		this.couleur=couleur;
		this.nom=nom;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	
	public String getNom() {
		if(nom.contentEquals(null)) {
			nom = "  ";
		}
		return this.nom;
	}
	
	public void setCouleur(String couleur){
		this.couleur=couleur;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
	
	public abstract boolean deplacementValide(Case[][] plateau, Case cd, Case ca);
	
	public abstract String toString();
	
	
}