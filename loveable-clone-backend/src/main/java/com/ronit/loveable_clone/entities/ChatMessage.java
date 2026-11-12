
package com.ronit.loveable_clone.entities;

import com.ronit.loveable_clone.enums.MessageRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import tools.jackson.databind.JsonNode;

import java.time.Instant;

@Entity
@Table(name = "chat_message")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Project is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    Project project;

    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @NotBlank(message = "Message role cannot be blank")
    @Column(name = "role", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    MessageRole role;

    @NotBlank(message = "Message content cannot be blank")
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    String content;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "tool_calls", columnDefinition = "jsonb")
    JsonNode toolCalls;

    @Size(max = 255, message = "Tool call ID cannot exceed 255 characters")
    @Column(name = "tool_call_id", length = 255)
    String toolCallId;

    @PositiveOrZero(message = "Tokens used cannot be negative")
    @Column(name = "tokens_used")
    Integer tokensUsed;

    @NotNull(message = "Created date is required")
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }
}
