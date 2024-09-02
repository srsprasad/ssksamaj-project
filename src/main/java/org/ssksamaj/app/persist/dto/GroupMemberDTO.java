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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROUP_MEMBER")
@Access(AccessType.PROPERTY)
public class GroupMemberDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private AuthorityGroupDTO authorityGroupId;
	private UserDTO userId;
	private Integer updateBy;
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
	
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	public AuthorityGroupDTO getAuthorityGroupId() {
		return authorityGroupId;
	}
	public void setAuthorityGroupId(AuthorityGroupDTO authorityGroupId) {
		this.authorityGroupId = authorityGroupId;
	}
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public UserDTO getUserId() {
		return userId;
	}
	public void setUserId(UserDTO userId) {
		this.userId = userId;
	}
	
	@Column(name = "UPDATED_BY")
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	
	@Column(name = "LAST_UPDATED")
	public OffsetDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(OffsetDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
