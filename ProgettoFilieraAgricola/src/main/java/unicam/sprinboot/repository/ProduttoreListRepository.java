package unicam.sprinboot.repository;

import org.springframework.data.repository.CrudRepository;
import unicam.modelli.actors.azienda.Azienda;

public interface ProduttoreListRepository extends CrudRepository<Azienda,String> {
}
