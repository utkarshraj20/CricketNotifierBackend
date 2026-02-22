package com.cricketnotifier.backend.alert.service.impl;

import com.cricketnotifier.backend.alert.dto.SubscribeRequest;
import com.cricketnotifier.backend.alert.entity.AlertPreference;
import com.cricketnotifier.backend.alert.entity.AlertType;
import com.cricketnotifier.backend.alert.repository.AlertPreferenceRepository;
import com.cricketnotifier.backend.alert.service.AlertService;
import com.cricketnotifier.backend.auth.entity.User;
import com.cricketnotifier.backend.auth.repository.UserRepository;
import com.cricketnotifier.backend.exception.BadRequestException;
import com.cricketnotifier.backend.match.repository.MatchRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertPreferenceRepository alertRepository;
    private final UserRepository userRepository;
    private final MatchRepository matchRepository;

    public AlertServiceImpl(AlertPreferenceRepository alertRepository,
                            UserRepository userRepository,
                            MatchRepository matchRepository) {
        this.alertRepository = alertRepository;
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public void subscribe(SubscribeRequest request) {

        User user = getCurrentUser();

        // Validate MATCH existence
        if (request.getAlertType() == AlertType.MATCH) {
            Long matchId = Long.parseLong(request.getReferenceValue());
            if (!matchRepository.existsById(matchId)) {
                throw new BadRequestException("Match not found");
            }
        }

        // Check duplicate
        alertRepository.findByUserAndAlertTypeAndReferenceValue(
                user,
                request.getAlertType(),
                request.getReferenceValue()
        ).ifPresent(alert -> {
            throw new BadRequestException("Already subscribed");
        });

        AlertPreference preference = AlertPreference.builder()
                .user(user)
                .alertType(request.getAlertType())
                .referenceValue(request.getReferenceValue())
                .createdAt(LocalDateTime.now())
                .build();

        alertRepository.save(preference);
    }

    @Override
    public void unsubscribe(SubscribeRequest request) {

        User user = getCurrentUser();

        alertRepository.deleteByUserAndAlertTypeAndReferenceValue(
                user,
                request.getAlertType(),
                request.getReferenceValue()
        );
    }

    @Override
    public List<AlertPreference> getMyAlerts() {

        User user = getCurrentUser();
        return alertRepository.findByUser(user);
    }

    private User getCurrentUser() {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
