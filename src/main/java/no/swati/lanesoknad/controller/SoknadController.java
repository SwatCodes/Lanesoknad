package no.swati.lanesoknad.controller;

import no.swati.lanesoknad.model.Soknad;
import no.swati.lanesoknad.service.SoknadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/soknad")
public class SoknadController {
    private final SoknadService soknadservice;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public SoknadController(SoknadService soknadservice) {
        this.soknadservice = soknadservice;
    }

    @GetMapping("/{soknadId}")
    public ResponseEntity<String> getSoknadStatus(@PathVariable Long soknadId) {
        String status = soknadservice.getSoknad(soknadId);
        log.debug("Status of soknad with ID {} is {}",soknadId, status);
        return ResponseEntity.ok(status);
    }

    @PostMapping("/")
    public ResponseEntity<Long> addSoknad(@Valid @RequestBody Soknad soknad) {
        Long id = soknadservice.addSoknad(soknad);
        log.debug("Soknad is saved with ID {}", id);
        return ResponseEntity.ok(id);
    }

}
