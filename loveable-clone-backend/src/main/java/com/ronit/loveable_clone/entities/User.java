
package com.ronit.loveable_clone.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(name = "name", nullable = false, length = 100)
    String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email address")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    @Column(name = "email", unique = true, nullable = false, length = 255)
    String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 60, max = 255, message = "Invalid password hash length")
    @Column(name = "hash_password", nullable = false)
    String hashPassword;

    @Size(max = 2048, message = "Avatar URL cannot exceed 2048 characters")
    @Column(name = "avatar_url", length = 2048)
    String avatarUrl;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Builder.Default
    List<Subscription> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @Builder.Default
    List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    @Builder.Default
    List<ProjectFile> createdFiles = new ArrayList<>();

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    @Builder.Default
    List<ProjectMember> projectMember = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at")
    Instant updatedAt;

    @Column(name = "deleted_at")
    Instant deletedAt; // soft delete

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
