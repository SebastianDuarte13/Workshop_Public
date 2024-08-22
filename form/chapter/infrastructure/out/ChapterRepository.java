package form.chapter.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.chapter.domain.entity.Chapter;
import form.chapter.domain.service.ChapterService;
import form.infrastructure.config.DatabaseConfig;

public class ChapterRepository implements ChapterService {

    @Override
    public Chapter FindChapterById(int id) {
        String sql = "SELECT id, created_at, updated_at, chapter_number, chapter_title, survey_id FROM chapter WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Date created_at = resultSet.getDate("created_at");
                Date updated_at = resultSet.getDate("updated_at");
                String chapter_number = resultSet.getString("chapter_number");
                String chapter_title = resultSet.getString("chapter_title");
                int survey_id = resultSet.getInt("survey_id");
                Chapter chapter = new Chapter(created_at, updated_at, chapter_number, chapter_title, survey_id);
                chapter.setId(resultSet.getInt("id"));
                return chapter;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateChapter(Chapter chapter) {
        String sql = "INSERT INTO chapter (created_at, updated_at, chapter_number, chapter_title, survey_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, chapter.getCreated_at());
            statement.setDate(2, chapter.getUpdated_at());
            statement.setString(3, chapter.getChapter_number());
            statement.setString(4, chapter.getChapter_title());
            statement.setInt(5, chapter.getSurvey_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateChapter(Chapter chapter) {
        String sql = "UPDATE chapter SET created_at = ?, updated_at = ?, chapter_number = ?, chapter_title = ?, survey_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setDate(1, chapter.getCreated_at());
            statement.setDate(2, chapter.getUpdated_at());
            statement.setString(3, chapter.getChapter_number());
            statement.setString(4, chapter.getChapter_title());
            statement.setInt(5, chapter.getSurvey_id());
            statement.setInt(6, chapter.getId()); // El ID debe ser el sexto parámetro
    
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void DeleteChapter(int id) {
        String sql = "DELETE FROM chapter WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
