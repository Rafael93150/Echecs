import java.io.Serializable;

public class Roi extends Piece implements Serializable{

	private static final long serialVersionUID = 6169793971519476021L;


	public Roi() {
		
	}
	
	public Roi(String couleur) {
		super(couleur,"Roi");
	}
	
	public String toString() {
		if(couleur=="noir"){
			return "\u265A";
		}
		else{
			return "\u2654";
		}
	}
	
	
	public boolean deplacementValide(Case[][] plateau, Case cd ,Case ca) {
		if (ca.getPiece()==null||ca.getPiece().getCouleur() != couleur) {
			if (ca.getLigne()==cd.getLigne()-1 &&(ca.getColonne()==cd.getColonne()+1||ca.getColonne()==cd.getColonne()-1||ca.getColonne()==cd.getColonne())) {
				return true;
		}
			if(ca.getLigne()==cd.getLigne()&& (ca.getColonne()==cd.getColonne()-1||ca.getColonne()==cd.getColonne()+1)){
				return true;
			}
			
			if(ca.getLigne()==cd.getLigne()+1&&(ca.getColonne()==cd.getColonne()-1||ca.getColonne()==cd.getColonne()||ca.getColonne()==cd.getColonne()+1)){
				return true;
			}
		return false;
	}
	return false;

	}
}
