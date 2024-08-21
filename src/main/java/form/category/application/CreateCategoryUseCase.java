package form.category.application;


import form.category.domain.entity.Category;
import form.category.domain.service.CategoryService;

public class CreateCategoryUseCase {
    private final CategoryService categoryService;

    public CreateCategoryUseCase(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void execute(Category category) {
        categoryService.CreateCategory(category);
    }
}
