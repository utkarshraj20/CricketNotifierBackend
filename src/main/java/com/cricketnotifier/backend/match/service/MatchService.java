package com.cricketnotifier.backend.match.service;

import com.cricketnotifier.backend.match.entity.Match;
import com.cricketnotifier.backend.match.dto.CreateMatchRequest;

import java.util.List;

public interface MatchService {

    List<Match> getAllMatches();

    List<Match> getLiveMatches();

    Match createMatch(CreateMatchRequest request);
}
