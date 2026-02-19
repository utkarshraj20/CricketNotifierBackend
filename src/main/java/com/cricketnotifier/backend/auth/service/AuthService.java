package com.cricketnotifier.backend.auth.service;

import com.cricketnotifier.backend.auth.dto.LoginRequest;
import com.cricketnotifier.backend.auth.dto.LoginResponse;
import com.cricketnotifier.backend.auth.dto.SignUpRequest;

public interface AuthService {

    void signUp(SignUpRequest request);

    LoginResponse login(LoginRequest request);
}
