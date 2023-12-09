package com.example.medicaltoolsapplication.repositories;

import com.example.medicaltoolsapplication.models.MedicalDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDevicesRepository extends JpaRepository<MedicalDevices, Integer> {
}
