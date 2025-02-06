package com.projeto.simulacao.FissaoNuclear.Models;

import com.projeto.simulacao.FissaoNuclear.DTO.ChemicalElementDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChemicalElement {
//    URANIUM_235("U", 92, 238.02891, 1132.2, 3900),
//    KRYPTON_92("K",32, 83.798,  -157.36, -153.22),
//    BARIUM_141("Ba", 56, 141, 27727.0, 1870.0),
//    PLUTONIUM_239("Pu", 94, 244, 639.4, 3230.0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String symbol;
    private int atomicNumber;
    private double massAtomic;
    private double meltingPoint;
    private double boilingPoint;

    public ChemicalElement(ChemicalElementDTO chemicalElementDTO){
        this.symbol = chemicalElementDTO.symbol();
        this.atomicNumber = chemicalElementDTO.atomicNumber();
        this.massAtomic = chemicalElementDTO.massAtomic();
        this.meltingPoint = chemicalElementDTO.meltingPoint();
        this.boilingPoint = chemicalElementDTO.boilingPoint();
    }

}
