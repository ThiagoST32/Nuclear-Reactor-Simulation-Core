package com.projeto.simulacao.FissaoNuclear.DTO;

import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import com.projeto.simulacao.FissaoNuclear.Models.ReactorSize;

public record ReactorDTO(
        String reactorType,
        double maxTemperature,
        double maxPressure,
        double coreMaxVolume,
        double fuelCapacity,
        String moderatorType,
        ReactorSizeDTO reactorSize,
        ChemicalElement idChemicalElement) {
}
