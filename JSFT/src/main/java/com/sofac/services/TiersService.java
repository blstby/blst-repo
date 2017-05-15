package com.sofac.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sofac.dao.TiersDao;
import com.sofac.model.TiersInfo;
import com.sofac.util.Codiff;

public class TiersService {

	private TiersDao dao = new TiersDao();

	public List<TiersInfo> recherche(String code, String cin, String cinN, String rc, String nom) {
		List<TiersInfo> ret = new ArrayList<>();
		if (code == null && cin == null && rc == null && nom == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Veuillez saisir (au moins) un critère "));
		} else {
			if (nom != null)
				nom = nom.replace(" ", "%").toUpperCase();
			if (cin != null) {
				cin = cin.toUpperCase();
				if (cin.length() == 1)
					cin += " ";
				if (cinN != null)
					cin = cin + "-" + cinN;
			}
			ret = dao.recherche(code, cin, rc, nom);
			if (ret == null) {
				ret = new ArrayList<>();
			} else if (ret.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"Aucun résultats ne correspond à votre recherche "));
			}
		}
		return ret;
	}

	public TiersInfo explorer(TiersInfo tiersInfo) {
		return dao.explorer(tiersInfo);
	}

	public String getDateFromJulian(Long date) throws ParseException {
		if (date == null) {
			return "";
		} else {
			Date dt = new SimpleDateFormat("Myydd").parse(date + "");
			return new SimpleDateFormat("dd/MM/yyyy").format(dt);
		}
	}

	public List<Codiff> getCodiff(String type) {
		return dao.getCodiff(type);
	}

	public String getCoddif(List<Codiff> list, String code, String type) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode().equals(code) && list.get(i).getType().equals(type)) {
				return list.get(i).getLibelle();
			}
		}
		return "Lib_corresp_introuv";
	}
}
