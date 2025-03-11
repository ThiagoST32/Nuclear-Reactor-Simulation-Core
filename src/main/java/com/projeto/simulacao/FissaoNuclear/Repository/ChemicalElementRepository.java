package com.projeto.simulacao.FissaoNuclear.Repository;

import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChemicalElementRepository extends JpaRepository <ChemicalElement, String>{

    @Query(value = "SELECT ch FROM chemical_element WHERE chemical_name LIKE %:name%", nativeQuery = true)
    ChemicalElement findChemicalByName(@Param("name") String name);
}
