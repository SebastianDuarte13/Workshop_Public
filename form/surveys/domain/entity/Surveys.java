package form.surveys.domain.entity;

import java.sql.Date;

public class Surveys {
    private int id;
    private Date created_at;
    private Date updated_at;
    private String description;
    private String name;

    public Surveys(Date created_at, Date updated_at, String description, String name) {
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.name = name;
    }

    // Getters y Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
