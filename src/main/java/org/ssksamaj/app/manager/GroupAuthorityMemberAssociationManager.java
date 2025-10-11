package org.ssksamaj.app.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.AuthorityGroupBean;
import org.ssksamaj.app.beans.GroupAuthorityBean;
import org.ssksamaj.app.beans.GroupMemberBean;
import org.ssksamaj.app.persist.dto.GroupAuthorityId;

@Service
public class GroupAuthorityMemberAssociationManager {
	
	// AUTHORITY GROUP MANAGEMENT
	public List<AuthorityGroupBean> fetchAllGroups() {
		List<AuthorityGroupBean> authGrpBeanList = new ArrayList<>();
		//authorityGroupRepository.findAll().forEach(authGrpDTO -> authGrpBeanList.add(DTOConverter.toAuthorityGroupBean(authGrpDTO)));
		return null; //authGrpBeanList;
	}
	
	public AuthorityGroupBean fetchAuthorityGroup(final Integer id) {
		return null; //DTOConverter.toAuthorityGroupBean(authorityGroupRepository.findById(id).get());
	}
	
	public Integer createAuthorityGroup(AuthorityGroupBean authorityGroupBean) {
		return null; //authorityGroupRepository.save(BeanConverter.toAuthorityGroupDTO(authorityGroupBean)).getId();
	}
	
	// GROUP AUTHORITY MANAGEMENT
	public List<GroupAuthorityBean> fetchAllGroupAuthorities() {
		List<GroupAuthorityBean> grpAuthBeanList = new ArrayList<>();
		//groupAuthorityRepository.findAll().forEach(grpAuthDTO -> grpAuthBeanList.add(DTOConverter.toGroupAuthorityBean(grpAuthDTO)));
		return grpAuthBeanList;
	}
	
	public GroupAuthorityBean fetchGroupAuthority(final Integer id) {
		GroupAuthorityId grpAuthId = new GroupAuthorityId();
		grpAuthId.setAuthorityGroupId(id);
		return null; //DTOConverter.toGroupAuthorityBean(groupAuthorityRepository.findById(grpAuthId).get());
	}
	
	public Integer createGroupAuthority(GroupAuthorityBean groupAuthorityBean) {
		//AuthorityGroupDTO authGrpDTO = authorityGroupRepository.findById(groupAuthorityBean.getAuthorityGroupId()).get();
		//GroupAuthorityDTO grpAuthDTO = BeanConverter.toGroupAuthorityDTO(groupAuthorityBean);
		//grpAuthDTO.setAuthorityGroupId(authGrpDTO);
		return null; //groupAuthorityRepository.save(grpAuthDTO).getAuthorityGroupId().getId();
	}
	
	public Integer createGroupMember(final GroupMemberBean groupMemberBean) {
		return null; //groupMemberRepository.save(BeanConverter.toGroupMemberDTO(groupMemberBean)).getId();
	}
}
