package com.cricketnotifier.backend.alert.repository;

import com.cricketnotifier.backend.alert.entity.AlertPreference;
import com.cricketnotifier.backend.alert.entity.AlertType;
import com.cricketnotifier.backend.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlertPreferenceRepository extends JpaRepository<AlertPreference, Long> {

    List<AlertPreference> findByUser(User user);

    Optional<AlertPreference> findByUserAndAlertTypeAndReferenceValue(
            User user,
            AlertType alertType,
            String referenceValue
    );

    void deleteByUserAndAlertTypeAndReferenceValue(
            User user,
            AlertType alertType,
            String referenceValue
    );
}
