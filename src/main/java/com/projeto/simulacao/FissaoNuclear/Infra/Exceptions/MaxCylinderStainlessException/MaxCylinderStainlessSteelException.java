package com.projeto.simulacao.FissaoNuclear.Infra.Exceptions.MaxCylinderStainlessException;

public class MaxCylinderStainlessSteelException extends RuntimeException{
    public MaxCylinderStainlessSteelException(){
        super("Invalid pressure cylinder format!");
    }
}
