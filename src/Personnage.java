package ehptmmmorpgsvr;

import java.util.*;

/**
 *
 * @author ASHOKAR Thanusiyan , BADOUD Zakaria
 */
public abstract class Personnage extends Grille {
    
	private static final int VIEMAX=40;

	private String niveauBlessures;
	private int vie;
	private String signature;
	
    // Les Capacites
	private int initiative;
	private int attaque;
	private int endurance;
	private int defense;
	private int degats;
	private int esquive;

/**
 *
 * Constructeur Personnage 
 * @param car
 * @param x
 * @param y
 */	
	public Personnage(String car, int x, int y){
		super(x, y);
		this.niveauBlessures="en pleine forme!";
		this.signature=car;
		this.vie=VIEMAX;
		this.initiative=5;
		this.attaque=5;
		this.endurance=6;
		this.defense=5;
		this.degats=5;
		this.esquive=5;
	}

/**
 *
 * Constructeur Personnage utilise pour les monstres
 * @param car
 */		
	public Personnage(String car){
		super();
		this.niveauBlessures="en pleine forme!";
		this.signature=car;
		this.vie=VIEMAX;
		this.initiative=3;
		this.attaque=3;
		this.endurance=3;
		this.defense=3;
		this.degats=3;
		this.esquive=3;
	}
	
	/** 
	 * Methode qui permet de savoir si le joueur a touche le monstre
	 * @param p
	 */
	public boolean toucheCible(Personnage p){
		if(scoreAttaque()>p.scoreEsquive()){
			return true;
		}
		return false;
	}
	
	/** 
	 * Methode qui permet au joueur d'attaquer si le monstre a perdu des degats
	 * @param p
         * @return 
	 */
	public int attaque(Personnage p){
		int degats=scoreDegats();
		int defense=p.scoreDefense();
		if(degats>defense){
			int vie=(int)(p.getVie()*((degats-defense)/3f)/6f);
			p.retirerVie(vie);
			return (vie);
		}
		return 0;
		
	}
	


	/** 
	 * Methode qui calcule un score d'attaque random entre 1 et 6
         * @return 
	 */
	public int scoreAttaque(){
		Random r = new Random(); 
		return this.attaque*(1+r.nextInt(6));
	}
	

	/** 
	 * Methode qui calcule un score de defense random entre 1 et 6 
         * @return 
	 */
	public int scoreDefense(){
		Random r = new Random(); 
		 return this.defense*(1+r.nextInt(6));
	}
	
	/** 
	 * Methode qui calcule un score d'esquive random entre 1 et 6
         * @return 
	 */
	public int scoreEsquive(){
		Random r = new Random(); 
		 return this.esquive*(1+r.nextInt(6));
	}
	
	/** 
	 * Methode qui calcule un score de degats random entre 1 et 6 
         * @return 
	 */
	public int scoreDegats(){
		Random r = new Random(); 
		return this.degats*(1+r.nextInt(6));
	}
	
	public int getVie(){
		return this.vie;
	}
	public void setVie(int n){
		this.vie=n;
		changeNiveauBlessure();
	}
	
	public int getVIEMAX(){
		return this.VIEMAX;
	}
	
	 /** 
	 * Methode qui ajoute des points de vie au personnage
	 * Change le niveau des blessures apres avoir ajouter des points de vie
	 * @param n
	 */
	public void ajouterVie(int n){
			if((this.vie+n)<VIEMAX){
				this.vie+=n;
			}
			else{
				this.vie=VIEMAX;
			}
			changeNiveauBlessure();
		}
	
	/** 
	 * Methode qui retire des points de vie au personnage
	 * Change le niveau des blessures apres avoir retirer des points de vie
         * @param n
	 */
	public void retirerVie(int n){
		if((this.vie-n)>0){
			this.vie-=n;
		}
		else{
			this.vie=0;
		}
		changeNiveauBlessure();
	}
	
	public String getBlessure(){
		return this.niveauBlessures;
	}
	public void setBlessure(String s){
		this.niveauBlessures=s;
	}
	
	/** 
	 * Methode qui change le niveau de blessures
	 */
	public void changeNiveauBlessure(){
		if (this.vie==VIEMAX){
			this.niveauBlessures=" en pleine forme!";
		}
		else if (this.vie>= (5/6F*VIEMAX)){
			this.niveauBlessures=" legerement blesse";
		}
		else if (this.vie>=(4/6F*VIEMAX)){
			this.niveauBlessures=" blesse";
		}
		else if (this.vie>=(2/6F*VIEMAX)){
			this.niveauBlessures=" gravement blesse";
		}
		else if (this.vie>=(1/6F*VIEMAX)){
			this.niveauBlessures=" inconscient!";
		}
        else if (this.vie==0){
			this.niveauBlessures=" mort";
		}
	}
	
	public String getSignature(){
		return this.signature;
	}
	public int getInitiative(){
		return this.initiative;
	}
	public int getAttaque(){
		return this.attaque;
	}
	public int getEsquive(){
		return this.esquive;
	}
	public int getDefense(){
		return this.defense;
	}
	public int getDegats(){
		return this.degats;
	}
	public int getEndurance(){
		return this.endurance;
	}
	public String getNiveauBlessures(){
		return this.niveauBlessures;
	}

	public void setInitiative(int n){
		this.initiative=n;
	}
	public void setAttaque(int n){
		this.attaque=n;
	}
	public void setEsquive(int n){
		this.endurance=n;
	}
	public void setDefense(int n){
		this.defense=n;
	}
	public void setDegats(int n){
		this.degats=n;
	}
	
/** 
 * Methode qui fourni les capacités en random
 * Cette methode est utilise pour calculer les capacites des monstres
 */
    public void capaciteRandom(){
            Random r = new Random() ;
            this.esquive=r.nextInt(2);
            this.initiative=1+r.nextInt(4);
            this.defense=1+r.nextInt(3);
            this.degats=2+r.nextInt(4);
            this.attaque=2+r.nextInt(4);
    }
}// fin class Personnage