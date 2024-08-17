package form;

import form.roles.infrastructure.out.RolesRepository;
import form.roles.infrastructure.in.RolesController;
import form.roles.application.CreateRolesUseCase;
import form.roles.domain.service.RolesService;

public class Main {
    public static void main(String[] args) {
        // Inicializar el servicio de roles
        RolesService rolesService = new RolesRepository();
        
        // Inicializar el caso de uso para crear roles
        CreateRolesUseCase createRolesUseCase = new CreateRolesUseCase(rolesService);
        
        // Inicializar el controlador de roles
        RolesController rolesController = new RolesController(createRolesUseCase, rolesService);

        // Ejecutar el menú de roles
        rolesController.tabla_roles();
        
        System.out.println("Programa terminado.");
    }
}
