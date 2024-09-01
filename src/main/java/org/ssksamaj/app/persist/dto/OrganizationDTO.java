package org.ssksamaj.app.persist.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ORGANIZATION")
public class OrganizationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="TITLE")
	private String name;
	@Column(name="LOCATION_NAME")
	private String locationName;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="UPDATED_BY")
	private int updatedBy;
	@Column(name="LAST_UPDATED")
	private OffsetDateTime lastUpdated;
	@OneToMany
	@JoinColumn(name = "ORGN_ID")
	private List<UserDTO> allUserDTOs;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public OffsetDateTime getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(OffsetDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	public List<UserDTO> getAllUserDTOs() {
		return this.allUserDTOs;
	}

}
