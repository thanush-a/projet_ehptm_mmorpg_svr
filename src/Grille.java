package ehptmmmorpgsvr;

/**
 *
 * @author BADOUD Zakaria 
 */
public class Grille 
{
	private int x;
	private int y;
	
	 /**
	 * Constructeur Grille sans parametre
	 */
	public Grille(){
		this.x = 1;
		this.y = 1;
	}
	
    /**
     *
     * @param a
     * @param b
     */	
	public Grille(int a, int b){
		this.x = a;
		this.y = b;
	}

    /**
     *
     * @return x
     */
	public int getAbs(){
		return this.x;
	}
	
    /**
     *
     * @return y
     */	
	public int getOrd(){
		return this.y;
	}
	
	
    /**
     *
     * @param n
     */
	public void setAbs(int n){
		this.x = n;
	}
	
    /**
     *
     * @param n
     */	
	public void setOrd(int n){
		this.y = n;
	}
	
}// fin class Grille
