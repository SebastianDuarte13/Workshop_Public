package form.questions.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.infrastructure.config.DatabaseConfig;
import form.questions.domain.entity.Question;
import form.questions.domain.service.QuestionService;

public class QuestionRespository implements QuestionService {

    @Override
    public Question FindQuestionById(int id) {
        String sql = "SELECT id, created_at, updated_at, question_number, response_type, comment_question, question_text, chapter_id FROM questions WHERE id = ? ";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Date created_at = resultSet.getDate("created_at");
                Date updated_at = resultSet.getDate("updated_at");
                String question_number = resultSet.getString("question_number");
                String response_type = resultSet.getString("response_type");
                String comment_question = resultSet.getString("comment_question");
                String question_text = resultSet.getString("question_text");
                int chapter_id = resultSet.getInt("chapter_id");
                Question question = new Question(created_at, updated_at, question_number, response_type,
                        comment_question, question_text, chapter_id);
                question.setId(resultSet.getInt("id"));
                return question;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateQuestion(Question question) {
        String sql = "INSERT INTO questions (created_at, updated_at, question_number, response_type, comment_question, question_text, chapter_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, question.getCreated_at());
            statement.setDate(2, question.getUpdated_at());
            statement.setString(3, question.getQuestion_number());
            statement.setString(4, question.getResponse_type());
            statement.setString(5, question.getComment_question());
            statement.setString(6, question.getQuestion_text());
            statement.setInt(7, question.getChapter_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateQuestion(Question question) {
        String sql = "UPDATE questions SET created_at = ?, updated_at = ?, question_number = ?, response_type = ?, comment_question = ?, question_text = ?, chapter_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, question.getCreated_at());
            statement.setDate(2, question.getUpdated_at());
            statement.setString(3, question.getQuestion_number());
            statement.setString(4, question.getResponse_type());
            statement.setString(5, question.getComment_question());
            statement.setString(6, question.getQuestion_text());
            statement.setInt(7, question.getChapter_id());
            statement.setInt(8, question.getId()); // Este es el parámetro que estaba faltando
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteQuestion(int id) {
        String sql = "DELETE FROM questions WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
