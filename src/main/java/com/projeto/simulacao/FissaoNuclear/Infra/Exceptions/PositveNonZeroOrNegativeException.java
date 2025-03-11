package com.projeto.simulacao.FissaoNuclear.Infra.Exceptions;

public class PositveNonZeroOrNegativeException extends RuntimeException{
    public PositveNonZeroOrNegativeException(){
        super("THE VALUES CANNOT BE ZERO OR NEGATIVE!!!");
    }
}
