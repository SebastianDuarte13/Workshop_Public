package form.questions.application;

import form.questions.domain.entity.Question;
import form.questions.domain.service.QuestionService;

public class CreateQuestionUseCase {
    private final QuestionService questionService;

    public CreateQuestionUseCase(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void execute (Question question) {
        questionService.CreateQuestion(question);
    }
}
