package Services;

import DTO.ReactorDTO;
import DTO.ReactorSizeDTO;
import DTO.UpdateDTOS.ReactorUpdateDTO;
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

    private boolean isAllowed = false;

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

        return isAllowed;
    }

}
