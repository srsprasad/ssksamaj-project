package org.ssksamaj.app.manager;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.Organization;
import org.ssksamaj.app.persist.dto.OrganizationDTO;
import org.ssksamaj.app.persist.repository.OrganizationRepository;

@Service
public class OrganizationManager {

	@Autowired
	private OrganizationRepository organizationRepository;

	public List<Organization> fetchAll() {
		List<Organization> orgs = new ArrayList<>();
		organizationRepository.findAll().forEach(orgDTO -> orgs.add(convertToBean(orgDTO)));
		return orgs;

	}

	public Organization find(Integer id) {
		return convertToBean(organizationRepository.findById(id).get());
	}

	public Integer create(final Organization organization) {
		return organizationRepository.save(convertToDTO(organization)).getId();
	}

	private OrganizationDTO convertToDTO(final Organization orgBean) {
		OrganizationDTO orgDTO = new OrganizationDTO();
		orgDTO.setName(orgBean.getName());
		orgDTO.setDescription(orgBean.getDescription());
		orgDTO.setLocationName(orgBean.getLocationName());
		orgDTO.setAddress(orgBean.getAddress());
		orgDTO.setUpdatedBy(1);
		orgDTO.setLastUpdated(OffsetDateTime.now());
		return orgDTO;
	}

	private Organization convertToBean(final OrganizationDTO orgDTO) {
		Organization orgBean = new Organization();
		orgBean.setId(orgDTO.getId());
		orgBean.setName(orgDTO.getName());
		orgBean.setLocationName(orgDTO.getLocationName());
		orgBean.setAddress(orgDTO.getAddress());
		orgBean.setDescription(orgDTO.getDescription());
		orgBean.setLocalDateTime(orgDTO.getLastUpdated().atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
		return orgBean;
	}

}
