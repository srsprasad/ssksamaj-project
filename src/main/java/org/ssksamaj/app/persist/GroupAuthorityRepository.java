package org.ssksamaj.app.persist;

import org.springframework.data.repository.CrudRepository;
import org.ssksamaj.app.persist.dto.GroupAuthorityDTO;
import org.ssksamaj.app.persist.dto.GroupAuthorityId;

public interface GroupAuthorityRepository extends CrudRepository<GroupAuthorityDTO, GroupAuthorityId> {

}
