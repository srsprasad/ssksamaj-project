package org.ssksamaj.app.persist.repository;

import org.springframework.data.repository.CrudRepository;
import org.ssksamaj.app.persist.dto.MemberDTO;

public interface MemberRepository extends CrudRepository<MemberDTO, Integer> {

}
