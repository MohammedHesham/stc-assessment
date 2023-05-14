package org.stc.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stc.service.SpaceService;

@RestController
@RequestMapping("/api")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping("/spaces/stc")
    public ResponseEntity<Error> createSTCSpace() {
        spaceService.createSTCAssessmentSpace();
        return ResponseEntity.ok(new Error("Space created!"));
    }
}
