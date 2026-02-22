package com.cricketnotifier.backend.alert.service;

import com.cricketnotifier.backend.alert.dto.SubscribeRequest;
import com.cricketnotifier.backend.alert.entity.AlertPreference;

import java.util.List;

public interface AlertService {

    void subscribe(SubscribeRequest request);

    void unsubscribe(SubscribeRequest request);

    List<AlertPreference> getMyAlerts();
}
