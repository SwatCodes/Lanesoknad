package no.swati.lanesoknad.service;

import no.swati.lanesoknad.model.Soknad;
import no.swati.lanesoknad.repository.SoknadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoknadService {
    @Autowired
    private SoknadRepository soknadRepository;

    public String getSoknad(Long id) {
        return soknadRepository.findById(id).isPresent() ? "Mottatt" : "Ukjent";
    }

    public Long addSoknad(Soknad soknad) {
        return soknadRepository.save(soknad).getId();
    }


}
