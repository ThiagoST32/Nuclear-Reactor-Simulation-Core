package com.projeto.simulacao.FissaoNuclear.Models.Reactor.Params;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxPressure {
    private double maxPressure;

    public MaxPressure(double maxPressure){
        this.verifyMaxPressurePermitted(maxPressure);
        this.setMaxPressure(maxPressure);
    }

    private void verifyMaxPressurePermitted(double maxPressure){
        if (maxPressure != 0){
            throw new RuntimeException("The pressure cannot be less than zero!");
        }
    }
}
