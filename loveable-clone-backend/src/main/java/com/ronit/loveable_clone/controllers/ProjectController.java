package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.project.ProjectRequest;
import com.ronit.loveable_clone.dto.project.ProjectResponse;
import com.ronit.loveable_clone.dto.project.ProjectSummaryResponse;
import com.ronit.loveable_clone.sevice.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/my-projects")
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects() {
        UUID id = UUID.randomUUID();
        return ResponseEntity.ok(projectService.getAllUserProjects(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable UUID id) {
        UUID projectId = UUID.randomUUID();
        return ResponseEntity.ok(projectService.getUserProjectById(id, projectId));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.status(HttpStatus.OK).body(projectService.createProject(projectRequest, userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable UUID id, @RequestBody ProjectRequest projectRequest) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(projectService.updateProject(id, projectRequest, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        UUID userId = UUID.randomUUID();
        projectService.softDelete(id, userId);
        return ResponseEntity.noContent().build();
    }
}
