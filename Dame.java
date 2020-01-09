import java.io.Serializable;

public class Dame extends Piece implements Serializable{

	private static final long serialVersionUID = 5309572273431236565L;

	public Dame() {
		
	}
	
	public Dame(String couleur) {
		super(couleur,"Dame");
	}
	
	public String toString() {
		if(couleur=="noir"){
			return "\u265B";
		}
		else{
			return "\u2655";
		}
	}
	
	public boolean deplacementValide(Case[][] plateau, Case ca, Case cd) {
		if (ca.getPiece() == null || ca.getPiece().getCouleur() != couleur) {
		if ( ( (ca.getColonne() == cd.getColonne()) || (ca.getLigne() == cd.getLigne()) || // comme la tour
				Math.abs(ca.getLigne() - cd.getLigne()) == Math.abs(ca.getColonne() - cd.getColonne()) ) ) { // comme le fou
			
			
			
			
			
			if( (ca.getColonne() == cd.getColonne()) || (ca.getLigne() == cd.getLigne())){
				
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
							System.out.println(plateau);
							if(plateau[cd.getLigne()-1][cd.getColonne()].caseOccupee()==true){
								System.out.println("false1");
								return false;
							}
						}
						return true;
					}
								
					
					
					if(cd.getLigne()<ca.getLigne()){  //vers le bas
						
						for (int i=cd.getLigne();i<ca.getLigne();i++){
							System.out.println(plateau[0][0]);
							if(plateau[cd.getLigne()+1][cd.getColonne()].caseOccupee()==true){
								System.out.println("false2");
								return false;
							}
						}
					}
					
					if (cd.getColonne()>ca.getColonne()){//vers la gauche
						for(int i=cd.getColonne();i>ca.getColonne();i--){
							if(plateau[cd.getLigne()][cd.getColonne()-1].caseOccupee()==true){
								System.out.println("false3");
								return false;
							}
						}
						return true;
					}
					
					if (cd.getColonne()<ca.getColonne()){//vers la droite
						for(int i=cd.getColonne();i<ca.getColonne();i++){
							if(plateau[cd.getLigne()][cd.getColonne()+1].caseOccupee()==true){
								System.out.println("false4");
								return false;
							}
						}
						return true;
					}
			}
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
				
				if(cd.getLigne()>ca.getLigne()&& cd.getColonne()>ca.getColonne()){ //deplacement vers haut  gauche
					
				for(int i=cd.getColonne();i>ca.getColonne();i--){				
					if(plateau[cd.getLigne()-1][cd.getColonne()-1].caseOccupee()==true){
						return false;
					
					}

				}
				return true;
			}
				
				if(cd.getLigne()>ca.getLigne()&& cd.getColonne()<ca.getColonne()){
					for(int i=cd.getColonne();i<ca.getColonne();i++){    //deplacement vers haut droite
						if(plateau[cd.getLigne()-1][cd.getColonne()+1].caseOccupee()==true){
							return false;
							
						}
					}
				return true;
				}
				
				if (cd.getLigne()<ca.getLigne()&& cd.getColonne()>ca.getColonne()){ //deplacement bas gauche 
					for(int i=cd.getColonne();i>ca.getColonne();i--){
						if(plateau[cd.getLigne()+1][cd.getColonne()-1].caseOccupee()==true){
							return false;
							
						}
					}
				return true;
			}
				
				
				if(cd.getLigne()<ca.getLigne()&& cd.getColonne()<ca.getColonne()){// deplacement bas droit
					for(int i=cd.getColonne();i<ca.getColonne();i++){
						if(plateau[cd.getLigne()+1][cd.getColonne()+1].caseOccupee()==true){
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
		return false;





	}
}