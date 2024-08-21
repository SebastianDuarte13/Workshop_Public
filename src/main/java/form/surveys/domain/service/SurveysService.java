package form.surveys.domain.service;

import form.surveys.domain.entity.Surveys;

public interface SurveysService {
    Surveys FindSurveysById(int id);
    void CreateSurveys(Surveys surveys);
    void UpdateSurveys(Surveys surveys);
    void DeleteSurveys(int id);
}
