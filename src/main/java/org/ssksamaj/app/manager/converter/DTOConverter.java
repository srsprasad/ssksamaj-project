package org.ssksamaj.app.manager.converter;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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

public final class DTOConverter {

	public static OrganizationBean toOrganisationBean(final OrganizationDTO orgDTO) {
		OrganizationBean orgBean = new OrganizationBean();
		orgBean.setId(orgDTO.getId());
		orgBean.setName(orgDTO.getName());
		orgBean.setLocationName(orgDTO.getLocationName());
		orgBean.setAddress(orgDTO.getAddress());
		orgBean.setDescription(orgDTO.getDescription());
		List<UserBean> userBeans = new ArrayList<>();
		orgDTO.getAllUserDTOs().forEach(userDTO -> userBeans.add(toUserBean(userDTO)));
		orgBean.setAllUserBeans(userBeans);
		orgBean.setLocalDateTime(orgDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return orgBean;
	}
	
	public static UserBean toUserBean(UserDTO userDTO) {
			
			UserBean userBean = new UserBean();
			
			userBean.setId(userDTO.getId());
			userBean.setGender(userDTO.getGender());
			userBean.setSurname(userDTO.getSurname());
			userBean.setGivenname(userDTO.getGivenname());
			userBean.setGothraname(userDTO.getGothraname());
			userBean.setDateOfBirth(userDTO.getDateOfBirth());
			userBean.setEmail(userDTO.getEmail());
			userBean.setPhone(userDTO.getPhone());
			userBean.setAddress(userDTO.getAddress());
			userBean.setUsername(userDTO.getUsername());
			userBean.setPassword(userDTO.getPassword());
			userBean.setEnabled(userDTO.getEnabled());
			userBean.setOrganizationId(userDTO.getOrganizationDTO().getId());
			List<GroupMemberBean> grpMbrBean = new ArrayList<>();
			userDTO.getGroupMemberDTOList().forEach(grpMbrDTO -> grpMbrBean.add(toGroupMemberBean(grpMbrDTO)));
			userBean.setMemberGroups(grpMbrBean);
			userBean.setLastUpdated(userDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
			return userBean;
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
		grpMbrBean.setUserId(grpMbrDTO.getUserId().getId());
		grpMbrBean.setLastUpdated(grpMbrDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return grpMbrBean;
	}
}
