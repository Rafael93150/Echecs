import java.util.Scanner;

public class Partie {
	private Echiquier echiquier;
	private String saisie ="";
	private Scanner s;
	public String depart;
	public String arrivee;
	private int ligneDepart;
	private int colonneDepart;
	private int ligneArrivee;
	private int colonneArrivee;
	private String coups = "Coups jou�s : ";
	private String coulJoueur = "blanc";
	Case[][] plateau;
	
	public Partie(){
		
		echiquier = new Echiquier();
		echiquier.initialiseEchiquier();
		plateau = echiquier.getPlateau();
		echiquier.afficheEchiquier();
		
		while (!saisie.equals("exit")) {
			saisie();
			
			if (!saisie.equals("exit")) {
				
				if (saisie.equals("sauver")) {
					new Sauvegarder().sauvegarde(plateau);
					System.out.println("La partie a �t� sauvegard�e.");
				}
				
				else if (saisie.equals("charger")) {
					plateau = new Charger().charge("sauvegarde");
					echiquier.afficheEchiquier();
					System.out.println("La partie a �t� charg�e.");
				}
				
				else {
				
				// v�rifie que le joueur utilise l'un de ses pions
					if (plateau[getLigneDepart()][getColonneDepart()].getPiece() != null) {
						if (coulJoueur.equals(plateau[getLigneDepart()][getColonneDepart()].getPiece().getCouleur())) {
							
							// v�rifie que le d�placement est valide
							if (plateau[getLigneDepart()][getColonneDepart()].getPiece().deplacementValide(plateau, plateau[getLigneDepart()][getColonneDepart()], plateau[getLigneArrivee()][getColonneArrivee()]) == true) {
								echiquier.deplacer(plateau[getLigneDepart()][getColonneDepart()], plateau[getLigneArrivee()][getColonneArrivee()]);
								echiquier.afficheEchiquier();
								
								// affiche la liste des coups jou�s
								if (coups.length() == 14) coups = coups + saisie + " ("+coulJoueur.charAt(0)+")";
								else coups = coups + " - " + saisie+ " ("+coulJoueur.charAt(0)+")";
								System.out.println(coups);
								
								changeJoueur(); // change le joueur
							}
							else {
								System.out.println("\nCe coup ne peut pas �tre jou�.");
							}
						}
						else { System.out.println("\nCette pi�ce ne vous appartient pas."); }
					}
				}
			}
		}
		
	}

	public void saisie(){
		s = new Scanner(System.in);
		System.out.println("\nJoueur " + coulJoueur + ",\nveuillez saisir le coup � jouer (ex:a1b1)\n- 'exit' pour quitter\n- 'sauver' pour sauvegarder\n- 'charger' pour charger");
		saisie = s.nextLine();
		depart = saisie.substring(0,2);
		arrivee = saisie.substring(2,4);
	}
	
	public int getColonneDepart() {
		colonneDepart = depart.charAt(0)-97;
		return colonneDepart;
	}
	
	public int getLigneDepart() {
		ligneDepart = depart.charAt(1)-49;
		ligneDepart = 7 - ligneDepart; // inverser les lignes
		return ligneDepart;
	}
	
	public int getColonneArrivee() {
		colonneArrivee = arrivee.charAt(0)-97;
		return colonneArrivee;
	}
	
	public int getLigneArrivee() {
		ligneArrivee = arrivee.charAt(1)-49;
		ligneArrivee = 7 - ligneArrivee;
		return ligneArrivee;
	}
	
	public String changeJoueur() {
		if (coulJoueur == "noir")
			coulJoueur = "blanc";
		else coulJoueur = "noir";
		return coulJoueur;
	}
	
	public static void main (String[] Args){
		new Partie();
	}
}
