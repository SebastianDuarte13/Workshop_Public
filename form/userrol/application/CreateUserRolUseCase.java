package form.userrol.application;

import form.userrol.domain.entity.UserRol;
import form.userrol.domain.service.UserRolService;

public class CreateUserRolUseCase {
    private final UserRolService userRolService;

    public CreateUserRolUseCase(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    public void execute(UserRol userRol) {
        userRolService.createUserRol(userRol);
    }
}
