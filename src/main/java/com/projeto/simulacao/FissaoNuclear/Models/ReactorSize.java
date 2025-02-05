package com.projeto.simulacao.FissaoNuclear.Models;

import com.projeto.simulacao.FissaoNuclear.DTO.ReactorSizeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class ReactorSize {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalSize;

    private double diameter;

    private double radius;

    private double wallThickness;

    public ReactorSize(ReactorSizeDTO reactorSizeDTO) {
        this.diameter = reactorSizeDTO.diameter();
        this.radius = reactorSizeDTO.radius();
        this.wallThickness = reactorSizeDTO.wallThickness();
    }
}
