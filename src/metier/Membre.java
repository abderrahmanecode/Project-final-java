package metier;

public class Membre {
   private String Id_membre;
   private String Id_labo;
   private String nom;
   private String prenom;
public Membre() {
	super();
}
public Membre(String id_membre, String id_labo, String nom, String prenom) {
	super();
	Id_membre = id_membre;
	Id_labo = id_labo;
	this.nom = nom;
	this.prenom = prenom;
}
public String getId_membre() {
	return Id_membre;
}
public void setId_membre(String id_membre) {
	Id_membre = id_membre;
}
public String getId_labo() {
	return Id_labo;
}
public void setId_labo(String id_labo) {
	Id_labo = id_labo;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
@Override
public String toString() {
	return "Membre [Id_membre=" + Id_membre + ", Id_labo=" + Id_labo + ", nom=" + nom + ", prenom=" + prenom + "]";
}
  
}
