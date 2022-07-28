package metier;

public class filiere {
	private String Id_filiere;
	private String Nom_F;
	private String Id_coordinateu;
	private String Id_deparetement;
	
	public filiere() {
		super();
	}
	public filiere(String id_filiere, String nom_F, String id_coordinateu, String id_deparetement) {
		super();
		Id_filiere = id_filiere;
		Nom_F = nom_F;
		Id_coordinateu = id_coordinateu;
		Id_deparetement = id_deparetement;
	}
	public String getId_filiere() {
		return Id_filiere;
	}
	public void setId_filiere(String id_filiere) {
		Id_filiere = id_filiere;
	}
	public String getNom_F() {
		return Nom_F;
	}
	public void setNom_F(String nom_F) {
		Nom_F = nom_F;
	}
	public String getId_coordinateu() {
		return Id_coordinateu;
	}
	public void setId_coordinateu(String id_coordinateu) {
		Id_coordinateu = id_coordinateu;
	}
	public String getId_deparetement() {
		return Id_deparetement;
	}
	public void setId_deparetement(String id_deparetement) {
		Id_deparetement = id_deparetement;
	}
	@Override
	public String toString() {
		return "filiere [Id_filiere=" + Id_filiere + ", Nom_F=" + Nom_F + ", Id_coordinateu=" + Id_coordinateu
				+ ", Id_deparetement=" + Id_deparetement + "]";
	}
}

