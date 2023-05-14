package org.stc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stc.controller.errors.NotFoundException;
import org.stc.domain.PermissionGroup;
import org.stc.domain.enumerations.PermissionLevel;
import org.stc.repository.PermissionGroupRepository;

@Service
public class PermissionGroupService {
    private final PermissionGroupRepository permissionGroupRepository;
    private final PermissionService permissionService;

    @Autowired
    public PermissionGroupService(PermissionGroupRepository permissionGroupRepository, PermissionService permissionService) {
        this.permissionGroupRepository = permissionGroupRepository;
        this.permissionService = permissionService;
    }



    public void delete(Long id) {
        PermissionGroup permissionGroup = permissionGroupRepository.findById(id).orElseThrow(() -> new NotFoundException("Failed to find group"));
        permissionGroupRepository.delete(permissionGroup);
    }


    PermissionGroup createPermissionGroup(String name) {
        PermissionGroup permissionGroup = new PermissionGroup();
        permissionGroup.setGroupName(name);
        permissionGroup = permissionGroupRepository.save(permissionGroup);
        permissionService.createPermission(PermissionLevel.VIEW, "viewer@stc.co", permissionGroup);
        permissionService.createPermission(PermissionLevel.EDIT, "editor@stc.co", permissionGroup);
        return permissionGroup;
    }
}
