package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.project.ProjectRequest;
import com.ronit.loveable_clone.dto.project.ProjectResponse;
import com.ronit.loveable_clone.dto.project.ProjectSummaryResponse;
import com.ronit.loveable_clone.entities.Project;
import com.ronit.loveable_clone.entities.User;
import com.ronit.loveable_clone.mapper.ProjectMapper;
import com.ronit.loveable_clone.repository.ProjectRepository;
import com.ronit.loveable_clone.repository.UserRepository;
import com.ronit.loveable_clone.sevice.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, UUID userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(projectRequest.name())
                .owner(user)
                .build();

        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getAllUserProjects(UUID id) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(UUID id, UUID projectId) {
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
