
package com.ronit.loveable_clone.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "project_files",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_project_file_path",
                        columnNames = "path"
                )
        }
)
public class ProjectFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Project is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    Project project;

    @NotBlank(message = "File path cannot be blank")
    @Size(max = 1000, message = "File path cannot exceed 1000 characters")
    @Column(name = "path", nullable = false, length = 1000)
    String path;

    @NotBlank(message = "MinIO object key cannot be blank")
    @Size(max = 500, message = "MinIO object key cannot exceed 500 characters")
    @Column(name = "minio_object_key", nullable = false, length = 500)
    String minioObjectKey;

    @NotNull(message = "Creator is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    User updatedBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;

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
