package metier;

public class Etape {
	private String idEtape;
	private String etapeD;
	private String dureeEtape;
	private String id;
	private String titrepro;
	public Etape() {
		super();
	}
	
	public Etape(String idEtape) {
		super();
		this.idEtape = idEtape;
		
	}

	public Etape(String idEtape, String etapeD, String dureeEtape, String id, String titrepro) {
		super();
		this.idEtape = idEtape;
		this.etapeD = etapeD;
		this.dureeEtape = dureeEtape;
		this.id = id;
		this.titrepro = titrepro;
	}

	public Etape(String idEtape, String etapeD, String dureeEtape) {
		super();
		this.idEtape = idEtape;
		this.etapeD = etapeD;
		this.dureeEtape = dureeEtape;
	}
	public String getIdEtape() {
		return idEtape;
	}
	
	public String getEtapeD() {
		return etapeD;
	}
	
	public String getDureeEtape() {
		return dureeEtape;
	}
	
	public void setIdEtape(String idEtape) {
		this.idEtape = idEtape;
	}
	
	public void setEtapeD(String etapeD) {
		this.etapeD = etapeD;
	}
	
	public void setDureeEtape(String dureeEtape) {
		this.dureeEtape = dureeEtape;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the titrepro
	 */
	public String getTitrepro() {
		return titrepro;
	}
	/**
	 * @param titrepro the titrepro to set
	 */
	public void setTitrepro(String titrepro) {
		this.titrepro = titrepro;
	}
	
}
