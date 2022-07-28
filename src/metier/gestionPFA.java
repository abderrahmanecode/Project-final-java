package metier;

import java.io.IOException;
import java.sql.SQLException;

import persistance.DAOProjetpfa;

public class gestionPFA {
	
  private DAOProjetpfa dao;
  private ProjetPFA pr;
  public gestionPFA() throws SQLException {
	super();
	dao = new DAOProjetpfa();
}

public gestionPFA(DAOProjetpfa dao) {
	super();
	this.dao = dao;
} 
public void Creation( ) throws IOException, SQLException  {
	 dao.Creation(pr);
	
}
 public void Affiche() throws SQLException {
	 dao.Edition();
 }
}
