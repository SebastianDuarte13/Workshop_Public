package form.surveys.infrastructure.out.in;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import form.surveys.application.CreateSurveysUseCase;
import form.surveys.domain.entity.Surveys;
import form.surveys.domain.service.SurveysService;

public class SurveysController {
    private CreateSurveysUseCase createSurveysUseCase;
    private SurveysService surveysService;

    public SurveysController(CreateSurveysUseCase createSurveysUseCase, SurveysService surveysService) {
        this.createSurveysUseCase = createSurveysUseCase;
        this.surveysService = surveysService;
    }

    public void tabla_Surveys() {
        while (true) {
            String[] options = {"Añadir Surveys", "Editar Surveys", "Mostrar Surveys", "Eliminar Surveys", "Salir al menú anterior"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Encuestas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addSurveys();
                    break;
                case 1:
                    editSurveys();
                    break;
                case 2:
                    searchSurveys();
                    break;
                case 3:
                    deleteSurveys();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addSurveys() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String createdAtString = JOptionPane.showInputDialog("Ingrese fecha de creación (yyyy-MM-dd):");
            String updatedAtString = JOptionPane.showInputDialog("Ingrese fecha de actualización (yyyy-MM-dd):");
            String descriptionString = JOptionPane.showInputDialog("Ingrese una descripción: ");
            String name = JOptionPane.showInputDialog("Ingrese el nombre:");

            if (createdAtString != null && updatedAtString != null && descriptionString != null && name != null && !name.trim().isEmpty()) {
                Date createdAt = new Date(sdf.parse(createdAtString).getTime());
                Date updatedAt = new Date(sdf.parse(updatedAtString).getTime());
                Surveys surveys = new Surveys(createdAt, updatedAt, descriptionString, name);
                createSurveysUseCase.execute(surveys);
                JOptionPane.showMessageDialog(null, "Encuesta añadida exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la encuesta no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        }
    }

    private void editSurveys() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String idString = JOptionPane.showInputDialog("Ingrese el ID de la encuesta a editar:");
            int id = Integer.parseInt(idString);
            
            Surveys surveys = surveysService.FindSurveysById(id);
            if (surveys == null) {
                JOptionPane.showMessageDialog(null, "Encuesta no encontrada.");
                return;
            }

            String createdAtString = JOptionPane.showInputDialog("Ingrese nueva fecha de creación (yyyy-MM-dd):", sdf.format(surveys.getCreated_at()));
            String updatedAtString = JOptionPane.showInputDialog("Ingrese nueva fecha de actualización (yyyy-MM-dd):", sdf.format(surveys.getUpdated_at()));
            String description = JOptionPane.showInputDialog("Ingrese nueva descripción:", surveys.getDescription());
            String name = JOptionPane.showInputDialog("Ingrese nuevo nombre:", surveys.getName());

            if (createdAtString != null && updatedAtString != null && name != null && !name.trim().isEmpty()) {
                Date createdAt = new Date(sdf.parse(createdAtString).getTime());
                Date updatedAt = new Date(sdf.parse(updatedAtString).getTime());
                surveys.setCreated_at(createdAt);
                surveys.setUpdated_at(updatedAt);
                surveys.setDescription(description);
                surveys.setName(name);
                surveysService.UpdateSurveys(surveys);
                JOptionPane.showMessageDialog(null, "Encuesta actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la encuesta no válidos.");
            }
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados.");
        }
    }

    private void searchSurveys() {
        try {
            String idString = JOptionPane.showInputDialog("Ingrese el ID de la encuesta a buscar:");
            int id = Integer.parseInt(idString);
            
            Surveys surveys = surveysService.FindSurveysById(id);
            if (surveys != null) {
                JOptionPane.showMessageDialog(null, "Encuesta encontrada:\nID: " + surveys.getId() +
                    "\nFecha de Creación: " + surveys.getCreated_at() +
                    "\nFecha de Actualización: " + surveys.getUpdated_at() +
                    "\nDescripción: " + surveys.getDescription() +
                    "\nNombre: " + surveys.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Encuesta no encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }

    private void deleteSurveys() {
        try {
            String idString = JOptionPane.showInputDialog("Ingrese el ID de la encuesta a eliminar:");
            int id = Integer.parseInt(idString);
            
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar la encuesta con ID " + id + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                surveysService.DeleteSurveys(id);
                JOptionPane.showMessageDialog(null, "Encuesta eliminada exitosamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
        }
    }
}
