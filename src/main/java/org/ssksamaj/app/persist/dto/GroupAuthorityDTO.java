package org.ssksamaj.app.persist.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROUP_AUTHORITY")
@IdClass(GroupAuthorityId.class)
@Access(AccessType.PROPERTY)
public class GroupAuthorityDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private AuthorityGroupDTO authorityGroupId;
	private String authorityName;
	private String description;
	private Integer updatedBy;
	private OffsetDateTime lastUpdated;
	
	@Id @ManyToOne
	@JoinColumn(name = "GROUP_ID")
	public AuthorityGroupDTO getAuthorityGroupId() {
		return authorityGroupId;
	}
	public void setAuthorityGroupId(AuthorityGroupDTO authorityGroupId) {
		this.authorityGroupId = authorityGroupId;
	}
	
	@Id
	@Column(name = "AUTHORITY_NAME")
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "UPDATED_BY")
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "LAST_UPDATED")
	public OffsetDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(OffsetDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

}
