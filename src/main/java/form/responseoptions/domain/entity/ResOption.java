package form.responseoptions.domain.entity;

import java.sql.Date;

public class ResOption {
    private int id;
    private int option_value;
    private Date created_at;
    private Date updated_at;
    private String comment_response;
    private String option_text;
    private int categorycatalog_id;
    private int parentresponse_id;
    private int question_id;

    public ResOption(int option_value, Date created_at, Date updated_at, String comment_response, String option_text,
            int categorycatalog_id, int parentresponse_id, int question_id) {
        this.option_value = option_value;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.comment_response = comment_response;
        this.option_text = option_text;
        this.categorycatalog_id = categorycatalog_id;
        this.parentresponse_id = parentresponse_id;
        this.question_id = question_id;
    }

    public ResOption(int response_id, int subresponses_id, String responsetext) {
        //TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOption_value() {
        return option_value;
    }

    public void setOption_value(int option_value) {
        this.option_value = option_value;
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

    public String getComment_response() {
        return comment_response;
    }

    public void setComment_response(String comment_response) {
        this.comment_response = comment_response;
    }

    public String getOption_text() {
        return option_text;
    }

    public void setOption_text(String option_text) {
        this.option_text = option_text;
    }

    public int getCategorycatalog_id() {
        return categorycatalog_id;
    }

    public void setCategorycatalog_id(int categorycatalog_id) {
        this.categorycatalog_id = categorycatalog_id;
    }

    public int getParentresponse_id() {
        return parentresponse_id;
    }

    public void setParentresponse_id(int parentresponse_id) {
        this.parentresponse_id = parentresponse_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

}
