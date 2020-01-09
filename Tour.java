import java.io.Serializable;


public class Tour extends Piece implements Serializable{


	private static final long serialVersionUID = -4883876980747043373L;

	public Tour() {
		
	}
	
	public Tour(String couleur){
		super(couleur,"Tour");
	}
		
	public String toString() {
		if(couleur=="noir"){
			return "\u265C";
		}
		else{
			return "\u2656";
		}
	}
	

	public boolean deplacementValide(Case[][] plateau, Case cd, Case ca) {
		if (ca.getPiece() == null || ca.getPiece().getCouleur() != couleur) {		
		
		if ((ca.getColonne() == cd.getColonne()) || (ca.getLigne() == cd.getLigne())) {

			if(cd.getLigne()==ca.getLigne()-1 && cd.getColonne()==ca.getColonne()){
				return true;
			}
			if(cd.getLigne()==ca.getLigne()+1 && cd.getColonne()==ca.getColonne()){
				return true;
			}
			if(cd.getLigne()==ca.getLigne() && cd.getColonne()==ca.getColonne()-1){
				return true;
			}
			if(cd.getLigne()==ca.getLigne() && cd.getColonne()==ca.getColonne()+1){
				return true;
			}
			
			if(cd.getLigne()>ca.getLigne()&& cd.getColonne()==ca.getColonne()){//vers le haut
				
				for(int i=cd.getLigne();i>ca.getLigne();i--){
					if(plateau[cd.getLigne()-1][cd.getColonne()].caseOccupee()==true){
						//System.out.println("false1");
						return false;
					}
				//j=j+1;
				}
				return true;
			}
						
			
			
			if(cd.getLigne()<ca.getLigne()&& cd.getColonne()==cd.getColonne()){  //vers le bas
				
				for (int i=cd.getLigne();i<ca.getLigne();i++){
					System.out.println(plateau[0][0]);
					if(plateau[cd.getLigne()+1][cd.getColonne()].caseOccupee()==true){
						//System.out.println("false2");
						return false;
					}
				}
			}
			
			if (cd.getColonne()>ca.getColonne()){//vers la gauche
				for(int i=cd.getColonne();i>ca.getColonne();i--){
					if(plateau[cd.getLigne()][cd.getColonne()-1].caseOccupee()==true){
						//System.out.println("false3");
						return false;
					}
				}
				return true;
			}
			
			if (cd.getColonne()<ca.getColonne()){//vers la droite
				for(int i=cd.getColonne();i<ca.getColonne();i++){

					if(plateau[cd.getLigne()][cd.getColonne()+1].caseOccupee()==true){
						//System.out.println("false4");

						return false;
					}
				}
				return true;
			}
				
	}
		return false;
		}
		return false;

	}
}
