package com.slloww.lgpd.DTOs;

import com.slloww.lgpd.models.Document;
import com.slloww.lgpd.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private Long id;
    private String email;
    private String password;
    private String username;
    private List<Document> document;
    private UserRole role;
}
