package metier;

import java.util.ArrayList;
import java.util.Date;

public class Doctorat {
	
	
	private String id;
	private String titre;
	private String motcle;
	private String duree;
	private String dateDepart;
	private String peofesseur;
	private String membre;
	private String idLabo;
	//private Integer a;
	public Doctorat() {
		super();
	}
	
	

	public Doctorat(String titre) {
		super();
		this.titre = titre;
	}



	

	public Doctorat(String id, String titre, String motcle, String duree, String dateDepart, String peofesseur,
			String membre, String idLabo) {
		super();
		this.id = id;
		this.titre = titre;
		this.motcle = motcle;
		this.duree = duree;
		this.dateDepart = dateDepart;
		this.peofesseur = peofesseur;
		this.membre = membre;
		this.idLabo = idLabo;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @return the idLabo
	 */
	public String getIdLabo() {
		return idLabo;
	}
	/**
	 * @return the motcle
	 */
	public String getMotcle() {
		return motcle;
	}
	/**
	 * @return the duree
	 */
	public String getDuree() {
		return duree;
	}
	/**
	 * @return the dateDepart
	 */
	public String getDateDepart() {
		return dateDepart;
	}
	/**
	 * @return the idetape
	 */
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @param idLabo the idLabo to set
	 */
	public void setIdLabo(String idLabo) {
		this.idLabo = idLabo;
	}
	/**
	 * @param motcle the motcle to set
	 */
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	/**
	 * @param duree the duree to set
	 */
	public void setDuree(String duree) {
		this.duree = duree;
	}
	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	/**
	 * @param idetape the idetape to set
	 */
	



	/**
	 * @return the p
	 */
	public String getP() {
		return peofesseur;
	}



	/**
	 * @return the mem
	 */
	public String getMem() {
		return membre;
	}



	/**
	 * @param p the p to set
	 */
	public void setP(String p) {
		this.peofesseur = p;
	}



	/**
	 * @param mem the mem to set
	 */
	public void setMem(String mem) {
		this.membre = mem;
	}
	
}
