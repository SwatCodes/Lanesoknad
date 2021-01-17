package no.swati.lanesoknad.repository;

import no.swati.lanesoknad.model.Soknad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoknadRepository extends CrudRepository<Soknad, Long> {
}
