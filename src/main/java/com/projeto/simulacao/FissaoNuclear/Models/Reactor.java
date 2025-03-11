package com.projeto.simulacao.FissaoNuclear.Models;


import com.projeto.simulacao.FissaoNuclear.DTO.ReactorDTO;
import com.projeto.simulacao.FissaoNuclear.DTO.ReactorSizeDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "reactor")
@Table(name = "reactor")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*

        PWR == Pressurized water reactors (PWR), uses water as a coolant.

        BWR == Boiling water reactors (BWR), uses water as a coolant.
               Have bottom-entry control roods that can be inserted without removing control rod drives.

        FBRs == Fast Breeders, uses liquid metal like sodium as a coolant.
                Are very expansive.
                Can generate more nuclear fuel than they consume.
                Have a core of plutonium surrounded by Uranium-238 rods.
                Are not equipped with moderator to slow down neutrons.
                Use fast neutrons to create more nuclear fuel than they consume.
                The fuel cycle is close because the reactor "breeds" its own fuel.
     */


    private String reactorType; //Ex: PWR, BWR, Fast Breeder

    private double maxTemperature; //Em Kelvin

    private double maxPressure; //Em MPa

    private double coreMaxVolume; //Em Liters

    private double fuelCapacity; //Em kg

    private String moderatorType; //Ex: light water, graphite

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "reactor_size_id")
    private ReactorSize reactorSize;

    @ManyToOne
    @JoinColumn(name = "chemical_element_id", referencedColumnName = "chemical_name")
    private ChemicalElement chemicalElement;


    public Reactor(ReactorDTO reactorDTO, ChemicalElement chemicalElementReceive){
        this.reactorType = reactorDTO.reactorType();
        this.maxTemperature = reactorDTO.maxTemperature();
        this.maxPressure = reactorDTO.maxPressure();
        this.coreMaxVolume = reactorDTO.coreMaxVolume();
        this.fuelCapacity = reactorDTO.fuelCapacity();
        this.moderatorType = reactorDTO.moderatorType();
        ReactorSizeDTO sizeDTO = reactorDTO.reactorSize();
        this.reactorSize = new ReactorSize(
                sizeDTO.diameter(),
                sizeDTO.radius(),
                sizeDTO.totalSize(),
                sizeDTO.wallThickness()
        );
        this.chemicalElement = new ChemicalElement(
                chemicalElementReceive.getSymbol(),
                chemicalElementReceive.getName(),
                chemicalElementReceive.getAtomicNumber(),
                chemicalElementReceive.getBoilingPoint(),
                chemicalElementReceive.getDensity(),
                chemicalElementReceive.getMassAtomic(),
                chemicalElementReceive.getMeltingPoint()
        );
    }

    public Reactor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReactorType() {
        return reactorType;
    }

    public void setReactorType(String reactorType) {
        this.reactorType = reactorType;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
    }

    public double getCoreMaxVolume() {
        return coreMaxVolume;
    }

    public void setCoreMaxVolume(double coreMaxVolume) {
        this.coreMaxVolume = coreMaxVolume;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getModeratorType() {
        return moderatorType;
    }

    public void setModeratorType(String moderatorType) {
        this.moderatorType = moderatorType;
    }

    public ReactorSize getReactorSize() {
        return reactorSize;
    }

    public void setReactorSize(ReactorSize reactorSize) {
        this.reactorSize = reactorSize;
    }

    public ChemicalElement getChemicalElement() {
        return chemicalElement;
    }

    public void setChemicalElement(ChemicalElement chemicalElement) {
        this.chemicalElement = chemicalElement;
    }
}
