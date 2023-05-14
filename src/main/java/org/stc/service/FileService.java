package org.stc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stc.domain.File;
import org.stc.domain.Item;
import org.stc.domain.PermissionGroup;
import org.stc.domain.enumerations.ItemType;
import org.stc.repository.FileRepository;

@Service
public class FileService {
    private final FileRepository fileRepository;
    private final ItemService itemService;
    private final PermissionService permissionService;

    @Autowired
    public FileService(FileRepository fileRepository, ItemService itemService, PermissionService permissionService) {
        this.fileRepository = fileRepository;
        this.itemService = itemService;
        this.permissionService = permissionService;
    }


    public void createAssessmentsFile(String email, byte[] content) {
        Item backendFolder = itemService.findItemByNameAndType(ItemType.FOLDER, "backend");
        PermissionGroup permissionGroup = backendFolder.getPermissionGroup();
        permissionService.validatePermission(permissionGroup, email);

        Item assessmentFile = itemService.create("assessment.pdf", ItemType.FILE,
                permissionGroup, backendFolder);
        File file = new File();
        file.setItem(assessmentFile);
        file.setBinary(content);
        fileRepository.save(file);
    }
}
