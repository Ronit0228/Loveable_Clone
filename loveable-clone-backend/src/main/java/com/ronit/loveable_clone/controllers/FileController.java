package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.project.FileContentResponse;
import com.ronit.loveable_clone.dto.project.FileNode;
import com.ronit.loveable_clone.sevice.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable UUID projectId) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(fileService.getFileTree(projectId, userId));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable UUID projectId, @PathVariable String path) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(fileService.getFileContent(projectId, path, userId));
    }
}
