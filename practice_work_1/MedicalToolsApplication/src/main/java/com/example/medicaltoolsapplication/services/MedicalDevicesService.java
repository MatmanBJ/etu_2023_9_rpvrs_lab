package com.example.medicaltoolsapplication.services;

import com.example.medicaltoolsapplication.models.MedicalDevices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalDevicesService {
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

    public int createMedicalDevices(MedicalDevices medicalDevices) {
        medicalDevices.setId(++count);
        list.add(medicalDevices);
        return medicalDevices.getId();
    }

    public int updateMedicalDevices(int id, MedicalDevices updateMedicalDevices) {
        MedicalDevices medicalDevices = list.get(id - 1);
        changesMedicalDevices(medicalDevices, updateMedicalDevices);
        return medicalDevices.getId();
    }

    private void changesMedicalDevices(MedicalDevices medicalDevices, MedicalDevices updateMedicalDevices) {
        medicalDevices.setGlucoseSensor(updateMedicalDevices.getGlucoseSensor());
        medicalDevices.setHolterMonitor(updateMedicalDevices.getHolterMonitor());
        medicalDevices.setPressureMeter(updateMedicalDevices.getPressureMeter());
        medicalDevices.setRectalThermometer(updateMedicalDevices.getRectalThermometer());
        medicalDevices.setHeartRateMonitor(updateMedicalDevices.getHeartRateMonitor());
    }

    public void deleteById(int id) {
        list.remove(id - 1);
    }
}
