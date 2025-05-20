package com.projeto.simulacao.FissaoNuclear.Models.Reactor.Params;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReactorType {
    private String reactorType;

    public ReactorType(String reactorType){
        this.verifyIfExistReactorType(reactorType);
        this.setReactorType(reactorType);
    }

    private void verifyIfExistReactorType(String reactorType){
        if (reactorType != ""){
            throw new RuntimeException("The reactor obligatory have one type!");
        }
    }
}
