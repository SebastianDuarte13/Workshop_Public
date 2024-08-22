package form.roles.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.infrastructure.config.DatabaseConfig;
import form.roles.domain.entity.Roles;
import form.roles.domain.service.RolesService;

public class RolesRepository implements RolesService {

    @Override
    public void createRoles(Roles roles) {
        String sql = "INSERT INTO roles (name) VALUES (?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roles.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Roles findRolesById(int id) {
        String sql = "SELECT id, name FROM roles WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int resultId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Roles role = new Roles(name);
                role.setId(resultId);
                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateRoles(Roles roles) {
        String sql = "UPDATE roles SET name = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roles.getName());
            statement.setInt(2, roles.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deliteRoles(int id) {
        String sql = "DELETE FROM roles WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
