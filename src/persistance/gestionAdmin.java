package persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Connection;

import prasentation.EspaceAdministration;

public class gestionAdmin {
	 Connection conn;
	  public gestionAdmin() {
		  conn= connexion.getConnexion();
	  }
	  public boolean Exsite(String email,String id) {
		  ResultSet resultat = null;
		  try {
				resultat = this.conn.createStatement().executeQuery("select * from administration where email='"+ email +"' and identifiant='" + id +"' ");
				EspaceAdministration f=new EspaceAdministration();
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
