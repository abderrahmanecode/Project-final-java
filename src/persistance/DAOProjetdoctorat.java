package persistance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import metier.Doctorat;
import metier.Professeur;
import metier.ProjetPFA;


public class DAOProjetdoctorat {
	String id;
	 String titre;
	 String motcle;
	 String duree;
	 String dateDepart;
	 String professeur;
	 String membre;
	 String idLabo;
	Connection conn;
	public DAOProjetdoctorat()throws SQLException{
		conn = connexion.getConnexion();
	}
	public void Creation(Doctorat d	) throws IOException {
		ResultSet rs = null;
		try {
			PreparedStatement pr=this.conn.prepareStatement("INSERT INTO doctorat (id,titre,motcle,duree,dateDepart,professeur,membre,idLabo) VALUES(?,?,?,?,?,?,?,?)");
			BufferedReader r=new BufferedReader(new InputStreamReader(System.in));		
			
			  pr.setString(1,d.getId()); 
			  pr.setString(2,d.getTitre()); 
			  pr.setString(3,d.getMotcle()); 
			  pr.setString(4,d.getDuree()); 
			  pr.setString(5, d.getDateDepart());
			   
			  pr.setString(6, d.getP()); 
			  pr.setString(7,d.getMem());
			  pr.setString(8,d.getIdLabo());
			int i=pr.executeUpdate();
		
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void Modifier (Doctorat d) throws IOException{
		try {
		 PreparedStatement pr =this.conn.prepareStatement("UPDATE doctorat SET  titre=?, motcle=? ,duree=?,dateDepart=?, professeur=?, membre=?, idLabo=? "+"WHERE id=?");  
		 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));		
		
		 
	
		 
		   
		  pr.setString(8,d.getId()); 
		  pr.setString(1,d.getTitre()); 
		  pr.setString(2,d.getMotcle()); 
		  pr.setString(3,d.getDuree()); 
		  pr.setString(4, d.getDateDepart());
		   
		  pr.setString(5, d.getP()); 
		  pr.setString(6,d.getMem());
		  pr.setString(7,d.getIdLabo());
		int i=pr.executeUpdate();
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	
	public void Supprimer(Doctorat d) throws IOException{
		  try {
			  PreparedStatement pr =this.conn.prepareStatement("DELETE FROM doctorat"+" WHERE titre=? ");  
				 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
				
				  pr.setString(1,d.getTitre()); 
				  int i=pr.executeUpdate();  
		  }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public void Edition(){
		ArrayList<Doctorat> list = new ArrayList<Doctorat>();
		ResultSet rs = null;	
		try {
			rs = this.conn.createStatement().executeQuery("SELECT * FROM doctorat");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				
			 id=rs.getString(1);
			 titre=rs.getString(2);
			 motcle=rs.getString(3); 
			 duree=rs.getString(4); 
			 dateDepart=rs.getString(5);
			 
			 professeur=rs.getString(6); 
			membre= rs.getString(7);
			 idLabo=rs.getString(8);
			 list.add(new Doctorat( id,  titre,  motcle,  duree, dateDepart,   
					 professeur,  membre,  idLabo) );
			 
			}
			for(Doctorat e:list) {
				 System.out.println(e.getId()+""+e.getTitre()+""+e.getMotcle()+""+e.getDuree()+""+e.getP()+""+e.getMem()+""+e.getIdLabo());
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}