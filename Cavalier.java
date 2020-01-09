import java.io.Serializable;


public class Cavalier extends Piece implements Serializable{
	
	private static final long serialVersionUID = 479950153254013726L;

	public Cavalier() {
		
	}
	
	public Cavalier(String couleur) {
		super(couleur,"Cavalier");

	}
	public String toString() {
		if(couleur=="noir"){
			return "\u265E";
		}
		else{
			return "\u2658";
		}
	}

	public boolean deplacementValide(Case[][] plateau, Case cd, Case ca) {
		if (ca.getPiece() == null || ca.getPiece().getCouleur() != couleur) {
			if ( ((Math.abs(ca.getLigne() - cd.getLigne()) == 2) && (Math.abs(ca.getColonne() - cd.getColonne()) == 1)) || 
			((Math.abs(ca.getLigne() - cd.getLigne()) == 1) && (Math.abs(ca.getColonne() - cd.getColonne()) == 2)) ) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
