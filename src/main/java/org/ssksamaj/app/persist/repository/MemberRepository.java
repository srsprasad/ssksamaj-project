package org.ssksamaj.app.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssksamaj.app.persist.dto.MemberDTO;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, Long> {
    MemberDTO findByName(String name);
}
