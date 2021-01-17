package no.swati.lanesoknad.controller;

import no.swati.lanesoknad.model.Soknad;
import no.swati.lanesoknad.service.SoknadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SoknadController {
    @Autowired
    private SoknadService soknadservice;

    @GetMapping("/soknad/{id}")
    public Soknad getSoknad(@PathVariable Long soknadId) {
        return soknadservice.getSoknad(soknadId);
    }

    @PostMapping("/soknad")
    public void addSoknad(@RequestBody Soknad soknad) {
        soknadservice.addSoknad(soknad);
    }

}
