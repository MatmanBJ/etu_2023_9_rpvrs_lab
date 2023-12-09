package com.example.medicaltoolsapplication.controllers;

import com.example.medicaltoolsapplication.models.MedicalDevices;
import com.example.medicaltoolsapplication.services.MedicalDevicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices")
public class MedicalDevicesControllers {
    private final MedicalDevicesService service;
    private final MessageSource messages;

    @GetMapping("/{id}")
    public MedicalDevices getMedicalDevices(@PathVariable("id") int id,
                                            @RequestHeader(value = "Accept-Language", required = false) Locale locale){
        MedicalDevices medicalDevices = service.findById(id, locale);
        medicalDevices.add(
                linkTo(methodOn(MedicalDevicesControllers.class)
                        .getMedicalDevices(id, locale))
                        .withSelfRel(),
                linkTo(methodOn(MedicalDevicesControllers.class)
                        .createMedicalDevices(medicalDevices))
                        .withRel(String.format(messages.getMessage(
                                "medical.hateoas.create.message", null, locale))),
                linkTo(methodOn(MedicalDevicesControllers.class)
                        .updateMedicalDevices(id, medicalDevices))
                        .withRel(String.format(messages.getMessage(
                                "medical.hateoas.update.message", null, locale))),
                linkTo(methodOn(MedicalDevicesControllers.class)
                        .deleteById(id, locale))
                        .withRel(String.format(messages.getMessage(
                                "medical.hateoas.delete.message", null, locale)))
        );
        return medicalDevices;
    }

    @PostMapping
    public ResponseEntity<MedicalDevices> createMedicalDevices(@RequestBody MedicalDevices medicalDevices){
        return ok(service.createMedicalDevices(medicalDevices));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalDevices> updateMedicalDevices(@PathVariable("id") int id,
                                       @RequestBody MedicalDevices medicalDevices){
        return ok(service.updateMedicalDevices(id, medicalDevices));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id,
                             @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ok(service.deleteById(id, locale));
    }

}
