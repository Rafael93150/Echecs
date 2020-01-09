import java.io.Serializable;


public class Fou extends Piece implements Serializable{
	
	private static final long serialVersionUID = 8250999734099907608L;

	public Fou() {
		
	}

	public Fou(String couleur) {
		super(couleur,"Fou");
	}
		
	public String toString() {
		if(couleur=="noir"){
			return "\u265D";
		}
		else{
			return "\u2657";
		}
	}
	
	public boolean deplacementValide(Case[][] plateau, Case cd, Case ca) {

		
		if (ca.getPiece() == null || ca.getPiece().getCouleur() != couleur) {
			if ( Math.abs(ca.getLigne() - cd.getLigne()) == Math.abs(ca.getColonne() - cd.getColonne()) ) {
				
				if(cd.getLigne()==ca.getLigne()+1 && cd.getColonne()==ca.getColonne()-1){
					return true;
				}
				if(cd.getLigne()==ca.getLigne()+1 && cd.getColonne()==ca.getColonne()+1){
					return true;
				}
				if(cd.getLigne()==ca.getLigne()-1 && cd.getColonne()==ca.getColonne()-1){
					return true;
				}
				if(cd.getLigne()==ca.getLigne()-1 && cd.getColonne()==ca.getColonne()+1){
					return true;
				}
				
				
				if(cd.getLigne()>ca.getLigne()&& cd.getColonne()>ca.getColonne()){ //deplacement vers haut gauche

				for(int i=cd.getColonne();i>ca.getColonne();i--){
					if(plateau[cd.getLigne()-1][cd.getColonne()-1].caseOccupee()==true){
						System.out.println("false1");
						return false;

					}
				}
				return true;
			}
				
				if(cd.getLigne()>ca.getLigne()&& cd.getColonne()<ca.getColonne()){
					for(int i=cd.getColonne();i<ca.getColonne();i++){    //deplacement vers haut droite
						if(plateau[cd.getLigne()-1][cd.getColonne()+1].caseOccupee()==true){
							System.out.println("false2");
							return false;
							
						}
					}
				return true;
				}
				
				if (cd.getLigne()<ca.getLigne()&& cd.getColonne()>ca.getColonne()){ //deplacement bas gauche 
					for(int i=cd.getColonne();i>ca.getColonne();i--){
						if(plateau[cd.getLigne()+1][cd.getColonne()-1].caseOccupee()==true){
							System.out.println("false3");
							return false;
							
						}
					}
				return true;
			}
				
				
				if(cd.getLigne()<ca.getLigne()&& cd.getColonne()<ca.getColonne()){// deplacement bas droit
					for(int i=cd.getColonne();i<ca.getColonne();i++){
						if(plateau[cd.getLigne()+1][cd.getColonne()+1].caseOccupee()==true){
							System.out.println("false4");
							return false;
							
						}
					}
					return true;
				}
			
			}
			System.out.println("false5");
			return false;
		
		
		}
		return false;
	}
}
