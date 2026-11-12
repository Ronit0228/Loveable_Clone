
package com.ronit.loveable_clone.entities;

import com.ronit.loveable_clone.enums.PreviewStatus;
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
@Table(name = "previews")
public class Preview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Project is required")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "project_id",
            nullable = false,
            unique = true
    )
    Project project;

    @NotBlank(message = "Namespace cannot be blank")
    @Size(max = 255, message = "Namespace cannot exceed 255 characters")
    @Column(name = "namespace", nullable = false, length = 255)
    String namespace;

    @NotBlank(message = "Pod name cannot be blank")
    @Size(max = 255, message = "Pod name cannot exceed 255 characters")
    @Column(name = "pod_name", nullable = false, length = 255)
    String podName;

    @NotBlank(message = "Preview URL cannot be blank")
    @Size(max = 2048, message = "Preview URL cannot exceed 2048 characters")
    @Column(name = "preview_url", nullable = false, length = 2048)
    String previewUrl;

    @NotBlank(message = "Preview status cannot be blank")
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    PreviewStatus status;

    @Column(name = "started_at")
    Instant startedAt;

    @Column(name = "terminated_at")
    Instant terminatedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }
}
