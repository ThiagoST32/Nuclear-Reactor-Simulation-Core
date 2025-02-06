package com.projeto.simulacao.FissaoNuclear.DTO;

import com.projeto.simulacao.FissaoNuclear.Models.ReactorSize;

public record ReactorDTO(
        String reactorType,
        double maxTemperature,
        double maxPressure,
        double fuelCapacity,
        String moderatorType,
        ReactorSizeDTO reactorSize) {
}
