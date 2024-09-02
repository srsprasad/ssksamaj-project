package org.ssksamaj.app.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.AuthorityGroupBean;
import org.ssksamaj.app.beans.GroupAuthorityBean;
import org.ssksamaj.app.beans.GroupMemberBean;
import org.ssksamaj.app.manager.converter.BeanConverter;
import org.ssksamaj.app.manager.converter.DTOConverter;
import org.ssksamaj.app.persist.GroupAuthorityRepository;
import org.ssksamaj.app.persist.dto.GroupAuthorityDTO;
import org.ssksamaj.app.persist.dto.GroupAuthorityId;
import org.ssksamaj.app.persist.repository.AuthorityGroupRepository;
import org.ssksamaj.app.persist.repository.GroupMemberRepository;

@Service
public class GroupAuthorityMemberAssociationManager {
	
	@Autowired
	private AuthorityGroupRepository authorityGroupRepository;
	
	@Autowired
	private GroupAuthorityRepository groupAuthorityRepository;
	
	@Autowired
	private GroupMemberRepository groupMemberRepository;

	// AUTHORITY GROUP MANAGEMENT
	public List<AuthorityGroupBean> fetchAllGroups() {
		List<AuthorityGroupBean> authGrpBeanList = new ArrayList<>();
		authorityGroupRepository.findAll().forEach(authGrpDTO -> authGrpBeanList.add(DTOConverter.toAuthorityGroupBean(authGrpDTO)));
		return authGrpBeanList;
	}
	
	public AuthorityGroupBean fetchAuthorityGroup(final Integer id) {
		return DTOConverter.toAuthorityGroupBean(authorityGroupRepository.findById(id).get());
	}
	
	public Integer createAuthorityGroup(AuthorityGroupBean authorityGroupBean) {
		return authorityGroupRepository.save(BeanConverter.toAuthorityGroupDTO(authorityGroupBean)).getId();
	}
	
	// GROUP AUTHORITY MANAGEMENT
	public List<GroupAuthorityBean> fetchAllGroupAuthorities() {
		List<GroupAuthorityBean> grpAuthBeanList = new ArrayList<>();
		groupAuthorityRepository.findAll().forEach(grpAuthDTO -> grpAuthBeanList.add(DTOConverter.toGroupAuthorityBean(grpAuthDTO)));
		return grpAuthBeanList;
	}
	
	public GroupAuthorityBean fetchGroupAuthority(final Integer id) {
		GroupAuthorityId grpAuthId = new GroupAuthorityId();
		grpAuthId.setAuthorityGroupId(id);
		return DTOConverter.toGroupAuthorityBean(groupAuthorityRepository.findById(grpAuthId).get());
	}
	
	public Integer createGroupAuthority(GroupAuthorityBean groupAuthorityBean) {
		//AuthorityGroupDTO authGrpDTO = authorityGroupRepository.findById(groupAuthorityBean.getAuthorityGroupId()).get();
		GroupAuthorityDTO grpAuthDTO = BeanConverter.toGroupAuthorityDTO(groupAuthorityBean);
		//grpAuthDTO.setAuthorityGroupId(authGrpDTO);
		return groupAuthorityRepository.save(grpAuthDTO).getAuthorityGroupId().getId();
	}
	
	public Integer createGroupMember(final GroupMemberBean groupMemberBean) {
		return groupMemberRepository.save(BeanConverter.toGroupMemberDTO(groupMemberBean)).getId();
	}
}
