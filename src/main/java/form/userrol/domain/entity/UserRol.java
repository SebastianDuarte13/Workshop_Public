package form.userrol.domain.entity;

public class UserRol {
    private int role_id;
    private int user_id;
    public UserRol(int role_id, int user_id) {
        this.role_id = role_id;
        this.user_id = user_id;
    }
    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
}
