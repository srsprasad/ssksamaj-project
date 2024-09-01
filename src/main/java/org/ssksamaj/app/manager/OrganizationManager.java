package org.ssksamaj.app.manager;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.beans.UserBean;
import org.ssksamaj.app.persist.dto.OrganizationDTO;
import org.ssksamaj.app.persist.repository.OrganizationRepository;

@Service
public class OrganizationManager {

	@Autowired
	private OrganizationRepository organizationRepository;

	public List<OrganizationBean> fetchAll() {
		List<OrganizationBean> orgs = new ArrayList<>();
		organizationRepository.findAll().forEach(orgDTO -> orgs.add(convertToBean(orgDTO)));
		return orgs;

	}

	public OrganizationBean find(Integer id) {
		return convertToBean(organizationRepository.findById(id).get());
	}

	public Integer create(final OrganizationBean organization) {
		return organizationRepository.save(convertToDTO(organization)).getId();
	}

	public static OrganizationDTO convertToDTO(final OrganizationBean orgBean) {
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

	public static OrganizationBean convertToBean(final OrganizationDTO orgDTO) {
		OrganizationBean orgBean = new OrganizationBean();
		orgBean.setId(orgDTO.getId());
		orgBean.setName(orgDTO.getName());
		orgBean.setLocationName(orgDTO.getLocationName());
		orgBean.setAddress(orgDTO.getAddress());
		orgBean.setDescription(orgDTO.getDescription());
		List<UserBean> userBeans = new ArrayList<>();
		orgDTO.getAllUserDTOs().forEach(userDTO -> userBeans.add(UserManager.convertToBean(userDTO)));
		orgBean.setAllUserBeans(userBeans);
		orgBean.setLocalDateTime(orgDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return orgBean;
	}

}
