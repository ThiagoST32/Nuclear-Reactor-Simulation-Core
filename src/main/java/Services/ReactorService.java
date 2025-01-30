package Services;

import DTO.ReactorDTO;
import Models.Reactor;
import Repository.ReactorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactorService {

    @Autowired
    private ReactorRepository reactorRepository;

    public Reactor createReactor(ReactorDTO reactorDTO){
        Reactor newReactor = new Reactor(reactorDTO);
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
        return this.reactorRepository.findById(id).orElseThrow(() -> new RuntimeException("Reactor not Found!!"));
    }

    @Transactional
    public void deleteReactorById(int id){
       this.reactorRepository.deleteById(id);
    }

    public Reactor updateReactor(ReactorUpdateDTO reactorUpdateDTO,int id) {
        Reactor reactorUpdate = this.getReactorById(id);
        if (reactorUpdate != null){
            reactorUpdate.setReactorType(reactorUpdateDTO.getReactorType);
            reactorUpdate.setTankCapacity(reactorUpdateDTO.getTankCapacity); //CHANGE FOR FUEL_CAPACITY
            reactorUpdate.setNeutronFlux(reactorUpdateDTO.getNeutroFlux); //CHANGE FOR MODERATOR_TYPE
        }
        return reactorUpdate;
    }

}
