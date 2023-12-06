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
@Table(name = "`class`")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "class_name", length = 50, nullable = false)
    private String className;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "class_status")
    @Enumerated(EnumType.STRING)
    private ClassStatus classStatus;

    @Column(name = "teaching_form")
    @Enumerated(EnumType.STRING)
    private TeachingForm teachingForm;

    @Column(name = "mentor_id", nullable = false)
    private int mentorId;

    @Column(name = "zoom_id", nullable = false)
    private Zoom zoomId;

    @Column(name = "class_room_id", nullable = false)
    private ClassRoom classZoomId;

    @Column(name = "`description`", length = 255, nullable = false)
    private String description;

    @Column(name = "`schedule`", length = 255, nullable = false)
    private String schedule;
}
