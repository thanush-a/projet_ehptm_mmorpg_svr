package ehptmmmorpgsvr;

 
import java.util.*;

/** 
 * Gere le sac du joueur et le joueur peut porter que 5 elements maximum
 * @author AZA Bettina
 */
public class Inventaire {
   
    private ArrayList<Objet> sacADos;
    private final static int OBJETMAX=5;
    
    /**
    *
    */
    public Inventaire(){
        this.sacADos = new ArrayList <Objet>(OBJETMAX);
    }
    
    /**
     * Ajouter un objet dans le sac
     * @param o
     */    
    public void ajouterObjet(Objet o){
        this.sacADos.add(o);
    }

    /**
     * Supprimer un objet de sac
     * @param o
     */    
    public void supprimerObjet(Objet o){
        if(this.sacADos.contains(o))
            this.sacADos.remove(o);
    }

    /**
     * retourner l'objet
     * @param i
     * @return
     */    
    public Objet getObjet(int i){
        return (this.sacADos.get(i));
    }

    /**
     *get la taille max de sac
     * @return
     */    
    public int getOBJETMAX(){
		return this.OBJETMAX;
	}

    /**
     *get size de sac
     * @return
     */   	
	public int nbElement(){
	    return this.sacADos.size();
	}
	
    /**
     * Tous les elements de sac present
     * @return toString
     */	
    public String toString(){
		String string;
		if(!this.sacADos.isEmpty()){
			string="";
			for(int i=0; i<this.sacADos.size(); i++){
				string+=i+1+"-"+this.sacADos.get(i);
			}
		}
		else{
			string="Le sac est vide\n";
		}
		return string;
		
	}
}// fin class Inventaire
