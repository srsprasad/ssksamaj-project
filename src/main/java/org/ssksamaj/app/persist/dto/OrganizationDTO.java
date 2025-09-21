package org.ssksamaj.app.persist.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORGANIZATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
	private List<MemberDTO> allMemberDTOs;
	
	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitDTO> chits;

}
