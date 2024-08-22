package form.userrol.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import form.infrastructure.config.DatabaseConfig;
import form.userrol.domain.entity.UserRol;
import form.userrol.domain.service.UserRolService;

public class UserRolRepository implements UserRolService {

    @Override
    public void createUserRol(UserRol userRol) {
        String sql = "INSERT INTO user_roles (role_id, user_id) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userRol.getRole_id());
            statement.setInt(2, userRol.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
