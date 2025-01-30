package Repository;

import Models.Reactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactorRepository extends JpaRepository<Reactor, Integer> {

    Optional<Reactor> findById(Integer integer);
}
