package com.cricketnotifier.backend.alert.entity;

import com.cricketnotifier.backend.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "alert_preferences",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"user_id", "alertType", "referenceValue"}
                )
        }
)
public class AlertPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many alerts belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertType alertType;

    @Column(nullable = false)
    private String referenceValue; // matchId OR teamName OR tournamentName

    private LocalDateTime createdAt;
}
