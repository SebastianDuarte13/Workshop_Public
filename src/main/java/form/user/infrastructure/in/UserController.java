package form.user.infrastructure.in;

import javax.swing.JOptionPane;

import form.user.application.CreateUserUseCase;
import form.user.domain.entity.User;
import form.user.domain.service.UserService;

public class UserController {
    private CreateUserUseCase createUserUseCase;
    private UserService userService;

    public UserController(CreateUserUseCase createUserUseCase, UserService userService) {
        this.createUserUseCase = createUserUseCase;
        this.userService = userService;
    }

    public void tabla_user() {
        while (true) {
            String[] options = {"Añadir user","Editar user", "Mostrar user", "Eliminar user", "Salir al menú anterior"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Usuarios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addUser();
                    break;
                case 1:
                    editUser();
                    break;
                case 2:
                    searchUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    return; 
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addUser() {
        String username = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        String password = JOptionPane.showInputDialog("Ingrese la contraseña del usuario:");
        if (username != null && !username.trim().isEmpty() && password != null && !password.trim().isEmpty()) {
            User user = new User(false, username, password);
            createUserUseCase.execute(user); 
            JOptionPane.showMessageDialog(null, "Usuario añadido exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos del usuario no válidos.");
        }
    }    

    private void editUser() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del usuario a editar:");
        try {
            int id = Integer.parseInt(idStr);
            User user = userService.FindUserById(id);
            if (user != null) {
                // Solicitar nuevo nombre de usuario
                String newName = JOptionPane.showInputDialog("Ingrese el nuevo nombre del usuario:", user.getUsername());
                if (newName != null && !newName.trim().isEmpty()) {
                    user.setUsername(newName);
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no válido.");
                    return;
                }
                
                // Solicitar nueva contraseña
                String newPassword = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    user.setPassword(newPassword);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña no válida.");
                    return;
                }
                
                // Actualizar el usuario en el servicio
                userService.UpdateUser(user);
                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }

    private void searchUser() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del usuario a buscar:");
        try {
            int id = Integer.parseInt(idStr);
            User user = userService.FindUserById(id);
            if (user != null) {
                JOptionPane.showMessageDialog(null, "Usuario encontrado:\nID: " + user.getId() +
                        "\nNombre: " + user.getUsername() + "\nContraseña: " + user.getPassword());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }

    private void deleteUser() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar:");
        try {
            int id = Integer.parseInt(idStr);
            userService.DeleteUser(id);
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }
}
