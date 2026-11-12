package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.project.ProjectRequest;
import com.ronit.loveable_clone.dto.project.ProjectResponse;
import com.ronit.loveable_clone.dto.project.ProjectSummaryResponse;

import java.util.List;
import java.util.UUID;

public interface ProjectService {
    List<ProjectSummaryResponse> getAllUserProjects(UUID id);
    ProjectResponse getUserProjectById(UUID id, UUID projectId);
    ProjectResponse createProject(ProjectRequest projectRequest, UUID userId);
    ProjectResponse updateProject(UUID id, ProjectRequest projectRequest, UUID userId);
    void softDelete(UUID id, UUID userId);
}
