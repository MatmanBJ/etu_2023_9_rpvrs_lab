package com.example.medicaltoolsapplication.services;

import com.example.medicaltoolsapplication.configs.ServiceConfig;
import com.example.medicaltoolsapplication.models.MedicalDevices;
import com.example.medicaltoolsapplication.repositories.MedicalDevicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MedicalDevicesService {
    private final ServiceConfig config;
    private final MessageSource messages;
    private final MedicalDevicesRepository repository;


    public MedicalDevices findById(int id, Locale locale) {
        var smartHouse = repository.findById(id);

        if(smartHouse.isEmpty()){
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("medical.search.error.message", null, locale))
            );
        }

        return smartHouse.get().withComment(config.getProperty());
    }

    public MedicalDevices createMedicalDevices(MedicalDevices medicalDevices) {
        return repository.save(medicalDevices).withComment(config.getProperty());
    }

    public MedicalDevices updateMedicalDevices(int id, MedicalDevices updateMedicalDevices) {
        var medicalDevices = changesMedicalDevices(repository.findById(id).get(), updateMedicalDevices);
        return repository.save(medicalDevices).withComment(config.getProperty());
    }

    private MedicalDevices changesMedicalDevices(MedicalDevices medicalDevices, MedicalDevices updateMedicalDevices) {
        medicalDevices.setGlucoseSensor(updateMedicalDevices.getGlucoseSensor());
        medicalDevices.setHolterMonitor(updateMedicalDevices.getHolterMonitor());
        medicalDevices.setLowPressureMeter(updateMedicalDevices.getLowPressureMeter());
        medicalDevices.setUpPressureMeter(updateMedicalDevices.getUpPressureMeter());
        medicalDevices.setRectalThermometer(updateMedicalDevices.getRectalThermometer());
        medicalDevices.setHeartRateMonitor(updateMedicalDevices.getHeartRateMonitor());

        return medicalDevices;
    }

    public String deleteById(int id, Locale locale) {
        repository.deleteById(id);

        return String.format(
                messages.getMessage("medical.delete.message", null, locale),
                id
        );
    }
}
