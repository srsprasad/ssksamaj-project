package org.ssksamaj.app.persist.repository;

import org.springframework.data.repository.CrudRepository;
import org.ssksamaj.app.persist.dto.OrganizationDTO;

public interface OrganizationRepository extends CrudRepository<OrganizationDTO, Integer> {

}
