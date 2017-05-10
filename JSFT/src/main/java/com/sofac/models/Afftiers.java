package com.sofac.models;
// Generated 2 mai 2017 11:47:09 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Afftiers generated by hbm2java
 */
@Entity
@Table(name = "AFFTIERS", schema = "OPS$INGENETUDES", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ID_AFFAIRE", "CODE_NAT_TIERS", "DATE_EFFET", "NO_ORDRE" }))
public class Afftiers implements java.io.Serializable {

	private AfftiersId id;
	private Integer dossier;
	private String contrat;
	private Byte avenant;
	private String codeRelation;
	private Long dateModification;
	private String commentaire;
	private String tiers2;
	private Byte noAdresse;
	private String codeReglement;
	private Byte noRib;
	private Long dateFin;
	private Short nbOriginauxFactures;
	private Short nbExemplairesEdites;
	private String codeTiersPrincipal;
	private Long idGrpaffarc;

	public Afftiers() {
	}

	public Afftiers(AfftiersId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tiers1", column = @Column(name = "TIERS_1", nullable = false, length = 10)),
			@AttributeOverride(name = "codeNatTiers", column = @Column(name = "CODE_NAT_TIERS", nullable = false, length = 4)),
			@AttributeOverride(name = "dateEffet", column = @Column(name = "DATE_EFFET", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "noOrdre", column = @Column(name = "NO_ORDRE", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "idAffaire", column = @Column(name = "ID_AFFAIRE", nullable = false, precision = 10, scale = 0))})
	public AfftiersId getId() {
		return this.id;
	}

	public void setId(AfftiersId id) {
		this.id = id;
	}
	
	@Column(name = "DOSSIER", precision = 6, scale = 0)
	public Integer getDossier() {
		return this.dossier;
	}

	public void setDossier(Integer dossier) {
		this.dossier = dossier;
	}

	@Column(name = "CONTRAT", length = 2)
	public String getContrat() {
		return this.contrat;
	}

	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

	@Column(name = "AVENANT", precision = 2, scale = 0)
	public Byte getAvenant() {
		return this.avenant;
	}

	public void setAvenant(Byte avenant) {
		this.avenant = avenant;
	}

	@Column(name = "CODE_RELATION", length = 4)
	public String getCodeRelation() {
		return this.codeRelation;
	}

	public void setCodeRelation(String codeRelation) {
		this.codeRelation = codeRelation;
	}

	@Column(name = "DATE_MODIFICATION", precision = 10, scale = 0)
	public Long getDateModification() {
		return this.dateModification;
	}

	public void setDateModification(Long dateModification) {
		this.dateModification = dateModification;
	}

	@Column(name = "COMMENTAIRE", length = 60)
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Column(name = "TIERS_2", length = 10)
	public String getTiers2() {
		return this.tiers2;
	}

	public void setTiers2(String tiers2) {
		this.tiers2 = tiers2;
	}

	@Column(name = "NO_ADRESSE", precision = 2, scale = 0)
	public Byte getNoAdresse() {
		return this.noAdresse;
	}

	public void setNoAdresse(Byte noAdresse) {
		this.noAdresse = noAdresse;
	}
	
	@Column(name = "CODE_REGLEMENT", length = 4)
	public String getCodeReglement() {
		return this.codeReglement;
	}

	public void setCodeReglement(String codeReglement) {
		this.codeReglement = codeReglement;
	}

	@Column(name = "NO_RIB", precision = 2, scale = 0)
	public Byte getNoRib() {
		return this.noRib;
	}

	public void setNoRib(Byte noRib) {
		this.noRib = noRib;
	}
	
	@Column(name = "DATE_FIN", precision = 10, scale = 0)
	public Long getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Long dateFin) {
		this.dateFin = dateFin;
	}

	@Column(name = "NB_ORIGINAUX_FACTURES", precision = 3, scale = 0)
	public Short getNbOriginauxFactures() {
		return this.nbOriginauxFactures;
	}

	public void setNbOriginauxFactures(Short nbOriginauxFactures) {
		this.nbOriginauxFactures = nbOriginauxFactures;
	}

	@Column(name = "NB_EXEMPLAIRES_EDITES", precision = 3, scale = 0)
	public Short getNbExemplairesEdites() {
		return this.nbExemplairesEdites;
	}

	public void setNbExemplairesEdites(Short nbExemplairesEdites) {
		this.nbExemplairesEdites = nbExemplairesEdites;
	}

	@Column(name = "CODE_TIERS_PRINCIPAL", length = 4)
	public String getCodeTiersPrincipal() {
		return this.codeTiersPrincipal;
	}

	public void setCodeTiersPrincipal(String codeTiersPrincipal) {
		this.codeTiersPrincipal = codeTiersPrincipal;
	}

	@Column(name = "ID_GRPAFFARC", precision = 11, scale = 0)
	public Long getIdGrpaffarc() {
		return this.idGrpaffarc;
	}

	public void setIdGrpaffarc(Long idGrpaffarc) {
		this.idGrpaffarc = idGrpaffarc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avenant == null) ? 0 : avenant.hashCode());
		result = prime * result + ((codeReglement == null) ? 0 : codeReglement.hashCode());
		result = prime * result + ((codeRelation == null) ? 0 : codeRelation.hashCode());
		result = prime * result + ((codeTiersPrincipal == null) ? 0 : codeTiersPrincipal.hashCode());
		result = prime * result + ((commentaire == null) ? 0 : commentaire.hashCode());
		result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((dateModification == null) ? 0 : dateModification.hashCode());
		result = prime * result + ((dossier == null) ? 0 : dossier.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idGrpaffarc == null) ? 0 : idGrpaffarc.hashCode());
		result = prime * result + ((nbExemplairesEdites == null) ? 0 : nbExemplairesEdites.hashCode());
		result = prime * result + ((nbOriginauxFactures == null) ? 0 : nbOriginauxFactures.hashCode());
		result = prime * result + ((noAdresse == null) ? 0 : noAdresse.hashCode());
		result = prime * result + ((noRib == null) ? 0 : noRib.hashCode());
		result = prime * result + ((tiers2 == null) ? 0 : tiers2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Afftiers other = (Afftiers) obj;
		if (avenant == null) {
			if (other.avenant != null)
				return false;
		} else if (!avenant.equals(other.avenant))
			return false;
		if (codeReglement == null) {
			if (other.codeReglement != null)
				return false;
		} else if (!codeReglement.equals(other.codeReglement))
			return false;
		if (codeRelation == null) {
			if (other.codeRelation != null)
				return false;
		} else if (!codeRelation.equals(other.codeRelation))
			return false;
		if (codeTiersPrincipal == null) {
			if (other.codeTiersPrincipal != null)
				return false;
		} else if (!codeTiersPrincipal.equals(other.codeTiersPrincipal))
			return false;
		if (commentaire == null) {
			if (other.commentaire != null)
				return false;
		} else if (!commentaire.equals(other.commentaire))
			return false;
		if (contrat == null) {
			if (other.contrat != null)
				return false;
		} else if (!contrat.equals(other.contrat))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (dateModification == null) {
			if (other.dateModification != null)
				return false;
		} else if (!dateModification.equals(other.dateModification))
			return false;
		if (dossier == null) {
			if (other.dossier != null)
				return false;
		} else if (!dossier.equals(other.dossier))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idGrpaffarc == null) {
			if (other.idGrpaffarc != null)
				return false;
		} else if (!idGrpaffarc.equals(other.idGrpaffarc))
			return false;
		if (nbExemplairesEdites == null) {
			if (other.nbExemplairesEdites != null)
				return false;
		} else if (!nbExemplairesEdites.equals(other.nbExemplairesEdites))
			return false;
		if (nbOriginauxFactures == null) {
			if (other.nbOriginauxFactures != null)
				return false;
		} else if (!nbOriginauxFactures.equals(other.nbOriginauxFactures))
			return false;
		if (noAdresse == null) {
			if (other.noAdresse != null)
				return false;
		} else if (!noAdresse.equals(other.noAdresse))
			return false;
		if (noRib == null) {
			if (other.noRib != null)
				return false;
		} else if (!noRib.equals(other.noRib))
			return false;
		if (tiers2 == null) {
			if (other.tiers2 != null)
				return false;
		} else if (!tiers2.equals(other.tiers2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Afftiers [id=" + id + ", dossier=" + dossier + ", contrat=" + contrat + ", avenant=" + avenant
				+ ", codeRelation=" + codeRelation + ", dateModification=" + dateModification + ", commentaire="
				+ commentaire + ", tiers2=" + tiers2 + ", noAdresse=" + noAdresse + ", codeReglement=" + codeReglement
				+ ", noRib=" + noRib + ", dateFin=" + dateFin + ", nbOriginauxFactures=" + nbOriginauxFactures
				+ ", nbExemplairesEdites=" + nbExemplairesEdites + ", codeTiersPrincipal=" + codeTiersPrincipal
				+ ", idGrpaffarc=" + idGrpaffarc + "]";
	}
}
