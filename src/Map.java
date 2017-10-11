package ehptmmmorpgsvr;

import java.util.*;

/**
 *
 * @author BADOUD Zakaria
 */
public class Map {
	/** 
	 * Creation et Mise a jour de la carte
	 * @version 1.0 
	 */
	private Grille[][]tab;
	private final static int TAILLE=20;
	
	/** 
	 * Cree un tableau 2D de type Objects
	 * Taille du tableau=20
	 */
	public Map(){
		Mur mur=new Mur();
		this.tab=new Grille[TAILLE][TAILLE];
		for(int i=0; i<TAILLE;i++){
			for(int j=0; j<TAILLE;j++){
				if (i==0 || i==(TAILLE-1) || j==0 || j==(TAILLE-1)){
					this.tab[i][j]=mur;
				}
				else{
					this.tab[i][j]=null;
				}
			
			}
		}
	}

	
	/** 
	 * Permet d'afficher le tableau a 2D
	 */
	public void afficheMap(){
		for(int i=0; i<TAILLE; i++){
			for(int j=0;j<TAILLE;j++){
				if (tab[i][j] instanceof Personnage){
					System.out.print(((Personnage)this.tab[i][j]).getSignature()+ " ");
				}
				else if (tab[i][j] instanceof Objet){
					System.out.print(((Objet)this.tab[i][j]).getSignature()+ " ");
				}
				else if (tab[i][j] instanceof Mur){
					System.out.print(((Mur)this.tab[i][j]).getSignature()+ " ");
				}
				else {
					System.out.print(" " + " ");
				}
			}
			System.out.println();	
		}
	}
	
    /**
     *
     * @return la taille de la map
     */
    public int getTAILLE(){
		return this.TAILLE;
	}
	
	
	/** 
	 * Positionne des murs aleatoirement
	 */
	public void randomMur(){
		Random r = new Random();
		Mur mur=new Mur();
		int val1;
		int val2;
		boolean sens;
		int nbMur;
		do{
			val1=2+r.nextInt(TAILLE-2-2);
			val2=2+r.nextInt(TAILLE-2-2);
			nbMur=3+r.nextInt(3); // taille de mur est entre 3 et 6
			sens=r.nextBoolean();
		} while(!caseAutour(val1, val2, nbMur, sens));
			for (int i=0; i<nbMur; i++){
				this.tab[val1][val2]=mur;
				if(sens){
					val1+=1;
				}
				else if(!sens){
					val2+=1;
				}
			}
		}
	

	public Grille getElement(int i, int j){
		return this.tab[i][j];
	}
	
	public void supprimerElement(Grille g){
		this.tab[g.getAbs()][g.getOrd()]=null;
	}
	/** 
	 * Place un element de type Object sur la carte
         * @param g
	 */
	public void setObject(Grille g){
		int i=g.getAbs();
		int j=g.getOrd();
		this.tab[i][j]= g;
	}
	/** 
	 * Deplacement vers le haut d'un element
         * @param g
	 */
	public void deplacementHaut(Grille g){
		if (caseVide(g.getAbs()-1,g.getOrd())){
			this.tab[g.getAbs()][g.getOrd()]=null;
			g.setAbs(g.getAbs()-1);
			this.tab[g.getAbs()][g.getOrd()]=g;
		}
	}
	/** 
	 * Deplacement vers le bas d'un element
         * @param g
	 */
	public void deplacementBas(Grille g){
		if (caseVide(g.getAbs()+1,g.getOrd())){
			this.tab[g.getAbs()][g.getOrd()]=null;
			g.setAbs(g.getAbs()+1);
			this.tab[g.getAbs()][g.getOrd()]=g;
		}
	}
	/** 
	 * Deplacement vers la droite d'un element
         * @param g
	 */
	public void deplacementDroite(Grille g){
		if (caseVide(g.getAbs(),g.getOrd()+1)){
			this.tab[g.getAbs()][g.getOrd()]=null;
			g.setOrd(g.getOrd()+1);
			this.tab[g.getAbs()][g.getOrd()]=g;
		}
	}
	/** 
	 * Deplacement vers la gauche d'un element
         * @param g
	 */
	public void deplacementGauche(Grille g){
		if (caseVide(g.getAbs(),g.getOrd()-1)){
			this.tab[g.getAbs()][g.getOrd()]=null;
			g.setOrd(g.getOrd()-1);
			this.tab[g.getAbs()][g.getOrd()]=g;
		}
	}
		
		
	/** 
	* Verifie que les murs ne se touchent pas
        * @param i
        * @param j
        * @param murs
        * @param dir
        * @return boolean
	*/
	public boolean caseAutour(int i, int j, int murs, boolean dir){
		int verif=0;
		for (int x=1; x<=murs; x++){
			if(dir){
				if(tab[i][j+1]==null && tab[i][j-1]==null && i<TAILLE-1 && tab[i][j]==null){
					i++;
					verif+=1;
				}
			}
			else if(!dir){
				if(tab[i+1][j]==null && tab[i-1][j]==null && j<TAILLE-1 && tab[i][j]==null){
					j++;
					verif+=1;
				}
			}
		}
		if (verif==murs){
			return true;
		}
		return false;	
	}
		
    /** 
     * verifie que la case ciblee est vide
     * @param i
     * @param j
     * @return 
     */
	public boolean caseVide(int i, int j){
		if(this.tab[i][j]==null){
			return true;
		}
		return false;
	}
}// fin class Map