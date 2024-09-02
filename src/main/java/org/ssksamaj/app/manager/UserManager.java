package org.ssksamaj.app.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.UserBean;
import org.ssksamaj.app.manager.converter.BeanConverter;
import org.ssksamaj.app.manager.converter.DTOConverter;
import org.ssksamaj.app.persist.repository.UserRepository;

@Service
public class UserManager {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserBean> fetchAll() {
		List<UserBean> userBeanList = new ArrayList<>();
		userRepository.findAll().forEach(userDTO -> userBeanList.add(DTOConverter.toUserBean(userDTO)));
		return userBeanList;
	}
	
	public UserBean find(Integer id) {
		return DTOConverter.toUserBean(userRepository.findById(id).get());
	}
	
	public Integer create(UserBean userBean) {
		return userRepository.save(BeanConverter.toUserDTO(userBean)).getId();
	}
}
