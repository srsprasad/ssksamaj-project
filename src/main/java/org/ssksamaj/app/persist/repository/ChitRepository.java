package org.ssksamaj.app.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssksamaj.app.persist.dto.ChitDTO;

import java.util.List;

@Repository
public interface ChitRepository extends JpaRepository<ChitDTO, Long> {
    List<ChitDTO> findByOrganizationId(Long organizationId);
}
