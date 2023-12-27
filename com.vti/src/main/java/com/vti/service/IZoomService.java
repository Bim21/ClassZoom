package com.vti.service;

import com.vti.dto.ZoomDTO;
import com.vti.entity.Zoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IZoomService {
    Page<ZoomDTO> getAllZooms(Pageable pageable);

    ZoomDTO getZoomById(int id);

    Zoom createZoom(Zoom zoom);

    Zoom updateZoom(Zoom zoom, int id);

    void deleteZoomById(int id);
}
