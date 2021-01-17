package no.swati.lanesoknad.repository;

import no.swati.lanesoknad.model.Lanetakere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanetakereRepository extends CrudRepository<Lanetakere, String> {
}
