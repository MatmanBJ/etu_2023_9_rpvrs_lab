package com.WearableMedicalSensors.features;

import java.util.Random;
import org.springframework.stereotype.Service;
import com.WearableMedicalSensors.features.Sensor;

@Service
public class SensorService {

    public Fractures getFractures(String hospitalName, String boneType, int patientsNumber) {
        Fractures fractures = new Fractures();
        fractures.setId(new Random().nextInt(1000));
        fractures.setHospitalName(hospitalName);
        fractures.setBoneType(boneType);
        fractures.setSegmentBone("diaphyseal");
        fractures.setFractureType("closed");
        fractures.setInfection(false);
        fractures.setPatientsNumber(patientsNumber);

        return fractures;
    }
}
