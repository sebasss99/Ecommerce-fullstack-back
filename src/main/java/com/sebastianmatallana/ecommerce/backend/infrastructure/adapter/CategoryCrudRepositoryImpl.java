package com.sebastianmatallana.ecommerce.backend.infrastructure.adapter;

import com.sebastianmatallana.ecommerce.backend.domain.model.Category;
import com.sebastianmatallana.ecommerce.backend.domain.port.ICategoryRepository;
import com.sebastianmatallana.ecommerce.backend.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {

    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory(iCategoryCrudRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategoryList(iCategoryCrudRepository.findAll());
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(
                iCategoryCrudRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + id))
        );
    }

    @Override
    public void deleteById(Integer id) {
        iCategoryCrudRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + id));
        iCategoryCrudRepository.deleteById(id);
    }
}
