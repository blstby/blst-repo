package com.sofac.services;

import java.util.List;

import com.sofac.dao.TieidenDao;
import com.sofac.models.Tieiden;
import com.sofac.util.Codiff;

public class TieidenService {

	private TieidenDao dao = new TieidenDao();
	
	
	public Tieiden getCIN(List<Tieiden> lst){
		for(int i = 0; i < lst.size(); i++){
			if(lst.get(i).getCodePieceIden().equals("BI")){
				return lst.get(i);
			}
		}
		return null;
	}
	
	public List<Codiff> getPiece(){
		return dao.getPiece();
	}
	
	public String getLibId(List<Codiff> list, String code){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getCode().equals(code) && list.get(i).getType().equals("PIDN")){
				return list.get(i).getLibelle();
			}
		}
		return "Lib_corresp_introuv";
	}
}
