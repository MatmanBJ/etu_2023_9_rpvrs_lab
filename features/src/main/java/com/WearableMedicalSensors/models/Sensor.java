package com.wearablemedicalsensors.models;

import lombok.Data;
import lombok.ToString;

//@Getter
//@Setter
@ToString
@Data
public class Sensor {

    private int id;
    private String hospitalName;
    private String boneType;
    private String segmentBone;
    private String fractureType;
    private boolean infection;
    private int patientsNumber;

    public void setId(int id){
        this.id = id;
    }


    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setBoneType(String boneType) {
        this.boneType = boneType;
    }

    public void setSegmentBone(String segmentBone) {
        this.segmentBone = segmentBone;
    }

    public void setFractureType(String closed) {
        this.fractureType = closed;
    }

    public void setInfection(boolean b) {
        this.infection = b;
    }

    public void setPatientsNumber(int patientsNumber) {
        this.patientsNumber = patientsNumber;

    }
}
