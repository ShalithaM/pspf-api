package org.pspf.model.pojo;

import javax.persistence.Column;

/**
 * @author Shalitha Mihirnga
 *
 */
public class MetaData {
	
	private String from;
	private String type;
	
	@Column(name = "from", length = 400, nullable = false)
	public String getFrom() {
		return from;
	}
	
	@Column(name = "type", length = 400, nullable = false)
	public String getType() {
		return type;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public void setType(String type) {
		this.type = type;
	}

}
