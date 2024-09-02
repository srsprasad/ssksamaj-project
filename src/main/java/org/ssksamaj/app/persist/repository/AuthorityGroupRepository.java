package org.ssksamaj.app.persist.repository;

import org.springframework.data.repository.CrudRepository;
import org.ssksamaj.app.persist.dto.AuthorityGroupDTO;

public interface AuthorityGroupRepository extends CrudRepository<AuthorityGroupDTO, Integer> {

}
