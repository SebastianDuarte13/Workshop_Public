package form.subresponse_options.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.infrastructure.config.DatabaseConfig;
import form.subresponse_options.domain.service.SubResOpService;
import form.subresponse_options.domain.entity.SubResOp;

public class SubResOpRepository implements SubResOpService {
    @Override
    public SubResOp FindSubResOpById(int id) {
        String sql = "SELECT id, subresponse_number, created_at, updated_at, subresponse_text, responseoptions_id FROM subresponse_options WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int subresponse_number = resultSet.getInt("subresponse_number");
                Date created_at = resultSet.getDate("created_at");
                Date updated_at = resultSet.getDate("updated_at");
                String subresponse_text = resultSet.getString("subresponse_text");
                int responseoptions_id = resultSet.getInt("responseoptions_id");
                SubResOp subResOp = new SubResOp(subresponse_number, created_at, updated_at, subresponse_text, responseoptions_id);
                subResOp.setId(resultSet.getInt("id"));
                return subResOp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateSubResOp(SubResOp subResOp) {
        String sql = "INSERT INTO subresponse_options (subresponse_number, created_at, updated_at, subresponse_text, responseoptions_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subResOp.getSubresponse_number());
            statement.setDate(2, subResOp.getCreated_at());
            statement.setDate(3, subResOp.getUpdated_at());
            statement.setString(4, subResOp.getSubresponse_text());
            statement.setInt(5, subResOp.getResponseoptions_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateSubResOp(SubResOp subResOp) {
        String sql = "UPDATE subresponse_options SET subresponse_number = ?, created_at = ?, updated_at = ?, subresponse_text = ?, responseoptions_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subResOp.getSubresponse_number());
            statement.setDate(2, subResOp.getCreated_at());
            statement.setDate(3, subResOp.getUpdated_at());
            statement.setString(4, subResOp.getSubresponse_text());
            statement.setInt(5, subResOp.getResponseoptions_id());
            statement.setInt(6, subResOp.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteSubResOp(int id) {
        String sql = "DELETE FROM subresponse_options WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

