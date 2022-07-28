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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import metier.ProjetPFA;
import metier.ProjetPFE;



public class DAOProjetpfe {
	String id;
	 String titre;
	 String idLabo;
	 String motcle;
	 String duree;
	 String dateDepart;
	 String nometape;
	 String idEnt;
	 String idP;
	 String a;
	
	Connection conn;
	public DAOProjetpfe()throws SQLException{
		conn = connexion.getConnexion();
	}
	//ProjetPFA p=new ProjetPFA();
	public void Creation (ProjetPFE pr) throws IOException, SQLException {
	ResultSet rs = null;
	
	try {
	PreparedStatement p=this.conn.prepareStatement("INSERT INTO projetpfe (id,titre,motcle,duree,dateDepart,idP,idEnt,idLabo) VALUES(?,?,?,?,?,?,?,?)");
	BufferedReader r=new BufferedReader(new InputStreamReader(System.in));		
	 
	//int i=p.executeUpdate();
	  p.setString(1,pr.getId()); 
	  p.setString(2,pr.getTitre()); 
	  p.setString(3,pr.getMotcle()); 
	  p.setString(4,pr.getDuree()); 
	  p.setString(5, pr.getDateDepart());
	 
	  p.setString(6,pr.getIdP()); 
	  p.setString(7,pr.getIdEnt());
	  p.setString(8,pr.getIdLabo());
	
	  int i=p.executeUpdate();
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public void Modifier (ProjetPFE pr) throws IOException, SQLException{
		ResultSet rs = null;
		DAOetape ee=new DAOetape();
		try {
		 PreparedStatement p =this.conn.prepareStatement("UPDATE projetpfe SET  titre=?, motcle=? ,duree=?, dateDepart=?, idP=?, idEnt=?, idLabo=? "+"WHERE id=?");  
		 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));		
		
		 p.setString(8,pr.getId()); 
		  p.setString(1,pr.getTitre()); 
		  p.setString(2,pr.getMotcle()); 
		  p.setString(3,pr.getDuree()); 
		  p.setString(4, pr.getDateDepart());
		 
		  p.setString(5,pr.getIdP()); 
		  p.setString(6,pr.getIdEnt());
		  p.setString(7,pr.getIdLabo());   
		   
		 
		int i=p.executeUpdate();
		 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public void Supprimer(ProjetPFE pr) throws IOException{
	  try {
		  PreparedStatement p =this.conn.prepareStatement("DELETE FROM projetpfe"+" WHERE titre=? ");  
			 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
			 
			  p.setString(1,pr.getTitre()); 
			  int i=p.executeUpdate();  
	  }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Edition() throws SQLException{
		ArrayList<ProjetPFA> list = new ArrayList<ProjetPFA>();
		ResultSet rs = null;	
		try {
			rs = this.conn.createStatement().executeQuery("SELECT * FROM projetpfe");
			
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
			 idP=rs.getString(6); 
			idEnt= rs.getString(7);
			 idLabo=rs.getString(8);
			 
			 list.add(new ProjetPFA( id,  titre,  motcle,  duree,  dateDepart,  
			 idEnt,  idP,  idLabo) );
			 
			}
			
			for(ProjetPFA e:list) {
				 System.out.println(e.getId()+""+e.getTitre()+""+e.getMotcle()+""+e.getDuree()+""+e.getDateDepart()+""+e.getIdP()+""+e.getIdEnt()+""+e.getIdLabo());
				
				
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void Affectation(ProjetPFE pr) throws IOException{
		ResultSet rs = null;
		ArrayList<ProjetPFA> list = new ArrayList<ProjetPFA>();
		
		  try {
			   PreparedStatement p =this.conn.prepareStatement("SELECT * FROM projetpfe WHERE a=? ");  
			   p.setString(1,"-1"); 
			   rs=p.executeQuery()	 ;
			  
				  
				 System.out.println("les list des projets");
		  
				while(rs.next())
				{
					
				 id=rs.getString(1);
				 titre=rs.getString(2);
				 motcle=rs.getString(3); 
				 duree=rs.getString(4); 
				 dateDepart=rs.getString(5); 
				 idP=rs.getString(6); 
				idEnt= rs.getString(7);
				 idLabo=rs.getString(8);
				 
				 list.add(new ProjetPFA( id,  titre,  motcle,  duree,  dateDepart,  
				 idEnt,  idP,  idLabo) );
				 
				}
				for(ProjetPFA e:list) {
					 System.out.println(e.getId()+""+e.getTitre()+""+e.getMotcle()+""+e.getDuree()+""+e.getDateDepart()+""+e.getIdP()+""+e.getIdEnt()+""+e.getIdLabo());
					
					
				 }
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
}
	

}
