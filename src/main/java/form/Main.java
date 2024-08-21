package form;

import form.roles.infrastructure.out.RolesRepository;
import form.user.application.CreateUserUseCase;
import form.user.domain.service.UserService;
import form.user.infrastructure.in.UserController;
import form.user.infrastructure.out.UserRepository;
import form.userrol.application.CreateUserRolUseCase;
import form.userrol.domain.service.UserRolService;
import form.userrol.infrastructure.in.UserRolController;
import form.userrol.infrastructure.out.UserRolRepository;
import form.roles.infrastructure.in.RolesController;
import form.category.application.CreateCategoryUseCase;
import form.category.infrastructure.in.CategoryController;
import form.category.infrastructure.out.CategoryRepository;
import form.roles.application.CreateRolesUseCase;
import form.roles.domain.service.RolesService;

public class Main {
    public static void main(String[] args) {
        // Inicializar el servicio de roles
        //RolesService rolesService = new RolesRepository();
        //UserService userService = new UserRepository();
        //UserRolService userRolService = new UserRolRepository();
        CategoryRepository categoryRepository = new CategoryRepository();
        
        // Inicializar el caso de uso para crear roles
        //CreateRolesUseCase createRolesUseCase = new CreateRolesUseCase(rolesService);
        //CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        //CreateUserRolUseCase createUserRolUseCase = new CreateUserRolUseCase(userRolService);
        CreateCategoryUseCase createCategoryUseCase = new CreateCategoryUseCase(categoryRepository);
        
        // Inicializar el controlador de roles
        //RolesController rolesController = new RolesController(createRolesUseCase, rolesService);
        //UserController userController = new UserController(createUserUseCase, userService);
        //UserRolController userRolController = new UserRolController(createUserRolUseCase, null);
        CategoryController categoryController = new CategoryController(createCategoryUseCase, categoryRepository);

        // Ejecutar el menú de roles
        //rolesController.tabla_roles();
        //userController.tabla_user();    
        //userRolController.tabla_userrol();
        categoryController.tabla_category();

        System.out.println("Programa terminado.");
    }
}
