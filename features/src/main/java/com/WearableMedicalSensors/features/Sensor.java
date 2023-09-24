package com.WearableMedicalSensors.features;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sensor {

    private int id;
    private String hospitalName;
    private String boneType;
    private String segmentBone;
    private String fractureType;
    private boolean infection;
    private int patientsNumber;

}
