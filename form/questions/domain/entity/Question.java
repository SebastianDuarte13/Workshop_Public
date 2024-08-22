package form.questions.domain.entity;

import java.sql.Date;

public class Question {
    private int id;
    private Date created_at;
    private Date updated_at;
    private String question_number;
    private String response_type;
    private String comment_question;
    private String question_text;
    private int chapter_id;

    public Question(Date created_at, Date updated_at, String question_number, String response_type,
            String comment_question, String question_text, int chapter_id) {
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.question_number = question_number;
        this.response_type = response_type;
        this.comment_question = comment_question;
        this.question_text = question_text;
        this.chapter_id = chapter_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(String question_number) {
        this.question_number = question_number;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getComment_question() {
        return comment_question;
    }

    public void setComment_question(String comment_question) {
        this.comment_question = comment_question;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

}
