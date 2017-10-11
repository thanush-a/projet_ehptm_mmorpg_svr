package ehptmmmorpgsvr;

import java.util.Random;
/**
 *
 * @author ASHOKAR Thanusiyan
 */
public class MorbitMask extends Armure {
    
	private final static String nom= "Armure : Morbit Mask";

/**
 *
 * consructeur MorbitMask
 */
	public MorbitMask(){
		super(nom, 5);
	}

/**
 *
 * consructeur MorbitMask
 * @param ch
 */
 public MorbitMask(String ch){
		super(ch, 5);
	}
	/**
	 * Fonction random pour l'armure "MorbitMask"
	 * avec une probabilite qui est la suivante
	 */
	public void randomBonus(){
		Random r = new Random() ;
	    	int indice=3+r.nextInt(5);
	    	this.setBonus(indice);
	}
}// fin class MorbitMask
