package com.vti.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zoom")
public class Zoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "`name`", length = 50, nullable = false)
    private String name;

    @Column(name = "`link`", length = 100, nullable = false)
    private String link;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "meeting_id", length = 15, nullable = false)
    private String meetingId;

    @Column(name = "pass_code", length = 15, nullable = false)
    private String passCode;
}
