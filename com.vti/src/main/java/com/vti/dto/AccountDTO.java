package com.vti.dto;

import com.vti.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String userName;
    private LocalDate dateOfBirth;
    private String address;
    private String fullName;
    private Role role;
    private String email;
}
