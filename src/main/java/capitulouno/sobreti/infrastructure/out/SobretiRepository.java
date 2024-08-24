package capitulouno.sobreti.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import capitulouno.sobreti.domain.entity.Sobreti;
import capitulouno.sobreti.domain.service.SobretiService;
import form.infrastructure.config.DatabaseConfig;

public class SobretiRepository implements SobretiService {

    @Override
    public Sobreti CreateSobreti(Sobreti sobreti) {
        String sql = "INSERT INTO response_options (option_value, created_at, updated_at, comment_response, option_text, categorycatalog_id, parentresponse_id, question_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            // Setear valores para todos los parámetros
            statement.setInt(1, sobreti.getOption_value());
            statement.setDate(2, sobreti.getCreated_at());
            statement.setDate(3, sobreti.getUpdated_at());
            statement.setString(4, sobreti.getComment_response());
            statement.setString(5, sobreti.getOption_text());
            statement.setInt(6, sobreti.getCategorycatalog_id());
            statement.setInt(7, sobreti.getParentresponse_id());
            statement.setInt(8, sobreti.getQuestion_id());

            // Ejecutar la inserción
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sobreti;
    }
}
