package com.projeto.simulacao.FissaoNuclear.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.simulacao.FissaoNuclear.DTO.ChemicalElementDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "chemical_element")
@Table(name = "chemical_element")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ChemicalElement {
//    URANIUM_235("U", 92, 238.02891, 1132.2, 3900),
//    KRYPTON_92("K",32, 83.798,  -157.36, -153.22),
//    BARIUM_141("Ba", 56, 141, 27727.0, 1870.0),
//    PLUTONIUM_239("Pu", 94, 244, 639.4, 3230.0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 2)
    private Character symbol;

    @Column(unique = true, nullable = false, name = "chemical_name")
    private String name;

    @Column(nullable = false)
    private int atomicNumber;

    @Column(nullable = false)
    private int density;

    @Column(nullable = false)
    private int massAtomic;

    @Column(nullable = false)
    private int meltingPoint;

    @Column(nullable = false)
    private int boilingPoint;

    @OneToOne(mappedBy = "chemicalElement")
    @JsonIgnore
    private Reactor reactor;

    public ChemicalElement(ChemicalElementDTO chemicalElementDTO) {
        this.symbol = chemicalElementDTO.symbol();
        this.atomicNumber = chemicalElementDTO.atomicNumber();
        this.massAtomic = chemicalElementDTO.massAtomic();
        this.meltingPoint = chemicalElementDTO.meltingPoint();
        this.boilingPoint = chemicalElementDTO.boilingPoint();
    }

    public ChemicalElement() {
    }


}
