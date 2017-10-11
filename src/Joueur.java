package ehptmmmorpgsvr;

/**
 *
 * @author ASHOKAR Thanusiyan , BADOUD Zakaria
 */
public class Joueur extends Personnage{
	
	private static final int PAMAX=10;
        
	private String pseudo;
	private Inventaire sac;
	private Arme armePorte;
	private Armure armurePorte;
	private int pointAction;
	private int force;
	private int resistance;
	private int adresse;
	private int bonusDegats;
	private int bonusInitiative;
	private int bonusAttaque;
	private int bonusDefense;
	
	public Joueur(String nom, int x, int y){
		super("j",x,y);
		this.pseudo = nom;
		this.sac = new Inventaire();
		this.armePorte = new DemonEdge("Arme : Demon Edge");
		this.armurePorte = new HelmOfDenominator("Armure : Helm Of Denominator");
		this.pointAction = this.PAMAX ;
		this.force = 6;
		this.resistance = 5;
		this.adresse = 6;
		this.bonusDefense = 15;
		this.bonusAttaque = 15;
		this.bonusInitiative = 15;
		this.bonusDegats = 15;
	}
	
	/*
	 * Methode renvoie pseudo du joueur
	*/
	public String getPseudo(){
		return this.pseudo;
	}
	
	/*
	* Methode set pseudo du joueur
	*/
	public void setPseudo(String ps){
		this.pseudo=ps;
	}
	/*
	 * Methode qui renvoie Arme equipe du joueur
	*/
	public Arme getArme(){
		return this.armePorte;
	}
	
	/*
	* Methode qui renvoie Armure equipe du joueur
	*/
	public Armure getArmure(){
		return this.armurePorte;
	}
	
	/*
	 * Methode qui renvoie Force du joueur
	*/
	public int getForce(){
		return this.force;
	}
	
	/*
	 * Methode qui renvoie Adresse du joueur
	*/
	public int getAdresse(){
		return this.adresse;
	}
	
	/*
	 * Methode qui renvoie Resistance du joueur
	*/
	public int getResistance(){
		return this.resistance;
	}
	
	/*
	 * Methode qui renvoie PointAction du joueur
	*/
	public int getPointAction(){
		return this.pointAction;
	}
	
	public int getPAMAX(){
		return this.PAMAX;
	}
	
	/*
 	 * Methode de set Force du joueur
	*/
	public void setForce(int n){
		this.force=n;
	}
	
	/*
 	 * Methode de set Adresse du joueur
	*/
	public void setAdresse(int n){
		this.adresse=n;
	}
	
	/*
 	 * Methode de set Resistance du joueur
	*/
	public void setResistance(int n){
		this.resistance=n;
	}

	/*
 	 * Methode qui renvoie le contenu du sac du joueur sous forme d'inventaire
	*/
	public Inventaire getSac(){
		return this.sac;
	}
	
	/*
 	 * Methode de set Point d'action du joueur
	*/
	public void setPointAction(int n){
		this.pointAction = n; 
	}
	
	/*
 	 * Methode de "Maj" des points de defense du joueur
	*/
	
	public void changeDefense(){
		if(this.armurePorte!=null){
			this.setDefense(this.resistance+this.armurePorte.getBonus());
		}
		else 
			this.setDefense(this.resistance);
	}
	
	/*
 	 * Methode de "Maj" des points d'initiative du joueur
	*/
	public void changeInitiative(){
		if(this.armurePorte !=null){
			this.setInitiative(this.force+this.armurePorte.getBonus());
		}
		else
			this.setInitiative(this.force);
	}
	
	/*
 	 * Methode de "Maj" des points de degats du joueur
	*/
	
	public void changeDegats(){
		if(this.armePorte!=null){
			this.setDegats(this.force+this.armePorte.getBonus());
		}
		else
			this.setDegats(this.force);
	}
	
	/*
 	 * Methode qui retire arme des main du joueur et la met dans son sac
	*/
	
	public void desequiperArme(){
		this.sac.ajouterObjet(this.armePorte);
			this.armePorte=null;
				changeDegats();
	}
	
	/*
 	 * Methode qui retire armure du joueur et la met dans son sac
	*/
	
	public void desequiperArmure(){
		this.sac.supprimerObjet(this.armurePorte);
			this.armurePorte=null;
				changeDefense();
				changeInitiative();
				
	}
	
	/*
 	 * Methode qui retire n point d'action au joueur
	*/

	public void retirerPointAction(int n){
		if((this.pointAction-n)<0)
			this.pointAction=0;
		else
			this.pointAction = this.pointAction - n;
	}
	
	/*
 	 * Methode qui retire arme des main du joueur et la met dans son sac
	*/
	public void ajouterPointAction(int n){
		if ((this.pointAction+n) <PAMAX){
			this.pointAction= this.pointAction + n;
		}
		else{
			this.pointAction = PAMAX;
		}
	}
	
	/*
 	 * Methode set Arme du joueur
	*/
	public void setArme(Arme a){
		this.sac.ajouterObjet(this.armePorte);			
		this.armePorte=a;
		this.sac.supprimerObjet(a);
		changeDegats();
	}
	
	/*
 	 * Methode  set Armure du joueur
	*/
	
	public void setArmure(Armure a){
		this.sac.ajouterObjet(this.armurePorte);			
		this.armurePorte=a;
		this.sac.supprimerObjet(a);
		changeDefense();
		changeInitiative();
	}
	
	/*
 	 * Methode qui permet au joueur d'utiliser potion de soin(Bonta)
	*/
	
	public void utiliserPotion(PotionBonta b){
		ajouterVie(b.getBonus());
		this.sac.supprimerObjet(b);
		
	}

	/*
 	 * Methode toString permet d'afficher le nom de joueur, l'etat de vie, points d'action restants,  les objets equipes
 	 * les capacites et les caracteristiques du jouer , sac de joueur
	*/
	public String toString(){
			String string="\n"+this.pseudo +" est " +this.getNiveauBlessures()
							+"\nVie: "+this.getVie()
							+"\nVos points d'actions: "+this.pointAction+"\n"
							+"\nVos objets equipes:\n";
									if(this.armePorte!=null){
										string+=this.armePorte;
										}
									else if(this.armePorte==null){
										string+="\n-Pas d'arme equipee";
										}
									if(this.armurePorte!=null){
										string+=this.armurePorte;
										}
									else if(this.armurePorte==null){
										string+="\n-Pas d'armure equipee";
										}
				string+="\nVos caracteristiques:\n"
						+"|Force: "+this.force+"D|"
						+"|Adresse: "+this.adresse+"D|"
						+"|Endurance: "+this.getEndurance()+"D|"
						+"|Resistance: "+this.resistance+"D|"
						+"|Esquive: "+this.getEsquive()+"D|"
						+"|Initiative: "+this.getInitiative()+"D+"+this.bonusInitiative + "|"
						+"|Attaque: "+this.getAttaque()+"D+"+this.bonusAttaque+ "|"
						+"|Defense: "+this.getDefense()+"D+"+this.bonusDefense+ "|"
						+"|Degats: "+this.getDegats()+"D+"+this.bonusDegats+ "|\n"
						+"\nVotre sac:\n"+this.sac.toString();
			return string;
		}
}// fin class Joueur