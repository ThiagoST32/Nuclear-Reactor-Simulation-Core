package com.projeto.simulacao.FissaoNuclear.Services;

import com.projeto.simulacao.FissaoNuclear.DTO.ChemicalElementDTO;
import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import com.projeto.simulacao.FissaoNuclear.Repository.ChemicalElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemicalElementService {

    @Autowired
    private ChemicalElementRepository chemicalElementRepository;

    public ChemicalElement chemicalInsertDB (ChemicalElementDTO chemicalElementDTO){
        ChemicalElement saveChemical = new ChemicalElement(chemicalElementDTO);
        return this.chemicalElementRepository.save(saveChemical);
    }
}
