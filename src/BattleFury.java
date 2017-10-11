package ehptmmmorpgsvr;
 
import java.util.Random;

/**
 *
 * @author BADOUD Zakaria
 */
public class BattleFury extends Arme{
	private final static String nom= "Arme : Battle Fury";
	
	/**
     *constructeur BattleFury
     */
	public BattleFury(){
		super(nom, 5);
	}
	
    /**
    * Fonction random pour l'arme "BattleFury"
    * avec une probabilite qui est la suivante
    */  
	public void randomBonus(){
		Random r = new Random() ;
	    	int indice=4+r.nextInt(7);
	    	super.setBonus(indice);
	}
}// fin class BattleFury
