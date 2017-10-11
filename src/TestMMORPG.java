package ehptmmmorpgsvr;

import java.util.*;

/**
 *
 * @author ASHOKAR Thanusiyan , BADOUD Zakaria
 */
public class TestMMORPG {
	
	public static void main(String[] args) {

 /***************Creation de Menu , Map , Joueur, des objets *************************************/
		Menu menu=new Menu();
		menu.menuTitre();
	
	//Creation de la map
		Map map=new Map();
	//Creation du joueur et placement des joueurs sur la map
		Joueur j1=new Joueur(menu.getChoix(), map.getTAILLE()-2, map.getTAILLE()/2);
		map.setObject(j1);
		Random r= new Random();
	//Menu principal: Afficher les regles , jouer, quitter
		do{
			try{
				menu.menuPrincipal();
					switch (menu.getVal()){
					case 1:
						menu.menuRegle();
						break;
					case 2:
						System.out.println("Entrez votre pseudo pour commencer la partie: ");
						Scanner sc= new Scanner(System.in);
						j1.setPseudo(sc.nextLine());
						System.out.println("---------Bon Courage " + j1.getPseudo() + " -----------" );
						while(menu.getVal()!=1 && menu.getVal()!=2);
						menu.setVal(2);
						break;
					case 3:
						menu.quitter();
						System.exit(0);
				}
			}
			catch(InputMismatchException e){
				System.out.println("Erreur: la valeur entrée n'est pas un chiffre ");
			}
			}while(menu.getVal()==1 || menu.getVal()>3 || menu.getVal()<1);


		for (int i=0; i<5; i++){
				map.randomMur();
		}

	//Creation d'une arraylist monstre dans une boucle et les positioner dans la map
			ArrayList<Monstre> monstre= new ArrayList<Monstre>();
				int x, y;
					for(int i=0; i<5; i++){
						Monstre m=null;
						for (int j=0; j<2; j++){
							do{
								//Creer de l'espace au debut de la partie
									x=1+r.nextInt(map.getTAILLE()-5);
									y=1+r.nextInt(map.getTAILLE()-2);
							}while(!map.caseVide(x, y) || !map.caseAutour(x, y,0,true));
							switch(j){
								case 0:
									m=new ShadowDemon();
									break;
								case 1:
									m=new TideHunter();
									break;
								}
							m.capaciteRandom();
							m.setAbs(x);
							m.setOrd(y);
							map.setObject(m);
							monstre.add(m);
							}
				
						} 
	//Creation d'une arraylist objet dans une boucle et les positioner dans la map						
			ArrayList<Objet> objet= new ArrayList<Objet>();
	
				Objet ob=null;
					for (int j=0; j<2; j++){
							for(int i=0 ;i<7;i++){
								do{
	//Creer de l'espace au debut de la partie
									x=1+r.nextInt(map.getTAILLE()-3);
									y=1+r.nextInt(map.getTAILLE()-4);
									}while(!map.caseVide(x, y) || !map.caseAutour(x, y,0,true));
									switch(i){
										case 0:
											ob=new EthernelBlade();
											break;
										case 1:
											ob=new DemonEdge();
											break;		
										case 2:
											ob=new BattleFury();
											break;
										case 3:
											ob=new HelmOfDenominator();
											break;
										case 4:
											ob=new MorbitMask();
											break;
										case 5:
											ob=new PotionBonta();
											break;
										case 6:
											ob=new PotionTorboya();
											break;
								}
							ob.setAbs(x);
							ob.setOrd(y);
							map.setObject(ob);
							objet.add(ob);
							}
				
						} 
 /********************************************DEBUT DE LA PARTIE*************************************/
		 
		 
		MenuJeu partie = new MenuJeu(j1);
		int tours=5;
	//Choix de joueur
		do{
			map.afficheMap();
			System.out.println(j1);
			
			try{
				partie.choixAction();
			}catch(InputMismatchException e){
				System.out.println("Erreur: la valeur entrée n'est pas un chiffre ");
			}
			
	//-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --/
	// si le joueur choisi de deplacer
			if (partie.getVal()==1 && j1.getPointAction()>=2 && j1.getVie()>=j1.getVIEMAX()*(1/6f)){
				partie.direction();
				if (partie.getChoix().equals("z")){
					map.deplacementHaut(j1);
				}
				else if (partie.getChoix().equals("s")){
					map.deplacementBas(j1);
				}
				else if (partie.getChoix().equals("d")){
					map.deplacementDroite(j1);
				}
				else if (partie.getChoix().equals("q")){
					map.deplacementGauche(j1);
				}
				j1.retirerPointAction(2);
			}
			
	// si le joueur choisi d'attaquer
			else if (partie.getVal()==2  && j1.getPointAction()>=3  && j1.getVie()>=j1.getVIEMAX()*(1/6f)){
				
				partie.direction();
				Monstre m=null;
				int degats=0;
	//si il ya un monstre dans les cases a cote
				if (partie.getChoix().equals("z")){
					if(map.getElement(j1.getAbs()-1, j1.getOrd()) instanceof Monstre){
						m=(Monstre)map.getElement(j1.getAbs()-1, j1.getOrd());
					}
				}
				else if (partie.getChoix().equals("s")){
					if(map.getElement(j1.getAbs()+1, j1.getOrd()) instanceof Monstre){
						 m=(Monstre)map.getElement(j1.getAbs()+1, j1.getOrd());
					}
				}
				else if (partie.getChoix().equals("d")){
					if(map.getElement(j1.getAbs(), j1.getOrd()+1) instanceof Monstre){
						 m=(Monstre)map.getElement(j1.getAbs(), j1.getOrd()+1);
					}
				}
				else if (partie.getChoix().equals("q")){
					if(map.getElement(j1.getAbs(), j1.getOrd()-1) instanceof Monstre){
						 m=(Monstre)map.getElement(j1.getAbs(), j1.getOrd()-1);
					}
				}
	//si il ya pas de monstre dans les cases a cote
				if(m==null){
					partie.aucuneCible();
				}
				else{
					//le joueur attaque 
					//savoir si le monstre est touche
					if(j1.toucheCible(m)){
						j1.retirerPointAction(3);
						j1.setDegats(j1.attaque(m));
						//savoir le nombre de degats du monstre
						if(degats!=0){
							partie.infligeDegats(degats);
						}
					}
	//si le monstre n'a subi aucun degat
					if (degats==0){
						partie.indemneMonstre();
					}
	//si le monstre n'est pas mort, il peut attaquer
					if(m.getVie()!=0){
						partie.contreAttaque();
						j1.setDegats(m.attaque(j1));
						if(degats!=0){
							partie.recevoirDegats(degats);
						}
						else{
	//le monstre n'a pas inflige de degats au joueur
							partie.indemne();
						}
					}
				}
			}
			
			
	//-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --/
	//si le joueur choisi d'utiliser un objet
			else if (partie.getVal()==3){
				try{
					partie.utiliserObjet();
				}
				catch(InputMismatchException e){
					System.out.println("Erreur: la valeur entrée n'est pas un chiffre ");
				}
	//Le joueur veut equiper un objet: on equipe le type Arme ou Armure 
				if(partie.getVal()==1 && j1.getPointAction()>=1 && j1.getVie()>=j1.getVIEMAX()*(1/6f)){
					partie.equiper();
					if (partie.getVal()<j1.getSac().nbElement() && j1.getSac().getObjet(partie.getVal()) instanceof Arme){
						j1.setArme((Arme)j1.getSac().getObjet(partie.getVal()));
						partie.armeEquipee();
						j1.retirerPointAction(1);
					}
					else if (partie.getVal()<j1.getSac().nbElement() && j1.getSac().getObjet(partie.getVal()) instanceof Armure){
						j1.setArmure((Armure)j1.getSac().getObjet(partie.getVal()));
						partie.armureEquipee();
						j1.retirerPointAction(1);
					}
	// sinon on affiche une erreur
					else{
						partie.erreurObjet();
					}
				}
	//Le joueur choisi de desequiper un objet de type
				else if(partie.getVal()==2 && j1.getPointAction()>=1 && j1.getVie()>=j1.getVIEMAX()*(1/6f)){
					partie.desequiper();
					if (partie.getVal()==1){
						j1.desequiperArme();
						j1.retirerPointAction(1);
					}
					else if(partie.getVal()==2){
						j1.desequiperArmure();
						j1.retirerPointAction(1);
					}
					else{
						partie.erreurObjet();
					}
				}
	//le joueur choisi d'utiliser une potion
				else if(partie.getVal()==3){
					do{
					try{
						partie.utiliser();
					}
					catch(InputMismatchException e){
						System.out.println("Erreur: la valeur entrée n'est pas un chiffre ");
					}
		
					}while((partie.getVal()>j1.getSac().nbElement()) || (partie.getVal()<=-1));
	//Si c'est une potion Bonta, on soigne le joueur et on supprime l'objet
					if (j1.getPointAction()>2 && j1.getSac().getObjet(partie.getVal()) instanceof PotionBonta){
						j1.utiliserPotion((PotionBonta)j1.getSac().getObjet(partie.getVal()));
						j1.retirerPointAction(2);
					 }
	//Si c'est une potionTorboy, on regarde si il y a des Monstre dans les cases autour du joueur
	//et on inflige des degats aux Monstre puis on supprime l'objet
					else if(j1.getPointAction()>3  && j1.getSac().getObjet(partie.getVal()) instanceof PotionTorboya){
						PotionTorboya p= ((PotionTorboya)j1.getSac().getObjet(partie.getVal()));
						
						if ((map.getElement(j1.getAbs()+1, j1.getOrd()) instanceof Monstre)) {
							((Monstre)map.getElement(j1.getAbs()+1, j1.getOrd())).retirerVie(p.getBonus());
						}
						if ((map.getElement(j1.getAbs()-1, j1.getOrd()) instanceof Monstre)) {
							((Monstre)map.getElement(j1.getAbs()-1, j1.getOrd())).retirerVie(p.getBonus());
		
						}
						if ((map.getElement(j1.getAbs(), j1.getOrd()+1) instanceof Monstre)) {
							((Monstre)map.getElement(j1.getAbs(), j1.getOrd()+1)).retirerVie(p.getBonus());
						}
						if ((map.getElement(j1.getAbs(), j1.getOrd()-1) instanceof Monstre)) {
							((Monstre)map.getElement(j1.getAbs(), j1.getOrd()-1)).retirerVie(p.getBonus());
						}
						partie.infligeDegats(p.getBonus());
						j1.getSac().supprimerObjet(p);
						j1.retirerPointAction(3);
					}
	// erreur sur l'objet selectionne
					else{
						partie.erreurObjet();
					}
					
				}
			}
			
	//Le joueur choisi de Deposer ou Ramasser un objet
			else if (partie.getVal()==4 && j1.getPointAction()>=2  && j1.getVie()>=j1.getVIEMAX()*(1/6f)){
				Objet o=null;//Pas d'objet selectionne
				try{
				partie.poserRamasser();
				}
				catch(InputMismatchException e){
					System.out.println("Erreur: la valeur entrée n'est pas un chiffre ");
				}
	//Il choisi de poser: il selectionne un objet existe dans le sac
				if (partie.getVal()==1){
					do{
						try{
						partie.utiliser();
						}
						catch(InputMismatchException e){
							System.out.println("Erreur: la valeur entrée n'est pas un chiffre ");
						}
					}while((partie.getVal()>j1.getSac().nbElement()) || (partie.getVal()<=-1));
					o=j1.getSac().getObjet(partie.getVal());
				}
	//on demande la direction pour Deposer ou ramasser
				partie.direction();
	//suivant la direction on pose l'objet si il a ete selectionne 
	//sinon on ramasse si il y a un objet a terre
				if(partie.getChoix().equals("z")) {
					
					if(o!=null && map.caseVide(j1.getAbs()-1, j1.getOrd())){
						o.setAbs(j1.getAbs()-1);
						o.setOrd(j1.getOrd());
						map.setObject(o);
						j1.getSac().supprimerObjet(o);
						j1.retirerPointAction(2);
					}
					else if(o==null && map.getElement(j1.getAbs()-1,  j1.getOrd())instanceof Objet){
	//	System.out.println("test boucle");
						if (j1.getSac().nbElement()<j1.getSac().getOBJETMAX()){
							System.out.println("test if ");
							j1.getSac().ajouterObjet((Objet)map.getElement(j1.getAbs()-1,  j1.getOrd()));
							map.supprimerElement(map.getElement(j1.getAbs()-1,  j1.getOrd()));
							j1.retirerPointAction(2);
						}
						else{
	//	System.out.println("test else ");
							partie.inventairePlein();
						}
					}
					else{
						partie.errorPoserRamasser();//impossible de ramasser ou poser l'objet
					}
				}		
				else if (partie.getChoix().equals("s")){
					if(o!=null && map.caseVide(j1.getAbs()+1, j1.getOrd())){
						o.setAbs(j1.getAbs()+1);
						o.setOrd(j1.getOrd());
						map.setObject(o);
						j1.getSac().supprimerObjet(o);
						j1.retirerPointAction(2);
					}
					else if(o==null && map.getElement(j1.getAbs()+1,  j1.getOrd()) instanceof Objet){
						if (j1.getSac().nbElement()<j1.getSac().getOBJETMAX()){
						j1.getSac().ajouterObjet((Objet)map.getElement(j1.getAbs()+1,  j1.getOrd()));
						map.supprimerElement(map.getElement(j1.getAbs()+1,  j1.getOrd()));
						j1.retirerPointAction(2);
						}
						else{
							partie.inventairePlein();
		
						}
					}
					else{
						partie.errorPoserRamasser();
		
					}
				}
				else if (partie.getChoix().equals("d")){						
					if(o!=null && map.caseVide(j1.getAbs(), j1.getOrd()+1)){
						o.setAbs(j1.getAbs());
						o.setOrd(j1.getOrd()+1);
						map.setObject(o);
						j1.getSac().supprimerObjet(o);
						j1.retirerPointAction(2);
					}
					else if(o==null && map.getElement(j1.getAbs(),  j1.getOrd()+1) instanceof Objet){
						if (j1.getSac().nbElement()<j1.getSac().getOBJETMAX()){
						j1.getSac().ajouterObjet((Objet)map.getElement(j1.getAbs(),  j1.getOrd()+1));
						map.supprimerElement(map.getElement(j1.getAbs(),  j1.getOrd()+1));
						j1.retirerPointAction(2);
						}
						else{
							partie.inventairePlein();
						}
					}
					else{
						partie.errorPoserRamasser();
					}
				}
				else if(partie.getChoix().equals("q")){
					if(o!=null && map.caseVide(j1.getAbs(), j1.getOrd()-1)){
						o.setAbs(j1.getAbs());
						o.setOrd(j1.getOrd()-1);
						map.setObject(o);
						j1.getSac().supprimerObjet(o);
						j1.retirerPointAction(2);
					}
					else if(o==null && map.getElement(j1.getAbs(),  j1.getOrd()-1) instanceof Objet){
						if (j1.getSac().nbElement()<j1.getSac().getOBJETMAX()){
						j1.getSac().ajouterObjet((Objet)map.getElement(j1.getAbs(),  j1.getOrd()-1));
						map.supprimerElement(map.getElement(j1.getAbs(),  j1.getOrd()-1));
						j1.retirerPointAction(2);
						}
						else{
							partie.inventairePlein();
						}
				}
					else{
						partie.errorPoserRamasser();
					}
				}
			}
			
	//Le joueur choisi de passer son tour et recupere des PA
			if (partie.getVal()==5 || j1.getVie()<j1.getVIEMAX()*(1/6f) && j1.getVie()!=0){
				if(j1.getVie()<j1.getVIEMAX()*(1/6f)){
						tours-=1;
						partie.inconscient(tours);
						if(tours==1){
							j1.ajouterVie((int)(j1.getVIEMAX()*(1/6f)));
							tours=5;
					}
				}
				if(j1.getPointAction()!=j1.getPAMAX()){
					partie.passerTour();
					j1.ajouterPointAction(2);
				}
			}
			
		/*****Tour des Monstre****/
			for (int i=0; i<monstre.size();i++){
	//quand le monstre meurt , on le supprime
				if(monstre.get(i).getVie()==0){
					System.out.println("monstre mort");
	//A la place de monstre on place un objet
					int random=r.nextInt(8);
					Objet o=null;
					switch(random){
						case 0:
							o=new EthernelBlade();
							break;
						case 1:
							o=new DemonEdge();
							break;		
						case 2:
							o=new BattleFury();
							break;
						case 3:
							o=new HelmOfDenominator();
							break;
						case 4:
							o=new MorbitMask();
							break;
						case 5:
							o=new PotionBonta();
							break;
						case 6:
							o=new PotionTorboya();
							break;
						}
					o.randomBonus();
					o.setAbs(monstre.get(i).getAbs());
					o.setOrd(monstre.get(i).getOrd());
					map.supprimerElement(monstre.get(i));
					monstre.remove(monstre.get(i));
					map.setObject(o);
				}
	//Seulement si le joueur est DEVANT le monstre, il l'attaque
				else if(monstre.get(i).getAbs()==j1.getAbs()-1 && monstre.get(i).getOrd()==j1.getOrd()){
					map.afficheMap();
					partie.monstreAttaqueJoueur();
					if(monstre.get(i).toucheCible(j1)){
						int degats=monstre.get(i).attaque(j1);
						if(degats!=0){
							partie.recevoirDegats(degats);
						}
					}
					
					else{
						partie.joueurEsquive();
						partie.indemne();
					}
				}
	//si pas d'attaque, les Monstre se deplacent
				else{
	//les TideHunter sont les monstre plus dur a tuer ils peuvent se deplacer de 2 cases				
						int nbpas=0;
						do{
							int direction=1+r.nextInt(4);
							if(direction==1){
								map.deplacementHaut(monstre.get(i));
							}
							else if(direction==2){
								map.deplacementBas(monstre.get(i));
							}
							else if(direction==3){
								map.deplacementDroite(monstre.get(i));
							}
							else if(direction==4){
								map.deplacementGauche(monstre.get(i));
							}
							nbpas+=1;
						}while(monstre.get(i) instanceof TideHunter && nbpas<2);
					
					
				}
			}
	//Le jeu ne termine pas jusqu'il y a des Monstre sur la carte et que le joueur est mort
		}while (!(monstre.isEmpty()) && j1.getVie()!=0);

	if(j1.getVie()==0){
		partie.mort();
	}
	else{
		partie.fin();
	}

	System.out.println("Fin de programme");
 
		
	} // 	public static void main(String[] args) {
} // 	public class TestMMORPG {
