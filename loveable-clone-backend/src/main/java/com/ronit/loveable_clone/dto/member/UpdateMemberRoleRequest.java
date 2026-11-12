package com.ronit.loveable_clone.dto.member;

import com.ronit.loveable_clone.enums.ProjectMemberRole;

public record UpdateMemberRoleRequest(
        ProjectMemberRole projectMemberRole
) {
}
