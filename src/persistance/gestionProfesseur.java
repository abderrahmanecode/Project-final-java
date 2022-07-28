package persistance;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;


import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;

import prasentation.EspaceAdministration;
import prasentation.ProfileEtudiant;
import prasentation.ProfileProfesseur;

import java.sql.PreparedStatement;
import java.sql.Statement;

import metier.Professeur;

public class gestionProfesseur {
	String idp;
    String nom;
    String prenom;
    String email;
    String id_depart;
    String grade;
    String role;
	Connection conn;
	public gestionProfesseur() {
		  conn= (Connection) connexion.getConnexion();
	}
	 public  ArrayList<Professeur> getAll() {
		   ArrayList<Professeur> list=new ArrayList<Professeur>();
			ResultSet resultat = null;
			try {
				resultat = this.conn.createStatement().executeQuery("SELECT * FROM Professeur");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(resultat.next())
				{
					idp = resultat.getString("idp");
				    nom = resultat.getString("nom");
				    prenom = resultat.getString("prenom");
				    email=resultat.getString("email");
				    id_depart=resultat.getString("id_depart");
				    role=resultat.getString("role");
				    grade=resultat.getString("grade");
				    list.add(new Professeur( id_depart,idp,nom, prenom,email,grade,role));
				    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
			}
	   
	   public void AdditionProfesseur(Professeur E) throws IOException {
			  try {
			
				  java.sql.PreparedStatement st= conn.prepareStatement("insert into Professeur (id_depart,idp,nom,prenom,email,grade,role) values(?,?,?,?,?,?,?)");
			   
			    	   
			    	   st.setString(1, E.getId_depart());
			    	   st.setString(2, E.getIdP());
			           st.setString(3, E.getNom());
			           st.setString(4, E.getPrenom());
			           st.setString(5, E.getEmail());
			           st.setString(6, E.getGrade());
			           st.setString(7, E.getRole());
			    
			        int i=st.executeUpdate();
			        //System.out.println("nbr d'addition "+ i);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		  }
	   
	   public void AdditionProfesseurGroube(String Pathfile) throws IOException {
			  
		   //String Pathfile="C:\\Users\\hp\\Desktop\\Etudiant.csv";
		   int batchSize=20;
		  try {
			  PreparedStatement st= (PreparedStatement) conn.prepareStatement("insert into Professeur (id_depart,idp,nom,prenom,email,grade,role) values(?,?,?,?,?,?,?)");
		       BufferedReader r=new BufferedReader(new FileReader(Pathfile));
		 
		       String TextLine=null;
		       int count=0;
		       r.readLine();
		       while((TextLine=r.readLine())!=null) {
		    	   String [] Professeur =TextLine.split(";");
		    	   
		    		
		    		id_depart=Professeur[0];
		    	    idp=Professeur[1];
		    	    nom=Professeur[2];
		    	    prenom=Professeur[3];
		    	    email=Professeur[4];
		    	    grade=Professeur[5];
		    	    role=Professeur[6];
		    	    
		    	    st.setString(1, id_depart);
		    	    st.setString(2, idp);
		    	    st.setString(3, nom);
		    	    st.setString(4, prenom);
		    	    st.setString(5, email);
		    	    st.setString(6, grade);
		    	    st.setString(7, role);
		    	    st.addBatch();
		    	    
		    	    if(count%batchSize==0) {
		    	    	st.executeBatch();
		    	    }
		       }
		       r.close();
		       st.executeBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	   
	   public void modifierProfesseur(String a,String b,String c,String d,String e,String f,String g) throws IOException {
	   	
	 	  try {
	         PreparedStatement st= (PreparedStatement) conn.prepareStatement("UPDATE Professeur SET id_depart=?, nom=?, prenom=?, email=?,grade=?,role=? WHERE idp=?");
	    
		     
	         st.setString(1, id_depart);
	         st.setString(2, nom);
	         st.setString(3, prenom);
	         st.setString(4, email);
	         st.setString(5, grade);
	         st.setString(6, role);
	         st.setString(7, idp);
	         
	 	} catch (SQLException e1) {
	 		// TODO Auto-generated catch block
	 		e1.printStackTrace();
	 	}
	   }
	   
	   public Integer SuppresionProfesseur(String ID) throws IOException {
		   int j=0;
	 	  try {
	 		  String i="-1";
	 		  
	 		 EspaceAdministration f=new EspaceAdministration();
	         PreparedStatement st= (PreparedStatement) conn.prepareStatement("SELECT *From Professeur WHERE idp = '"+ID+"' ");
	         ResultSet resulta = st.executeQuery();
	         if(resulta.next()) {
	        	 Statement stmt = (Statement) conn.createStatement();
	     	    j=stmt.executeUpdate("delete from Professeur where idp='"+ID+"' and a='"+i+"'");
	        // JOptionPane.showMessageDialog(f,"supprission est fait","supprimer", JOptionPane.YES_OPTION);
	     	  //if(j==0) {
	     		  //formulaire9 f=new formulaire9();
	 		   //   JOptionPane.showMessageDialog(null, "impossible de supprimer","Erreur",JOptionPane.ERROR_MESSAGE);
	     	 // }
	     	    return j;   
	       }
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 	  return j;
	   }
	   
	   public void getProfesseur(String ID) throws IOException{
			Professeur P;
			try {
				 PreparedStatement st= (PreparedStatement) conn.prepareStatement("SELECT * FROM Professeur where idp='"+ID+"'",ResultSet.TYPE_SCROLL_INSENSITIVE,
						 ResultSet.CONCUR_UPDATABLE);
				 BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
				
		   	     st.setString(1, ID);
		   	     ResultSet resultat =st.executeQuery();
		   	     if(resultat.next()==false) {
		   	    	 System.out.println("n'exsite pas");
		   	     }
		   	     else {
		   	    	 resultat.previous();
		   	    	 while(resultat.next()) {
		   	    		 id_depart=resultat.getString(1);
		   	    		 idp=resultat.getString(2);
		   	    		 nom=resultat.getString(3);
		   	    		 prenom=resultat.getString(4);
		   	    		email=resultat.getString(5);
		   	    		grade=resultat.getString(6);
		   	    		role=resultat.getString(7);
		   	    		P = new Professeur(id_depart,idp, nom, prenom,email,grade,role);
		   	    	 }
		   	     }

			} catch (SQLException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
			}
	   public void EditionTable(JTable TAB,String titre) {
		   MessageFormat entete=new MessageFormat(titre);
		   MessageFormat pied=new MessageFormat("page 0");
		   
		   try {
			TAB.print(JTable.PrintMode.FIT_WIDTH,entete,pied);
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erreur d'imprimer","déclarer une erreur d'imprimer",JOptionPane.ERROR_MESSAGE);
		}
		   }
	   public boolean ExsiteProfesseur(String email,String id) {
			  ResultSet resultat = null;
			  try {
					resultat = this.conn.createStatement().executeQuery("select * from professeur where email='"+ email +"' and idp='" + id +"' ");
					ProfileProfesseur f=new ProfileProfesseur();
					if(resultat.next()) {
						
						f.setVisible(true);
						f.setLocationRelativeTo(null);
						return true;
			        }
			        else {
			        	JOptionPane.showMessageDialog(f,"erreur de connexion","Désolé", JOptionPane.ERROR_MESSAGE);
			        	return false;
			        }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return false;
		  }
		       
	
}

