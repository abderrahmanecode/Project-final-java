package metier;

public class Professeur {
	private String id_depart;
     private String idP;
     private String nom;
     private String prenom;
     private String email;
     private String grade;
     private String role;
     
	public Professeur() {
		super();
	}

	public Professeur(String id_depart,String id, String nom, String prenom, String email, String grade,String role) {
		super();
		this.idP = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.grade = grade;
		this.id_depart=id_depart;
		this.role=role;
	}

	public String getId_depart() {
		return id_depart;
	}

	public void setId_depart(String id_depart) {
		this.id_depart = id_depart;
	}

	public String getIdP() {
		return idP;
	}

	public void setIdP(String idP) {
		this.idP = idP;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public Object get(int i){
		switch (i){
		case 0 : return this.getId_depart();
		case 1 : return this.getIdP();
		case 2 : return this.getNom();
		case 3 : return this.getPrenom();
		case 4 : return this.getEmail();
		case 5 : return this.getGrade();
		case 6 : return this.getRole();
		}
		return null;
	}
	
	public static String[] getAttributs(){
		String[] resultat = {"id_depart","idP","nom","prenom","email","grade","role"};
		return resultat;
		}
     
     
}
