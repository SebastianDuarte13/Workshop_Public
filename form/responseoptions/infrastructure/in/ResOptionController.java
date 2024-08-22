package form.responseoptions.infrastructure.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import form.responseoptions.application.CreateResOptionUseCase;
import form.responseoptions.domain.entity.ResOption;
import form.responseoptions.domain.service.ResOptionService;

public class ResOptionController {
    private CreateResOptionUseCase createResOptionUseCase;
    private ResOptionService resOptionService;

    public ResOptionController(CreateResOptionUseCase createResOptionUseCase, ResOptionService resOptionService) {
        this.createResOptionUseCase = createResOptionUseCase;
        this.resOptionService = resOptionService;
    }

    public void tabla_ResOption() {
        while (true) {
            String[] options = { "Añadir ResOption", "Editar ResOption", "Mostrar ResOption", "Eliminar ResOption", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de ResOptions",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addResOption();
                    break;
                case 1:
                    editResOption();
                    break;
                case 2:
                    searchResOption();
                    break;
                case 3:
                    deleteResOption();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addResOption() {
        try {
            // Convertir las fechas de entrada de String a Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int option_value = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la opción:"));
            java.util.Date created_at_util = dateFormat.parse(JOptionPane.showInputDialog("Ingrese fecha de creación (yyyy-MM-dd):"));
            java.util.Date updated_at_util = dateFormat.parse(JOptionPane.showInputDialog("Ingrese fecha de actualización (yyyy-MM-dd):"));
            java.sql.Date created_at = new java.sql.Date(created_at_util.getTime());
            java.sql.Date updated_at = new java.sql.Date(updated_at_util.getTime());

            // Entradas adicionales
            String comment_response = JOptionPane.showInputDialog("Ingrese el comentario:");
            String option_text = JOptionPane.showInputDialog("Ingrese el tipo de respuesta:");
            int categorycatalog_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la categoría:"));
            int parentresponse_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del padre de la respuesta:"));
            int question_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la pregunta:"));

            // Validación de las entradas
            if (option_text != null && !option_text.trim().isEmpty()) {
                // Creación del objeto ResOption
                ResOption resOption = new ResOption(option_value, created_at, updated_at, comment_response, option_text, categorycatalog_id, parentresponse_id, question_id);

                // Llamada al caso de uso para crear la respuesta
                createResOptionUseCase.execute(resOption);

                JOptionPane.showMessageDialog(null, "Respuesta añadida exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la respuesta no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor debe ser un número entero.");
        }
    }

    private void editResOption() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ResOption a editar:"));
            ResOption resOption = resOptionService.FindResOptionById(id);
            if (resOption == null) {
                JOptionPane.showMessageDialog(null, "ResOption no encontrada.");
                return;
            }
    
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int option_value = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo valor de la opción:", resOption.getOption_value()));
            java.util.Date created_at_util = dateFormat.parse(JOptionPane.showInputDialog("Ingrese la nueva fecha de creación (yyyy-MM-dd):", resOption.getCreated_at().toString()));
            java.util.Date updated_at_util = dateFormat.parse(JOptionPane.showInputDialog("Ingrese la nueva fecha de actualización (yyyy-MM-dd):", resOption.getUpdated_at().toString()));
            java.sql.Date created_at = new java.sql.Date(created_at_util.getTime());
            java.sql.Date updated_at = new java.sql.Date(updated_at_util.getTime());
    
            String comment_response = JOptionPane.showInputDialog("Ingrese el nuevo comentario:", resOption.getComment_response());
            String option_text = JOptionPane.showInputDialog("Ingrese el nuevo tipo de respuesta:", resOption.getOption_text());
            int categorycatalog_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la categoría:", resOption.getCategorycatalog_id()));
            int parentresponse_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del padre de la respuesta:", resOption.getParentresponse_id()));
            int question_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la pregunta:", resOption.getQuestion_id()));
    
            // Actualizar los campos del objeto ResOption
            resOption.setOption_value(option_value);
            resOption.setCreated_at(created_at);
            resOption.setUpdated_at(updated_at);
            resOption.setComment_response(comment_response);
            resOption.setOption_text(option_text);
            resOption.setCategorycatalog_id(categorycatalog_id);
            resOption.setParentresponse_id(parentresponse_id);
            resOption.setQuestion_id(question_id);
    
            // Llamada al caso de uso para actualizar la ResOption
            resOptionService.UpdateResOption(resOption);
    
            JOptionPane.showMessageDialog(null, "ResOption actualizada exitosamente.");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor debe ser un número entero.");
        }
    }
    

    private void searchResOption() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ResOption a buscar:"));
            ResOption resOption = resOptionService.FindResOptionById(id);
            if (resOption == null) {
                JOptionPane.showMessageDialog(null, "ResOption no encontrada.");
                return;
            }
    
            // Mostrar los detalles de la ResOption
            String message = String.format("ID: %d\nValor: %d\nFecha de Creación: %s\nFecha de Actualización: %s\nComentario: %s\nTexto: %s\nID Categoría: %d\nID Padre: %d\nID Pregunta: %d",
                resOption.getId(), resOption.getOption_value(), resOption.getCreated_at(), resOption.getUpdated_at(),
                resOption.getComment_response(), resOption.getOption_text(), resOption.getCategorycatalog_id(),
                resOption.getParentresponse_id(), resOption.getQuestion_id());
    
            JOptionPane.showMessageDialog(null, message, "Detalles de ResOption", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }
    

    private void deleteResOption() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ResOption a eliminar:"));
            int response = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar la ResOption con ID " + id + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                resOptionService.DeleteResOption(id);
                JOptionPane.showMessageDialog(null, "ResOption eliminada exitosamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }
    
}
