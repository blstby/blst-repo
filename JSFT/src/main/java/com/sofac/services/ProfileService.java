package com.sofac.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sofac.dao.ProfileDao;
import com.sofac.model.Profile;

public class ProfileService {

	private ProfileDao dao = new ProfileDao();

	public boolean save(Profile profile) {
		return dao.save(profile);
	}

	public boolean update(Profile profile) {
		return dao.update(profile);
	}

	public List<Profile> getExploitable() {
		List<Profile> profiles = dao.getAll();
		List<Profile> ret = new ArrayList<Profile>();
		for (int i = 0; i < profiles.size(); i++) {
			if (profiles.get(i).isExploitable()) {
				ret.add(profiles.get(i));
			}
		}
		return ret;
	}

	public List<Profile> getAll() {
		return dao.getAll();
	}

	public void update(List<Profile> profiles) {
		boolean test = true;
		for (int i = 0; i < profiles.size(); i++) {
			if (!update(profiles.get(i))) {
				test = false;
			}
		}
		if (test) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", "Profiles mis à jour avec succès"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Une erreur s'est produite lors de la mis à jour"));
		}
	}
}
