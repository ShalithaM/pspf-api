package org.pspf.data.dao;

import org.pspf.data.interfaces.IChequeDAO;

/**
 * @author Shalitha Mihirnga
 *
 */
public class DaoManager {
	
	public static IChequeDAO chequeDao(){
		return new ChequeDao();
	}
}
