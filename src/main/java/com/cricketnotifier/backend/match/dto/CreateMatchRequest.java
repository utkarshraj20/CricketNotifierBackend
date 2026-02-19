package com.cricketnotifier.backend.match.dto;

import com.cricketnotifier.backend.match.entity.MatchStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateMatchRequest {

    @NotBlank
    private String team1;

    @NotBlank
    private String team2;

    private String venue;

    private LocalDateTime matchDate;

    private MatchStatus status;

    private Integer team1Runs;
    private Integer team1Wickets;
    private Double team1Overs;

    private Integer team2Runs;
    private Integer team2Wickets;
    private Double team2Overs;

    private Integer currentInnings;

    private String result;
}
