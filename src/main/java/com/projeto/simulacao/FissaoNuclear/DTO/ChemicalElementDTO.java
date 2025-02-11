package com.projeto.simulacao.FissaoNuclear.DTO;

import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;

public record ChemicalElementDTO(String name, Character symbol, int density , int atomicNumber, int massAtomic, int meltingPoint, int boilingPoint){
}
