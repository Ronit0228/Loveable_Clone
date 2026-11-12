package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.member.InviteMemberRequest;
import com.ronit.loveable_clone.dto.member.MemberResponse;
import com.ronit.loveable_clone.dto.member.UpdateMemberRoleRequest;
import com.ronit.loveable_clone.sevice.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable UUID projectId) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId, userId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable UUID projectId, @RequestBody InviteMemberRequest inviteMemberRequest) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId, inviteMemberRequest, userId));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateProjectMemberRole(@PathVariable UUID projectId, UUID memberId, @RequestBody UpdateMemberRoleRequest updateMemberRoleRequest) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, updateMemberRoleRequest, userId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteProjectMember(@PathVariable UUID projectId, UUID memberId) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId, memberId, userId));
    }
}
