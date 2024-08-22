package form.surveys.application;

import form.surveys.domain.entity.Surveys;
import form.surveys.domain.service.SurveysService;

public class CreateSurveysUseCase {
    private final SurveysService surveysService;

    public CreateSurveysUseCase(SurveysService surveysService) {
        this.surveysService = surveysService;
    }

    public void execute(Surveys surveys) {
        surveysService.CreateSurveys(surveys);
    }
}
