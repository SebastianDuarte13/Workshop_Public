package form.category.domain.entity;

import java.sql.Date;

public class Category {
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    
    public Category(Date createdAt, Date updatedAt, String name) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
