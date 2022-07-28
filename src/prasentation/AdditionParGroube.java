package prasentation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import persistance.connexion;

import java.sql.Connection;

public class AdditionParGroube {
	 Connection conn;
	  public AdditionParGroube() {
		  conn=(Connection) connexion.getConnexion();
	  }
	  public void AdditionEtudiantGroube() throws IOException {
		  
		   String Pathfile="C:\\Users\\hp\\Desktop\\Etudiant.csv";
		   int batchSize=20;
		  try {
			  PreparedStatement st= conn.prepareStatement("insert into Etudiant (id,nom,prenom,email,niveau) values(?,?,?,?,?)");
		       BufferedReader r=new BufferedReader(new FileReader(Pathfile));
		 
		       String TextLine=null;
		       int count=0;
		       r.readLine();
		       while((TextLine=r.readLine())!=null) {
		    	   String [] Etudiant =TextLine.split(";");
		    	   
		    		String id=Etudiant[0];
		    	    String nom=Etudiant[1];
		    	    String prenom=Etudiant[2];
		    	    String email=Etudiant[3];
		    	    String niveau=Etudiant[4];
		    	    
		    	    st.setString(1, id);
		    	    st.setString(2, nom);
		    	    st.setString(3, prenom);
		    	    st.setString(4, email);
		    	    st.setString(5, niveau);
		    	    st.addBatch();
		    	    
		    	    if(count%batchSize==0) {
		    	    	st.executeBatch();
		    	    }
		    	   
		       }
		       r.close();
		       st.executeBatch();
		       int i=st.executeUpdate();
		        System.out.println("nbr d'addition "+ i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
}
