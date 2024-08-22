package form.response_question.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.infrastructure.config.DatabaseConfig;
import form.response_question.domain.entity.RespondeQuestion;
import form.response_question.domain.service.RespondeQuestionService;

public class RespondeQuestionRepository implements RespondeQuestionService {

    @Override
    public RespondeQuestion FindRespondeQuestionById(int id) {
        String sql = "SELECT id, response_id, subresponses_id, responsetext FROM response_question WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int resultId = resultSet.getInt("id");
                    int responseId = resultSet.getInt("response_id");
                    int subresponsesId = resultSet.getInt("subresponses_id");
                    String responsetext = resultSet.getString("responsetext");

                    RespondeQuestion respondeQuestion = new RespondeQuestion(responseId, subresponsesId, responsetext);
                    respondeQuestion.setId(resultId);
                    return respondeQuestion;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes lanzar una excepción personalizada o registrar el error de una manera más adecuada aquí.
        }
        return null; // Devuelve null si no se encuentra el registro o si ocurre un error.
    }

    @Override
    public void CreateRespondeQuestion(RespondeQuestion respondeQuestion) {
        String sql = "INSERT INTO response_question (response_id, subresponses_id, responsetext) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, respondeQuestion.getResponse_id());
            statement.setInt(2, respondeQuestion.getSubresponses_id());
            statement.setString(3, respondeQuestion.getResponsetext());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción de manera adecuada aquí.
        }
    }

    @Override
    public void UpdateRespondeQuestion(RespondeQuestion respondeQuestion) {
        String sql = "UPDATE response_question SET response_id = ?, subresponses_id = ?, responsetext = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, respondeQuestion.getResponse_id());
            statement.setInt(2, respondeQuestion.getSubresponses_id());
            statement.setString(3, respondeQuestion.getResponsetext());
            statement.setInt(4, respondeQuestion.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción de manera adecuada aquí.
        }
    }

    @Override
    public void DeleteRespondeQuestion(int id) {
        String sql = "DELETE FROM response_question WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción de manera adecuada aquí.
        }
    }
}
