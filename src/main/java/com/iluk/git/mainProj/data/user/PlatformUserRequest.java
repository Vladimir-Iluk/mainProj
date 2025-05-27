package com.iluk.git.mainProj.data.user;

public record PlatformUserRequest(String username, String password, Role role) {
}