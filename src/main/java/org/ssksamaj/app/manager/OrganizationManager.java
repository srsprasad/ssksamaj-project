package org.ssksamaj.app.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.manager.converter.BeanConverter;
import org.ssksamaj.app.manager.converter.DTOConverter;
import org.ssksamaj.app.persist.repository.OrganizationRepository;

@Service
public class OrganizationManager {

	@Autowired
	private OrganizationRepository organizationRepository;

	public List<OrganizationBean> fetchAll() {
		List<OrganizationBean> orgs = new ArrayList<>();
		organizationRepository.findAll().forEach(orgDTO -> orgs.add(DTOConverter.toOrganisationBean(orgDTO)));
		return orgs;

	}

	public OrganizationBean find(Integer id) {
		return DTOConverter.toOrganisationBean(organizationRepository.findById(id).get());
	}

	public Integer create(final OrganizationBean organization) {
		return organizationRepository.save(BeanConverter.toOrganisationDTO(organization)).getId();
	}

}
