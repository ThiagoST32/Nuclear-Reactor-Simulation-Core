package com.projeto.simulacao.FissaoNuclear.Repository;

import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemicalElementRepository extends JpaRepository <ChemicalElement, Integer>{
}
