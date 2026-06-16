package com.marciosalesdev.movieflix.mapper;

import com.marciosalesdev.movieflix.controller.request.UserRequest;
import com.marciosalesdev.movieflix.controller.response.UserResponse;
import com.marciosalesdev.movieflix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
