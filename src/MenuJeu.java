package ehptmmmorpgsvr;

import java.util.*;
/**
 *
 * @author AZA Bettina
 */
public class MenuJeu extends Menu {
	
	private Joueur joueur;
	
	 /**
	 * Constructeur MenuJeu
         * @param j
	 */
	public MenuJeu(Joueur j){
		super();
		this.joueur=j;
	}
	
	 /**
	 * Demande au joueur si il veut se deplacer , attaquer , utiliser un objet , le ramasser ou passer le tour
	 */	
	public void choixAction(){
		System.out.println("Vous pouvez: \n1 - Deplacer |2PA| \n2 - Attaquer |3PA| \n3 - Utiliser un objet |Variable|"
						+"\n4 - Ramasser ou Deposer un objet |2PA|\n5 - Passer le tour & Obtenir +2PA \nVotre choix: ");
		Scanner sc=new Scanner(System.in);
		setVal(sc.nextInt());
	}

	 /**
	 * Demande au joueur dans quelle direction il veut se deplacer ou attaquer etc...
	 */
	public void direction(){
			
		System.out.println("          z: haut  \nq: Gauche      d: Droite\n         s: bas");
		Scanner sc=new Scanner(System.in);	
		setChoix(sc.nextLine());
	}	
	
	/**
	* Demande au joueur de choisir s'il veut  s'equiper se desequiper ou utiliser objet du sac 
	*/
	public void utiliserObjet(){
		System.out.println("1-Equiper \n2-Désequiper \n3-Utiliser un objet du sac\nVotre choix: ");
		Scanner sc= new Scanner(System.in);
		setVal(sc.nextInt());
	}
	
	 /**
	 * Demande de choisir un objet parmis la liste d'objets dans le sac  
	 */	
	public void utiliser(){
			System.out.println("Quel objet voulez-vous parmis la liste suivante? \n"+this.joueur.getSac()+"\nVotre choix: ");
			Scanner sc= new Scanner(System.in);
			setVal(sc.nextInt()-1);
	}

	 /**
	 * demande au joueur de choisir entre deposer ou ramasser l'ojet
	 */
	public void poserRamasser(){
		System.out.println("1-Deposer\n2-Ramasser\nVotre choix: ");
		Scanner sc=new Scanner(System.in);
		setVal(sc.nextInt());
		
	}
	
	 /**
	 *  Joueur passe le tour pour obtenir des 2PA et pour augmenter la vie quand il est inconscient
	 */	
	public void passerTour(){
		System.out.println("Vous avez recupere 2 PA\n");		
	}
	
	 /**
	 * demande au joueur de choisir une arme ou armure dont il veut s'equiper
	 */	
	public void equiper(){
		System.out.println("Quel objet voulez-vous parmis la liste suivante? \n"+this.joueur.getSac()+"\nVotre choix: ");
		Scanner sc= new Scanner(System.in);
		setVal(sc.nextInt()-1);
	}
	
	 /**
	 * demande au joueur de choisir une arme ou armure dont il veut se desequiper
	 */
	public void desequiper(){
		System.out.println("Les objets que vous portez: "+"\n1"+this.joueur.getArme()+"\n2"+this.joueur.getArmure()+"\nVotre choix: ");
		Scanner sc= new Scanner(System.in);
		setVal(sc.nextInt());
	}

	 /**
	 * affiche un message d'erreur pour le choix d'un objet inexistant
	 */
	public void erreurObjet(){
		System.out.println("Cet objet n'existe pas !\n");
	}

	 /**
	 * Affiche l'arme porte par le joueur
	 */	
	public void armeEquipee(){
		System.out.println("L'arme que vous portez:\n "+this.joueur.getArme()+"\n");
	}
	
	 /**
	 * Affiche l'armure porte par le joueur
	 */		
	public void armureEquipee(){
		System.out.println("L'armure que vous portez:\n "+this.joueur.getArmure()+"\n");
	}
	
	/**
	 * annonce au joueur qu'il n'a pas pu deposer ou ramasser l'objet
	 */
	public void errorPoserRamasser(){
		System.out.println("Vous ne pouvez pas deposer ou ramasser l'objet\n");
	}
	
	/**
	 * annonce au joueur qu'il a perdu des points de degats
         * @param n
	 */
	public void recevoirDegats(int n){
		System.out.println(this.joueur.getPseudo()+" a perdu "+ n +" points de degats !");
	}
	
	/**
	 * annonce au joueur qu'il a fait perdre des points de degats au monstre
         * @param n
	 */
	public void infligeDegats(int n){
		System.out.println(this.joueur.getPseudo()+" a fait perdre "+ n +" points de degats au monstre !\n");
	}
	
	/**
	 * annonce au joueur qu'il n'a perdu aucun points de degats
	 */
	public void indemne(){
		System.out.println(this.joueur.getPseudo()+" n'a perdu aucun points de degats !");
	}
	
	/**
	 * annonce au joueur n'a fait perdre aucun points de degats au monstres
	 */
	public void indemneMonstre(){
		System.out.println(this.joueur.getPseudo()+" n'a fait perdre aucun points de degats au monstre!\n");
	}
	
	/**
	 * annonce au joueur que le monstre contre-attaque
	 */
	public void contreAttaque(){
		System.out.println("Le monstre contre-attaque!\n");	
	}
	
	/**
	 * annonce au joueur qu'il a esquiver l'attaque
	 */
	
	public void joueurEsquive(){
		System.out.println(this.joueur.getPseudo()+" a esquive l'attaque sans blessure !");
	}
	
	/**
	 * annonce au joueur qu'il est attaque par annonce
	 */
	
	public void monstreAttaqueJoueur(){
		System.out.println(this.joueur.getPseudo()+" est attaque par un monstre !");
	}
	
	/**
	 * annonce au joueur qu'il est incionscient
         * @param x
	 */
	public void inconscient(int x){
		System.out.println(this.joueur.getPseudo()+" n'a plus de force pour continuer, \n Nous vous conseillons de prendre une potion Bonta ou passer "+x+" tours\n");
	}
	
	/**
	 * annonce au joueur qu'il n'a selectionne qucune cible
	 */
	
	public void aucuneCible(){
		System.out.println(this.joueur.getPseudo()+" n'a selectionne aucune cible");
	}

	/**
	 * annonce que le sac est plein
	 */
	public void inventairePlein(){
		System.out.println("Votre sac est plein");
	}
	
	/**
	 * annonce la mort du joueur
	 */
	
	public void mort(){
		System.out.println(this.joueur.getPseudo()+" n'a pas survecu...");
	}
	
	/**
	 * annonce fin de jeu
	 */
	public void fin(){
		System.out.println(this.joueur.getPseudo()+"a gagne \nFelicitations!");
	}
}