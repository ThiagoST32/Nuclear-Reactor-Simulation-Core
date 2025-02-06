package com.projeto.simulacao.FissaoNuclear.Controller;


import com.projeto.simulacao.FissaoNuclear.DTO.ReactorDTO;
import com.projeto.simulacao.FissaoNuclear.Models.Reactor;
import com.projeto.simulacao.FissaoNuclear.Services.ReactorService;
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

    @PostMapping("/create")
    public ResponseEntity<Reactor> createReactor(@RequestBody ReactorDTO reactorDTO){
        log.info("Creating Reactor!!!");
        Reactor newReactor = reactorService.createReactor(reactorDTO);
        System.out.println(newReactor);
        System.out.println(reactorDTO);
        return new ResponseEntity<>(newReactor, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Reactor>> getAllReactors(){
        log.info("Getting all reactors!!!");
        List<Reactor> reactors = reactorService.getAllReactors();
        return new ResponseEntity<>(reactors, HttpStatus.OK);
    }
}
