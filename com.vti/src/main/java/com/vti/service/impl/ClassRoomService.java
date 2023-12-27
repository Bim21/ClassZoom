package com.vti.service.impl;

import com.vti.constants.MessageConstant;
import com.vti.dto.ClassRoomDTO;
import com.vti.entity.ClassRoom;
import com.vti.exception.ClassRoomNotFoundException;
import com.vti.repository.IClassRoomRepository;
import com.vti.service.IClassRoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassRoomService implements IClassRoomService {

    private final IClassRoomRepository classRoomRepository;

    private final ModelMapper mapper;
    @Override
    public Page<ClassRoomDTO> getAllClassRooms(Pageable pageable) {
        Page<ClassRoom> classRoomPage = classRoomRepository.findAll(pageable);
        return classRoomPage.map(classRoom -> mapper.map(classRoom, ClassRoomDTO.class));
    }

    @Override
    public ClassRoomDTO getClassRoomById(int id) {
        ClassRoom classRoom = classRoomRepository.findById(id)
                .orElseThrow(() -> new ClassRoomNotFoundException(MessageConstant.CLASS_ROOM_NOT_FOUND + id));
        return mapper.map(classRoom, ClassRoomDTO.class);
    }

    @Override
    public ClassRoom createClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoom updateClassRoom(ClassRoom classRoom, int id) {
        ClassRoom existingClassRoom = classRoomRepository.findById(id)
                .orElseThrow(() -> new ClassRoomNotFoundException(MessageConstant.CLASS_ROOM_NOT_FOUND + id));
        return classRoomRepository.save(existingClassRoom);
    }

    @Override
    public void deleteClassRoomById(int id) {
        if (!classRoomRepository.existsById(id)){
            throw new ClassRoomNotFoundException(MessageConstant.CLASS_ROOM_NOT_FOUND + id);
        }
        classRoomRepository.deleteById(id);
    }
}
