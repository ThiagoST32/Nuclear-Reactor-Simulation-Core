package Models;


import DTO.ReactorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reactor {
    @Id
    private int id;

    private String reactorType;

    private double temperature;

    private double neutronFlux;

    private double tankCapacity;


    public Reactor(ReactorDTO reactorDTO){
        this.reactorType = reactorDTO.reactorType();
        this.temperature = reactorDTO.temperature();
        this.neutronFlux = reactorDTO.neutronFlux();
        this.tankCapacity = reactorDTO.tankCapacity();
    }

}
