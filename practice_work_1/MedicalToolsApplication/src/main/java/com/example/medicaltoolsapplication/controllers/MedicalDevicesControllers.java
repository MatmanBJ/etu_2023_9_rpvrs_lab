package com.example.medicaltoolsapplication.controllers;

import com.example.medicaltoolsapplication.models.MedicalDevices;
import com.example.medicaltoolsapplication.services.MedicalDevicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices")
public class MedicalDevicesControllers {
    private final MedicalDevicesService service;

    @GetMapping("/{id}")
    public MedicalDevices getMedicalDevices(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PostMapping
    public int createMedicalDevices(@RequestBody MedicalDevices medicalDevices){
        return service.createMedicalDevices(medicalDevices);
    }

    @PutMapping("/{id}")
    public int updateMedicalDevices(@PathVariable("id") int id, @RequestBody MedicalDevices medicalDevices){
        return service.updateMedicalDevices(id, medicalDevices);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        service.deleteById(id);
    }

}
