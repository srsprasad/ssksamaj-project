package org.ssksamaj.app.manager;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.beans.UserBean;
import org.ssksamaj.app.persist.dto.UserDTO;
import org.ssksamaj.app.persist.repository.UserRepository;

@Service
public class UserManager {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserBean> fetchAll() {
		List<UserBean> userBeanList = new ArrayList<>();
		userRepository.findAll().forEach(userDTO -> userBeanList.add(convertToBean(userDTO)));
		return userBeanList;
	}
	
	public UserBean find(Integer id) {
		return convertToBean(userRepository.findById(id).get());
	}
	
	public Integer create(UserBean userBean) {
		return userRepository.save(convertToDTO(userBean)).getId();
	}
	
public static UserBean convertToBean(UserDTO userDTO) {
		
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
		userBean.setLastUpdated(userDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return userBean;
}
	
	public static UserDTO convertToDTO(UserBean userBean) {
		
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
		userDTO.setOrganizationDTO(OrganizationManager.convertToDTO(orgBean));
		userDTO.setUpdatedBy(1);
		userDTO.setLastUpdated(OffsetDateTime.now());
		return userDTO;
		
	}
}
