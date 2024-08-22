package form.response_question.infrastructure.in;

import javax.swing.JOptionPane;

import form.response_question.application.CreateRespondeQuestionUseCase;
import form.response_question.domain.entity.RespondeQuestion;
import form.response_question.domain.service.RespondeQuestionService;

public class RespondeQuestionController {
    private CreateRespondeQuestionUseCase createRespondeQuestionUseCase;
    private RespondeQuestionService respondeQuestionService;

    public RespondeQuestionController(CreateRespondeQuestionUseCase createRespondeQuestionUseCase,
            RespondeQuestionService respondeQuestionService) {
        this.createRespondeQuestionUseCase = createRespondeQuestionUseCase;
        this.respondeQuestionService = respondeQuestionService;
    }

    public void tabla_RespondeQuestion() {
        while (true) {
            String[] options = { "Añadir RespondeQuestion", "Editar RespondeQuestion", "Mostrar RespondeQuestion", "Eliminar RespondeQuestion","Regresar al menu anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Usuarios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addRespondeQuestion();
                    break;
                case 1:
                    editRespondeQuestion();
                    break;
                case 2:
                    searchRespondeQuestion();
                    break;
                case 3:
                    deleteRespondeQuestion();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addRespondeQuestion() {
        int response_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la respuesta:"));
        int subresponses_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la subrespuesta:"));
        String responsetext = JOptionPane.showInputDialog("Ingrese su respuesta:");

        if (response_id > 0 && subresponses_id > 0 && responsetext != null && !responsetext.trim().isEmpty()) {
            RespondeQuestion respondeQuestion = new RespondeQuestion(response_id, subresponses_id, responsetext);
            createRespondeQuestionUseCase.execute(respondeQuestion); // Pasando RespondeQuestion en lugar de
                                                                     // RespondeQuestion
            JOptionPane.showMessageDialog(null, "Respuesta añadida exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos de la respuesta no válidos.");
        }
    }

    private void editRespondeQuestion() {
        int id = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese el ID de la opción de respuesta que desea editar:"));

        RespondeQuestion respondeQuestion = respondeQuestionService.FindRespondeQuestionById(id);

        if (respondeQuestion != null) {
            int response_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id de la respuesta:",
                    respondeQuestion.getResponse_id()));
            int subresponses_id = Integer.parseInt(JOptionPane
                    .showInputDialog("Ingrese el nuevo id de la subrespuesta:", respondeQuestion.getSubresponses_id()));
            String responsetext = JOptionPane.showInputDialog("Ingrese la nueva respuesta:",
                    respondeQuestion.getResponsetext());

            if (response_id > 0 && subresponses_id > 0 && responsetext != null && !responsetext.trim().isEmpty()) {
                respondeQuestion.setResponse_id(response_id);
                respondeQuestion.setSubresponses_id(subresponses_id);
                respondeQuestion.setResponsetext(responsetext);

                respondeQuestionService.UpdateRespondeQuestion(respondeQuestion);
                JOptionPane.showMessageDialog(null, "Opción de respuesta actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos no válidos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opción de respuesta no encontrada.");
        }
    }

    private void searchRespondeQuestion() {
        int id = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese el ID de la opción de respuesta que desea buscar:"));

        RespondeQuestion respondeQuestion = respondeQuestionService.FindRespondeQuestionById(id);

        if (respondeQuestion != null) {
            String details = "ID Respuesta: " + respondeQuestion.getResponse_id() +
                    "\nID Subrespuesta: " + respondeQuestion.getSubresponses_id() +
                    "\nTexto Respuesta: " + respondeQuestion.getResponsetext();
            JOptionPane.showMessageDialog(null, details);
        } else {
            JOptionPane.showMessageDialog(null, "Opción de respuesta no encontrada.");
        }
    }

    private void deleteRespondeQuestion() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la opción de respuesta que desea eliminar:"));
    
        RespondeQuestion respondeQuestion = respondeQuestionService.FindRespondeQuestionById(id);
    
    if (respondeQuestion != null) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar esta opción de respuesta?", 
                                                     "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            respondeQuestionService.DeleteRespondeQuestion(id);
            JOptionPane.showMessageDialog(null, "Opción de respuesta eliminada exitosamente.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Opción de respuesta no encontrada.");
    }
    }

}
