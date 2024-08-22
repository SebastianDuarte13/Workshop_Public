package form.chapter.domain.entity;

import java.sql.Date;

public class Chapter {
    private int id;
    private Date created_at;
    private Date updated_at;
    private String chapter_number;
    private String chapter_title;
    private int survey_id;

    public Chapter(Date created_at, Date updated_at, String chapter_number, String chapter_title, int survey_id) {
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.chapter_number = chapter_number;
        this.chapter_title = chapter_title;
        this.survey_id = survey_id;
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

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

}
