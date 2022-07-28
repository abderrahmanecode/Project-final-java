package metier;


public class laboratoire {
	private String Id_laboratoire;
	private String Nom_L;
	private String Email_L;
	private String Id_responsable;
	
	public laboratoire() {
		super();
	}
	public laboratoire(String id_laboratoire, String nom_L, String email_L, String id_responsable) {
		super();
		Id_laboratoire = id_laboratoire;
		Nom_L = nom_L;
		Email_L = email_L;
		Id_responsable = id_responsable;
	}
	public String getId_laboratoire() {
		return Id_laboratoire;
	}
	public void setId_laboratoire(String id_laboratoire) {
		Id_laboratoire = id_laboratoire;
	}
	public String getNom_L() {
		return Nom_L;
	}
	public void setNom_L(String nom_L) {
		Nom_L = nom_L;
	}
	public String getEmail_L() {
		return Email_L;
	}
	public void setEmail_L(String email_L) {
		Email_L = email_L;
	}
	public String getId_responsable() {
		return Id_responsable;
	}
	public void setId_responsable(String Id_rsponsable) {
		Id_responsable = Id_rsponsable;
	}
	@Override
	public String toString() {
		return "laboratoire [Id_laboratoire=" + Id_laboratoire + ", Nom_L=" + Nom_L + ", Email_L=" + Email_L
				+ ", Id_responsable=" + Id_responsable + "]";
	}
}

