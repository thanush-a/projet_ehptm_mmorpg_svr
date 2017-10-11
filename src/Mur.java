package ehptmmmorpgsvr;

/**
 *
 * @author AZA Bettina
 */
public class Mur extends Grille{
    
    private String signature;

/**
 *
 * consructeur Mur
 */
    public Mur(){
        this.signature = "#";
    }
    
    public String getSignature(){
        return this.signature;
    }
    
}// fin class Mur