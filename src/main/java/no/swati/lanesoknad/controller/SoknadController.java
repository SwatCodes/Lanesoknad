package no.swati.lanesoknad.controller;

import no.swati.lanesoknad.model.Soknad;
import no.swati.lanesoknad.service.SoknadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SoknadController {
    @Autowired
    private SoknadService soknadservice;

    @GetMapping("/soknad/{soknadId}")
    public ResponseEntity<String> getSoknad(@PathVariable Long soknadId) {
        return ResponseEntity.ok(soknadservice.getSoknad(soknadId));
    }

    @PostMapping("/soknad")
    public ResponseEntity<Long> addSoknad(@Valid @RequestBody Soknad soknad) {
        return ResponseEntity.ok(soknadservice.addSoknad(soknad));
    }

}
