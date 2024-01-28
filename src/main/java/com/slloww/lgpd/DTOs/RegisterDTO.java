package com.slloww.lgpd.DTOs;

import com.slloww.lgpd.models.UserRole;

public record RegisterDTO(String email, String password, String username, UserRole role) {
}
