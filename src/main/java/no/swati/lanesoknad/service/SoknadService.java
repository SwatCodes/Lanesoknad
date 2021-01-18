package no.swati.lanesoknad.service;

import no.swati.lanesoknad.model.Soknad;
import no.swati.lanesoknad.repository.SoknadRepository;
import org.springframework.stereotype.Service;

@Service
public class SoknadService {
    private final SoknadRepository soknadRepository;

    public SoknadService(SoknadRepository soknadRepository) {
        this.soknadRepository = soknadRepository;
    }

    public String getSoknad(Long id) {
        return soknadRepository.findById(id).isPresent() ? "Mottatt" : "Ukjent";
    }

    public Long addSoknad(Soknad soknad) {
        return soknadRepository.save(soknad).getId();
    }


}
