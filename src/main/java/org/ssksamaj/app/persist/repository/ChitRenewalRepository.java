package org.ssksamaj.app.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssksamaj.app.persist.dto.ChitRenewalDTO;

import java.util.List;

@Repository
public interface ChitRenewalRepository extends JpaRepository<ChitRenewalDTO, Long> {
    List<ChitRenewalDTO> findByChitId(Long chitId);
}
