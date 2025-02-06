package com.projeto.simulacao.FissaoNuclear.Models;

import com.projeto.simulacao.FissaoNuclear.DTO.ReactorStateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReactorState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String state;

    private Timestamp dateTime;

    private double neutronFlux;

    private int temperature;

    private int pressure;

    private double coolantFlowRate;


    private ReactorState(ReactorStateDTO reactorStateDTO){
        this.dateTime = reactorStateDTO.dateTime();
        this.neutronFlux = reactorStateDTO.neutronFlux();
        this.temperature = reactorStateDTO.temperature();
        this.pressure = reactorStateDTO.pressure();
        this.coolantFlowRate = reactorStateDTO.coolantFlowRate();
    }
}
