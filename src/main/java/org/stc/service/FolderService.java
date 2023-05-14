package org.stc.service;


import org.springframework.stereotype.Service;
import org.stc.domain.Item;
import org.stc.domain.PermissionGroup;
import org.stc.domain.enumerations.ItemType;
import org.stc.domain.enumerations.PermissionLevel;

@Service
public class FolderService {
    private final ItemService itemService;
    private final PermissionService permissionService;

    public FolderService(ItemService itemService, PermissionService permissionService) {
        this.itemService = itemService;
        this.permissionService = permissionService;
    }

    public void createBackendFolder(String email) {
        Item stcSpace = itemService.findItemByNameAndType(ItemType.SPACE, "stc-assessments");
        PermissionGroup permissionGroup = stcSpace.getPermissionGroup();

        permissionService.validatePermission(permissionGroup, email, PermissionLevel.VIEW);
        Item backend = new Item();
        backend.setType(ItemType.FOLDER);
        itemService.create("backend", ItemType.FOLDER, permissionGroup, stcSpace);


    }
}
