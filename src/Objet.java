package ehptmmmorpgsvr;

/**
 *
 * @author AZA Bettina
 */
public abstract class Objet extends Grille{

	private String signature;
	private int bonus;

/**
 *
 * consructeur Objet
 * @param ch
 * @param n
 */	
    public Objet(String ch, int n){
		super();
		this.signature=ch;
		this.bonus=n;
	}

/**
 *
 * consructeur Objet par copie
 * @param o
 */	
    public Objet(Objet o){
		super(o.getAbs(), o.getOrd());
		this.signature=o.signature;
		this.bonus=o.getBonus();
	}
	
/** 
 * Le bonus d'une Arme & Armure &Potion est different selon l'objet
 */
    public abstract void randomBonus();
	
/**
 *
 * @return signature
 */
    public String getSignature(){
		return this.signature;
	}
	
    /**
     *
     * @return bonus
     */
    public int getBonus(){
		return this.bonus;
	}

    /**
     *
     * @param n
     */
    public void setBonus(int n){
		this.bonus=n;
	}

}// fin class Objet
