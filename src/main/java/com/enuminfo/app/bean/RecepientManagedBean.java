/**
 * 
 */
package com.enuminfo.app.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.enuminfo.app.dto.RecepientDTO;
import com.enuminfo.app.file.AppFile;
import com.enuminfo.app.file.impl.CSVFileImpl;
import com.google.gson.Gson;

/**
 * @author Kumar
 */
@ManagedBean (name = "recepientBean", eager = true)
@RequestScoped
public class RecepientManagedBean {

	
	private RecepientDTO recepientItem = new RecepientDTO();
	
	public String loadAll() {
		//System.out.println("RecepientManagedBean.loadAll()");
		Gson recepientsJson = new Gson();
		AppFile appFile = new CSVFileImpl();
		appFile.readFromFile();
		return recepientsJson.toJson(appFile.dtoRecepients);
	}
	
	public void save() {
		AppFile appFile = new CSVFileImpl();
		//appFile.readFromFile();
		appFile.dtoRecepients.add(recepientItem);
		appFile.writeIntoFile();
	}
	
	public String search() {
		List<RecepientDTO> filterRecepientsDTOs = new ArrayList<RecepientDTO>();
		Gson recepientsJson = new Gson();
		AppFile appFile = new CSVFileImpl();
		appFile.readFromFile();
		for (Iterator<RecepientDTO> iterator = appFile.dtoRecepients.iterator(); iterator.hasNext();) {
			RecepientDTO dtoSavedRecepient = iterator.next();
			if (recepientItem.getRecepientId() == dtoSavedRecepient.getRecepientId() || 
					recepientItem.getRecepientName().contains(dtoSavedRecepient.getRecepientName())) {
				filterRecepientsDTOs.add(dtoSavedRecepient);
			}
		}
		//System.out.println("search");
		//return filterRecepientsDTOs;
		return recepientsJson.toJson(filterRecepientsDTOs);
	}

	
	public String searchresult() {
		
		search();
		return null;
	}
	public RecepientDTO getRecepientItem() {
		return recepientItem;
	}

	public void setRecepientItem(RecepientDTO recepientItem) {
		this.recepientItem = recepientItem;
	}
}
