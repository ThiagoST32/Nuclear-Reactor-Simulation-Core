package com.projeto.simulacao.FissaoNuclear.Models.Reactor.Params;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreMaxVolume {
    private double coreMaxVolume;

    public CoreMaxVolume(double coreMaxVolume){
        this.verifyCoreMaxVolumeReactor(coreMaxVolume);
        this.setCoreMaxVolume(coreMaxVolume);
    }

    private void verifyCoreMaxVolumeReactor(double coreMaxVolume) {
        if (coreMaxVolume != 0){
            throw  new RuntimeException("The core cannot be less than zero!");
        }
    }
}
