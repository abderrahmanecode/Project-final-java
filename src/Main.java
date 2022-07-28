
import java.util.List;

import metier.Membre;
import metier.filiere;
//import metier.laboratoire;
import persistance.connexion;
import persistance.filiereDao;
//import persistance.laboratoireDoa;
import persistance.membreDao;
import prasentation.controlleur;

public class Main {

	public static void main(String[] args) throws Exception{
		controlleur controleur = new controlleur();
		controleur.demmarrer();
	}
	
	
}
