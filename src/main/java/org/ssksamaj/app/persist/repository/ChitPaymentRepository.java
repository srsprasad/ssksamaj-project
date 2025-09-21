package org.ssksamaj.app.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssksamaj.app.persist.dto.ChitPaymentDTO;

import java.util.List;

@Repository
public interface ChitPaymentRepository extends JpaRepository<ChitPaymentDTO, Long> {
    List<ChitPaymentDTO> findByChitAuctionId(Long chitAuctionId);
    List<ChitPaymentDTO> findByChitRenewalMembersId(Long chitRenewalMembersId);
}
