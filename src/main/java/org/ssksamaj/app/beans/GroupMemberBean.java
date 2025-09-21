package org.ssksamaj.app.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GroupMemberBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer authorityGroupId;
	private Integer memberId;
	private LocalDateTime lastUpdated;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAuthorityGroupId() {
		return authorityGroupId;
	}
	public void setAuthorityGroupId(Integer authorityGroupId) {
		this.authorityGroupId = authorityGroupId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
