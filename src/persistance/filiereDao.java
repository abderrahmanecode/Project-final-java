package persistance;

/*import java.io.BufferedReader;
import java.io.InputStreamReader;*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.filiere;

public class filiereDao implements Dao<filiere>{
	Connection conn;
	public filiereDao(){
		conn = connexion.getConnexion();
	}
	/*********************getAll/***********************************/
	@Override
	public List<filiere> getAll() {
	ArrayList<filiere> list = new ArrayList<filiere>();
	ResultSet resultat = null;
	try {
		resultat =this.conn.createStatement().executeQuery("SELECT * FROM filiere");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    String id="";
    String nom="";
    String id_coordinateur="";
    String Id_deparetement="";
	try {
		while(resultat.next())
		{
		    id= resultat.getString("Id_filiere");
		    nom = resultat.getString("Nom_F");
		    id_coordinateur= resultat.getString("Id_coordinateu");
		    Id_deparetement=resultat.getString("Id_deparetement");
		    list.add(new filiere(id,nom,id_coordinateur, Id_deparetement));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}
	
/*****************************save*********************************/
	@Override
	public void save(filiere item) {
		 try {
				
				  PreparedStatement st= conn.prepareStatement("insert into filiere (id_filiere,nom_F, id_coordinateu,id_deparetement) values(?,?,?,?)");
			       
			    	   
			    	   st.setString(1, item.getId_filiere());
			    	   st.setString(2, item.getNom_F());
			           st.setString(3, item.getId_coordinateu());
			           st.setString(4, item.getId_deparetement());
			       
			    
			        int i=st.executeUpdate();
			        System.out.println("nbr d'addition "+ i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	/**********************************************save All**************************/

	@Override
	public boolean saveAll(List<filiere> items) {
		// TODO Auto-generated method stub
		return false;
	}
	/***************************getById ***************************************/

	public filiere getById(String id)  {
		filiere fil;
		String Id;
		String nom;
		String id_coordinateu;
		String id_deparetement;
		try {
			 PreparedStatement st= conn.prepareStatement("SELECT * FROM filiere where Id_filiere=?",ResultSet.TYPE_SCROLL_INSENSITIVE,
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
	   	    		id_coordinateu=resultat.getString(3);
	   	    		id_deparetement=resultat.getString(4);
	   	    		fil = new filiere(Id, nom, id_coordinateu,id_deparetement);
	   	    		return fil;
	   	    	 }
	   	     }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
	/**************************update***********************************************/

	@Override
	public void update(filiere item) {
		try {
	         PreparedStatement st= conn.prepareStatement("UPDATE filiere SET Nom_F=?, Id_coordinateu=?,Id_deparetement=? WHERE Id_filiere=?");
	         /*BufferedReader r=new BufferedReader(new InputStreamReader(System.in));

	         System.out.println("Entrez un id d'etudiant de suppression :");
	  	      id=r.readLine();
	  	     System.out.println("Entrez un email :");
	  	      email=r.readLine();
	  	      System.out.println("Entrez un niveau :");
	  	     niveau=r.readLine();*/
	         
	         st.setString(1, item.getNom_F());
	         st.setString(2, item.getId_coordinateu());
	         st.setString(3, item.getId_deparetement());
	         st.setString(4, item.getId_filiere());
	         
	       int i=st.executeUpdate();
	         System.out.println( i + " etudiant est modifier dans la table Etudiant");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	   }
/*********************************delete***************************************/
	public void delete(String item) {
		try {
	         PreparedStatement st= conn.prepareStatement("delete from filiere where Id_filiere=?");
	         /*BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
	         System.out.println("Entrez un nom de suppression :");
	         nom=r.readLine();*/
	         st.setString(1, item);
	         int i=st.executeUpdate();
	         System.out.println(i + "etudiant est supprimer dans la table Etudiant");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	}
/***********************************deleteAll*********************************/
	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
