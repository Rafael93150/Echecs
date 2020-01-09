
public class Echiquier {
	
	private int taille = 8;
	Case[][] plateau;
	private String couleur;

	
	public Echiquier() {
		this.plateau= new Case[taille][taille];
		for (int i = 0; i<taille; i++) {
			for (int j = 0; j<taille; j++) {
				if ((i%2==0 && j%2==0) || (!(i%2==0) && !(j%2==0))) {
					couleur = "blanc";
				}
				else {
					couleur = "noir";
				}
				this.plateau[i][j]=new Case(i,j,couleur,null);
			}
		}
	}

	public Piece getPiece(Case c) {
		return c.getPiece();
	}

	
	
	public void initialiseEchiquier(){
		
		plateau[0][0].setPiece(new Tour("noir"));
		plateau[0][1].setPiece(new Cavalier("noir"));
		plateau[0][2].setPiece(new Fou("noir"));
		plateau[0][3].setPiece(new Dame("noir"));
		plateau[0][4].setPiece(new Roi("noir"));
		plateau[0][5].setPiece(new Fou("noir"));
		plateau[0][6].setPiece(new Cavalier("noir"));
		plateau[0][7].setPiece(new Tour("noir"));
		plateau[1][0].setPiece(new Pion("noir"));
		plateau[1][1].setPiece(new Pion("noir"));
		plateau[1][2].setPiece(new Pion("noir"));
		plateau[1][3].setPiece(new Pion("noir"));
		plateau[1][4].setPiece(new Pion("noir"));
		plateau[1][5].setPiece(new Pion("noir"));
		plateau[1][6].setPiece(new Pion("noir"));
		plateau[1][7].setPiece(new Pion("noir"));
		plateau[7][0].setPiece(new Tour("blanc"));
		plateau[7][1].setPiece(new Cavalier("blanc"));
		plateau[7][2].setPiece(new Fou("blanc"));
		plateau[7][3].setPiece(new Dame("blanc"));
		plateau[7][4].setPiece(new Roi("blanc"));
		plateau[7][5].setPiece(new Fou("blanc"));
		plateau[7][6].setPiece(new Cavalier("blanc"));
		plateau[7][7].setPiece(new Tour("blanc"));
		plateau[6][0].setPiece(new Pion("blanc"));
		plateau[6][1].setPiece(new Pion("blanc"));
		plateau[6][2].setPiece(new Pion("blanc"));
		plateau[6][3].setPiece(new Pion("blanc"));
		plateau[6][4].setPiece(new Pion("blanc"));
		plateau[6][5].setPiece(new Pion("blanc"));
		plateau[6][6].setPiece(new Pion("blanc"));
		plateau[6][7].setPiece(new Pion("blanc"));
		
	}
	
	public void deplacer(Case cd, Case ca) {
		if (cd.getPiece()==null);
		else { //verification du deplacement valide ou non fait dans la classe Partie
				ca.setPiece(cd.getPiece());
				cd.setPiece(null);
		}
	}
	
	public void afficheEchiquier(){
		String[] numLigne={"8","7","6","5","4","3","2","1"}; 
		System.out.println("\n  -----------------------------------------");
		for(int i=0;i<8;i++){
			System.out.print(numLigne[i]+ " |");
			for (int j=0;j<8;j++){
				if (plateau[i][j].getPiece()==null){
					if (plateau[i][j].getCouleur()=="blanc") {
						System.out.print("    |");
					}
					else {
						System.out.print(" -- |");
					}
				} 
				else {
					String h= plateau[i][j].toString();
					if (plateau[i][j].getCouleur()=="blanc") {
						System.out.print("  " +h + "  |");
					}
					else {System.out.print(" -" +h + " |"); }
				}

			}
			System.out.println("                                  ");
			System.out.println("  -----------------------------------------");
		}
		System.out.println("    A    B    C    D    E    F    G    H\n");
		
	}
	
	public boolean Echec(Case[][] plateau){
        int ligneduRoi = 0;
        int colonneduRoi = 0;
        Case cd = new Case();
        Case ca = new Case();
        for(int i=0;i<taille; i++){
            for(int j=0; j<taille;j++){
                if(plateau[i][j].getPiece().getNom()=="Roi"){
                    ligneduRoi=i;
                    colonneduRoi=j;
                }
            }
        }
        ca=plateau[ligneduRoi][colonneduRoi];
        
        for(int i=0;i<taille;i++){
            for(int j=0; j<taille;j++){
                if(plateau[i][j].caseOccupee()==true){
                    cd=plateau[i][j];
                    if(plateau[i][j].getPiece().getCouleur()!=plateau[ligneduRoi][colonneduRoi].getPiece().getCouleur() && plateau[i][j].getPiece().deplacementValide(this.plateau,cd,ca) ){
                        return true;

                    }
                }
            }
        }
        return false;
    }
	
	public Case getCase(int l, int h) {
		return plateau[l][h];
	}
	
	public Case[][] getPlateau(){
		return this.plateau;
	}
	
}