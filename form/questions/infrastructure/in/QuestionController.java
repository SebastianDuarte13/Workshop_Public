package form.questions.infrastructure.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


import form.questions.application.CreateQuestionUseCase;
import form.questions.domain.entity.Question;
import form.questions.domain.service.QuestionService;

public class QuestionController {
    private CreateQuestionUseCase createQuestionUseCase;
    private QuestionService questionService;

    public QuestionController(CreateQuestionUseCase createQuestionUseCase, QuestionService questionService) {
        this.createQuestionUseCase = createQuestionUseCase;
        this.questionService = questionService;
    }

    public void tabla_Question() {
        while (true) {
            String[] options = { "Añadir Question", "Editar Question", "Mostrar Question", "Eliminar Question",
                    "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Preguntas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addQuestion();
                    break;
                case 1:
                    editQuestion();
                    break;
                case 2:
                    searchQuestion();
                    break;
                case 3:
                    deleteQuestion();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addQuestion() {
        try {
            // Convertir las fechas de entrada de String a Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date created_at_util = dateFormat.parse(JOptionPane.showInputDialog("Ingrese fecha de creación (yyyy-MM-dd):"));
            java.util.Date updated_at_util = dateFormat.parse(JOptionPane.showInputDialog("Ingrese fecha de actualización (yyyy-MM-dd):"));
            java.sql.Date created_at = new java.sql.Date(created_at_util.getTime());
            java.sql.Date updated_at = new java.sql.Date(updated_at_util.getTime());
    
            // Entradas adicionales
            String question_number = JOptionPane.showInputDialog("Ingrese el número de la pregunta:");
            String response_type = JOptionPane.showInputDialog("Ingrese el tipo de respuesta:");
            String comment_question = JOptionPane.showInputDialog("Ingrese el comentario de la pregunta:");
            String question_text = JOptionPane.showInputDialog("Ingrese el texto de la pregunta:");
            int chapter_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del capítulo:"));
    
            // Validación de las entradas
            if (created_at != null && updated_at != null && question_text != null && !question_text.trim().isEmpty()) {
                // Creación del objeto Question
                Question question = new Question(created_at, updated_at, question_number, response_type, comment_question, question_text, chapter_id);
    
                // Llamada al caso de uso para crear la pregunta
                createQuestionUseCase.execute(question);
    
                JOptionPane.showMessageDialog(null, "Pregunta añadida exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la pregunta no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID del capítulo debe ser un número entero.");
        }
    }
    

    private void editQuestion() {
        try {
            int questionId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la pregunta a editar:"));
            Question question = questionService.FindQuestionById(questionId);
    
            if (question != null) {
                // Mostrar los valores actuales y permitir que el usuario edite
                String newQuestionNumber = JOptionPane.showInputDialog("Ingrese el nuevo número de la pregunta:", question.getQuestion_number());
                String newResponseType = JOptionPane.showInputDialog("Ingrese el nuevo tipo de respuesta:", question.getResponse_type());
                String newCommentQuestion = JOptionPane.showInputDialog("Ingrese el nuevo comentario de la pregunta:", question.getComment_question());
                String newQuestionText = JOptionPane.showInputDialog("Ingrese el nuevo texto de la pregunta:", question.getQuestion_text());
    
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date updated_at_util = dateFormat.parse(JOptionPane.showInputDialog("Ingrese la nueva fecha de actualización (yyyy-MM-dd):"));
                java.sql.Date updated_at = new java.sql.Date(updated_at_util.getTime());
    
                // Actualizar los valores de la pregunta
                question.setQuestion_number(newQuestionNumber);
                question.setResponse_type(newResponseType);
                question.setComment_question(newCommentQuestion);
                question.setQuestion_text(newQuestionText);
                question.setUpdated_at(updated_at);
    
                // Establecer el ID de la pregunta antes de la actualización
                question.setId(questionId);
    
                // Llamada al servicio para actualizar la pregunta
                questionService.UpdateQuestion(question);
                JOptionPane.showMessageDialog(null, "Pregunta actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la pregunta con el ID proporcionado.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }
    
    

    private void searchQuestion() {
        try {
            int questionId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la pregunta a buscar:"));
            Question question = questionService.FindQuestionById(questionId);
    
            if (question != null) {
                String message = String.format("Pregunta encontrada:\nID: %d\nNúmero: %s\nTipo de respuesta: %s\nComentario: %s\nTexto: %s\nFecha de creación: %s\nFecha de actualización: %s",
                    question.getId(), question.getQuestion_number(), question.getResponse_type(), question.getComment_question(),
                    question.getQuestion_text(), question.getCreated_at(), question.getUpdated_at());
    
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna pregunta con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }
    

    private void deleteQuestion() {
        try {
            int questionId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la pregunta a eliminar:"));
            Question question = questionService.FindQuestionById(questionId);
    
            if (question != null) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar esta pregunta?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    questionService.DeleteQuestion(questionId);
                    JOptionPane.showMessageDialog(null, "Pregunta eliminada exitosamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la pregunta con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }
    
}
