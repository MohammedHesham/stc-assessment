package org.stc.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stc.service.FolderService;

@RestController
@RequestMapping("/api")
public class FolderController {

    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @PostMapping("/folders/backend")
    public ResponseEntity<Error> createBackendFolder(@RequestParam("mail") String mail) {
        folderService.createBackendFolder(mail);
        return ResponseEntity.ok(new Error("folder created."));
    }
}
