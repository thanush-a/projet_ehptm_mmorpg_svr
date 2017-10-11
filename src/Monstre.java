package ehptmmmorpgsvr;

/**
 *
 * @author ASHOKAR Thanusiyan
 */
public class Monstre extends Personnage {
    
    
    private static final int VIEMAXMONSTRE=5;

/**
 *
 * consructeur Monstre
 * @param car
 */
    public Monstre (String car){
            super(car);
            this.setVie(VIEMAXMONSTRE);
}
	
}// fin class Monstre