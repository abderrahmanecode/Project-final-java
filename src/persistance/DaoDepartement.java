package persistance;


import metier.Departement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;



public class DaoDepartement implements Dao<Departement> {
	 
	 Connection conn;
	public DaoDepartement(){
		
		 conn= connexion.getConnexion();}
	
	
	
	@Override
	public List<Departement> getAll() {
	ArrayList<Departement> list = new ArrayList<Departement>();
	ResultSet resultat = null;  
	   
	 
	  try {
		resultat =this.conn.createStatement().executeQuery("SELECT * FROM departement");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   
	 String id="";
    String nom="";
    String email="";
      
      
    try {
		while(resultat.next())
		{
		    id= resultat.getString("IdDep");
		    nom = resultat.getString("nomDep");
		    email = resultat.getString("emailDep");
		 
		    list.add(new Departement(id,nom,email));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}  
	
	
	@Override
	public void save(Departement item) {
		 try {
				
				  PreparedStatement st= conn.prepareStatement("insert into departement (idDep,nomdep,emailDep) values(?,?,?,?)");
			       
			    	   
			    	   st.setString(1, item.getIdDep());
			    	   st.setString(2, item.getNomDep());
			    	   st.setString(3, item.getEmailDep());
			           
			       
			    
			        int i=st.executeUpdate();
			        System.out.println("nbr d'addition "+ i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	/**********************************************save All**************************/
      
    @Override
	public boolean saveAll(List<Departement> items) {
		// TODO Auto-generated method stub
		return false;
	}
	/***************************getById *************************************/
      
      
      public Departement getById(String id)  {
		Departement dep;
		String Id;
		String nom;
		String email;
		try {
			 PreparedStatement st= conn.prepareStatement("SELECT * FROM departement where idDep=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			 
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
	   	    	
	   	    		dep = new Departement(Id, nom, email);
	   	    		return dep;
	   	    	 }
	   	     }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
	/*************************update**********************************************/
      
      
	@Override
	public void update(Departement item) {
		try {
	         PreparedStatement st= conn.prepareStatement("UPDATE departement SET nomDep=?, emailDep=? WHERE idDep=?");
	       
	         
	         
	         
	         st.setString(1, item.getIdDep());
			 st.setString(2, item.getNomDep());
			 st.setString(3, item.getEmailDep());
	         
	       int i=st.executeUpdate();
	       //  System.out.println( i + " etudiant est modifier dans la table Etudiant");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	   }
/********************************delete**************************************/
      
      
      
      public void delete(String item) {
		try {
	         PreparedStatement st= conn.prepareStatement("delete from departement where idDep=?");
	        
	         st.setString(1, item);
	         int i=st.executeUpdate();
	     //    System.out.println(i + "deppartement est supprimer dans la table deppartement");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	}
//***********************************deleteAll*******************************
      
      @Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}
      
      
      
      
      
}     
      
      
      
      
      
      
      
      
      
      
      
      
      
      
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
 * 
 * 	
 
////////////////////////////////////////////////////////////////////

public class DaoDepartement {
	 
	 Connection conn;
	public DaoDepartement(){
		
		 conn= Connexion.getConnexion();
	}
/////////////////////////////////////////////////////////////////////////
	
	public List<Departement> getAll() {
	ArrayList<Departement> list = new ArrayList<Departement>();
	ResultSet resultat = null;
	try {
		resultat =this.conn.createStatement().executeQuery("SELECT * FROM departement");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String idDep="";
	String nomDep="";
	 String emailDep="";
	try {
		while(resultat.next())
		{
			idDep= resultat.getString("idDep");
			nomDep= resultat.getString("nomDep");
			emailDep= resultat.getString("emailDep");
		   
		    list.add(new Departement(idDep,nomDep,emailDep));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}
	
	
///////////////////fonction ajouter ///////////////////,String idDep, String nomDep, String emailDep
	public void Creation (Departement d) {
		//ResultSet rs = null;
		try {System.out.println("creation");
			PreparedStatement q=this.conn.prepareStatement("INSERT INTO deparetement (idDep,nomDep,emailDep) VALUES(?,?,?)");
			
			 
			
			q.setString(1,d.getIdDep()); 
			  q.setString(2,d.getNomDep()); 
			  q.setString(3,d.getEmailDep());
			
			 // int i=q.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/////////////////// fonction edition ///////////////////
	public void Edition() throws SQLException{
		ArrayList<Departement> list = new ArrayList<Departement>();
		ResultSet rs = null;	
		try {
			rs = this.conn.createStatement().executeQuery("SELECT * FROM deparetement");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				
				String idDep;
				String nomDep;
				 String emailDep;	
			idDep=rs.getString(1);
			nomDep=rs.getString(2);
			emailDep=rs.getString(3); 
			
			 list.add(new Departement(idDep,nomDep,emailDep) );
			 
			}
			
			for(Departement e:list) {
				 System.out.println(e.getIdDep()+""+e.getNomDep()+""+e.getEmailDep());
				
				
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
///////////////////fonction supprimer ///////////////////Departement D,
	public void Supprimer(String idDep) throws IOException{
		  try {
			  PreparedStatement p =this.conn.prepareStatement("DELETE FROM departement WHERE idDep=? ");  
				// BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
				
				  p.setString(1,idDep); 
				 // int i=p.executeUpdate();  
		  }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
///////////////////fonction modifier ///////////////////
	public void Modifier (Departement D,String idDep, String nomDep, String emailDep) throws IOException, SQLException{
		ResultSet rs = null;
		//Daodepartement ee=new DAOetape();
		try {
		 PreparedStatement p =this.conn.prepareStatement("UPDATE deparetement SET  nomDep=?,emailDep=?"+"WHERE idDep=?");  
		 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));		
		
		   
		   
		  p.setString(1,idDep); 
		  p.setString(2,nomDep); 
		  p.setString(3,emailDep); 
		  
		 
		int i=p.executeUpdate();
		 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	
	

}*/
