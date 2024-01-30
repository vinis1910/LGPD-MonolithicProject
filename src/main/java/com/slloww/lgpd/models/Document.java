package com.slloww.lgpd.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "db_document")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String type;
    private String urlS3;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

}
