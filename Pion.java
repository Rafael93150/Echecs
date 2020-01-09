import java.io.Serializable;

public class Pion extends Piece implements Serializable{

	private static final long serialVersionUID = -1440756278572548986L;
	boolean premierCoup = true;
	
	public Pion() {
		
	}
	
	public Pion(String couleur) {
		super(couleur,"Pion");
	}
	
	public String toString() {
		if(couleur=="noir"){
			return "\u265F";
		}
		else{
			return "\u2659";
		}
	}

	
	public boolean getPremierCoup() {
		return premierCoup;
	}
	
	public void setPremierCoup(boolean pc) {
		premierCoup = pc;
	}
	
	public boolean peutManger(Case cd, Case ca) {
		if (couleur == "blanc") {
			if ((ca.getColonne() == cd.getColonne() -1 || ca.getColonne() == cd.getColonne() +1) && ca.getLigne() == cd.getLigne() -1) {
				if (ca.getPiece()!=null) {
					if (!ca.getPiece().getCouleur().equals(couleur)) {
						premierCoup = false;
						return true;
					}
				}
			}
			
		}
		if (couleur == "noir") {
			if ((ca.getColonne() == cd.getColonne() +1 || ca.getColonne() == cd.getColonne() -1) && ca.getLigne() == cd.getLigne() +1) {
				if (ca.getPiece()!=null) {
					if (!ca.getPiece().getCouleur().equals(couleur)) {
						premierCoup = false;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	public boolean deplacementValide(Case[][] plateau, Case cd, Case ca) {
		//pour un pion blanc
		if (couleur == "blanc") {
			
			
			if (peutManger(cd, ca) == true) {
				//System.out.println("peut manger dans blanc");
				return true;
			}
			if (premierCoup == true) {
				//System.out.println("premier coup valide dans blanc");
				if (ca.getColonne() == cd.getColonne() && ((ca.getLigne() == cd.getLigne() - 1) || (ca.getLigne() == cd.getLigne() -2)) ) {
					if(ca.getLigne() == cd.getLigne() - 1){
						premierCoup=false;
						return true;
					}
					if(ca.getLigne() == cd.getLigne() -2){
						if(plateau[cd.getLigne()-1][cd.getColonne()].caseOccupee()==false){
							premierCoup=false;
							return true;
						}
					}

				}

			}
			
			
			else {
				if (ca.getColonne() == cd.getColonne() && ((ca.getLigne() == cd.getLigne() - 1) || (ca.getLigne() == cd.getLigne() -2)) ) {
					if(ca.getLigne() == cd.getLigne() - 1 && ca.caseOccupee()==false){
						return true;
					}
				}
			}
			return false;
		}
		
		
		
		
		
		//pour un pion noir
		else {
			if (peutManger(cd, ca) == true) {
				
				//System.out.println("a peut manger");
				return true;
			}
			if (premierCoup == true) {
				//System.out.println("a peut premier coup manger");
				if (ca.getColonne() == cd.getColonne() && ((ca.getLigne() == cd.getLigne() + 1) || (ca.getLigne() == cd.getLigne() + 2))) {
					if(ca.getLigne() == cd.getLigne() + 1){
						premierCoup=false;
						return true;
					}
					if(ca.getLigne()==cd.getLigne()+2){
						if(plateau[cd.getLigne()+1][cd.getColonne()].caseOccupee()==false){
							premierCoup=false;
							return true;
						}
					}
				}
			}
			else {
				if (ca.getColonne() == cd.getColonne() && ((ca.getLigne() == cd.getLigne() + 1) || (ca.getLigne() == cd.getLigne() +2)) ) {
					if(ca.getLigne() == cd.getLigne() + 1 && ca.caseOccupee()==false){
						return true;
					}
				}
			}
			return false;

		}
	}
}


