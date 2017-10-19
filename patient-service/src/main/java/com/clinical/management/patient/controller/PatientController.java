package com.clinical.management.patient.controller;


import com.clinical.management.patient.domain.Patient;
import com.clinical.management.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Patient create(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{patientId}")
    public Patient get(@PathVariable String patientId) {
        return patientRepository.findOne(patientId);
    }
}