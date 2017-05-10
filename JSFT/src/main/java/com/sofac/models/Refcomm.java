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
 * Refcomm generated by hbm2java
 */
@Entity
@Table(name = "REFCOMM", schema = "OPS$INGENETUDES", uniqueConstraints = @UniqueConstraint(columnNames = "ID_REFCOMM"))
public class Refcomm implements java.io.Serializable {

	private RefcommId id;
	private Byte noAdresse;
	private String representant;
	private String telephone;
	private String telex;
	private String fax;
	private String EMail;
	private String prenom;
	private String nom;
	private String initiale;
	private String preposition;
	private String codeSuffixe;
	private String codeQualite;
	private String codeTypeTiers;
	private String codeAutorisation;
	private String flagApproch;
	private String flagEnvra;
	private String flagEnvcn;
	private String flagEnvagenda;
	private String flagUndef1;
	private String flagUndef2;
	private Long dateNaissance;
	private String codeLangueTravail;
	private String telPortable;
	private Long idGroupeSgt;

	public Refcomm() {
	}

	public Refcomm(RefcommId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idRefcomm", column = @Column(name = "ID_REFCOMM", unique = true, nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "tiers", column = @Column(name = "TIERS", nullable = false, length = 10)),
			@AttributeOverride(name = "codeReference", column = @Column(name = "CODE_REFERENCE", nullable = false, length = 4))})
	public RefcommId getId() {
		return this.id;
	}

	public void setId(RefcommId id) {
		this.id = id;
	}
	
	@Column(name = "NO_ADRESSE", precision = 2, scale = 0)
	public Byte getNoAdresse() {
		return this.noAdresse;
	}

	public void setNoAdresse(Byte noAdresse) {
		this.noAdresse = noAdresse;
	}

	@Column(name = "REPRESENTANT")
	public String getRepresentant() {
		return this.representant;
	}

	public void setRepresentant(String representant) {
		this.representant = representant;
	}

	@Column(name = "TELEPHONE", length = 30)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "TELEX", length = 30)
	public String getTelex() {
		return this.telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	@Column(name = "FAX", length = 30)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "E_MAIL", length = 80)
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	@Column(name = "PRENOM")
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "NOM")
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "INITIALE", length = 10)
	public String getInitiale() {
		return this.initiale;
	}

	public void setInitiale(String initiale) {
		this.initiale = initiale;
	}

	@Column(name = "PREPOSITION", length = 10)
	public String getPreposition() {
		return this.preposition;
	}

	public void setPreposition(String preposition) {
		this.preposition = preposition;
	}

	@Column(name = "CODE_SUFFIXE", length = 4)
	public String getCodeSuffixe() {
		return this.codeSuffixe;
	}

	public void setCodeSuffixe(String codeSuffixe) {
		this.codeSuffixe = codeSuffixe;
	}

	@Column(name = "CODE_QUALITE", length = 4)
	public String getCodeQualite() {
		return this.codeQualite;
	}

	public void setCodeQualite(String codeQualite) {
		this.codeQualite = codeQualite;
	}

	@Column(name = "CODE_TYPE_TIERS", length = 4)
	public String getCodeTypeTiers() {
		return this.codeTypeTiers;
	}

	public void setCodeTypeTiers(String codeTypeTiers) {
		this.codeTypeTiers = codeTypeTiers;
	}

	@Column(name = "CODE_AUTORISATION", length = 4)
	public String getCodeAutorisation() {
		return this.codeAutorisation;
	}

	public void setCodeAutorisation(String codeAutorisation) {
		this.codeAutorisation = codeAutorisation;
	}

	@Column(name = "FLAG_APPROCH", length = 1)
	public String getFlagApproch() {
		return this.flagApproch;
	}

	public void setFlagApproch(String flagApproch) {
		this.flagApproch = flagApproch;
	}

	@Column(name = "FLAG_ENVRA", length = 1)
	public String getFlagEnvra() {
		return this.flagEnvra;
	}

	public void setFlagEnvra(String flagEnvra) {
		this.flagEnvra = flagEnvra;
	}

	@Column(name = "FLAG_ENVCN", length = 1)
	public String getFlagEnvcn() {
		return this.flagEnvcn;
	}

	public void setFlagEnvcn(String flagEnvcn) {
		this.flagEnvcn = flagEnvcn;
	}

	@Column(name = "FLAG_ENVAGENDA", length = 1)
	public String getFlagEnvagenda() {
		return this.flagEnvagenda;
	}

	public void setFlagEnvagenda(String flagEnvagenda) {
		this.flagEnvagenda = flagEnvagenda;
	}

	@Column(name = "FLAG_UNDEF1", length = 1)
	public String getFlagUndef1() {
		return this.flagUndef1;
	}

	public void setFlagUndef1(String flagUndef1) {
		this.flagUndef1 = flagUndef1;
	}

	@Column(name = "FLAG_UNDEF2", length = 1)
	public String getFlagUndef2() {
		return this.flagUndef2;
	}

	public void setFlagUndef2(String flagUndef2) {
		this.flagUndef2 = flagUndef2;
	}

	@Column(name = "DATE_NAISSANCE", precision = 10, scale = 0)
	public Long getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Long dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "CODE_LANGUE_TRAVAIL", length = 4)
	public String getCodeLangueTravail() {
		return this.codeLangueTravail;
	}

	public void setCodeLangueTravail(String codeLangueTravail) {
		this.codeLangueTravail = codeLangueTravail;
	}

	@Column(name = "TEL_PORTABLE", length = 30)
	public String getTelPortable() {
		return this.telPortable;
	}

	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}

	@Column(name = "ID_GROUPE_SGT", precision = 10, scale = 0)
	public Long getIdGroupeSgt() {
		return this.idGroupeSgt;
	}

	public void setIdGroupeSgt(Long idGroupeSgt) {
		this.idGroupeSgt = idGroupeSgt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EMail == null) ? 0 : EMail.hashCode());
		result = prime * result + ((codeAutorisation == null) ? 0 : codeAutorisation.hashCode());
		result = prime * result + ((codeLangueTravail == null) ? 0 : codeLangueTravail.hashCode());
		result = prime * result + ((codeQualite == null) ? 0 : codeQualite.hashCode());
		result = prime * result + ((codeSuffixe == null) ? 0 : codeSuffixe.hashCode());
		result = prime * result + ((codeTypeTiers == null) ? 0 : codeTypeTiers.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((flagApproch == null) ? 0 : flagApproch.hashCode());
		result = prime * result + ((flagEnvagenda == null) ? 0 : flagEnvagenda.hashCode());
		result = prime * result + ((flagEnvcn == null) ? 0 : flagEnvcn.hashCode());
		result = prime * result + ((flagEnvra == null) ? 0 : flagEnvra.hashCode());
		result = prime * result + ((flagUndef1 == null) ? 0 : flagUndef1.hashCode());
		result = prime * result + ((flagUndef2 == null) ? 0 : flagUndef2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idGroupeSgt == null) ? 0 : idGroupeSgt.hashCode());
		result = prime * result + ((initiale == null) ? 0 : initiale.hashCode());
		result = prime * result + ((noAdresse == null) ? 0 : noAdresse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((preposition == null) ? 0 : preposition.hashCode());
		result = prime * result + ((representant == null) ? 0 : representant.hashCode());
		result = prime * result + ((telPortable == null) ? 0 : telPortable.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((telex == null) ? 0 : telex.hashCode());
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
		Refcomm other = (Refcomm) obj;
		if (EMail == null) {
			if (other.EMail != null)
				return false;
		} else if (!EMail.equals(other.EMail))
			return false;
		if (codeAutorisation == null) {
			if (other.codeAutorisation != null)
				return false;
		} else if (!codeAutorisation.equals(other.codeAutorisation))
			return false;
		if (codeLangueTravail == null) {
			if (other.codeLangueTravail != null)
				return false;
		} else if (!codeLangueTravail.equals(other.codeLangueTravail))
			return false;
		if (codeQualite == null) {
			if (other.codeQualite != null)
				return false;
		} else if (!codeQualite.equals(other.codeQualite))
			return false;
		if (codeSuffixe == null) {
			if (other.codeSuffixe != null)
				return false;
		} else if (!codeSuffixe.equals(other.codeSuffixe))
			return false;
		if (codeTypeTiers == null) {
			if (other.codeTypeTiers != null)
				return false;
		} else if (!codeTypeTiers.equals(other.codeTypeTiers))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (flagApproch == null) {
			if (other.flagApproch != null)
				return false;
		} else if (!flagApproch.equals(other.flagApproch))
			return false;
		if (flagEnvagenda == null) {
			if (other.flagEnvagenda != null)
				return false;
		} else if (!flagEnvagenda.equals(other.flagEnvagenda))
			return false;
		if (flagEnvcn == null) {
			if (other.flagEnvcn != null)
				return false;
		} else if (!flagEnvcn.equals(other.flagEnvcn))
			return false;
		if (flagEnvra == null) {
			if (other.flagEnvra != null)
				return false;
		} else if (!flagEnvra.equals(other.flagEnvra))
			return false;
		if (flagUndef1 == null) {
			if (other.flagUndef1 != null)
				return false;
		} else if (!flagUndef1.equals(other.flagUndef1))
			return false;
		if (flagUndef2 == null) {
			if (other.flagUndef2 != null)
				return false;
		} else if (!flagUndef2.equals(other.flagUndef2))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idGroupeSgt == null) {
			if (other.idGroupeSgt != null)
				return false;
		} else if (!idGroupeSgt.equals(other.idGroupeSgt))
			return false;
		if (initiale == null) {
			if (other.initiale != null)
				return false;
		} else if (!initiale.equals(other.initiale))
			return false;
		if (noAdresse == null) {
			if (other.noAdresse != null)
				return false;
		} else if (!noAdresse.equals(other.noAdresse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (preposition == null) {
			if (other.preposition != null)
				return false;
		} else if (!preposition.equals(other.preposition))
			return false;
		if (representant == null) {
			if (other.representant != null)
				return false;
		} else if (!representant.equals(other.representant))
			return false;
		if (telPortable == null) {
			if (other.telPortable != null)
				return false;
		} else if (!telPortable.equals(other.telPortable))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (telex == null) {
			if (other.telex != null)
				return false;
		} else if (!telex.equals(other.telex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Refcomm [id=" + id + ", noAdresse=" + noAdresse + ", representant=" + representant + ", telephone="
				+ telephone + ", telex=" + telex + ", fax=" + fax + ", EMail=" + EMail + ", prenom=" + prenom + ", nom="
				+ nom + ", initiale=" + initiale + ", preposition=" + preposition + ", codeSuffixe=" + codeSuffixe
				+ ", codeQualite=" + codeQualite + ", codeTypeTiers=" + codeTypeTiers + ", codeAutorisation="
				+ codeAutorisation + ", flagApproch=" + flagApproch + ", flagEnvra=" + flagEnvra + ", flagEnvcn="
				+ flagEnvcn + ", flagEnvagenda=" + flagEnvagenda + ", flagUndef1=" + flagUndef1 + ", flagUndef2="
				+ flagUndef2 + ", dateNaissance=" + dateNaissance + ", codeLangueTravail=" + codeLangueTravail
				+ ", telPortable=" + telPortable + ", idGroupeSgt=" + idGroupeSgt + "]";
	}
}
