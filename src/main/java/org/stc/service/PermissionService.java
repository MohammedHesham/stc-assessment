package org.stc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stc.controller.errors.ForbiddenException;
import org.stc.domain.Permission;
import org.stc.domain.PermissionGroup;
import org.stc.domain.enumerations.PermissionLevel;
import org.stc.repository.PermissionRepository;

import java.util.List;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }


    void validatePermission(PermissionGroup permissionGroup, String mail) {
        List<Permission> permissions = permissionRepository.findAllByPermissionGroup(permissionGroup);

        permissions.stream().filter(permission -> permission.getUserEmail().equals(mail)
                && permission.getPermissionLevel() == PermissionLevel.EDIT).findFirst().orElseThrow(() ->
                new ForbiddenException("User doesn't have access to this resource!"));

    }


    void createPermission(PermissionLevel permissionLevel, String email, PermissionGroup permissionGroup) {
        Permission permission = new Permission();
        permission.setPermissionLevel(permissionLevel);
        permission.setUserEmail(email);
        permission.setPermissionGroup(permissionGroup);
        permissionRepository.save(permission);
    }

}
