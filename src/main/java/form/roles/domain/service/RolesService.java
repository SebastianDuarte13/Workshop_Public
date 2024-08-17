package form.roles.domain.service;

import form.roles.domain.entity.Roles;

public interface RolesService {
    Roles findRolesById(int id);
    void createRoles(Roles roles);
    void updateRoles(Roles roles);
    void deliteRoles(int id);
}
