package form.user.application;

import form.user.domain.entity.User;
import form.user.domain.service.UserService;

public class CreateUserUseCase {
    private final UserService userService;

    public CreateUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void execute(User user) {
        userService.CreateUser(user);
    }
}
