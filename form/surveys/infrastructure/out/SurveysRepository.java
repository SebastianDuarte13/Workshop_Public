package form.surveys.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.infrastructure.config.DatabaseConfig;
import form.surveys.domain.entity.Surveys;
import form.surveys.domain.service.SurveysService;

public class SurveysRepository implements SurveysService {

    @Override
    public Surveys FindSurveysById(int id) {
        String sql = "SELECT created_at, updated_at, description, name FROM surveys WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Date created_at = resultSet.getDate("created_at");
                    Date updated_at = resultSet.getDate("updated_at");
                    String description = resultSet.getString("description");
                    String name = resultSet.getString("name");
                    Surveys surveys = new Surveys(created_at, updated_at, description, name);
                    surveys.setId(id); // Establecer ID después de la creación
                    return surveys;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no survey is found
    }

    @Override
    public void CreateSurveys(Surveys surveys) {
        String sql = "INSERT INTO surveys (created_at, updated_at, description, name) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new Date(surveys.getCreated_at().getTime()));
            statement.setDate(2, new Date(surveys.getUpdated_at().getTime()));
            statement.setString(3, surveys.getDescription());
            statement.setString(4, surveys.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateSurveys(Surveys surveys) {
        String sql = "UPDATE surveys SET created_at = ?, updated_at = ?, description = ?, name = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new Date(surveys.getCreated_at().getTime()));
            statement.setDate(2, new Date(surveys.getUpdated_at().getTime()));
            statement.setString(3, surveys.getDescription());
            statement.setString(4, surveys.getName());
            statement.setInt(5, surveys.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteSurveys(int id) {
        String sql = "DELETE FROM surveys WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
