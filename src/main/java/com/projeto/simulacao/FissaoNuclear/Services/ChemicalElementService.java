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

    public ChemicalElement checkChemicalElementByName(String nameChemical){
        this.testeNameChemical(nameChemical);
        if (nameChemical == null || nameChemical.isEmpty()){
            //Trocar por uma exceção personalizada para (BAD_REQUEST) caso o elemento seja apresentado vazio;
            //E caso já hovuer uma execeção que trate este erro ao criar o reator, desconsiderar tal e usar apenas a execeção abaixo.
            throw new RuntimeException();
        }
        //ChemicalElement chemicalElement = this.chemicalElementRepository.findChemicalByName(nameChemical);
        ChemicalElement chemicalElement = new ChemicalElement();
        if (chemicalElement == null){
            //Trocar por uma execeção personalizada para (BAD_REQUEST) em casos de elemento apresentado mas não existente (BAD_REQUEST);
            throw new RuntimeException();
        }
        return chemicalElement;
    }


    //Função procura dentro do banco de dados se o elemento quimico existe requisitado pelo usuario.
    //Caso ele não exista irá retornar ao usuario uma execeção personalziada (BAD_REQUEST).
    public boolean testeNameChemical(String nameChemical){
        return this.chemicalElementRepository.existByName(nameChemical);
    }
}
