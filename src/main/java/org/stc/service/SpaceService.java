package org.stc.service;


import org.springframework.stereotype.Service;
import org.stc.domain.PermissionGroup;
import org.stc.domain.enumerations.ItemType;

@Service
public class SpaceService {
    private final PermissionGroupService permissionGroupService;
    private final ItemService itemService;

    public SpaceService(PermissionGroupService permissionGroupService, ItemService itemService) {
        this.permissionGroupService = permissionGroupService;
        this.itemService = itemService;
    }

    public void createSTCAssessmentSpace() {
        PermissionGroup adminGroup = permissionGroupService.createPermissionGroup("admin");
        itemService.create("stc-assessments", ItemType.SPACE, adminGroup, null);
    }
}
