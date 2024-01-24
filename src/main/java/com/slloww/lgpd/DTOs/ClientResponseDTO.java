package com.slloww.lgpd.DTOs;

import com.slloww.lgpd.models.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {

    private Long id;
    private String email;
    private String password;
    private String username;
    private List<Document> document;
}
