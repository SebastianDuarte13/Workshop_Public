package form.response_question.infrastructure.in;

import form.response_question.application.CreateRespondeQuestionUseCase;
import form.responseoptions.domain.service.ResOptionService;

public class RespondeQuestionController {
    private CreateRespondeQuestionUseCase createRespondeQuestionUseCase;
    private ResOptionService resOptionService;
    public RespondeQuestionController(CreateRespondeQuestionUseCase createRespondeQuestionUseCase,
            ResOptionService resOptionService) {
        this.createRespondeQuestionUseCase = createRespondeQuestionUseCase;
        this.resOptionService = resOptionService;
    }

    
}
