package ehptmmmorpgsvr;

import java.util.*;

/**
 *
 * @author BADOUD Zakaria
 */
public class Menu {
	private int val;
	private String choix;
	
    /**
     * Constructeur Menu
     */
    public Menu(){
		this.val=0;
		this.choix="";
	}
		
    /**
     *
     * @return la val
     */
    public int getVal(){
		return this.val;
	}

    /**
     *
     * @param n 
     */
    public void setVal(int n){
		this.val=n;
	}

    /**
     *
     * @return choix
     */
    public String getChoix(){
		return this.choix;
	}

    /**
     *
     * @param s
     */
    public void setChoix(String s){
		this.choix=s;
	}

    /**
     * Affiche notre logo de jeu
     */
    public void menuTitre(){
		System.out.println(
				  " _____   _   _   _____   _____       ___  ___            ___  ___       ___  ___   _____   _____    _____   _____        _____   _     _   _____  \n"
				+ "| ____| | | | | |  _  | |_   _|     /   |/   |          /   |/   |     /   |/   | /  _  | |  _    |  _  |  /  ___|      /  ___/ | |   / / |  _  | \n"
				+ "| |__   | |_| | | |_| |   | |      / /|   /| |         / /|   /| |    / /|   /| | | | | | | |_| |  | |_| | | |          | |___  | |  / /  | |_| | \n"
				+ "|  __|  |  _  | |  ___/   | |     / / |__/ | |        / / |__/ | |   / / |__/ | | | | | | |  _  /  |  ___/ | |  _       |___  | | | / /   |  _  / \n"
				+ "| |___  | | | | | |       | |    / /       | |   _   / /       | |  / /       | | | |_| | | | | |  | |     | |_| |   _   ___| | | |/ /    | | | | \n"
				+ "|_____| |_| |_| |_|       |_|   /_/        |_|  |_| /_/        |_| /_/        |_| |_____/ |_| |_| |_|      |_____/  |_| /_____/ |___/     |_| |_| \n"
				+ " By Silver Sharks : ASHOKAR Thanush , BADOUD Zakaria , AZA Bettina\n\n");
	}
	
    /**
     * Affiche les regles 
     * @return choix
     */
    public String menuRegle(){
		System.out.println("/******************************************Règles du jeu**********************************************/\n"
						  +" Ce jeu est un jeu de type MMORPG.Les regles sont les suivantes:\n"
					   	  +" Vous devez vous deplacer sur la map en evitant les attaques de monstres.\n" 
					   	  +" Vous devez savoir qu'il existe 2 types de monstres les Tide Hunter et les Shadow Demon.\n"
						  +" Par ailleurs, tout au long du jeu vous pourrez ramasser 3 types d'elements:\n"
						  +" des armes, des armures et des potions.\n"
						  +" Les armes sont BattleFury, DemonEdge et EthernelBlade. Elles vous permettent d'attaquer les monstres.\n"
						  +" Les armures sont HelmOfDenominator ou MorbitMask.Elles vous permettent d'encaisser les coups\n"                
						  +" Les potions Torboya vous permettront d'attaquer et les potions Bonta de vous soigner.\n\n" 
                                                  +"                                                     Appuyer sur Entre pour revenir en arriere"
			);
				  
		Scanner sc2= new Scanner(System.in);
		String Choix = sc2.nextLine();
		return Choix;
	}
	
    /**
     * Affiche les 3 choix principaux
     */
    public void menuPrincipal(){
		System.out.println("Que souhaitez-vous faire?\n1-Afficher les Regles\n2-Commencer une nouvelle Partie\n3-Quitter le jeu\nVotre choix: ");
		Scanner sc= new Scanner(System.in);
		setVal(sc.nextInt());
	}
	
    /**
     * affiche error
     */
    public void menuError(){
		System.out.println("Veuillez saisir un bon chiffre \n");
	}
	
    /**
     * afffiche Aurevoir
     */
    public void quitter(){
		System.out.println("Aurevoir!");
	}
}// fin class Menu