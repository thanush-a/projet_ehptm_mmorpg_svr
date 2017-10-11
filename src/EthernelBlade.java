package ehptmmmorpgsvr;


import java.util.Random;

/**
 *
 * @author ASHOKAR Thanusiyan
 */
public class EthernelBlade extends Arme {
    private final static String nom= "Arme : Ethernel Blade";
        

    /**
    * Constructeur EthernetBlade
    */        
    public EthernelBlade(){
        super(nom,4);
        
    }
    
    /**
    *
    * @param nom
    */
    public EthernelBlade(String nom){
        super(nom,4);
    }
    
    /**
    * Fonction random pour l'arme "EthernelBlade"
    * avec une probabilite qui est la suivante
    */        
    public void randomBonus(){
	Random r = new Random() ;
    	int indice=4+r.nextInt(7);
    	super.setBonus(indice);
	}
        
    
}// Fin classe EthernelBlade