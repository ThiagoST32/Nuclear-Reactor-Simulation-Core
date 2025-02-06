package com.projeto.simulacao.FissaoNuclear.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.simulacao.FissaoNuclear.DTO.ReactorSizeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReactorSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalSize;

    private double diameter;

    private double radius;

    private double wallThickness;

    @OneToOne(mappedBy = "reactorSize")
    @JsonIgnore
    private Reactor reactor;

    public ReactorSize(double totalSize, double diameter, double radius, double wallThickness) {
        this.totalSize = totalSize;
        this.diameter = diameter;
        this.radius = radius;
        this.wallThickness = wallThickness;
    }
}
