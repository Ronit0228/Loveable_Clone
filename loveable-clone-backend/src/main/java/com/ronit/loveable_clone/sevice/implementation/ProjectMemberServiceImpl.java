package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.member.InviteMemberRequest;
import com.ronit.loveable_clone.dto.member.MemberResponse;
import com.ronit.loveable_clone.dto.member.UpdateMemberRoleRequest;
import com.ronit.loveable_clone.sevice.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMembers(UUID projectId, UUID userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(UUID projectId, InviteMemberRequest inviteMemberRequest, UUID userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(UUID projectId, UUID memberId, UpdateMemberRoleRequest updateMemberRoleRequest, UUID userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(UUID projectId, UUID memberId, UUID userId) {
        return null;
    }
}
