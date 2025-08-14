package com.sebastianmatallana.ecommerce.backend.infrastructure.adapter;

import com.sebastianmatallana.ecommerce.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity,Integer> {
}
