package com.proyecto.salvus.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.salvus.Models.Doctor;
import com.proyecto.salvus.Repositories.DoctorRepository;

import java.util.*;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> selectDoctores() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Doctor getDoctor(Doctor doctor) {
        return doctorRepository.findById(doctor.getIdDoctor()).orElse(null);
    }

    public void deleteDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

}
