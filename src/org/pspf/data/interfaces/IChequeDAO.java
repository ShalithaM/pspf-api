package org.pspf.data.interfaces;

import java.util.List;

import org.pspf.model.dto.ChequeModal;

/**
 * @author Shalitha Mihirnga
 *
 */
public interface IChequeDAO {
	
	
	/**
	 * get all cheque details
	 * @return
	 */
	List<ChequeModal> getChequeList();
	
	/**
	 * get list by state
	 * @return
	 */
	List<ChequeModal> getChequeListByState(int state);
	
	/**
	 * get reject cheque details
	 * @return
	 */
	List<ChequeModal> getRejectChequeList();
	


	

}