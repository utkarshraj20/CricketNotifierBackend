package com.cricketnotifier.backend.match.repository;

import com.cricketnotifier.backend.match.entity.Match;
import com.cricketnotifier.backend.match.entity.MatchStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByStatus(MatchStatus status);
}
