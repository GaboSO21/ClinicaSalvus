package com.proyecto.salvus.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.salvus.Models.SignoVital;
import com.proyecto.salvus.Models.Doctor;
import com.proyecto.salvus.Repositories.SignosRepository;
import com.proyecto.salvus.Repositories.SignosRepository;

import java.util.*;

@Service
public class SignoVitalService {

    @Autowired
    private SignosRepository SignosRepository;

    public SignoVitalService(SignosRepository SignosRepository) {
        this.SignosRepository = SignosRepository;
    }

    public List<SignoVital> selectSignoVitals() {
        return (List<SignoVital>) SignosRepository.findAll();
    }

    public SignoVital getSignoVital(SignoVital SignoVital) {
        return SignosRepository.findById(SignoVital.getIdSignos()).orElse(null);
    }

    public void deleteSignoVital(SignoVital SignoVital) {
        SignosRepository.delete(SignoVital);
    }

    public void saveSignoVital(SignoVital SignoVital) {
        SignosRepository.save(SignoVital);
    }

}
