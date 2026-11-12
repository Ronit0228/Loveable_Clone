
package com.ronit.loveable_clone.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NotBlank(message = "Plan name cannot be blank")
    @Size(max = 100, message = "Plan name cannot exceed 100 characters")
    @Column(name = "name", nullable = false, length = 100)
    String name;

    @NotBlank(message = "Stripe price ID cannot be blank")
    @Size(max = 255, message = "Stripe price ID cannot exceed 255 characters")
    @Column(name = "stripe_price_id", nullable = false)
    String stripePriceId;

    @NotNull(message = "Maximum projects is required")
    @PositiveOrZero(message = "Maximum projects must be zero or greater")
    @Column(name = "max_projects", nullable = false)
    Integer maxProjects;

    @NotNull(message = "Maximum tokens per day is required")
    @PositiveOrZero(message = "Maximum tokens per day must be zero or greater")
    @Column(name = "max_tokens_per_day", nullable = false)
    Integer maxTokensPerDay;

    @NotNull(message = "Maximum previews is required")
    @PositiveOrZero(message = "Maximum previews must be zero or greater")
    @Column(name = "max_preview", nullable = false)
    Integer maxPreview;

    @NotNull(message = "Unlimited AI status is required")
    @Column(name = "unlimited_ai", nullable = false)
    Boolean unlimitedAi;

    @NotNull(message = "Plan active status is required")
    @Column(nullable = false)
    Boolean active;

    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    @Builder.Default
    List<Subscription> subscriptions = new ArrayList<>();
}
