package org.ssksamaj.app.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.MemberBean;
import org.ssksamaj.app.manager.converter.BeanConverter;
import org.ssksamaj.app.manager.converter.DTOConverter;
import org.ssksamaj.app.persist.repository.MemberRepository;

@Service
public class MemberManager {

	@Autowired
	private MemberRepository memberRepository;
	
	public List<MemberBean> fetchAll() {
		List<MemberBean> memberBeanList = new ArrayList<>();
		memberRepository.findAll().forEach(memberDTO -> memberBeanList.add(DTOConverter.toMemberBean(memberDTO)));
		return memberBeanList;
	}
	
	public MemberBean find(Integer id) {
		return DTOConverter.toMemberBean(memberRepository.findById(id).get());
	}
	
	public Integer create(MemberBean memberBean) {
		return memberRepository.save(BeanConverter.toMemberDTO(memberBean)).getId();
	}
}
