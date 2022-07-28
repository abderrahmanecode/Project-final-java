package persistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import metier.Etape;
import metier.ProjetPFA;

public class DAOetape {
	String idEtape;
	 String etapeD;
	 String dureeEtape;
	 String id;
	 String titrepro;
	Connection conn;	
	public DAOetape()throws SQLException{
		conn = connexion.getConnexion();
	}
	
	public void Ajouter (Etape pr) throws IOException{
		ResultSet rs = null;
		
		try {
		PreparedStatement p=this.conn.prepareStatement("INSERT INTO etape (idEtape,etapeD,dureeEtape,id,titrepro) VALUES(?,?,?,?,?)");
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
		
		    
		  p.setString(1,pr.getIdEtape()); 
		  p.setString(2,pr.getEtapeD()); 
		  p.setString(3,pr.getDureeEtape()); 
		  p.setString(4,pr.getId()); 
		  p.setString(5,pr.getTitrepro()); 
		  int i=p.executeUpdate(); 
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void Delet(Etape pr ) throws IOException{
		  try {
			  PreparedStatement p =this.conn.prepareStatement("DELETE FROM etape"+" WHERE idEtape=? "); 
			  BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
				
				   p.setString(1,pr.getIdEtape());                                                      
				   
				  int i=p.executeUpdate(); 
				  
		  }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		}
	public void Modifier (Etape pr) throws IOException{
		ResultSet rs = null;
		
		try {
		PreparedStatement p=this.conn.prepareStatement("UPDATE etape SET etapeD=?,dureeEtape=? ,id=?,titrepro=?"+"WHERE idEtape=?");
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
		
		 p.setString(5,pr.getIdEtape()); 
		  p.setString(1,pr.getEtapeD()); 
		  p.setString(2,pr.getDureeEtape()); 
		  p.setString(3,pr.getId()); 
		  p.setString(4,pr.getTitrepro()); 
		  int i=p.executeUpdate(); 
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public ResultSet   AfficheEtapes(Etape pe) throws NumberFormatException, IOException{
		ArrayList<Etape> list = new ArrayList<Etape>();
		ResultSet rs = null;	
		try {
			PreparedStatement p=this.conn.prepareStatement("SELECT * FROM etape WHERE id=? AND titrepro=?");
			BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
			   
			  p.setString(1,pe.getId()); 
			  p.setString(2,pe.getTitrepro());
			  
			  rs=p.executeQuery();
			  while(rs.next())
				{
				  idEtape=rs.getString(1);
					etapeD=rs.getString(2);
					dureeEtape=rs.getString(3);
				    id=rs.getString(4);
				    titrepro=rs.getString(5);
				    list.add(new Etape( idEtape,  etapeD,  dureeEtape,id,titrepro) );
					
					 
				}
				/*for(Etape e:list) {
					 System.out.println(e.getIdEtape()+""+e.getEtapeD()+""+e.getDureeEtape()+""+e.getId()+""+e.getTitrepro());
				 }*/
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	
	}
	public void Affiche(){
		ArrayList<Etape> list = new ArrayList<Etape>();
		ResultSet rs = null;	
		try {
			rs = this.conn.createStatement().executeQuery("SELECT * FROM etape ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				
				idEtape=rs.getString(1);
				etapeD=rs.getString(2);
				dureeEtape=rs.getString(3); 
			    id=rs.getString(4);
			    titrepro=rs.getString(5);
			 list.add(new Etape( idEtape,  etapeD,  dureeEtape,id,titrepro) );
			
			 
			}
			for(Etape e:list) {
				 System.out.println(e.getIdEtape()+""+e.getEtapeD()+""+e.getDureeEtape()+""+e.getId()+""+e.getTitrepro());
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	} 
	
}
