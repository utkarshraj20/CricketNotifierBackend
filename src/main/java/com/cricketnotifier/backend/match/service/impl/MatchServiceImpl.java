package com.cricketnotifier.backend.match.service.impl;

import com.cricketnotifier.backend.match.entity.Match;
import com.cricketnotifier.backend.match.entity.MatchStatus;
import com.cricketnotifier.backend.match.repository.MatchRepository;
import com.cricketnotifier.backend.match.service.MatchService;
import com.cricketnotifier.backend.match.dto.CreateMatchRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<Match> getLiveMatches() {
        return matchRepository.findByStatus(MatchStatus.LIVE);
    }

    @Override
    public Match createMatch(CreateMatchRequest request) {

        Match match = Match.builder()
                .team1(request.getTeam1())
                .team2(request.getTeam2())
                .venue(request.getVenue())
                .matchDate(request.getMatchDate())
                .status(request.getStatus())
                .team1Runs(request.getTeam1Runs())
                .team1Wickets(request.getTeam1Wickets())
                .team1Overs(request.getTeam1Overs())
                .team2Runs(request.getTeam2Runs())
                .team2Wickets(request.getTeam2Wickets())
                .team2Overs(request.getTeam2Overs())
                .currentInnings(request.getCurrentInnings())
                .result(request.getResult())
                .build();

        return matchRepository.save(match);
    }

}