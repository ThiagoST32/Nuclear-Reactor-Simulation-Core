package com.projeto.simulacao.FissaoNuclear.DTO;

import java.sql.Timestamp;

public record ReactorStateDTO (Timestamp dateTime, double neutronFlux, int temperature, int pressure, double coolantFlowRate) {
}
