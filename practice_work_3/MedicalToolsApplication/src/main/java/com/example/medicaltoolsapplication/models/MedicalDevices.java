package com.example.medicaltoolsapplication.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_devices")
public class MedicalDevices extends RepresentationModel<MedicalDevices> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rectal_thermometer")
    private int rectalThermometer;

    @Column(name = "low_pressure_meter")
    private int lowPressureMeter;

    @Column(name = "up_pressure_meter")
    private int upPressureMeter;

    @Column(name = "heart_rate_monitor")
    private int heartRateMonitor;

    @Column(name = "holter_monitor")
    private int holterMonitor;

    @Column(name = "glucose_sensor")
    private int glucoseSensor;

    @Column(name = "comment")
    private String comment;

    public MedicalDevices withComment(String comment) {
        this.comment = comment;
        return this;
    }
}
