package com.wearablemedicalsensors.service;

import java.util.Random;
import org.springframework.stereotype.Service;
import com.wearablemedicalsensors.models.Sensor; // if grey colour -- there is no usage here

@Service
public class SensorService {

    public Sensor getSensor(String hospitalName, String boneType, int patientsNumber) {
        Sensor localSensor = new Sensor();
        localSensor.setId(new Random().nextInt(1000)); // red colour is OK, bcse there is no setters/getters, but annotations make it possible
        localSensor.setHospitalName(hospitalName);
        localSensor.setBoneType(boneType);
        localSensor.setSegmentBone("diaphyseal");
        localSensor.setFractureType("closed");
        localSensor.setInfection(false);
        localSensor.setPatientsNumber(patientsNumber);

        return localSensor;
    }

}
