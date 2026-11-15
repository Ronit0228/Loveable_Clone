package com.ronit.loveable_clone.mapper;

import com.ronit.loveable_clone.dto.auth.UserProfileResponse;
import com.ronit.loveable_clone.dto.project.ProjectResponse;
import com.ronit.loveable_clone.dto.project.ProjectSummaryResponse;
import com.ronit.loveable_clone.entities.Project;
import com.ronit.loveable_clone.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    UserProfileResponse toUserProfileResponse(User user);

    ProjectSummaryResponse toProjectSummary(Project project);

}
