package org.ssksamaj.app.persist.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
@Access(AccessType.PROPERTY)
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String gender;
	private String surname;
	private String givenname;
	private String gothraname;
	private LocalDate dateOfBirth;
	private String email;
	private String phone;
	private String address;
	private String username;
	private String password;
	private String enabled;
	private OrganizationDTO organizationDTO;
	private int updatedBy;
	private OffsetDateTime lastUpdated;
	private Set<GroupMemberDTO> groupMemberDTOList;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "SUR_NAME")
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name = "GVEN_NAME")
	public String getGivenname() {
		return givenname;
	}
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	
	@Column(name = "GOTR_NAME")
	public String getGothraname() {
		return gothraname;
	}
	public void setGothraname(String gothraname) {
		this.gothraname = gothraname;
	}
	
	@Column(name = "DOB")
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "ENABLED")
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	@ManyToOne
	@JoinColumn(name = "ORGN_ID")
	public OrganizationDTO getOrganizationDTO() {
		return organizationDTO;
	}
	public void setOrganizationDTO(OrganizationDTO organizationDTO) {
		this.organizationDTO = organizationDTO;
	}
	
	@Column(name = "UPDATED_BY")
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "LAST_UPDATED")
	public OffsetDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(OffsetDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "USER_ID")
	public Set<GroupMemberDTO> getGroupMemberDTOList() {
		return groupMemberDTOList;
	}
	public void setGroupMemberDTOList(Set<GroupMemberDTO> groupMemberDTOList) {
		this.groupMemberDTOList = groupMemberDTOList;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
