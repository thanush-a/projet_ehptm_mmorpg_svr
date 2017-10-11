package ehptmmmorpgsvr;

import java.util.Random;

/**
 *
 * @author AZA Bettina
 */
public class PotionBonta extends Potion {
	
	public PotionBonta(){
		super();
	}
	
	/**
	 * Produit un bonus aux potions de soins
	 * Influe sur le soin que recevra un personnage
	 */
	public void randomBonus(){
		Random r = new Random() ;
    	super.setBonus(3+r.nextInt(3));	
	}
	
	public String toString(){
		return "Potion Bonta (bonus "+this.getBonus()+" ) \n";
	}
}// fin class PotionBonta