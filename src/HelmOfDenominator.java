package ehptmmmorpgsvr;

import java.util.Random;

/**
 *
 * @author AZA Bettina
 */
public class HelmOfDenominator extends Armure {
	
	private final static String nom= "Armure : Helm Of Denominator";

	
	 /**
     * Constructeur HelmOfDenominator
     */
	public HelmOfDenominator(){
		super(nom,5);
	}

    /**
     *
     * @param nom
     */	
	public HelmOfDenominator(String nom){
	super(nom, 5);
	}
	
	/**
	 * Fonction random pour l'armure "HelmOfDenominator"
	 * avec une probabilite qui est la suivante
	 */
	public void randomBonus(){
		Random r = new Random() ;
	    	int indice=5+r.nextInt(6);
	    	super.setBonus(indice);
	}

}// fin class HelmOfDenominator