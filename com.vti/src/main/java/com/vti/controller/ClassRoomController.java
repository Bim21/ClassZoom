package com.vti.controller;

import com.vti.dto.ClassRoomDTO;
import com.vti.entity.ClassRoom;
import com.vti.service.impl.ClassRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classrooms")
@RequiredArgsConstructor
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    private final ModelMapper mapper;

    @GetMapping
    public Page<ClassRoomDTO> getAllClassRooms(Pageable pageable) {
        return classRoomService.getAllClassRooms(pageable);
    }

    @GetMapping("/{id}")
    public ClassRoomDTO getClassRoomById(@PathVariable("id") int id) {
        return classRoomService.getClassRoomById(id);
    }

    @PostMapping
    public ClassRoom createClassRoom(@RequestBody @Valid ClassRoom classRoom) {
        return classRoomService.createClassRoom(classRoom);
    }

    @PutMapping("/{id}")
    public ClassRoom updateClassRoom(@PathVariable("id") int id, @RequestBody ClassRoom classRoom){
        classRoom.setId(id);
        return classRoomService.updateClassRoom(classRoom,id);
    }
    @DeleteMapping("/{id}")
    public void deleteClassRoom(@PathVariable("id") int id) {
        classRoomService.deleteClassRoomById(id);
    }
}


