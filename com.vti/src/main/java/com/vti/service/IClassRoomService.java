package com.vti.service;

import com.vti.dto.ClassRoomDTO;
import com.vti.entity.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassRoomService {
    Page<ClassRoomDTO> getAllClassRooms(Pageable pageable);

    ClassRoomDTO getClassRoomById(int id);
    ClassRoom createClassRoom(ClassRoom classRoom);

    ClassRoom updateClassRoom(ClassRoom classRoom, int id);

    void deleteClassRoomById(int id);
}
