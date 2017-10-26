package org.pspf.model.params;

import javax.persistence.Entity;

/**
 * @author Shalitha Mihirnga
 *
 */
@Entity
public class SearchParams {
	
	private String nic;
	private long refNumber;
	private long revisionNumber;
	private long pensionNumber;
	
	public SearchParams() {
		
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public long getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(long refNumber) {
		this.refNumber = refNumber;
	}

	public long getRevisionNumber() {
		return revisionNumber;
	}

	public void setRevisionNumber(long revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	public long getPensionNumber() {
		return pensionNumber;
	}

	public void setPensionNumber(long pensionNumber) {
		this.pensionNumber = pensionNumber;
	}


}
