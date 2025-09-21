package org.ssksamaj.app.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssksamaj.app.persist.dto.ChitRenewalMembersDTO;

import java.util.List;

@Repository
public interface ChitRenewalMembersRepository extends JpaRepository<ChitRenewalMembersDTO, Long> {
    List<ChitRenewalMembersDTO> findByChitRenewalId(Long chitRenewalId);
    List<ChitRenewalMembersDTO> findByMemberId(Long memberId);
}
