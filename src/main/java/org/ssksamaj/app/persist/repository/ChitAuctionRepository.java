package org.ssksamaj.app.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssksamaj.app.persist.dto.ChitAuctionDTO;

import java.util.List;

@Repository
public interface ChitAuctionRepository extends JpaRepository<ChitAuctionDTO, Long> {
    List<ChitAuctionDTO> findByChitRenewalId(Long chitRenewalId);
    //List<ChitAuctionDTO> findByChitRenewalMemberId(Long chitRenewalMembersId);
}
