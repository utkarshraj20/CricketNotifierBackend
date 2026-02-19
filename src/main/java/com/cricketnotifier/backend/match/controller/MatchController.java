package com.cricketnotifier.backend.match.controller;

import com.cricketnotifier.backend.match.entity.Match;
import com.cricketnotifier.backend.match.service.MatchService;
import org.springframework.http.ResponseEntity;
import com.cricketnotifier.backend.match.dto.CreateMatchRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    // Public API
    @GetMapping("/all")
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    // Public API
    @GetMapping("/live")
    public ResponseEntity<List<Match>> getLiveMatches() {
        return ResponseEntity.ok(matchService.getLiveMatches());
    }

    // Temporary admin API (we will secure later)
    @PostMapping("/create")
    public ResponseEntity<Match> createMatch(@Valid @RequestBody CreateMatchRequest request) {
        return ResponseEntity.ok(matchService.createMatch(request));
    }
}