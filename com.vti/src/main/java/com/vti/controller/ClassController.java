package com.vti.controller;

import com.vti.dto.ClassDTO;
import com.vti.entity.Class;
import com.vti.service.impl.ClassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;
    private final ModelMapper mapper;

    @GetMapping
    public Page<ClassDTO> getAllClass(Pageable pageable) {
        return classService.getAllClass(pageable);
    }
    @GetMapping("/{id}")
    public ClassDTO getClassById(@PathVariable("id") int id) {
        return classService.getClassById(id);
    }
    @PostMapping
    public Class createClass(@RequestBody Class classes) {
        return classService.createClass(classes);
    }

    @PutMapping("/{id}")
    public Class updateClass(@PathVariable("id") int id, @RequestBody Class classes){
        return classService.updateClass(classes, id);

    }
    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable("id") int id){
        classService.deleteClassById(id);
    }
}
