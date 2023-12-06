package com.vti.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`Account`")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "`username`", length = 50, nullable = false)
    private String userName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "`password`", length = 50, nullable = false)
    private String password;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "`role`", nullable = false)
    @Enumerated(EnumType.STRING)
    private String role;

    @Column(name = "phone_number", length = 12, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "facebook", length = 50, nullable = false)
    private String faceBook;

    @Column(name = "information", length = 255, nullable = false)
    private String information;

    private Class class_id;
}
