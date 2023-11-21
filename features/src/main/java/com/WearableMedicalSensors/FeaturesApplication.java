package com.wearablemedicalsensors;

import com.wearablemedicalsensors.models.Sensor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeaturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeaturesApplication.class, args);
		Sensor sensor = new Sensor();
	}

}
