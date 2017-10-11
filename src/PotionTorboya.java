package ehptmmmorpgsvr;

import java.util.Random;

/**
 *
 * @author AZA Bettina
 */
public class PotionTorboya extends Potion {
	
	
	public PotionTorboya(){
		super();
	}
	
	/**
	 * Produit un bonus aux potions de degats
	 * Influe sur les degats infliges aux alentours
	 */
	public void randomBonus(){
		Random r = new Random() ;
    	this.setBonus(3+r.nextInt(3));		
	}
	
	public String toString(){
		return "Potion Torboya (bonus "+this.getBonus()+" )\n";
	}
}// fin class PotionTorboya
