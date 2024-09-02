package org.ssksamaj.app.persist.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUTH_GROUP")
@Access(AccessType.PROPERTY)
public class AuthorityGroupDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String groupName;
	private String description;
	private Integer updatedBy;
	private OffsetDateTime lastUpdated;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "GROUP_NAME")
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
