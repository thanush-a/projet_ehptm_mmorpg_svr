package ehptmmmorpgsvr;

/**
 *
 * @author AZA Bettina
 */
public abstract class Equipement extends Objet{
    
    private String nom;
	
	/**
	*
	* @param nom
	* @param n
	*/
	public Equipement(String nom, int n){
		super("a",n);
		this.nom=nom;
	}
	
	/**
     *
     * @return nom d'Equipement
     */
	public String getNom(){
		return this.nom;
	}

    /**
     * Change le nom d'Equipement
     * @param s
     */	
    public void setNom(String s){
		this.nom=s;
	}
	
	 /**
     * toString retourne Le nom et le degats d'equipement 
     */	
	public String toString(){
	    return this.getNom() +
	    		"|Degats:" + this.getBonus() + "|\n";	
	   
	}
    
    
}// fin class Equipement