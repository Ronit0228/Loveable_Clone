package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.project.ProjectRequest;
import com.ronit.loveable_clone.dto.project.ProjectResponse;
import com.ronit.loveable_clone.dto.project.ProjectSummaryResponse;
import com.ronit.loveable_clone.sevice.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectController {

    ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        UUID userId = UUID.fromString("91dc50c8-d899-4d7a-87cf-f807c90d1752");
        return ResponseEntity.status(HttpStatus.OK).body(projectService.createProject(projectRequest, userId));
    }

    @GetMapping("/my-projects")
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects() {
        UUID userId = UUID.fromString("91dc50c8-d899-4d7a-87cf-f807c90d1752");
        return ResponseEntity.ok(projectService.getAllUserProjects(userId));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable UUID projectId) {
        UUID userId = UUID.fromString("91dc50c8-d899-4d7a-87cf-f807c90d1752");
        return ResponseEntity.ok(projectService.getUserProjectById(projectId, userId));
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable UUID projectId, @RequestBody ProjectRequest projectRequest) {
        UUID userId = UUID.fromString("91dc50c8-d899-4d7a-87cf-f807c90d1752");
        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest, userId));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID projectId) {
        UUID userId = UUID.fromString("91dc50c8-d899-4d7a-87cf-f807c90d1752");
        projectService.softDelete(projectId, userId);
        return ResponseEntity.noContent().build();
    }
}
