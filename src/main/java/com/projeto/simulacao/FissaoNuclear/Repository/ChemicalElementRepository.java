package com.projeto.simulacao.FissaoNuclear.Repository;

import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChemicalElementRepository extends JpaRepository <ChemicalElement, String>{

    /*@Query(value = "SELECT ch FROM chemical_element WHERE chemical_name LIKE %:name%", nativeQuery = true)
    ChemicalElement findChemicalByName(@Param("name") String name);*/

    @Query(value = """
            SELECT CASE WHEN COUNT (chemical_name) > 0 THEN TRUE ELSE FALSE END
            FROM "CHEMICAL_ELEMENT"
            WHERE CHEMICAL_NAME = :chemicalName;
            """, nativeQuery = true)
    boolean existByName(@Param("chemicalName") String chemicalName);
}
