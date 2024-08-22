package form.response_question.application;

import form.response_question.domain.entity.RespondeQuestion;
import form.response_question.domain.service.RespondeQuestionService;

public class CreateRespondeQuestionUseCase {
    private final RespondeQuestionService respondeQuestionService;

    public CreateRespondeQuestionUseCase(RespondeQuestionService respondeQuestionService) {
        this.respondeQuestionService = respondeQuestionService;
    }

    public void execute(RespondeQuestion respondeQuestion) {
        respondeQuestionService.CreateRespondeQuestion(respondeQuestion);
    }
}
