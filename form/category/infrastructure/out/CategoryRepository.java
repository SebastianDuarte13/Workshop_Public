package form.category.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import form.category.domain.entity.Category;
import form.category.domain.service.CategoryService;
import form.infrastructure.config.DatabaseConfig;

public class CategoryRepository implements CategoryService {

    @Override
    public Category FindCategoryById(int id) {
        String sql = "SELECT id, created_at, updated_at, name FROM category_catalog WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Date createdAt = resultSet.getDate("created_at");
                Date updatedAt = resultSet.getDate("updated_at");
                String name = resultSet.getString("name");
                Category category = new Category(createdAt, updatedAt, name);
                category.setId(resultSet.getInt("id"));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateCategory(Category category) {
        String sql = "INSERT INTO category_catalog (created_at, updated_at, name) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, category.getCreatedAt());
            statement.setDate(2, category.getUpdatedAt());
            statement.setString(3, category.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateCategory(Category category) {
        String sql = "UPDATE category_catalog SET created_at = ?, updated_at = ?, name = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, category.getCreatedAt());
            statement.setDate(2, category.getUpdatedAt());
            statement.setString(3, category.getName());
            statement.setInt(4, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteCategory(int id) {
        String sql = "DELETE FROM category_catalog WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    


}
