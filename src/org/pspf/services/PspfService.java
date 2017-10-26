package org.pspf.services;


import java.util.List;

import org.pspf.exceptions.DataNotFoundException;
import org.pspf.data.dao.DaoManager;
import org.pspf.data.interfaces.IChequeDAO;
import org.pspf.model.dto.ChequeModal;
import org.pspf.model.lists.ChequeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shalitha Mihirnga
 *
 */
public class PspfService {
	
	private Logger logger = LoggerFactory.getLogger(PspfService.class);
	
	public ChequeList getAllList(){
		logger.info(" all cheque service executed ");
		
		IChequeDAO dao = DaoManager.chequeDao();
		List<ChequeModal> cheques = dao.getChequeList();
		if(cheques.isEmpty()){
			logger.info(" cheques are empty ");
			throw new DataNotFoundException("No cheques found");
		}
		ChequeList list = new ChequeList();
		cheques.stream().forEach(cheque -> {
			ChequeModal dto = new ChequeModal();
			dto.setId(cheque.getId());
			dto.setAmount(cheque.getAmount());
			dto.setBranch(cheque.getBranch());
			dto.setChequeDate(cheque.getChequeDate());
			dto.setChequeNumber(cheque.getChequeNumber());
			dto.setInstitute(cheque.getInstitute());
			
			list.getCheques().add(dto);
		});
		
		return list;
	}
	
	public ChequeList getAllListByState(String stateType){
		logger.info(" all cheque service executed ");
		int state = 0;
		if(stateType == "pending"){
			state = 100;
		}
		else if(stateType == "received"){
			state = 200;
		}
		else if(stateType == "toBank"){
			state = 300;
		}
		else if(stateType == "realized"){
			state = 400;
		}
		else if(stateType == "complete"){
			state = 500;
		}
		else if(stateType == "verified"){
			state = 600;
		}
		
		IChequeDAO dao = DaoManager.chequeDao();
		List<ChequeModal> cheques = dao.getChequeListByState(state);
		if(cheques.isEmpty()){
			logger.info(" cheques are empty ");
			throw new DataNotFoundException("No cheques found");
		}
		ChequeList list = new ChequeList();
		cheques.stream().forEach(cheque -> {
			ChequeModal dto = new ChequeModal();
			dto.setId(cheque.getId());
			dto.setAmount(cheque.getAmount());
			dto.setBranch(cheque.getBranch());
			dto.setChequeDate(cheque.getChequeDate());
			dto.setChequeNumber(cheque.getChequeNumber());
			dto.setInstitute(cheque.getInstitute());
			
			list.getCheques().add(dto);
		});
		
		return list;
	}
	
	public ChequeList getRejectList(){
		logger.info(" all cheque service executed ");
		
		IChequeDAO dao = DaoManager.chequeDao();
		List<ChequeModal> cheques = dao.getRejectChequeList();
		if(cheques.isEmpty()){
			logger.info(" cheques are empty ");
			throw new DataNotFoundException("No cheques found");
		}
		ChequeList list = new ChequeList();
		cheques.stream().forEach(cheque -> {
			ChequeModal dto = new ChequeModal();
			dto.setId(cheque.getId());
			dto.setAmount(cheque.getAmount());
			dto.setBranch(cheque.getBranch());
			dto.setChequeDate(cheque.getChequeDate());
			dto.setChequeNumber(cheque.getChequeNumber());
			dto.setInstitute(cheque.getInstitute());
			
			list.getCheques().add(dto);
		});
		
		return list;
	}

}
