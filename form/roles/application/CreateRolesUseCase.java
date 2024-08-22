package form.roles.application;

import form.roles.domain.entity.Roles;
import form.roles.domain.service.RolesService;

public class CreateRolesUseCase {
    private final RolesService rolesService;

    public CreateRolesUseCase(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public void execute(Roles roles){
        rolesService.createRoles(roles);
    }
}
