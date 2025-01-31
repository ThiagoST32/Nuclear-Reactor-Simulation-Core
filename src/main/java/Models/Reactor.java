package Models;


import DTO.ReactorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reactor {
    @Id
    private int id;

    private String reactorType; //Ex: PWR, BWR, Fast Breeder

    private double maxTemperature; //Em Kelvin

    private double maxPressure; //Em MPa

    private double fuelCapacity; //Em kg

    private String moderatorType; //Ex: light water, graphite

    private ReactorSize reactorSize;


    public Reactor(ReactorDTO reactorDTO){
        this.reactorType = reactorDTO.reactorType();
        this.maxTemperature = reactorDTO.maxTemperature();
        this.maxPressure = reactorDTO.maxPressure();
        this.fuelCapacity = reactorDTO.fuelCapacity();
        this.moderatorType = reactorDTO.moderatorType();
        this.reactorSize = reactorDTO.reactorSize();
    }

}
