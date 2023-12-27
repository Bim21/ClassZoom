package com.vti.service;

import com.vti.dto.ClassRoomDTO;
import com.vti.entity.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoomDTO> getAllClassRoom();

    ClassRoom createClassRoom(ClassRoom classRoom);

    ClassRoom updateClassRoom(ClassRoom classRoom);

    void deleteClassRoomById(int id);
}
