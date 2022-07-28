package metier;

public class Entreprise {
	

	private String idEnt;
	private String raisonSo;
	private String emailEnt;
	private String idEtape;
	private Integer tele;
	private Integer codepostal;
	private String ville;
	
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entreprise(String idEnt, String raisonSo, String emailEnt, String idEtape, Integer tele, Integer codepostal,
			String ville) {
		super();
		this.idEnt = idEnt;
		this.raisonSo = raisonSo;
		this.emailEnt = emailEnt;
		this.idEtape = idEtape;
		this.tele = tele;
		this.codepostal = codepostal;
		this.ville = ville;
	}

	public String getIdEnt() {
		return idEnt;
	}

	public String getRaisonSo() {
		return raisonSo;
	}
	
	public String getEmailEnt() {
		return emailEnt;
	}
	
	public String getIdEtape() {
		return idEtape;
	}
	
	public Integer getTele() {
		return tele;
	}
	
	public Integer getCodepostal() {
		return codepostal;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setIdEnt(String idEnt) {
		this.idEnt = idEnt;
	}
	
	public void setRaisonSo(String raisonSo) {
		this.raisonSo = raisonSo;
	}
	
	public void setEmailEnt(String emailEnt) {
		this.emailEnt = emailEnt;
	}
	
	public void setIdEtape(String idEtape) {
		this.idEtape = idEtape;
	}
	
	public void setTele(Integer tele) {
		this.tele = tele;
	}
	
	public void setCodepostal(Integer codepostal) {
		this.codepostal = codepostal;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Entreprise [idEnt=" + idEnt + ", raisonSo=" + raisonSo + ", emailEnt=" + emailEnt + ", idEtape="
				+ idEtape + ", tele=" + tele + ", codepostal=" + codepostal + ", ville=" + ville + "]";
	}
	
	
	
}
