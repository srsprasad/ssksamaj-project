package org.ssksamaj.app.persist.repository;

import org.springframework.data.repository.CrudRepository;
import org.ssksamaj.app.persist.dto.GroupMemberDTO;

public interface GroupMemberRepository extends CrudRepository<GroupMemberDTO, Integer> {

}
