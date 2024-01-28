package com.slloww.lgpd.DTOs;

import com.slloww.lgpd.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {

    private String name;
    private String type;
    private byte[] fileData;
    private User user;
}
