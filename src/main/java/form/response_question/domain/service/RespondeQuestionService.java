package form.response_question.domain.service;

import form.response_question.domain.entity.RespondeQuestion;

public interface RespondeQuestionService {
    RespondeQuestion FindRespondeQuestionById(int id);
    void CreateRespondeQuestion(RespondeQuestion respondeQuestion);
    void UpdateRespondeQuestion(RespondeQuestion respondeQuestion);
    void DeleteRespondeQuestion(int id);
}
