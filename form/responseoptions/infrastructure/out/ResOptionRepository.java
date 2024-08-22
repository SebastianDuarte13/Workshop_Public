package form.responseoptions.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.infrastructure.config.DatabaseConfig;
import form.responseoptions.domain.entity.ResOption;
import form.responseoptions.domain.service.ResOptionService;

public class ResOptionRepository implements ResOptionService {

    @Override
    public ResOption FindResOptionById(int id) {
        String sql = "SELECT id, option_value, created_at, updated_at, comment_response, option_text, categorycatalog_id, parentresponse_id, question_id FROM response_options WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int option_value = resultSet.getInt("option_value");
                Date created_at = resultSet.getDate("created_at");
                Date updated_at = resultSet.getDate("updated_at");
                String comment_response = resultSet.getString("comment_response");
                String option_text = resultSet.getString("option_text");
                int categorycatalog_id = resultSet.getInt("categorycatalog_id");
                int parentresponse_id = resultSet.getInt("parentresponse_id");
                int question_id = resultSet.getInt("question_id");
                ResOption resOption = new ResOption(option_value, created_at, updated_at, comment_response, option_text,
                        categorycatalog_id, parentresponse_id, question_id);
                resOption.setId(resultSet.getInt("id"));
                return resOption;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateResOption(ResOption resOption) {
        String sql = "INSERT INTO response_options (option_value, created_at, updated_at, comment_response, option_text, categorycatalog_id, parentresponse_id, question_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, resOption.getOption_value());
            statement.setDate(2, resOption.getCreated_at());
            statement.setDate(3, resOption.getUpdated_at());
            statement.setString(4, resOption.getComment_response());
            statement.setString(5, resOption.getOption_text());
            statement.setInt(6, resOption.getCategorycatalog_id());
            statement.setInt(7, resOption.getParentresponse_id());
            statement.setInt(8, resOption.getQuestion_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateResOption(ResOption resOption) {
        String sql = "UPDATE response_options SET option_value = ?, created_at = ?, updated_at = ?, comment_response = ?, option_text = ?, categorycatalog_id = ?, parentresponse_id = ?, question_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, resOption.getOption_value());
            statement.setDate(2, resOption.getCreated_at());
            statement.setDate(3, resOption.getUpdated_at());
            statement.setString(4, resOption.getComment_response());
            statement.setString(5, resOption.getOption_text());
            statement.setInt(6, resOption.getCategorycatalog_id());
            statement.setInt(7, resOption.getParentresponse_id());
            statement.setInt(8, resOption.getQuestion_id());
            statement.setInt(9, resOption.getId()); // Asegúrate de que este parámetro se establezca
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteResOption(int id) {
        String sql = "DELETE FROM response_options WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
