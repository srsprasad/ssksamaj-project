package org.ssksamaj.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssksamaj.app.beans.AuthorityGroupBean;
import org.ssksamaj.app.beans.GroupAuthorityBean;
import org.ssksamaj.app.beans.GroupMemberBean;
import org.ssksamaj.app.manager.GroupAuthorityMemberAssociationManager;

@RestController
@RequestMapping("/admin")
public class GroupAuthorityMemberAssociationController {

	@Autowired
	private GroupAuthorityMemberAssociationManager groupAuthorityMemberAssociationManager;
	
	//Group API's
	@GetMapping("/group/all")
	public ResponseEntity<List<AuthorityGroupBean>> getAllAuthorityGroups() {
		return ResponseEntity.ok(groupAuthorityMemberAssociationManager.fetchAllGroups());
	}
	
	@GetMapping("/group/find/{id}")
	public ResponseEntity<List<AuthorityGroupBean>> findAuthorityGroup(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(groupAuthorityMemberAssociationManager.fetchAllGroups());
	}
	
	@PostMapping("/group/create")
	private ResponseEntity<Integer> createAuthorityGroup(@RequestBody AuthorityGroupBean authorityGroupBean) {
		return ResponseEntity.ofNullable(groupAuthorityMemberAssociationManager.createAuthorityGroup(authorityGroupBean));
	}
	
	//Authority API's
	@GetMapping("/authority/all")
	public ResponseEntity<List<GroupAuthorityBean>> getAllGroupAuthorities() {
		return ResponseEntity.ok(groupAuthorityMemberAssociationManager.fetchAllGroupAuthorities());
	}
	@GetMapping("/authority/find/{id}")
	public ResponseEntity<GroupAuthorityBean> findGroupAuthority(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(groupAuthorityMemberAssociationManager.fetchGroupAuthority(id));
	}
	
	@PostMapping("/authority/create")
	private ResponseEntity<Integer> createGroupAuthority(@RequestBody GroupAuthorityBean groupAuthorityBean) {
		return ResponseEntity.ofNullable(groupAuthorityMemberAssociationManager.createGroupAuthority(groupAuthorityBean));
	}
	
	//GroupMember API's
	@PostMapping("/groupMember/create")
	public ResponseEntity<Integer> createGroupMember(@RequestBody GroupMemberBean groupMemberBean) {
		return ResponseEntity.ofNullable(groupAuthorityMemberAssociationManager.createGroupMember(groupMemberBean));
	}
}
