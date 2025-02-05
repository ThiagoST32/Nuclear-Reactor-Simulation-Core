package com.projeto.simulacao.FissaoNuclear.DTO.UpdateDTOS;

public record ReactorUpdateDTO(String reactorType, double maxTemperature, double maxPressure, double fuelCapacity, String moderatorType) {
}
