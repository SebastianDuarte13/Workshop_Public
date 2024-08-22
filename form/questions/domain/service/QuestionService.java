package form.questions.domain.service;

import form.questions.domain.entity.Question;

public interface QuestionService {
    Question FindQuestionById(int id);
    void CreateQuestion(Question question);
    void UpdateQuestion(Question question);
    void DeleteQuestion(int id);
}
