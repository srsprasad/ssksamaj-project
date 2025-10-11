package org.ssksamaj.app.manager.converter;

import java.time.OffsetDateTime;

import org.ssksamaj.app.beans.AuthorityGroupBean;
import org.ssksamaj.app.beans.GroupAuthorityBean;
import org.ssksamaj.app.beans.GroupMemberBean;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.beans.MemberBean;
import org.ssksamaj.app.persist.dto.AuthorityGroupDTO;
import org.ssksamaj.app.persist.dto.GroupAuthorityDTO;
import org.ssksamaj.app.persist.dto.GroupMemberDTO;
import org.ssksamaj.app.persist.dto.OrganizationDTO;
import org.ssksamaj.app.persist.dto.MemberDTO;

public final class BeanConverter {/* 

	public static OrganizationDTO toOrganisationDTO(final OrganizationBean orgBean) {
		OrganizationDTO orgDTO = new OrganizationDTO();
		orgDTO.setId(orgBean.getId());
		orgDTO.setName(orgBean.getName());
		orgDTO.setDescription(orgBean.getDescription());
		orgDTO.setLocationName(orgBean.getLocationName());
		orgDTO.setAddress(orgBean.getAddress());
		orgDTO.setUpdatedBy(1);
		orgDTO.setLastUpdated(OffsetDateTime.now());
		return orgDTO;
	}

	public static MemberDTO toMemberDTO(MemberBean memberBean) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(memberBean.getId());
		memberDTO.setGender(memberBean.getGender());
		memberDTO.setSurname(memberBean.getSurname());
		memberDTO.setGivenname(memberBean.getGivenname());
		memberDTO.setGothraname(memberBean.getGothraname());
		memberDTO.setDateOfBirth(memberBean.getDateOfBirth());
		memberDTO.setEmail(memberBean.getEmail());
		memberDTO.setPhone(memberBean.getPhone());
		memberDTO.setAddress(memberBean.getAddress());
		memberDTO.setUsername(memberBean.getUsername());
		memberDTO.setPassword(memberBean.getPassword());
		memberDTO.setEnabled(memberBean.getEnabled());
		OrganizationBean orgBean = new OrganizationBean();
		orgBean.setId(memberBean.getOrganizationId());
		memberDTO.setOrganizationDTO(toOrganisationDTO(orgBean));
		memberDTO.setUpdatedBy(1);
		memberDTO.setLastUpdated(OffsetDateTime.now());
		return memberDTO;
	}
	
	public static AuthorityGroupDTO toAuthorityGroupDTO(final AuthorityGroupBean authGrpBean) {
		AuthorityGroupDTO authGrpDTO = new AuthorityGroupDTO();
		authGrpDTO.setId(authGrpBean.getId());
		authGrpDTO.setGroupName(authGrpBean.getGroupname());
		authGrpDTO.setDescription(authGrpBean.getDescription());
		authGrpDTO.setUpdatedBy(1);
		authGrpDTO.setLastUpdated(OffsetDateTime.now());
		return authGrpDTO;
	}
	
	public static GroupAuthorityDTO toGroupAuthorityDTO(final GroupAuthorityBean grpAuthBean) {
		GroupAuthorityDTO grpAuthDTO = new GroupAuthorityDTO();
		AuthorityGroupDTO authGrpDTO = new AuthorityGroupDTO();
		authGrpDTO.setId(grpAuthBean.getAuthorityGroupId());
		grpAuthDTO.setAuthorityGroupId(authGrpDTO);
		grpAuthDTO.setAuthorityName(grpAuthBean.getAuthorityName());
		grpAuthDTO.setDescription(grpAuthBean.getDescription());
		grpAuthDTO.setUpdatedBy(1);
		grpAuthDTO.setLastUpdated(OffsetDateTime.now());
		return grpAuthDTO;
	}
	
	public static GroupMemberDTO toGroupMemberDTO(final GroupMemberBean grpMbrBean) {
		GroupMemberDTO grpMbrDTO = new GroupMemberDTO();
		AuthorityGroupDTO authGrpDTO = new AuthorityGroupDTO();
	MemberDTO usrDTO = new MemberDTO();
		authGrpDTO.setId(grpMbrBean.getAuthorityGroupId());
		usrDTO.setId(grpMbrBean.getMemberId());
		grpMbrDTO.setAuthorityGroupId(authGrpDTO);
		grpMbrDTO.setMemberId(usrDTO);
		grpMbrDTO.setUpdateBy(1);
		grpMbrDTO.setLastUpdated(OffsetDateTime.now());
		return grpMbrDTO;
	}*/
}
