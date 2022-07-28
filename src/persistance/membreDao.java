package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Membre;

public class membreDao {
	Connection conn;
	public membreDao(){
		conn = connexion.getConnexion();
	}
	/*****************************getAllByIdLabo***************************/
	public List<Membre> getAllByIdLabo(String id) {
		ArrayList<Membre> list = new ArrayList<Membre>();
		String Id_m="";
		String nomm="";
		String pren="";
		ResultSet resultat = null;
		try {
			PreparedStatement st= conn.prepareStatement("SELECT * FROM membre where Id_labo=?",ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 /*BufferedReader r=new BufferedReader(new InputStreamReader(System.in));*/
			 
			 /*System.out.println("Entrez un id d'etudiant de edition :");
	   	      id=r.readLine();*/
	   	     st.setString(1, id);
	   	     resultat =st.executeQuery();
			while(resultat.next())
			{
				Id_m= resultat.getString("Id_membre");
			    id = resultat.getString("Id_labo");
			    nomm= resultat.getString("nom");
			    pren=resultat.getString("prenom");
			    list.add(new Membre(Id_m,id,nomm, pren));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
	/****************************save************************************/
	public void save(Membre item) {
		 try {
				
				  PreparedStatement st= conn.prepareStatement("insert into membre (Id_membre,Id_labo,nom,prenom) values(?,?,?,?)");
			      
			    	   
			    	   st.setString(1, item.getId_membre());
			    	   st.setString(2, item.getId_labo());
			           st.setString(3, item.getNom());
			           st.setString(4, item.getPrenom());
			       
			    
			        int i=st.executeUpdate();
			        System.out.println("nbr d'addition "+ i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	/*******************************delete*****************************************/
	public void delete(String item) {
		try {
	         PreparedStatement st= conn.prepareStatement("delete from membre where Id_membre=?");
	         st.setString(1, item);
	         int i=st.executeUpdate();
	         System.out.println(i + "membre est supprimer");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	}
}
