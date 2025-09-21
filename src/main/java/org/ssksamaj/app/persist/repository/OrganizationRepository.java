package org.ssksamaj.app.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssksamaj.app.persist.dto.OrganizationDTO;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationDTO, Long> {
    OrganizationDTO findByName(String name);
}
