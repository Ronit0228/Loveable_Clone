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

import java.time.Instant;
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
    public List<ProjectSummaryResponse> getAllUserProjects(UUID userId) {
        List<Project> allProjects = projectRepository.findAllAccessibleProjectByUser(userId);
        return allProjects.stream()
                .map(projectMapper::toProjectSummary)
                .toList();
    }

    @Override
    public ProjectResponse getUserProjectById(UUID projectId, UUID userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(UUID projectId, ProjectRequest projectRequest, UUID userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        if(!project.getOwner().getId().equals(userId)) throw new RuntimeException("You are not allowed to update this Project : " + project.getName());

        project.setName(projectRequest.name());
        project = projectRepository.saveAndFlush(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(UUID projectId, UUID userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        if(!project.getOwner().getId().equals(userId)) throw new RuntimeException("You are not allowed to delete this Project : " + project.getName());

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    // INTERNAL METHODS
    private Project getAccessibleProjectById(UUID projectId, UUID userId) {
        return projectRepository.findAllAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
