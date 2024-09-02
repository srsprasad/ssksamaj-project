package org.ssksamaj.app.persist.dto;

import java.io.Serializable;

public class GroupAuthorityId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer authorityGroupId;
	private String authorityName;
	
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
	
	

}
