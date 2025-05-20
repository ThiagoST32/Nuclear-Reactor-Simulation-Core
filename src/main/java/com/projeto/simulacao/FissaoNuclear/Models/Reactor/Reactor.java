package com.projeto.simulacao.FissaoNuclear.Models.Reactor;


import com.projeto.simulacao.FissaoNuclear.DTO.ReactorDTO;
import com.projeto.simulacao.FissaoNuclear.DTO.ReactorSizeDTO;
import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement.ChemicalElement;
import com.projeto.simulacao.FissaoNuclear.Models.Reactor.Params.*;
import com.projeto.simulacao.FissaoNuclear.Models.ReactorSize;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "reactor")
@Table(name = "reactor")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
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


    private ReactorType reactorType; //Ex: PWR, BWR, Fast Breeder

    private MaxTemperature maxTemperature; //Em Kelvin

    private MaxPressure maxPressure; //Em MPa

    private CoreMaxVolume coreMaxVolume; //Em Liters

    private FuelCapacity fuelCapacity; //Em kg

    private ModeratorType moderatorType; //Ex: light water, graphite

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
}
