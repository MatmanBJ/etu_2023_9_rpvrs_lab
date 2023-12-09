package com.example.medicaltoolsapplication.models;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Arrays;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalDevices extends RepresentationModel<MedicalDevices> {
    private int id;
    private int rectalThermometer;
    private int[] pressureMeter;
    private int heartRateMonitor;
    private int holterMonitor;
    private int glucoseSensor;
}
