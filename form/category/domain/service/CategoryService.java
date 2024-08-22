package form.category.domain.service;

import form.category.domain.entity.Category;

public interface CategoryService {
    Category FindCategoryById(int id);
    void CreateCategory(Category category);
    void UpdateCategory(Category category);
    void DeleteCategory(int id);
}
