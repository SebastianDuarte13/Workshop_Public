package form.subresponse_options.domain.entity;

import java.sql.Date;

public class SubResOp {
    private int id;
    private int subresponse_number;
    private Date created_at;
    private Date updated_at;
    private String subresponse_text;
    private int responseoptions_id;

    public SubResOp(int subresponse_number, Date created_at, Date updated_at, String subresponse_text,
            int responseoptions_id) {
        this.subresponse_number = subresponse_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.subresponse_text = subresponse_text;
        this.responseoptions_id = responseoptions_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubresponse_number() {
        return subresponse_number;
    }

    public void setSubresponse_number(int subresponse_number) {
        this.subresponse_number = subresponse_number;
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

    public String getSubresponse_text() {
        return subresponse_text;
    }

    public void setSubresponse_text(String subresponse_text) {
        this.subresponse_text = subresponse_text;
    }

    public int getResponseoptions_id() {
        return responseoptions_id;
    }

    public void setResponseoptions_id(int responseoptions_id) {
        this.responseoptions_id = responseoptions_id;
    }

}
