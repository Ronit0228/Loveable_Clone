package com.ronit.loveable_clone.entities;

import com.ronit.loveable_clone.enums.SubscriptionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
        name = "subscriptions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_stripe_subscription_id",
                        columnNames = "stripe_subscription_id"
                )
        }
)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @NotNull(message = "Plan is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id", nullable = false)
    Plan plan;

    @NotBlank(message = "Stripe subscription ID cannot be blank")
    @Size(max = 255, message = "Stripe subscription ID cannot exceed 255 characters")
    @Column(name = "stripe_subscription_id", nullable = false, unique = true)
    String stripeSubscriptionId;

    @NotNull(message = "Subscription status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    SubscriptionStatus status;

    @NotNull(message = "Current period start is required")
    @Column(name = "current_period_start", nullable = false)
    Instant currentPeriodStart;

    @NotNull(message = "Current period end is required")
    @Column(name = "current_period_end", nullable = false)
    Instant currentPeriodEnd;

    @NotNull(message = "Cancel at period end status is required")
    @Column(name = "cancel_at_period_end", nullable = false)
    Boolean cancelAtPeriodEnd;

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

