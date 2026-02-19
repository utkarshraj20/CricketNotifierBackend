package com.cricketnotifier.backend.match.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic Info
    @Column(nullable = false)
    private String team1;

    @Column(nullable = false)
    private String team2;

    private String venue;

    private LocalDateTime matchDate;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    // Team 1 Score (1st innings if team1 bats first)
    private Integer team1Runs;
    private Integer team1Wickets;
    private Double team1Overs;

    // Team 2 Score (2nd innings if chasing)
    private Integer team2Runs;
    private Integer team2Wickets;
    private Double team2Overs;

    // 1 = first innings, 2 = second innings
    private Integer currentInnings;

    // Optional: store winner when completed
    private String result;
}
