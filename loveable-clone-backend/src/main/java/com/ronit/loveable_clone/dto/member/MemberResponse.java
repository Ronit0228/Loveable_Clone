package com.ronit.loveable_clone.dto.member;

import com.ronit.loveable_clone.enums.ProjectMemberRole;

import java.time.Instant;
import java.util.UUID;

public record MemberResponse(
        UUID id,
        String name,
        String email,
        String avatar,
        ProjectMemberRole projectMemberRole,
        Instant invitedAt
) {
}
