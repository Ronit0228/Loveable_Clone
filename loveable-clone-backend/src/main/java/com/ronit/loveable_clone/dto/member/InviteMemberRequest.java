package com.ronit.loveable_clone.dto.member;

import com.ronit.loveable_clone.enums.ProjectMemberRole;

public record InviteMemberRequest(
        String email,
        ProjectMemberRole projectMemberRole
) {
}
