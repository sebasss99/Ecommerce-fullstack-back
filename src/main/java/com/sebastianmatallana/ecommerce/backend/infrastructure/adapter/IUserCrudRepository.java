package com.sebastianmatallana.ecommerce.backend.infrastructure.adapter;

import com.sebastianmatallana.ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer> {

}
