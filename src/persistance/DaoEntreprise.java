package persistance;


import metier.Entreprise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.DriverManager;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;







public class DaoEntreprise implements Dao<Entreprise> {
	Connection conn;
	public DaoEntreprise(){
	conn = connexion.getConnexion();  
	 }   
 
@Override
	public void save(Entreprise item) {
		try {
			
			  PreparedStatement st= conn.prepareStatement("insert into entreprise (idEnt,raisonSo, emailEnt, idEtape, tele, codepostal, ville) VALUES(?,?,?,?,?,?,?");
		       
		    	   
	

		    	   
		    	   
		    	   st.setString(1, item.getIdEnt());
		    	   st.setString(2, item.getRaisonSo());
		           st.setString(3, item.getEmailEnt());
		  			st.setString(4, item.getIdEtape());
		    	   st.setInt(5, item.getTele());
		           st.setInt(6, item.getCodepostal());	
		       		st.setString(7, item.getVille());
		       
		       
		    
		        int i=st.executeUpdate();
		        System.out.println("nbr d'addition "+ i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}

 	
 	
 	@Override
	public boolean saveAll(List<Entreprise> items) {
		// TODO Auto-generated method stub
		return false;
	
 	}
 	public Entreprise getById( String id) {
		Entreprise E;
		
		
	String Id;
	String rai;
	String email;
	String idEt;
	Integer tel;
	Integer code;
	String ville; 
		
		
		
		
		try {
			 PreparedStatement st= conn.prepareStatement("SELECT * FROM entreprise where idEnt=?",ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 
			 
			
	   	     st.setString(1, id);
	   	     ResultSet resultat =st.executeQuery();
	   	     if(resultat.next()==false) {
	   	    	 System.out.println("n'exsite pas");
	   	     }
	   	     else {
	   	    	 resultat.previous();
	   	    	 while(resultat.next()) {
	   	    		 Id=resultat.getString(1);
	   	    		 rai=resultat.getString(2);
	   	    		email=resultat.getString(3);
	   	    		idEt=resultat.getString(4);
	   	    		tel=resultat.getInt(5);
	   	    		 code=resultat.getInt(6);
	   	    		ville=resultat.getString(7);
	   	    		
	   	    		
	   	    		
	   	    		E = new Entreprise (Id, rai, email,idEt,tel,code,ville);
	   	    		return E;
	   	    	 }
	   	     }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
	
	
	
@Override
	public List <Entreprise> getAll() {
		ArrayList<Entreprise> list = new ArrayList<Entreprise>();
		ResultSet resultat = null;
		try {
			resultat =this.conn.createStatement().executeQuery("SELECT * FROM entreprise");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	String Id="";
	String rai="";
	String email="";
	String idEt="";
	Integer tel=0;
	Integer code=0;
	String ville=""; 
		try {
			while(resultat.next())
			{
			   
			    
			    	Id=resultat.getString("idEnt");
	   	    		 rai=resultat.getString("raisonSo");
	   	    		email=resultat.getString("emailEnt");
	   	    		idEt=resultat.getString("idEtape");
	   	    		tel=resultat.getInt("tele");
	   	    		 code=resultat.getInt("codepostal");
	   	    		ville=resultat.getString("ville");
	   	    		list.add(new Entreprise(Id,rai,email,idEt,tel,code,ville));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}	
		 



@Override
	public void update(Entreprise item) {
		try {
	         PreparedStatement st= conn.prepareStatement("UPDATE entreprise SET Nom_L=?, Email_L=?,Id_responsable=? WHERE Id_laboratoire=?");
	         
	         
	   	st.setString(1, item.getIdEnt());
		st.setString(2, item.getRaisonSo());
		st.setString(3, item.getEmailEnt());
		st.setString(4, item.getIdEtape());
		st.setInt(5, item.getTele());
		st.setInt(6, item.getCodepostal());	
		st.setString(7, item.getVille());
	    
	         
	       int i=st.executeUpdate();
	         System.out.println( i + " entreprise est modifier dans la table entreprise");
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	   }	
	
	
	

public void delete(String item) {
		try {
	         PreparedStatement st= conn.prepareStatement("delete from entreprise where idEnt=?");
	         
	         st.setString(1, item);
	         int i=st.executeUpdate();
	         System.out.println(i + "entreprise est supprimer dans la table entreprise");
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
















/*

public class DaoEntreprise {
	private String idEnt;
	private String raisonSo;
	private String emailEnt;
	private String idEtape;
	private Integer tele;
	private Integer codepostal;
	private String ville;
	Connection conn;
		public DaoEntreprise()throws SQLException{
			 conn= Connexion.getConnexion();
		}
	public void Creation ( Entreprise E,String idEnt,String raisonSo, String emailEnt, String idEtape, Integer tele, Integer codepostal, String ville) throws IOException, SQLException {
			ResultSet rs = null;//idEnt raisonSo emailEnt idEtape tele codepostal ville
	
			try {
				PreparedStatement p=this.conn.prepareStatement("INSERT INTO entreprise (idEnt,raisonSo, emailEnt, idEtape, tele, codepostal, ville) VALUES(?,?,?,?,?,?,?)");
				BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
			
				 
				  p.setString(1,idEnt); 
				  p.setString(2,raisonSo); 
				  p.setString(3,emailEnt); 
				  p.setString(4,idEtape); 
				  p.setInt(5, tele); 
				  p.setInt(6,codepostal); 
				  p.setString(7,ville);
				 
				int i=p.executeUpdate();
				
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void Modifier (Entreprise E,String idEnt,String raisonSo, String emailEnt, String idEtape, Integer tele, Integer codepostal, String ville ) throws IOException, SQLException{
		ResultSet rs = null;
		//DAOetape ee=new DAOetape();
		try {
		 PreparedStatement p =this.conn.prepareStatement("UPDATE entreprise SET  raisonSo=?, emailEnt=?, idEtape=?, tele=?, codepostal=?, ville=? "+"WHERE idEnt=?");  
		 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));		
		
		  p.setString(1,idEnt); 
		  p.setString(2,raisonSo); 
		  p.setString(3,emailEnt); 
		  p.setString(4,idEtape); 
		  p.setInt(5, tele); 
		  p.setInt(6,codepostal); 
		  p.setString(7,ville);
		 
		int i=p.executeUpdate();
		 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void Supprimer(Entreprise E,String idEnt) throws IOException{
		  try {
			  PreparedStatement p =this.conn.prepareStatement("DELETE FROM entreprise"+" WHERE idEnt=? ");  
				 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
				
				  int i=p.executeUpdate();  
		  }catch (SQLException e) {
				// TODO -generated catch block
				e.printStackTrace();
			}
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
}*/
