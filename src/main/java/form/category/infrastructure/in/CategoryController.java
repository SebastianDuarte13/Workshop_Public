package form.category.infrastructure.in;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import form.category.application.CreateCategoryUseCase;
import form.category.domain.entity.Category;
import form.category.domain.service.CategoryService;

public class CategoryController {
    private CreateCategoryUseCase createCategoryUseCase;
    private CategoryService categoryService;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase, CategoryService categoryService) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.categoryService = categoryService;
    }

    public void tabla_category() {
        while (true) {
            String[] options = {"Añadir categoría", "Editar categoría", "Mostrar categoría", "Eliminar categoría", "Salir al menú anterior"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Categorías",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addCategory();
                    break;
                case 1:
                    editCategory();
                    break;
                case 2:
                    searchCategory();
                    break;
                case 3:
                    deleteCategory();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addCategory() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String createdAtString = JOptionPane.showInputDialog("Ingrese fecha de creación (yyyy-MM-dd):");
            String updatedAtString = JOptionPane.showInputDialog("Ingrese fecha de actualización (yyyy-MM-dd):");
            String name = JOptionPane.showInputDialog("Ingrese el nombre:");

            if (createdAtString != null && updatedAtString != null && name != null && !name.trim().isEmpty()) {
                Date createdAt = new Date(sdf.parse(createdAtString).getTime());
                Date updatedAt = new Date(sdf.parse(updatedAtString).getTime());
                Category category = new Category(createdAt, updatedAt, name);
                createCategoryUseCase.execute(category);
                JOptionPane.showMessageDialog(null, "Categoría añadida exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la categoría no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        }
    }

    private void editCategory() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String idString = JOptionPane.showInputDialog("Ingrese el ID de la categoría a editar:");
            int id = Integer.parseInt(idString);
            
            Category category = categoryService.FindCategoryById(id);
            if (category == null) {
                JOptionPane.showMessageDialog(null, "Categoría no encontrada.");
                return;
            }

            String createdAtString = JOptionPane.showInputDialog("Ingrese nueva fecha de creación (yyyy-MM-dd):", category.getCreatedAt().toString());
            String updatedAtString = JOptionPane.showInputDialog("Ingrese nueva fecha de actualización (yyyy-MM-dd):", category.getUpdatedAt().toString());
            String name = JOptionPane.showInputDialog("Ingrese nuevo nombre:", category.getName());

            if (createdAtString != null && updatedAtString != null && name != null && !name.trim().isEmpty()) {
                Date createdAt = new Date(sdf.parse(createdAtString).getTime());
                Date updatedAt = new Date(sdf.parse(updatedAtString).getTime());
                category.setCreatedAt(createdAt);
                category.setUpdatedAt(updatedAt);
                category.setName(name);
                categoryService.UpdateCategory(category);
                JOptionPane.showMessageDialog(null, "Categoría actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la categoría no válidos.");
            }
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados.");
        }
    }

    private void searchCategory() {
        try {
            String idString = JOptionPane.showInputDialog("Ingrese el ID de la categoría a buscar:");
            int id = Integer.parseInt(idString);
            
            Category category = categoryService.FindCategoryById(id);
            if (category != null) {
                JOptionPane.showMessageDialog(null, "Categoría encontrada:\nID: " + category.getId() +
                    "\nFecha de Creación: " + category.getCreatedAt() +
                    "\nFecha de Actualización: " + category.getUpdatedAt() +
                    "\nNombre: " + category.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Categoría no encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }

    private void deleteCategory() {
        try {
            String idString = JOptionPane.showInputDialog("Ingrese el ID de la categoría a eliminar:");
            int id = Integer.parseInt(idString);
            
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar la categoría con ID " + id + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                categoryService.DeleteCategory(id);
                JOptionPane.showMessageDialog(null, "Categoría eliminada exitosamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }
}
