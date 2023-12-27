package com.vti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZoomDTO {
    private String name;
    private String link;
    private String meetingId;
    private String passCode;
}
