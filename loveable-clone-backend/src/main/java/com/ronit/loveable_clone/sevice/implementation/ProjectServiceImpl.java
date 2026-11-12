package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.project.ProjectRequest;
import com.ronit.loveable_clone.dto.project.ProjectResponse;
import com.ronit.loveable_clone.dto.project.ProjectSummaryResponse;
import com.ronit.loveable_clone.sevice.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectSummaryResponse> getAllUserProjects(UUID id) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(UUID id, UUID projectId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, UUID userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(UUID id, ProjectRequest projectRequest, UUID userId) {
        return null;
    }

    @Override
    public void softDelete(UUID id, UUID userId) {

    }
}
