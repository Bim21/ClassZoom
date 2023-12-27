package com.vti.service.impl;

import com.vti.constants.MessageConstant;
import com.vti.dto.ZoomDTO;
import com.vti.entity.Zoom;
import com.vti.exception.ZoomNotFoundException;
import com.vti.repository.IZoomRepository;
import com.vti.service.IZoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZoomService implements IZoomService {

    private final IZoomRepository zoomRepository;

    private final ModelMapper mapper;

    @Override
    public Page<ZoomDTO> getAllZooms(Pageable pageable) {
        Page<Zoom> zoomPage = zoomRepository.findAll(pageable);
        return zoomPage.map(zoom -> mapper.map(zoom, ZoomDTO.class));
    }

    @Override
    public ZoomDTO getZoomById(int id) {
        Zoom zoom = zoomRepository.findById(id)
                .orElseThrow(() -> new ZoomNotFoundException(MessageConstant.ZOOM_NOT_FOUND + id));
        return mapper.map(zoom, ZoomDTO.class);
    }

    @Override
    public Zoom createZoom(Zoom zoom) {
        return zoomRepository.save(zoom);
    }

    @Override
    public Zoom updateZoom(Zoom zoom, int id) {
        Zoom existingZoom = zoomRepository.findById(id)
                .orElseThrow(() -> new ZoomNotFoundException(MessageConstant.ZOOM_NOT_FOUND + id));
        return zoomRepository.save(existingZoom);
    }
    @Override
    public void deleteZoomById(int id ) {
        if (!zoomRepository.existsById(id)) {
            throw new ZoomNotFoundException(MessageConstant.ZOOM_NOT_FOUND + id);
        }
        zoomRepository.deleteById(id);
    }
}
