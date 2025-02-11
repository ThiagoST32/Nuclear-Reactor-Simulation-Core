package com.projeto.simulacao.FissaoNuclear.DTO;

import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;

public record ChemicalElementDTO(Character symbol, int atomicNumber, int massAtomic, int meltingPoint, int boilingPoint){
}
