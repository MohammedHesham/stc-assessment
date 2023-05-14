package org.stc.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stc.controller.errors.Error;
import org.stc.dto.FileDTO;
import org.stc.service.FileService;

@RestController
@RequestMapping("/api")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/files/assessments")
    public ResponseEntity<Error> createAssessmentsFile(@RequestParam("email") String email, @RequestBody FileDTO file) {
        fileService.createAssessmentsFile(email, file.getBinary());
        return ResponseEntity.ok(new Error("file created."));
    }

}
