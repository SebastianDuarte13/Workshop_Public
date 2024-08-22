package form.userrol.infrastructure.in;

import javax.swing.JOptionPane;
import java.util.Scanner; // Asegúrate de importar Scanner

import form.user.domain.service.UserService;
import form.userrol.application.CreateUserRolUseCase;
import form.userrol.domain.entity.UserRol;

public class UserRolController {
    private CreateUserRolUseCase createUserRolUseCase;
    private UserService userService;
    private Scanner scanner = new Scanner(System.in); // Crear instancia de Scanner

    public UserRolController(CreateUserRolUseCase createUserRolUseCase, UserService userService) {
        this.createUserRolUseCase = createUserRolUseCase;
        this.userService = userService;
    }

    public void tabla_userrol() {
        while (true) {
            String[] options = {"Añadir userrol", "Salir al menú anterior"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Usuarios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addUserrol();
                    break;
                case 1:
                    return; 
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addUserrol() {
        String role_id_str = JOptionPane.showInputDialog("Ingrese el role_id:");
        String user_id_str = JOptionPane.showInputDialog("Ingrese el user_id:");

        // Convertir a enteros si es necesario
        int role_id = Integer.parseInt(role_id_str);
        int user_id = Integer.parseInt(user_id_str);

        UserRol userRol = new UserRol(role_id, user_id);

        try {
            createUserRolUseCase.execute(userRol);
            JOptionPane.showMessageDialog(null, "Userrol agregado exitosamente!");
            esperarTecla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Userrol: " + e.getMessage());
        }
    }

    private void esperarTecla() {
        JOptionPane.showMessageDialog(null, "Presione OK para continuar.");
    }
}
