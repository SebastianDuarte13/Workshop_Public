package form.roles.infrastructure.in;

import javax.swing.JOptionPane;
import form.roles.application.CreateRolesUseCase;
import form.roles.domain.entity.Roles;
import form.roles.domain.service.RolesService;

public class RolesController {
    private CreateRolesUseCase createRolesUseCase;
    private RolesService rolesService;

    public RolesController(CreateRolesUseCase createRolesUseCase, RolesService rolesService) {
        this.createRolesUseCase = createRolesUseCase;
        this.rolesService = rolesService;
    }

    public void tabla_roles() {
        while (true) {
            String[] options = {"Añadir rol","Editar rol", "Mostrar rol", "Eliminar rol", "Salir al menú anterior"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Roles",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addRol();
                    break;
                case 1:
                    editRol();
                    break;
                case 2:
                    searchRol();
                    break;
                case 3:
                    deleteRol();
                    break;
                case 4:
                    return; 
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addRol() {
        String name = JOptionPane.showInputDialog("Ingrese el nombre del rol:");
        if (name != null && !name.trim().isEmpty()) {
            Roles role = new Roles(name);
            createRolesUseCase.execute(role); 
            JOptionPane.showMessageDialog(null, "Rol añadido exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de rol no válido.");
        }
    }    

    private void editRol() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del rol a editar:");
        try {
            int id = Integer.parseInt(idStr);
            Roles role = rolesService.findRolesById(id);
            if (role != null) {
                String newName = JOptionPane.showInputDialog("Ingrese el nuevo nombre del rol:", role.getName());
                if (newName != null && !newName.trim().isEmpty()) {
                    role.setName(newName);
                    rolesService.updateRoles(role);
                    JOptionPane.showMessageDialog(null, "Rol actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de rol no válido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rol no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }

    private void searchRol() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del rol a buscar:");
        try {
            int id = Integer.parseInt(idStr);
            Roles role = rolesService.findRolesById(id);
            if (role != null) {
                JOptionPane.showMessageDialog(null, "Rol encontrado:\nID: " + role.getId() + "\nNombre: " + role.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Rol no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }

    private void deleteRol() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del rol a eliminar:");
        try {
            int id = Integer.parseInt(idStr);
            rolesService.deliteRoles(id);
            JOptionPane.showMessageDialog(null, "Rol eliminado exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }
}
