package com.vti.service.impl;

import com.vti.constants.MessageConstant;
import com.vti.dto.ClassDTO;
import com.vti.entity.Class;
import com.vti.exception.ClassNotFoundException;
import com.vti.repository.IClassRepository;
import com.vti.service.IClassService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassService implements IClassService {

    private final IClassRepository classRepository;

    private final ModelMapper mapper;
    @Override
    public Page<ClassDTO> getAllClass(Pageable pageable) {
        Page<Class> classPage = classRepository.findAll(pageable);
        return classPage.map(classes -> mapper.map(classes, ClassDTO.class));
    }

    @Override
    public ClassDTO getClassById(int id) {
        Class classes = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException(MessageConstant.CLASS_NOT_FOUND + id));
        return mapper.map(classes, ClassDTO.class);
    }

    @Override
    public Class createClass(Class classes) {
        return classRepository.save(classes);
    }

    @Override
    public Class updateClass(Class classes, int id) {
        Class existingClass = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException(MessageConstant.CLASS_NOT_FOUND + id));
        return classRepository.save(existingClass);
    }

    @Override
    public void deleteClassById(int id) {
        if (!classRepository.existsById(id)) {
            throw new ClassNotFoundException(MessageConstant.CLASS_NOT_FOUND + id);
        }
        classRepository.deleteById(id);
    }
}
