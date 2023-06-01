package com.pnevsky;

import com.pnevsky.dto.MeasurementDTO;
import com.pnevsky.dto.MeasurementsRespons;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TemperatureFromServer {

    public static void main(String[] args) {

        List<Double> temperature = getTemperature();
        System.out.println(temperature);

    }

    private static List<Double> getTemperature() {

        final RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/measurements";

        MeasurementsRespons jsonResponse = restTemplate.getForObject(url, MeasurementsRespons.class);

        if (jsonResponse == null || jsonResponse.getMeasurements() == null)
            return Collections.emptyList();

        return jsonResponse.getMeasurements().stream().map(MeasurementDTO::getValue)
                .collect(Collectors.toList());
    }
}
