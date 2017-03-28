package com.sofac;

import java.util.List;

public class TabService {

	public int returnIndex(int in, List<Tab> tabs){
		int ret = 0;
		for(int i = 0;i<tabs.size()-1;i++){
			for(int j = i+1;j<tabs.size();j++){
				if(tabs.get(i).getIndex()>tabs.get(j).getIndex()){
					Tab tab = new Tab(tabs.get(i).getIndex(),tabs.get(i).getTitle(),tabs.get(i).getContent());
					tabs.set(i, tabs.get(j));
					tabs.set(j, tab);
				}
			}
		}
		for(int i = 0;i<tabs.size();i++){
			if(tabs.get(i).getIndex() == in){
				ret = i;
			}
		}
		return ret;
	}
	
	public Tab getByIndex(int i, List<Tab> tabs){
		for(int j = 0;j<tabs.size();j++){
			if(tabs.get(j).getIndex() == i){
				return new Tab(i,tabs.get(j).getTitle(),tabs.get(j).getContent(),tabs.get(j).isOpen());
			}
		}
		return null;
	}
}
