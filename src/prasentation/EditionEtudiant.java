package prasentation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.Etudiant;
import persistance.connexion;


public class EditionEtudiant {
	   Connection conn;
	    public EditionEtudiant() {
	    	conn=connexion.getConnexion();
	    	}
	public void getEtudiant() throws IOException{
		Etudiant etudiant;
		String id;
		String nom;
		String prenom ;
		String email;
		String niveau;
		String nomfiliére;
		try {
			 PreparedStatement st= conn.prepareStatement("SELECT * FROM Etudiant where id=?",ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
			 
			 System.out.println("Entrez un id d'etudiant de edition :");
	   	      id=r.readLine();
	   	     st.setString(1, id);
	   	     ResultSet resultat =st.executeQuery();
	   	     if(resultat.next()==false) {
	   	    	 System.out.println("n'exsite pas");
	   	     }
	   	     else {
	   	    	 resultat.previous();
	   	    	 while(resultat.next()) {
	   	    		 id=resultat.getString(1);
	   	    		 nom=resultat.getString(2);
	   	    		 prenom=resultat.getString(3);
	   	    		 email=resultat.getString(4);
	   	    		niveau=resultat.getString(5);
	   	    		nomfiliére=resultat.getString(6);
	   	    		etudiant = new Etudiant(id, nom, prenom,email,niveau,nomfiliére);
	   	    		System.out.println(etudiant.getId()+" "+etudiant.getNom()+" "+etudiant.getPrenom()+" "+
		                  	etudiant.getEmail()+" "+etudiant.getNiveau());
	   	    	 }
	   	     }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 

}
