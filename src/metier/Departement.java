package metier;

public class Departement {
	private String idDep;
	private String nomDep;
	private String emailDep;
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Departement(String idDep, String nomDep ,String emailDep) {
		super();
		this.idDep = idDep;
		this.nomDep = nomDep;
		this.emailDep = emailDep;
	}


	public String getIdDep() {
		return idDep;
	}

	public void setIdDep(String idDep) {
		this.idDep = idDep;
	}

	public String getNomDep() {
		return nomDep;
	}
	
	public String getEmailDep() {
		return emailDep;
	}
	
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	
	public void setEmailDep(String emailDep) {
		this.emailDep = emailDep;
	}


	@Override
	public String toString() {
		return "Departement [idDep=" + idDep + ", nomDep=" + nomDep + ", emailDep=" + emailDep + "]";
	}
	
}












