package com.pnevsky.dto;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class MeasurementsRespons {

    List<MeasurementDTO> measurements;

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
