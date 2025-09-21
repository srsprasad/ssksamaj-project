package org.ssksamaj.app.persist.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "SUR_NAME")
	private String surname;
	
	@Column(name = "GVEN_NAME")
	private String givenname;
	
	@Column(name = "GOTR_NAME")
	private String gothraname;
	
	@Column(name = "DOB")
	private LocalDate dateOfBirth;
	
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ENABLED")
	private String enabled;
	
	@ManyToOne
	@JoinColumn(name = "ORGN_ID")
	private OrganizationDTO organizationDTO;
	
	@Column(name = "UPDATED_BY")
	private int updatedBy;
	
	@Column(name = "LAST_UPDATED")
	private OffsetDateTime lastUpdated;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "MEMBER_ID")
	private Set<GroupMemberDTO> groupMemberDTOList;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitRenewalMembersDTO> renewalMemberships;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
