package com.projeto.simulacao.FissaoNuclear.Repository;

import com.projeto.simulacao.FissaoNuclear.Models.Reactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactorRepository extends JpaRepository<Reactor, Integer> {

    Optional<Reactor> findById(Integer integer);
}
