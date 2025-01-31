package DTO;

import Models.ReactorSize;

public record ReactorDTO(String reactorType, double maxTemperature, double maxPressure, double fuelCapacity, String moderatorType, ReactorSize reactorSize) {
}
