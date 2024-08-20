package form;

import form.roles.infrastructure.out.RolesRepository;
import form.user.application.CreateUserUseCase;
import form.user.domain.service.UserService;
import form.user.infrastructure.in.UserController;
import form.user.infrastructure.out.UserRepository;
import form.roles.infrastructure.in.RolesController;
import form.roles.application.CreateRolesUseCase;
import form.roles.domain.service.RolesService;

public class Main {
    public static void main(String[] args) {
        // Inicializar el servicio de roles
        //RolesService rolesService = new RolesRepository();
        UserService userService = new UserRepository();
        
        // Inicializar el caso de uso para crear roles
        //CreateRolesUseCase createRolesUseCase = new CreateRolesUseCase(rolesService);
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        
        // Inicializar el controlador de roles
        //RolesController rolesController = new RolesController(createRolesUseCase, rolesService);
        UserController userController = new UserController(createUserUseCase, userService);

        // Ejecutar el menú de roles
        //rolesController.tabla_roles();
        userController.tabla_user();        
        System.out.println("Programa terminado.");
    }
}
