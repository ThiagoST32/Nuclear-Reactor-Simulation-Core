package com.projeto.simulacao.FissaoNuclear.Models.Reactor.Params;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuelCapacity {
    private double fuelCapacity;

    public FuelCapacity(double fuelCapacity){
        this.verfifyFuelCapacityReactor(fuelCapacity);
    }

    private void verfifyFuelCapacityReactor(double fuelCapacity) {
        if (fuelCapacity != 0){
            throw new RuntimeException("The fuel capacity cannot be less than zero!");
        }
    }
}
