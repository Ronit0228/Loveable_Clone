package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.project.FileContentResponse;
import com.ronit.loveable_clone.dto.project.FileNode;

import java.util.List;
import java.util.UUID;

public interface FileService {
    List<FileNode> getFileTree(UUID projectId, UUID userId);
    FileContentResponse getFileContent(UUID projectId, String path, UUID userId);
}
