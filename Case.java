import java.io.Serializable;

@SuppressWarnings("serial")
public class Case implements Serializable{

	private int ligne;
	private int colonne;
	private String couleur;
	private Piece p;
	
	public Case(){
		
	}
	
	public Case(int ligne, int colonne, String couleur, Piece p) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.couleur = couleur;
		this.p = p;
	}
	
	public int getLigne() {
		return this.ligne;
	}
	
	public int getColonne() {
		return this.colonne;
	}
	
	public Piece getPiece() {
		return this.p;	
	}

	public String getCouleur() {
		return this.couleur;
	}
	
	
	public void setPiece(Piece p){
		this.p=p;
	}
		
	public boolean caseOccupee() {
		if (p == null) 
			return false;
		return true;
	}
		
	public String toString(){
		return p.toString();
	}
	
}
