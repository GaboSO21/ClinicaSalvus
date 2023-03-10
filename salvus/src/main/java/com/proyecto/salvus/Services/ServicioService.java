package com.proyecto.salvus.Services;

import org.springframework.stereotype.Service;

import com.proyecto.salvus.Repositories.ServicioRepository;
import com.proyecto.salvus.Models.Servicio;

import java.util.*;

@Service
public class ServicioService {

    private ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> selectServicios() {
        return (List<Servicio>) servicioRepository.findAll();
    }

    public Servicio getServicio(Servicio servicio) {
        return servicioRepository.findById(servicio.getIdServicio()).orElse(null);
    }

    public void deleteServicio(Servicio servicio) {
        servicioRepository.delete(servicio);
    }

    public void saveServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

}
