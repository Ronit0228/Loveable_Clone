package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.project.FileContentResponse;
import com.ronit.loveable_clone.dto.project.FileNode;
import com.ronit.loveable_clone.sevice.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(UUID projectId, UUID userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(UUID projectId, String path, UUID userId) {
        return null;
    }
}
