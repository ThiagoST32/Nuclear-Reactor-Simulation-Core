package com.projeto.simulacao.FissaoNuclear.Repository;

import com.projeto.simulacao.FissaoNuclear.Models.SimulationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationLogRepository extends JpaRepository <SimulationLog, Integer>{
}
