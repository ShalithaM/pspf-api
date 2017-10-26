package org.pspf.model.lists;

import java.util.ArrayList;
import java.util.List;

import org.pspf.model.dto.ChequeModal;


public class ChequeList {

	private List<ChequeModal> cheques = new ArrayList<>();
	
	public ChequeList(){
		
	}

	public List<ChequeModal> getCheques() {
		return cheques;
	}

	public void setCheques(List<ChequeModal> cheques) {
		this.cheques = cheques;
	}
	
	
}