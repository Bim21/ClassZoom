package com.vti.service;

import com.vti.dto.ClassDTO;
import com.vti.entity.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClassService {
    Page<ClassDTO> getAllClass(Pageable pageable);

    ClassDTO getClassById(int id);

    Class createClass(Class classes);

    Class updateClass(Class classes, int id);

    void deleteClassById(int id);
}
