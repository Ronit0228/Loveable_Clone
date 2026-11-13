package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.auth.AuthResponse;
import com.ronit.loveable_clone.dto.auth.LoginRequest;
import com.ronit.loveable_clone.dto.auth.SignupRequest;
import com.ronit.loveable_clone.dto.auth.UserProfileResponse;
import com.ronit.loveable_clone.entities.User;
import com.ronit.loveable_clone.repository.UserRepository;
import com.ronit.loveable_clone.sevice.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;

    @Override
    public AuthResponse signup(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "User already exists with email: " + signupRequest.email());
        }

        User user = User.builder()
                .name(signupRequest.name())
                .email(signupRequest.email())
                .hashPassword(signupRequest.password())
                .avatarUrl(signupRequest.name().substring(0,1))
                .build();

        user = userRepository.save(user);


        return new AuthResponse(
                "kasjdkfjalskdfjaksdjfklasjdflkasl;kdfjaskdf",
                new UserProfileResponse(user.getId(), user.getName(), user.getEmail(), user.getAvatarUrl())
        );
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }
}
