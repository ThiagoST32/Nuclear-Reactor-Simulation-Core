package com.projeto.simulacao.FissaoNuclear.Repository;

import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChemicalElementRepository extends JpaRepository <ChemicalElement, Integer>{

    /*@Query("SELECT ch FROM chemical_element ch WHERE ch.chemical_name LIKE %:name%")
    ChemicalElement findChemicalByName(@Param("name") String name);*/
}
