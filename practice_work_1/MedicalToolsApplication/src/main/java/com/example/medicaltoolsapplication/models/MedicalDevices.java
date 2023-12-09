package com.example.medicaltoolsapplication.models;

import lombok.*;

import java.util.Arrays;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalDevices {
    private int id;
    private int rectalThermometer;
    private int[] pressureMeter;
    private int heartRateMonitor;
    private int holterMonitor;
    private int glucoseSensor;
}
