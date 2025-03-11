package com.projeto.simulacao.FissaoNuclear.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.simulacao.FissaoNuclear.DTO.ChemicalElementDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "chemical_element")
@Table(name = "chemical_element")
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
    private int density; //In g/cm

    @Column(nullable = false)
    private int massAtomic;

    @Column(nullable = false)
    private int meltingPoint;

    @Column(nullable = false)
    private int boilingPoint;

    @OneToMany(mappedBy = "chemicalElement")
    private List<Reactor> reactors;

    public ChemicalElement(ChemicalElementDTO chemicalElementDTO) {
        this.name = chemicalElementDTO.name();
        this.symbol = chemicalElementDTO.symbol();
        this.density = chemicalElementDTO.density();
        this.atomicNumber = chemicalElementDTO.atomicNumber();
        this.massAtomic = chemicalElementDTO.massAtomic();
        this.meltingPoint = chemicalElementDTO.meltingPoint();
        this.boilingPoint = chemicalElementDTO.boilingPoint();
    }

    public ChemicalElement(Character symbol, String name, int atomicNumber, int density, int massAtomic, int meltingPoint, int boilingPoint) {
        this.symbol = symbol;
        this.name = name;
        this.atomicNumber = atomicNumber;
        this.density = density;
        this.massAtomic = massAtomic;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
    }

    public ChemicalElement() {
    }


    public int getId() {
        return id;
    }

    public Character getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public int getDensity() {
        return density;
    }

    public int getMassAtomic() {
        return massAtomic;
    }

    public int getMeltingPoint() {
        return meltingPoint;
    }

    public int getBoilingPoint() {
        return boilingPoint;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public void setMassAtomic(int massAtomic) {
        this.massAtomic = massAtomic;
    }

    public void setMeltingPoint(int meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public void setBoilingPoint(int boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

}
