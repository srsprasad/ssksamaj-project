package org.ssksamaj.app.beans;

import java.io.Serializable;

public class GroupAuthorityBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer authorityGroupId;
	private String authorityName;
	private String description;
	
	public Integer getAuthorityGroupId() {
		return authorityGroupId;
	}
	public void setAuthorityGroupId(Integer authorityGroupId) {
		this.authorityGroupId = authorityGroupId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
