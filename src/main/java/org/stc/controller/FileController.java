package org.stc.controller;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    @GetMapping("/files")
    public ResponseEntity<Resource> download(@RequestParam("mail") String mail, @RequestParam("name") String name) {
        byte[] filecontent = fileService.getFilecontent(mail, name);
        ByteArrayResource resource = new ByteArrayResource(filecontent);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename(name)
                                .build().toString())
                .body(resource);
    }

}
