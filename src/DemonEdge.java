package ehptmmmorpgsvr;

import java.util.Random;

/**
 *
 * @author ASHOKAR Thanusiyan
 */
public class DemonEdge extends Arme {
	private  final static String nom= "Arme : Demon Edge";

    /**
     * Constructeur DemonEdge
     */
	public DemonEdge(){
		super(nom, 5);
	}
	
    /**
     *
     * @param nom
     */
	public DemonEdge(String nom){
		super(nom, 5);
	}

    /**
    * Fonction random pour l'arme "DemonEdge"
    * avec une probabilite qui est la suivante
    */   
	public void randomBonus(){
		Random r = new Random() ;
	    	int indice=1+r.nextInt(5);
	    	super.setBonus(indice);
	}
}// Fin classe DemonEdge
