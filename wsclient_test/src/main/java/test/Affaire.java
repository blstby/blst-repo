package test;
import javax.xml.bind.annotation.*;

@SuppressWarnings("restriction")
@XmlRootElement(name = "Affaire")
@XmlAccessorType (XmlAccessType.FIELD)
public class Affaire {
	
	@XmlElement(name = "id")
	private int id;
	@XmlElement(name = "code_produit")
	private String code_produit;
	@XmlElement(name = "montant_fin")
	private float montant_fin;
	@XmlElement(name = "id_tier")
	private int id_tier;
	
	public Affaire(){};
	
	public Affaire(int id, String code_produit, float montant_fin, int id_tier) {
		super();
		this.id = id;
		this.code_produit = code_produit;
		this.montant_fin = montant_fin;
		this.id_tier = id_tier;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode_produit() {
		return code_produit;
	}
	public void setCode_produit(String code_produit) {
		this.code_produit = code_produit;
	}
	public float getMontant_fin() {
		return montant_fin;
	}
	public void setMontant_fin(float montant_fin) {
		this.montant_fin = montant_fin;
	}
	public int getId_tier() {
		return id_tier;
	}
	public void setId_tier(int id_tier) {
		this.id_tier = id_tier;
	}

}
