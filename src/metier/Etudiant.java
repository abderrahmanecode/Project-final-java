package metier;

public class Etudiant {
	private String id;
     private String nom;
     private String prenom;
     private String email;
     private String niveau;
     private String nomfili�re;
     
	public Etudiant() {
		super();
	}

	public Etudiant(String id, String nom, String prenom,String email, String niveau,String nomfili�re) {
		super();
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.email=email;
		this.niveau=niveau;
		this.nomfili�re=nomfili�re;
		
	}
    
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getNiveau() {
		return niveau;
	}

	public void setGrade(String niveau) {
		this.niveau = niveau;
	}

	public String getNomfili�re() {
		return nomfili�re;
	}

	public void setNomfili�re(String nomfili�re) {
		this.nomfili�re = nomfili�re;
	}
	public Object get(int i){
		switch (i){
		case 0 : return this.getId();
		case 1 : return this.getNom();
		case 2 : return this.getPrenom();
		case 3 : return this.getEmail();
		case 4 : return this.getNiveau();
		case 5 : return this.getNomfili�re();
		}
		return null;
	}
	
	public static String[] getAttributs(){
		String[] resultat = {"id","nom","prenom","email","niveau","nomfili�re"};
		return resultat;
		}
     
} 
