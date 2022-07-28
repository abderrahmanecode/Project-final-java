package metier;

import java.util.Date;

public class ProjetPFE {
	private String id;
	private String titre;
	private String idLabo;
	private String motcle;
	private String duree;
	private String dateDepart;
	
	private String idEnt;
	private String idP;
	
	public ProjetPFE() {
		super();
	}
	//private Integer a;
	public ProjetPFE(String titre) {
		super();
		this.titre = titre;
	}
	
	public ProjetPFE(String id, String titre, String idLabo, String motcle, String duree, String dateDepart,
			String idEnt, String idP) {
		super();
		this.id = id;
		this.titre = titre;
		this.idLabo = idLabo;
		this.motcle = motcle;
		this.duree = duree;
		this.dateDepart = dateDepart;
		
		this.idEnt = idEnt;
		this.idP = idP;
	}
	/**
	 * @return the idPro
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
	 * @return the idEnt
	 */
	public String getIdEnt() {
		return idEnt;
	}
	/**
	 * @return the idP
	 */
	public String getIdP() {
		return idP;
	}
	/**
	 * @param idPro the idPro to set
	 */
	public void setId(String idPro) {
		this.id = idPro;
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
	 * @param idEnt the idEnt to set
	 */
	public void setIdEnt(String idEnt) {
		this.idEnt = idEnt;
	}
	/**
	 * @param idP the idP to set
	 */
	public void setIdP(String idP) {
		this.idP = idP;
	}
	
	

}
