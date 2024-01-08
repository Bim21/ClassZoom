package com.vti.dto;

import com.vti.entity.Account;
import com.vti.entity.ClassStatus;
import com.vti.entity.TeachingForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassDTO {
    private String className;
    private LocalDate startDate;
    private LocalDate endDate;
    private ClassStatus classStatus;
    private Account mentorId;
    private String schedule;

}
