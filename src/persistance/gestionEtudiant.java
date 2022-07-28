package persistance;

import metier.Etudiant;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;

import prasentation.EspaceAdministration;
import prasentation.ProfileEtudiant;
public class gestionEtudiant {
	String id;
    String nom;
    String prenom;
    String email;
    String niveau;
    String nomfili�re;
   Connection conn;
   public gestionEtudiant() {
	   conn= (Connection) connexion.getConnexion();
   }
   public  ArrayList<Etudiant> getAll() {
	   ArrayList<Etudiant> list=new ArrayList<Etudiant>();
		ResultSet resultat = null;
		try {
			resultat = this.conn.createStatement().executeQuery("SELECT * FROM Etudiant");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(resultat.next())
			{
				id = resultat.getString("id");
			    nom = resultat.getString("nom");
			    prenom = resultat.getString("prenom");
			    email=resultat.getString("email");
			    niveau=resultat.getString("niveau");
			    nomfili�re=resultat.getString("nomfili�re");
			    list.add(new Etudiant( id,nom, prenom,email,niveau,nomfili�re));
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
   
   public void AdditionEtudiant(Etudiant E) throws IOException {
		  try {
			//    String id;
			  //  String nom;
		      //  String prenom;
		      //  String email;
		      //  String niveau;
			  PreparedStatement st= conn.prepareStatement("insert into Etudiant (id,nom,prenom,email,niveau,nomfili�re) values(?,?,?,?,?,?)");
		     //  BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		     
		    	//   System.out.println("Entrez un id:");
		    	  // id=r.readLine();
		    	  // System.out.println("Entrez un nom :");
		    	  // nom=r.readLine();
		    	  // System.out.println("Entrez un prenom :");
		    	  // prenom=r.readLine();
		    	   //System.out.println("Entrez un email:");
		    	   //email=r.readLine();
		    	   //System.out.println("Entrez un niveau");
		    	   //niveau=r.readLine();
		    	   //System.out.println("Entrez un nomfili�re");
		    	   //nomfili�re=r.readLine();
		    	   
		    	   st.setString(1, E.getId());
		    	   st.setString(2, E.getNom());
		           st.setString(3, E.getPrenom());
		           st.setString(4, E.getEmail());
		           st.setString(5, E.getNiveau());
		           st.setString(6, E.getNomfili�re());
		    
		        int i=st.executeUpdate();
		        //System.out.println("nbr d'addition "+ i);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  }
   
   public void AdditionEtudiantGroube(String Pathfile) throws IOException {
	   //String Pathfile="C:\\Users\\hp\\Desktop\\Etudiant.csv";
	   int batchSize=20;
	  try {
		  PreparedStatement st= conn.prepareStatement("insert into Etudiant (id,nom,prenom,email,niveau,nomfili�re) values(?,?,?,?,?,?)");
	       BufferedReader r=new BufferedReader(new FileReader(Pathfile));
	 
	       String TextLine=null;
	       int count=0;
	       r.readLine();
	       while((TextLine=r.readLine())!=null) {
	    	   String [] Etudiant =TextLine.split(";");
	    	   
	    		
	    		id=Etudiant[0];
	    	    nom=Etudiant[1];
	    	    prenom=Etudiant[2];
	    	    email=Etudiant[3];
	    	    niveau=Etudiant[4];
	    	    nomfili�re=Etudiant[5];
	    	    
	    	    st.setString(1, id);
	    	    st.setString(2, nom);
	    	    st.setString(3, prenom);
	    	    st.setString(4, email);
	    	    st.setString(5, niveau);
	    	    st.setString(6, nomfili�re);
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
   
   public void modifierEtudiant(String a,String b,String c,String d,String e,String f) throws IOException {
   	
 	  try {
         PreparedStatement st= conn.prepareStatement("UPDATE Etudiant SET nom=?, prenom=?, email=?,niveau=?,nomfili�re=? WHERE id=?");
    
	     
         st.setString(1, nom);
         st.setString(2, prenom);
         st.setString(3, email);
         st.setString(4, niveau);
         st.setString(5, nomfili�re);
         st.setString(6, id);
         
 	} catch (SQLException e1) {
 		// TODO Auto-generated catch block
 		e1.printStackTrace();
 	}
   }
   
   public void SuppresionEtudiant(String ID) throws IOException {
	     
 	  try {
 		 EspaceAdministration f=new EspaceAdministration();
         PreparedStatement st= conn.prepareStatement("SELECT *From Etudiant WHERE id = '"+ID+"' ");
         ResultSet resulta = st.executeQuery();
         if(resulta.next()) {
        	 Statement stmt = (Statement) conn.createStatement();
     	    stmt.executeUpdate("delete from Etudiant where id='"+ID+"'");
        // JOptionPane.showMessageDialog(f,"supprission est fait","supprimer", JOptionPane.YES_OPTION);
       }
 	} catch (SQLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
   }
   
   public void getEtudiant() throws IOException{
		Etudiant etudiant;
		//String id;
		//String nom;
		//String prenom ;
		//String email;
		//String niveau;
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
	   	    		nomfili�re=resultat.getString(6);
	   	    		etudiant = new Etudiant(id, nom, prenom,email,niveau,nomfili�re);
	   	    		System.out.println(etudiant.getId()+" "+etudiant.getNom()+" "+etudiant.getPrenom()+" "+
		                  	etudiant.getEmail()+" "+etudiant.getNiveau()+" "+etudiant.getNomfili�re());
	   	    	 }
	   	     }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		JOptionPane.showMessageDialog(null, "Erreur d'imprimer","d�clarer une erreur d'imprimer",JOptionPane.ERROR_MESSAGE);
	}
	   }
   public boolean ExsiteEtudiant(String email,String id) {
		  ResultSet resultat = null;
		  try {
				resultat = this.conn.createStatement().executeQuery("select * from etudiant where email='"+ email +"' and id='" + id +"' ");
				ProfileEtudiant f=new ProfileEtudiant();
				if(resultat.next()) {
					
					f.setVisible(true);
					f.setLocationRelativeTo(null);
					return true;
		        }
		        else {
		        	JOptionPane.showMessageDialog(f,"erreur de connexion","D�sol�", JOptionPane.ERROR_MESSAGE);
		        	return false;
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	  }
	   
}

   
   



