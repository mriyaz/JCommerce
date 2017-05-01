package com.jcommerce.backend.persistence.repositories;

import com.jcommerce.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Riyazuddin M on 5/1/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
