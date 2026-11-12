package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.member.InviteMemberRequest;
import com.ronit.loveable_clone.dto.member.MemberResponse;
import com.ronit.loveable_clone.dto.member.UpdateMemberRoleRequest;

import java.util.List;
import java.util.UUID;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(UUID projectId, UUID userId);
    MemberResponse inviteMember(UUID projectId, InviteMemberRequest inviteMemberRequest, UUID userId);
    MemberResponse updateMemberRole(UUID projectId, UUID memberId, UpdateMemberRoleRequest updateMemberRoleRequest, UUID userId);
    MemberResponse deleteProjectMember(UUID projectId, UUID memberId, UUID userId);
}
