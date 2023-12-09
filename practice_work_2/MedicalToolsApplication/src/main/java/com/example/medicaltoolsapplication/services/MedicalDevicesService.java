package com.example.medicaltoolsapplication.services;

import com.example.medicaltoolsapplication.models.MedicalDevices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MedicalDevicesService {
    private final MessageSource messages;
    private final List<MedicalDevices> list = new ArrayList<>();
    private int count = 3;

    {
        list.add(new MedicalDevices(1, 1, new int[]{1, 1}, 1, 1, 1));
        list.add(new MedicalDevices(2, 2, new int[]{2, 2}, 2, 2, 2));
        list.add(new MedicalDevices(3, 3, new int[]{3, 3}, 3, 3, 3));
    }

    public MedicalDevices findById(int id) {
        return list.get(id - 1);
    }

    public String createMedicalDevices(MedicalDevices medicalDevices, Locale locale) {
        medicalDevices.setId(++count);
        list.add(medicalDevices);
        return String.format(messages.getMessage("medical.create.message", null, locale), medicalDevices);
    }

    public String updateMedicalDevices(int id, MedicalDevices updateMedicalDevices, Locale locale) {
        MedicalDevices medicalDevices = list.get(id - 1);
        changesMedicalDevices(medicalDevices, updateMedicalDevices);
        return String.format(messages.getMessage("medical.update.message", null, locale), medicalDevices);
    }

    private void changesMedicalDevices(MedicalDevices medicalDevices, MedicalDevices updateMedicalDevices) {
        medicalDevices.setGlucoseSensor(updateMedicalDevices.getGlucoseSensor());
        medicalDevices.setHolterMonitor(updateMedicalDevices.getHolterMonitor());
        medicalDevices.setPressureMeter(updateMedicalDevices.getPressureMeter());
        medicalDevices.setRectalThermometer(updateMedicalDevices.getRectalThermometer());
        medicalDevices.setHeartRateMonitor(updateMedicalDevices.getHeartRateMonitor());
    }

    public String deleteById(int id, Locale locale) {
        list.remove(id - 1);
        return String.format(messages.getMessage("medical.delete.message", null, locale), id);
    }
}
