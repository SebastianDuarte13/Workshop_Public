package form.subresponse_options.infrastructure.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import form.subresponse_options.application.CreateSubResOpUseCase;
import form.subresponse_options.domain.entity.SubResOp;
import form.subresponse_options.domain.service.SubResOpService;

public class SubResOpController {
    private final CreateSubResOpUseCase createSubResOpUseCase;
    private final SubResOpService subResOpService;

    public SubResOpController(CreateSubResOpUseCase createSubResOpUseCase, SubResOpService subResOpService) {
        this.createSubResOpUseCase = createSubResOpUseCase;
        this.subResOpService = subResOpService;
    }

    public void tabla_SubResOp() {
        while (true) {
            String[] options = {"Añadir SubResOp", "Editar SubResOp", "Mostrar SubResOp", "Eliminar SubResOp", "Salir al menú anterior"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de SubResOp",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addSubResOp();
                    break;
                case 1:
                    editSubResOp();
                    break;
                case 2:
                    searchSubResOp();
                    break;
                case 3:
                    deleteSubResOp();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addSubResOp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Entradas de usuario
            int subresponse_number = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la subrespuesta:"));
            String created_at = JOptionPane.showInputDialog("Ingrese fecha de creación (yyyy-MM-dd):");
            String updated_at = JOptionPane.showInputDialog("Ingrese fecha de actualización (yyyy-MM-dd):");
            String subresponse_text = JOptionPane.showInputDialog("Ingrese el texto de la subrespuesta:");
            int responseoptions_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la respuesta:"));

            if (created_at != null && updated_at != null && !subresponse_text.trim().isEmpty()) {
                Date createdUtilDate = sdf.parse(created_at);
                Date updatedUtilDate = sdf.parse(updated_at);

                java.sql.Date createdAt = new java.sql.Date(createdUtilDate.getTime());
                java.sql.Date updatedAt = new java.sql.Date(updatedUtilDate.getTime());

                SubResOp subResOp = new SubResOp(subresponse_number, createdAt, updatedAt, subresponse_text, responseoptions_id);
                createSubResOpUseCase.execute(subResOp);

                JOptionPane.showMessageDialog(null, "Subrespuesta añadida exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la subrespuesta no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID de la subrespuesta y el ID de la respuesta deben ser números enteros.");
        }
    }

    private void editSubResOp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            int subResOpId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la subrespuesta a editar:"));

            SubResOp subResOp = subResOpService.FindSubResOpById(subResOpId);
            if (subResOp == null) {
                JOptionPane.showMessageDialog(null, "Subrespuesta no encontrada.");
                return;
            }

            int subresponse_number = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la subrespuesta:", subResOp.getSubresponse_number()));
            String created_at = JOptionPane.showInputDialog("Ingrese fecha de creación (yyyy-MM-dd):", subResOp.getCreated_at());
            String updated_at = JOptionPane.showInputDialog("Ingrese fecha de actualización (yyyy-MM-dd):", subResOp.getUpdated_at());
            String subresponse_text = JOptionPane.showInputDialog("Ingrese el texto de la subrespuesta:", subResOp.getSubresponse_text());
            int responseoptions_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la respuesta:", subResOp.getResponseoptions_id()));

            if (created_at != null && updated_at != null && !subresponse_text.trim().isEmpty()) {
                Date createdUtilDate = sdf.parse(created_at);
                Date updatedUtilDate = sdf.parse(updated_at);

                java.sql.Date createdAt = new java.sql.Date(createdUtilDate.getTime());
                java.sql.Date updatedAt = new java.sql.Date(updatedUtilDate.getTime());

                subResOp.setSubresponse_number(subresponse_number);
                subResOp.setCreated_at(createdAt);
                subResOp.setUpdated_at(updatedAt);
                subResOp.setSubresponse_text(subresponse_text);
                subResOp.setResponseoptions_id(responseoptions_id);

                subResOpService.UpdateSubResOp(subResOp);

                JOptionPane.showMessageDialog(null, "Subrespuesta actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la subrespuesta no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID de la subrespuesta y el ID de la respuesta deben ser números enteros.");
        }
    }
    private void searchSubResOp() {
        try {
            // Pedir ID del capítulo a buscar
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del capítulo a buscar:"));

            // Buscar el capítulo por ID
            SubResOp subResOp = subResOpService.FindSubResOpById(id);
            if (subResOp != null) {
                // Mostrar información del capítulo
                JOptionPane.showMessageDialog(null, "ID: " + subResOp.getId() +
                        "\nsubrespuesta numero: " + subResOp.getSubresponse_number() +
                        "\nFecha de creación: " + subResOp.getCreated_at() +
                        "\nFecha de actualización: " + subResOp.getUpdated_at() +
                        "\nTítulo del capítulo: " + subResOp.getSubresponse_text() +
                        "\nID de la encuesta: " + subResOp.getResponseoptions_id());
            } else {
                JOptionPane.showMessageDialog(null, "Capítulo no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }

    private void deleteSubResOp() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la subrespuesta a eliminar:"));

            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar esta subrespuesta?");
            if (confirm == JOptionPane.YES_OPTION) {
                subResOpService.DeleteSubResOp(id);
                JOptionPane.showMessageDialog(null, "Subrespuesta eliminada exitosamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }
}
