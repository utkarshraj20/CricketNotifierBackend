package com.cricketnotifier.backend.alert.dto;

import com.cricketnotifier.backend.alert.entity.AlertType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscribeRequest {

    @NotNull
    private AlertType alertType;

    @NotBlank
    private String referenceValue;
}
