package com.projeto.simulacao.FissaoNuclear.Services;

import com.projeto.simulacao.FissaoNuclear.DTO.ReactorDTO;
import com.projeto.simulacao.FissaoNuclear.DTO.ReactorSizeDTO;
import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import com.projeto.simulacao.FissaoNuclear.Models.Reactor;
import com.projeto.simulacao.FissaoNuclear.Repository.ChemicalElementRepository;
import com.projeto.simulacao.FissaoNuclear.Repository.ReactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactorService {

    @Autowired
    private ReactorRepository reactorRepository;

    @Autowired
    private ChemicalElementRepository chemicalElementRepository;

    @Autowired
    private ReactorSizeService reactorSizeService;

    private boolean isAllowed;

    public Reactor createReactor(ReactorDTO reactorDTO){
        //ChemicalElement chemicalElement = this.chemicalElementRepository.findChemicalByName(String.valueOf(reactorDTO.chemicalElement()));
        ChemicalElement chemicalElement = new ChemicalElement();
        Reactor newReactor = new Reactor(reactorDTO, chemicalElement);
        this.saveReactor(newReactor);
        return newReactor;
    }

    public void saveReactor(Reactor reactor){
        this.reactorRepository.save(reactor);
    }

    public List<Reactor> getAllReactors(){
        return this.reactorRepository.findAll();
    }

    public Reactor getReactorById(int id){
        return this.reactorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    /*public ChemicalElement getChemicalByName(ChemicalElement nameChemical){
        return this.chemicalElementRepository.findChemicalByName(nameChemical.getName());
    }*/

//    @Transactional
//    public void deleteReactorById(int id){
//       this.reactorRepository.deleteById(id);
//    }
//
//    public Reactor updateReactor(ReactorUpdateDTO reactorUpdateDTO, int id) {
//        Reactor reactorUpdate = this.getReactorById(id);
//        if (reactorUpdate != null){
//            reactorUpdate.setReactorType(reactorUpdateDTO.reactorType());
//            reactorUpdate.setFuelCapacity(reactorUpdateDTO.fuelCapacity()); //CHANGE FOR FUEL_CAPACITY
//            reactorUpdate.setModeratorType(reactorUpdateDTO.moderatorType()); //CHANGE FOR MODERATOR_TYPE
//        }
//        return reactorUpdate;
//    }


    public boolean isReactorSizeAllowed(ReactorSizeDTO reactorSizeDTO){
        reactorSizeService.calculateCylinderStress(reactorSizeDTO.diameter(), reactorSizeDTO.radius(), reactorSizeDTO.wallThickness());
        return isAllowed;
    }

}
