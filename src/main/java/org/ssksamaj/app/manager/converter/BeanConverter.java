package org.ssksamaj.app.manager.converter;

import java.time.OffsetDateTime;

import org.ssksamaj.app.beans.AuthorityGroupBean;
import org.ssksamaj.app.beans.GroupAuthorityBean;
import org.ssksamaj.app.beans.GroupMemberBean;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.beans.UserBean;
import org.ssksamaj.app.persist.dto.AuthorityGroupDTO;
import org.ssksamaj.app.persist.dto.GroupAuthorityDTO;
import org.ssksamaj.app.persist.dto.GroupMemberDTO;
import org.ssksamaj.app.persist.dto.OrganizationDTO;
import org.ssksamaj.app.persist.dto.UserDTO;

public final class BeanConverter {

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

	public static UserDTO toUserDTO(UserBean userBean) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userBean.getId());
		userDTO.setGender(userBean.getGender());
		userDTO.setSurname(userBean.getSurname());
		userDTO.setGivenname(userBean.getGivenname());
		userDTO.setGothraname(userBean.getGothraname());
		userDTO.setDateOfBirth(userBean.getDateOfBirth());
		userDTO.setEmail(userBean.getEmail());
		userDTO.setPhone(userBean.getPhone());
		userDTO.setAddress(userBean.getAddress());
		userDTO.setUsername(userBean.getUsername());
		userDTO.setPassword(userBean.getPassword());
		userDTO.setEnabled(userBean.getEnabled());
		OrganizationBean orgBean = new OrganizationBean();
		orgBean.setId(userBean.getOrganizationId());
		userDTO.setOrganizationDTO(toOrganisationDTO(orgBean));
		userDTO.setUpdatedBy(1);
		userDTO.setLastUpdated(OffsetDateTime.now());
		return userDTO;
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
		UserDTO usrDTO = new UserDTO();
		authGrpDTO.setId(grpMbrBean.getAuthorityGroupId());
		usrDTO.setId(grpMbrBean.getUserId());
		grpMbrDTO.setAuthorityGroupId(authGrpDTO);
		grpMbrDTO.setUserId(usrDTO);
		grpMbrDTO.setUpdateBy(1);
		grpMbrDTO.setLastUpdated(OffsetDateTime.now());
		return grpMbrDTO;
	}
}
