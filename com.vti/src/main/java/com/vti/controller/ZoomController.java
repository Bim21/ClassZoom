package com.vti.controller;

import com.vti.dto.ZoomDTO;
import com.vti.entity.Zoom;
import com.vti.service.impl.ZoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zooms")
@RequiredArgsConstructor
public class ZoomController {
     private final ZoomService zoomService;

     private final ModelMapper mapper;

     @GetMapping
     public Page<ZoomDTO> getAllZooms(Pageable pageable){
         return zoomService.getAllZooms(pageable);
     }

     @GetMapping("/{id}")
     public ZoomDTO getZoomById(@PathVariable("id") int id){
         return zoomService.getZoomById(id);
     }

     @PostMapping
     public Zoom createZoom(@RequestBody @Valid Zoom zoom){
         return zoomService.createZoom(zoom);
     }

     @PutMapping("/{id}")
     public Zoom updateZoom(@PathVariable("id") int id, @RequestBody Zoom zoom){
         zoom.setId(id);
         return zoomService.updateZoom(zoom, id);
     }
     @DeleteMapping("/{id}")
     public void deleteZoom(@PathVariable("id") int id){
         zoomService.deleteZoomById(id);
     }
}
