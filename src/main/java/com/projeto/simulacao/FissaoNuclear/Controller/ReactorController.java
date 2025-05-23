package com.projeto.simulacao.FissaoNuclear.Controller;


import com.projeto.simulacao.FissaoNuclear.DTO.ChemicalElementDTO;
import com.projeto.simulacao.FissaoNuclear.DTO.ReactorDTO;
import com.projeto.simulacao.FissaoNuclear.DTO.ReactorSizeDTO;
import com.projeto.simulacao.FissaoNuclear.Models.ChemicalElement;
import com.projeto.simulacao.FissaoNuclear.Models.Reactor;
import com.projeto.simulacao.FissaoNuclear.Models.ReactorSize;
import com.projeto.simulacao.FissaoNuclear.Services.ChemicalElementService;
import com.projeto.simulacao.FissaoNuclear.Services.ReactorService;
import com.projeto.simulacao.FissaoNuclear.Services.ReactorSizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reactor")
@Validated
public class ReactorController {

    private static final Logger log = LoggerFactory.getLogger(ReactorController.class);
    @Autowired
    private ReactorService reactorService;

    @Autowired
    private ReactorSizeService reactorSizeService;

    @Autowired
    private ChemicalElementService chemicalElementService;

//    @PostMapping("/create")
//    public ResponseEntity<String> validateReactor(@RequestBody ReactorSizeDTO reactorSizeDTO, @RequestBody ReactorDTO reactorDTO, @RequestBody ChemicalElementDTO chemicalElementDTO){
//
//        boolean isCylinderValid = this.reactorSizeService.calculateCylinderStress(
//          reactorDTO.maxPressure(),
//                reactorSizeDTO.radius(),
//                reactorSizeDTO.wallThickness()
//        );
//
//        boolean isSphereValid = this.reactorSizeService.calculateSphereStress(
//                reactorDTO.maxPressure(),
//                reactorSizeDTO.radius(),
//                reactorSizeDTO.wallThickness()
//        );
//
//        boolean isCoreValid = this.reactorSizeService.calculateTankCapacity(
//                reactorDTO.coreMaxVolume(),
//                chemicalElementDTO.
//        )
//
//    }

    @PostMapping("/create")
    public ResponseEntity<Reactor> createReactor(@RequestBody ReactorDTO reactorDTO){
        Reactor newReactor = reactorService.createReactor(reactorDTO);
        return new ResponseEntity<>(newReactor, HttpStatus.CREATED);
    }

    @PostMapping("/chemicalElement")
    public ResponseEntity<ChemicalElement> registerElement(@RequestBody ChemicalElementDTO chemicalElementDTO){
        ChemicalElement saveElement = this.chemicalElementService.chemicalInsertDB(chemicalElementDTO);
        return new ResponseEntity<>(saveElement, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Reactor>> getAllReactors(){
        List<Reactor> reactors = reactorService.getAllReactors();
        return new ResponseEntity<>(reactors, HttpStatus.OK);
    }

    @GetMapping("/teste/{name}")
    public ResponseEntity<Boolean> checkIfExistChemicalElement(@PathVariable String name){
        boolean checkElement = this.chemicalElementService.testeNameChemical(name);
        return new ResponseEntity<>(checkElement, HttpStatus.ACCEPTED);
    }
}
