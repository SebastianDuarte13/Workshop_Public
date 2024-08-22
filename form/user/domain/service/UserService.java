package form.user.domain.service;

import form.user.domain.entity.User;

public interface UserService {
    User FindUserById(int id);
    void CreateUser(User user);
    void UpdateUser(User user);
    void DeleteUser(int id);
}
