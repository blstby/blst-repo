package test;

import java.util.List;
import javax.xml.bind.annotation.*;

@SuppressWarnings("restriction")
@XmlRootElement(name = "Affaires")
//@XmlAccessorType (XmlAccessType.FIELD)
public class Affaires {
	
	private List<Affaire> affList;

	@XmlElement(name = "Affaire")
	public List<Affaire> getAffList() {
		return affList;
	}

	public void setAffList(List<Affaire> affList) {
		this.affList = affList;
	}
	
	

}
