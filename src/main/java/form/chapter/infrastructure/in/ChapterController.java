package form.chapter.infrastructure.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import form.chapter.application.CreateChapterUseCase;
import form.chapter.domain.entity.Chapter;
import form.chapter.domain.service.ChapterService;

public class ChapterController {
    private CreateChapterUseCase createChapterUseCase;
    private ChapterService chapterService;

    public ChapterController(CreateChapterUseCase createChapterUseCase, ChapterService chapterService) {
        this.createChapterUseCase = createChapterUseCase;
        this.chapterService = chapterService;
    }

    // Menú de opciones para el CRUD
    public void tabla_Chapter() {
        while (true) {
            String[] options = {"Añadir Chapter", "Editar Chapter", "Mostrar Chapter", "Eliminar Chapter", "Salir al menú anterior"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Capítulos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addChapter();
                    break;
                case 1:
                    editChapter();
                    break;
                case 2:
                    searchChapter();
                    break;
                case 3:
                    deleteChapter();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addChapter() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
            // Entradas de usuario
            String created_at = JOptionPane.showInputDialog("Ingrese fecha de creación (yyyy-MM-dd):");
            String updated_at = JOptionPane.showInputDialog("Ingrese fecha de actualización (yyyy-MM-dd):");
            String chapter_number = JOptionPane.showInputDialog("Ingrese el número del capítulo:");
            String chapter_title = JOptionPane.showInputDialog("Ingrese el título del capítulo:");
            int survey_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la encuesta:"));
    
            // Validación de las entradas
            if (created_at != null && updated_at != null && chapter_title != null && !chapter_title.trim().isEmpty()) {
                // Conversión de las fechas a java.util.Date
                java.util.Date createdUtilDate = sdf.parse(created_at);
                java.util.Date updatedUtilDate = sdf.parse(updated_at);
    
                // Conversión de java.util.Date a java.sql.Date
                java.sql.Date createdAt = new java.sql.Date(createdUtilDate.getTime());
                java.sql.Date updatedAt = new java.sql.Date(updatedUtilDate.getTime());
    
                // Creación de un objeto Chapter
                Chapter chapter = new Chapter(createdAt, updatedAt, chapter_number, chapter_title, survey_id);
    
                // Llamada al caso de uso para crear el capítulo
                createChapterUseCase.execute(chapter);
    
                JOptionPane.showMessageDialog(null, "Capítulo añadido exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos del capítulo no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID de la encuesta debe ser un número entero.");
        }
    }
    

    private void editChapter() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
            // Pedir ID del capítulo a editar
            int chapterId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del capítulo a editar:"));
    
            // Buscar el capítulo existente
            Chapter chapter = chapterService.FindChapterById(chapterId);
            if (chapter == null) {
                JOptionPane.showMessageDialog(null, "Capítulo no encontrado.");
                return;
            }
    
            // Mostrar la información actual del capítulo y permitir la edición
            String created_at = JOptionPane.showInputDialog("Ingrese nueva fecha de creación (yyyy-MM-dd):", chapter.getCreated_at().toString());
            String updated_at = JOptionPane.showInputDialog("Ingrese nueva fecha de actualización (yyyy-MM-dd):", chapter.getUpdated_at().toString());
            String chapter_number = JOptionPane.showInputDialog("Ingrese nuevo número del capítulo:", chapter.getChapter_number());
            String chapter_title = JOptionPane.showInputDialog("Ingrese nuevo título del capítulo:", chapter.getChapter_title());
            int survey_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo ID de la encuesta:", chapter.getSurvey_id()));
    
            // Validación de las entradas
            if (created_at != null && updated_at != null && chapter_title != null && !chapter_title.trim().isEmpty()) {
                // Conversión de las fechas a java.util.Date
                java.util.Date createdUtilDate = sdf.parse(created_at);
                java.util.Date updatedUtilDate = sdf.parse(updated_at);
    
                // Conversión de java.util.Date a java.sql.Date
                java.sql.Date createdAt = new java.sql.Date(createdUtilDate.getTime());
                java.sql.Date updatedAt = new java.sql.Date(updatedUtilDate.getTime());
    
                // Actualizar los datos del capítulo
                chapter.setCreated_at(createdAt);
                chapter.setUpdated_at(updatedAt);
                chapter.setChapter_number(chapter_number);
                chapter.setChapter_title(chapter_title);
                chapter.setSurvey_id(survey_id);
    
                // Guardar los cambios
                chapterService.UpdateChapter(chapter);
    
                JOptionPane.showMessageDialog(null, "Capítulo actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos del capítulo no válidos.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID de la encuesta y el ID del capítulo deben ser números enteros.");
        }
    }
    

    private void searchChapter() {
        try {
            // Pedir ID del capítulo a buscar
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del capítulo a buscar:"));

            // Buscar el capítulo por ID
            Chapter chapter = chapterService.FindChapterById(id);
            if (chapter != null) {
                // Mostrar información del capítulo
                JOptionPane.showMessageDialog(null, "ID: " + chapter.getId() +
                        "\nFecha de creación: " + chapter.getCreated_at() +
                        "\nFecha de actualización: " + chapter.getUpdated_at() +
                        "\nNúmero del capítulo: " + chapter.getChapter_number() +
                        "\nTítulo del capítulo: " + chapter.getChapter_title() +
                        "\nID de la encuesta: " + chapter.getSurvey_id());
            } else {
                JOptionPane.showMessageDialog(null, "Capítulo no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }

    private void deleteChapter() {
        try {
            // Pedir ID del capítulo a eliminar
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del capítulo a eliminar:"));

            // Confirmar eliminación
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este capítulo?");
            if (confirm == JOptionPane.YES_OPTION) {
                chapterService.DeleteChapter(id);
                JOptionPane.showMessageDialog(null, "Capítulo eliminado exitosamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
        }
    }
}
