package no.swati.lanesoknad.controller;

import no.swati.lanesoknad.model.Soknad;
import no.swati.lanesoknad.service.SoknadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SoknadController.class)
class SoknadControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private SoknadService soknadService;

    @Test
    public void getStatus_Mottatt_for_given_soknadId() throws Exception {
        when(soknadService.getSoknad(1L)).thenReturn("Mottatt");
        mvc.perform(get("/soknad/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Mottatt"));
    }

    @Test
    public void getStatus_Ukjent_for_given_soknadId() throws Exception {
        when(soknadService.getSoknad(2L)).thenReturn("Ukjent");
        mvc.perform(get("/soknad/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Ukjent"));
    }

    @Test
    public void addSoknad_returns_soknadId() throws Exception {
        when(soknadService.addSoknad(any(Soknad.class))).thenReturn(1L);
        mvc.perform(post("/soknad/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"lanetakere\": [{ \"fnr\" : \"12345\", \"navn\" : \"Kari Nordmann\" } , { \"fnr\" : \"01056000301\", \"navn\" : \"Ola Nordmann\" }], \"lanebelop\": 2450000,\n" +
                        "  \"behov\": \"Vi skal låne penger til........\",\n" +
                        "  \"lopetid\": 300,\n" +
                        "  \"avdragsfriPeriode\": 12,\n" +
                        "  \"type\": \"gty\"}"))
                .andExpect(status().isOk());
    }

}