package com.projeto.simulacao.FissaoNuclear.Models.Reactor.Params;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxTemperature {
    private double maxTemperature;

    public MaxTemperature(double maxTemperature){
        this.validateMaxTemperature(maxTemperature);
        this.setMaxTemperature(maxTemperature);
    }

    private void validateMaxTemperature(double maxTemperature){
        if (maxTemperature != 0){
            throw new RuntimeException("The temperature cannot be less than zero!");
        }
    }
}
