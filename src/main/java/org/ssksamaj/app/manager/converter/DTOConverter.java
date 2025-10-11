package org.ssksamaj.app.manager.converter;


public final class DTOConverter {

	/*
	public static OrganizationBean toOrganisationBean(final OrganizationDTO orgDTO) {
		OrganizationBean orgBean = new OrganizationBean();
		orgBean.setId(orgDTO.getId());
		orgBean.setName(orgDTO.getName());
		orgBean.setLocationName(orgDTO.getLocationName());
		orgBean.setAddress(orgDTO.getAddress());
		orgBean.setDescription(orgDTO.getDescription());
		List<MemberBean> memberBeans = new ArrayList<>();
		orgDTO.getAllMemberDTOs().forEach(memberDTO -> memberBeans.add(toMemberBean(memberDTO)));
		orgBean.setAllMemberBeans(memberBeans);
		orgBean.setLocalDateTime(orgDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return orgBean;
	}

	public static MemberBean toMemberBean(MemberDTO memberDTO) {
		MemberBean memberBean = new MemberBean();
		memberBean.setId(memberDTO.getId());
		memberBean.setGender(memberDTO.getGender());
		memberBean.setSurname(memberDTO.getSurname());
		memberBean.setGivenname(memberDTO.getGivenname());
		memberBean.setGothraname(memberDTO.getGothraname());
		memberBean.setDateOfBirth(memberDTO.getDateOfBirth());
		memberBean.setEmail(memberDTO.getEmail());
		memberBean.setPhone(memberDTO.getPhone());
		memberBean.setAddress(memberDTO.getAddress());
		memberBean.setUsername(memberDTO.getUsername());
		memberBean.setPassword(memberDTO.getPassword());
		memberBean.setEnabled(memberDTO.getEnabled());
		memberBean.setOrganizationId(memberDTO.getOrganizationDTO() != null ? memberDTO.getOrganizationDTO().getId() : null);
		List<GroupMemberBean> grpMbrBean = new ArrayList<>();
		if (memberDTO.getGroupMemberDTOList() != null) {
			memberDTO.getGroupMemberDTOList().forEach(grpMbrDTO -> grpMbrBean.add(toGroupMemberBean(grpMbrDTO)));
		}
		memberBean.setMemberGroups(grpMbrBean);
		memberBean.setLastUpdated(memberDTO.getLastUpdated() != null ? memberDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime() : null);
		return memberBean;
	}
    
	public static AuthorityGroupBean toAuthorityGroupBean(final AuthorityGroupDTO authGrpDTO) {
		AuthorityGroupBean authGrpBean = new AuthorityGroupBean();
		authGrpBean.setId(authGrpDTO.getId());
		authGrpBean.setGroupname(authGrpDTO.getGroupName());
		authGrpBean.setDescription(authGrpDTO.getDescription());
		authGrpBean.setLastUpdated(authGrpDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return authGrpBean;
	}

	public static GroupAuthorityBean toGroupAuthorityBean(GroupAuthorityDTO grpAuthDTO) {
		GroupAuthorityBean grpAuthBean = new GroupAuthorityBean();
		grpAuthBean.setAuthorityGroupId(grpAuthDTO.getAuthorityGroupId().getId());
		grpAuthBean.setAuthorityName(grpAuthDTO.getAuthorityName());
		grpAuthBean.setDescription(grpAuthDTO.getDescription());
		return grpAuthBean;
	}
    
	public static GroupMemberBean toGroupMemberBean(final GroupMemberDTO grpMbrDTO) {
		GroupMemberBean grpMbrBean = new GroupMemberBean();
		grpMbrBean.setId(grpMbrDTO.getId());
		grpMbrBean.setAuthorityGroupId(grpMbrDTO.getAuthorityGroupId().getId());
		grpMbrBean.setMemberId(grpMbrDTO.getMemberId().getId());
		grpMbrBean.setLastUpdated(grpMbrDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return grpMbrBean;
	}
	*/
}
