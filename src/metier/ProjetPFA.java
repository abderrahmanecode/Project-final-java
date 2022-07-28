package metier;

import java.util.Date;

public class ProjetPFA {
	
	private String id;
	private String titre;
	private String motcle;
	private String duree;
	private String dateDepart;
	private String nometape;
	private String idEnt;
	private String idP;
	private String idLabo;
	public ProjetPFA(String id, String titre, String motcle, String duree, String dateDepart,
			String idEnt, String idP, String idLabo) {
		super();
		this.id = id;
		this.titre = titre;
		this.motcle = motcle;
		this.duree = duree;
		this.dateDepart = dateDepart;
		
		this.idEnt = idEnt;
		this.idP = idP;
		this.idLabo = idLabo;
		
	}



	public ProjetPFA(String titre) {
		super();
		this.titre = titre;
	}



	//private Integer a;
	public ProjetPFA() {
		super();
	}



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

	public String getIdLabo() {
		return idLabo;
	}

	public void setIdLabo(String idLabo) {
		this.idLabo = idLabo;
	}



	/**
	 * @return the nometape
	*/

}
