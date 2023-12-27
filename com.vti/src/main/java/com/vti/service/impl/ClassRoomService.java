package com.vti.service.impl;

import com.vti.dto.ClassRoomDTO;
import com.vti.entity.ClassRoom;
import com.vti.repository.IClassRoomRepository;
import com.vti.service.IClassRoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassRoomService implements IClassRoomService {

    private final IClassRoomRepository classRoomRepository;

    private final ModelMapper mapper;
    @Override
    public List<ClassRoomDTO> getAllClassRoom() {
        List<ClassRoom> classRooms = classRoomRepository.findAll();
        List<ClassRoomDTO> classRoomDTOS = new ArrayList<>();

        for (ClassRoom classRoom : classRooms) {
            ClassRoomDTO dto = mapper.map(classRoom, ClassRoomDTO.class);
            classRoomDTOS.add(dto);
        }
        return classRoomDTOS;
    }

    @Override
    public ClassRoom createClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoom updateClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public void deleteClassRoomById(int id) {
        classRoomRepository.deleteById(id);
    }
}
