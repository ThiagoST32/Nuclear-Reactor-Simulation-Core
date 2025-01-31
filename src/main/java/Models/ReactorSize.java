package Models;

import DTO.ReactorSizeDTO;
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
public class ReactorSize {
    @Id
    private int id;

    private double totalSize;

    private double diameter;

    private double ray;

    private double wallThickness;

    public ReactorSize(ReactorSizeDTO reactorSizeDTO) {
        this.diameter = reactorSizeDTO.diameter();
        this.ray = reactorSizeDTO.ray();
        this.wallThickness = reactorSizeDTO.wallThickness();
    }

    public ReactorSize(double diameter, double ray, double wallThickness) {
        this.diameter = diameter;
        this.ray = ray;
        this.wallThickness = wallThickness;
    }
}
