package com.ronit.loveable_clone.entities;

import com.ronit.loveable_clone.enums.ProjectMemberRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project_members")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId projectMemberId;

    @MapsId("projectId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    Project projectId;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_member_role")
    ProjectMemberRole projectMemberRole;

    @Column(name = "invited_by")
    User invitedBy;

    @Column(name = "invited_at")
    Instant invitedAt;

    @Column(name = "accepted_at")
    Instant acceptedAt;

}
