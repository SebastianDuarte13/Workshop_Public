package form.questions.domain.service;

import form.questions.domain.entity.Question;

public interface QuestionService {
    Question FindQuestionById(int id);
    void CreateQuestion(Question question);
    void UpdateQuestion(Question question);
    void DeleteQuestion(int id);
}



/* 
package form;

import form.chapter.application.CreateChapterUseCase;
import form.chapter.domain.service.ChapterService;
import form.chapter.infrastructure.in.ChapterController;
import form.chapter.infrastructure.out.ChapterRepository;
import form.questions.application.CreateQuestionUseCase;
import form.questions.domain.service.QuestionService;
import form.questions.infrastructure.in.QuestionController;
import form.questions.infrastructure.out.QuestionRespository;

public class Main {
    public static void main(String[] args) {
        // Crear las instancias necesarias
        // ChapterService chapterService = new ChapterRepository(); // Implementación del repositorio
        // CreateChapterUseCase createChapterUseCase = new CreateChapterUseCase(chapterService);
        
        // // Instanciar el controlador con las dependencias
        // ChapterController chapterController = new ChapterController(createChapterUseCase, chapterService);
        
        // // Ejecutar el menú CRUD
        // chapterController.tabla_Chapter();

        // Crear una instancia del repositorio de preguntas
        QuestionService questionService = new QuestionRespository();

        // Crear una instancia del caso de uso para la creación de preguntas
        CreateQuestionUseCase createQuestionUseCase = new CreateQuestionUseCase(questionService);

        // Crear una instancia del controlador de preguntas
        QuestionController questionController = new QuestionController(createQuestionUseCase, questionService);

        // Mostrar el menú de gestión de preguntas
        questionController.tabla_Question();

    }
}
*/
