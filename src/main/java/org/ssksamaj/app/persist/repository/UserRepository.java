package org.ssksamaj.app.persist.repository;

import org.springframework.data.repository.CrudRepository;
import org.ssksamaj.app.persist.dto.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, Integer> {

}
