package org.ssksamaj.app.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberBean implements Serializable {

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
	private OrganizationBean organizationBean;
	//private List<GroupMemberBean> memberGroups;
	private LocalDate lastUpdated;
	private List<ChitRenewalMembersBean> renewalMemberships;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
