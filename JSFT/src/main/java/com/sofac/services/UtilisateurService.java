package com.sofac.services;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sofac.dao.UtilisateurDao;
import com.sofac.model.Utilisateur;

public class UtilisateurService {

	private UtilisateurDao dao = new UtilisateurDao();

	public Utilisateur connect(Utilisateur utilisateur) {
		return dao.find(utilisateur);
	}

	public String check(Utilisateur utilisateur) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (utilisateur.getLogin().equals("") && utilisateur.getMdp().equals("")) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "Login ou Mot de passe incorrect"));
			return null;
		} else if (!utilisateur.isExploitable()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "Cet utilisateur est désactivé"));
			return null;
		} else if (!utilisateur.getProfile().isExploitable()) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Le profile de cet utilisateur est désactivé"));
			return null;
		} else {
			context.getExternalContext().getSessionMap().put("user", utilisateur.getLogin());
			return "/home/home?faces-redirect=true";
		}
	}

	public List<Utilisateur> getAll() {
		return dao.getAll();
	}

	public void update(List<Utilisateur> utilisateurs) {
		boolean test = true;
		for (int i = 0; i < utilisateurs.size(); i++) {
			if (!update(utilisateurs.get(i))) {
				test = false;
			}
		}
		if (test) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", "Utilisateurs mis à jour avec succès"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Une erreur s'est produite lors de la mis à jour"));
		}
	}

	private boolean update(Utilisateur utilisateur) {
		return dao.update(utilisateur);
	}
}
