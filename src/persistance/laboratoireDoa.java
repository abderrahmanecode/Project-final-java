package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.laboratoire;

public class laboratoireDoa implements Dao<laboratoire> {
	Connection conn;
	public laboratoireDoa(){
		conn = connexion.getConnexion();
	}
/**************************************************save**************************************/
	@Override
	public void save(laboratoire item) {
		try {
			//    String id;
			  //  String nom;
		      //  String prenom;
		      //  String email;
		      //  String niveau;
			  PreparedStatement st= conn.prepareStatement("insert into laboratoire (Id_laboratoire,Nom_L, Email_L,Id_responsable) values(?,?,?,?)");
		       /*BufferedReader r=new BufferedReader(new InputStreamReader(System.in));*/
		     
		    	   /*System.out.println("Entrez un id:");
		    	   id=r.readLine();
		    	   System.out.println("Entrez un nom :");
		    	   nom=r.readLine();
		    	   System.out.println("Entrez un prenom :");
		    	   prenom=r.readLine();
		    	   System.out.println("Entrez un email:");
		    	   email=r.readLine();
		    	   System.out.println("Entrez un niveau");
		    	   niveau=r.readLine();
		    	   System.out.println("Entrez un nomfili�re");
		    	   nomfili�re=r.readLine();*/
		    	   
		    	   st.setString(1, item.getId_laboratoire());
		    	   st.setString(2, item.getNom_L());
		           st.setString(3, item.getEmail_L());
		           st.setString(4, item.getId_responsable());
		       
		    
		        int i=st.executeUpdate();
		        System.out.println("nbr d'addition "+ i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
	/************************************save All***************************************/
	@Override
	public boolean saveAll(List<laboratoire> items) {
		// TODO Auto-generated method stub
		return false;
	}
	/***********************GetById********************************/
	public laboratoire getById( String id) {
		laboratoire labo;
		String Id;
		String nom;
		String email;
		String id_respo;
		try {
			 PreparedStatement st= conn.prepareStatement("SELECT * FROM laboratoire where Id_laboratoire=?",ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 /*BufferedReader r=new BufferedReader(new InputStreamReader(System.in));*/
			 
			 /*System.out.println("Entrez un id d'etudiant de edition :");
	   	      id=r.readLine();*/
	   	     st.setString(1, id);
	   	     ResultSet resultat =st.executeQuery();
	   	     if(resultat.next()==false) {
	   	    	 System.out.println("n'exsite pas");
	   	     }
	   	     else {
	   	    	 resultat.previous();
	   	    	 while(resultat.next()) {
	   	    		 Id=resultat.getString(1);
	   	    		 nom=resultat.getString(2);
	   	    		email=resultat.getString(3);
	   	    		id_respo=resultat.getString(4);
	   	    		labo = new laboratoire(Id, nom, email,id_respo);
	   	    		return labo;
	   	    	 }
	   	     }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
/********************************getAll***************************/
	@Override
	public List<laboratoire> getAll() {
		ArrayList<laboratoire> list = new ArrayList<laboratoire>();
		ResultSet resultat = null;
		try {
			resultat =this.conn.createStatement().executeQuery("SELECT * FROM laboratoire");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String id="";
	    String nom="";
	    String email="";
	    String Id_respo="";
		try {
			while(resultat.next())
			{
			    id= resultat.getString("Id_laboratoire");
			    nom = resultat.getString("Nom_L");
			    email= resultat.getString("Email_L");
			    Id_respo=resultat.getString("Id_responsable");
			    list.add(new laboratoire(id,nom,email, Id_respo));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
		
	/*****************update************************************/
	@Override
	public void update(laboratoire item) {
		try {
	         PreparedStatement st= conn.prepareStatement("UPDATE laboratoire SET Nom_L=?, Email_L=?,Id_responsable=? WHERE Id_laboratoire=?");
	         /*BufferedReader r=new BufferedReader(new InputStreamReader(System.in));

	         System.out.println("Entrez un id d'etudiant de suppression :");
	  	      id=r.readLine();
	  	     System.out.println("Entrez un email :");
	  	      email=r.readLine();
	  	      System.out.println("Entrez un niveau :");
	  	     niveau=r.readLine();*/
	         
	         st.setString(1, item.getNom_L());
	         st.setString(2, item.getEmail_L());
	         st.setString(3, item.getId_responsable());
	         st.setString(4, item.getId_laboratoire());
	         
	       int i=st.executeUpdate();
	         System.out.println( i + " laboratoire est modifier dans la table laboratoire");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	   }
/****************************delete************************************************/
	public void delete(String item) {
		try {
	         PreparedStatement st= conn.prepareStatement("delete from laboratoire where Id_laboratoire=?");
	         /*BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
	         System.out.println("Entrez un nom de suppression :");
	         nom=r.readLine();*/
	         st.setString(1, item);
	         int i=st.executeUpdate();
	         System.out.println(i + "laboratoire est supprimer dans la table laboratoire");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
