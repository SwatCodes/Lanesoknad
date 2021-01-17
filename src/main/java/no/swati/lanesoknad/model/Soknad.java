package no.swati.lanesoknad.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Soknad {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = {CascadeType.ALL})
    @Valid
    private List<Lanetakere> lanetakere;

    @NotNull
    @Positive(message = "Lanebelop can not be negative")
    private Long lanebelop;

    private String behov;

    @NotNull
    @Positive(message = "Lopetid can not be negative")
    private Long lopetid;

    @NotNull
    @Positive(message = "AvdragsfriPeriode can not be negative")
    private Integer avdragsfriPeriode;

    @NotEmpty(message = "Type should not be empty")
    private String type;

    public Soknad() {
    }

    public Soknad(List<Lanetakere> lanetakere, Long lanebelop, String behov, Long lopetid, Integer avdragsfriPeriode, String type){
        this.lanetakere = lanetakere;
        this.behov = behov;
        this.lopetid = lopetid;
        this.avdragsfriPeriode = avdragsfriPeriode;
        this.type = type;
        this.lanebelop = lanebelop;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Lanetakere> getLanetakere() {
        return lanetakere;
    }

    public void setLanetakere(List<Lanetakere> lanetakere) {
        this.lanetakere = lanetakere;
    }

    public Long getLanebelop() {
        return lanebelop;
    }

    public void setLanebelop(Long lanebelop) {
        this.lanebelop = lanebelop;
    }

    public String getBehov() {
        return behov;
    }

    public void setBehov(String behov) {
        this.behov = behov;
    }

    public Long getLopetid() {
        return lopetid;
    }

    public void setLopetid(Long lopetid) {
        this.lopetid = lopetid;
    }

    public Integer getAvdragsfriPeriode() {
        return avdragsfriPeriode;
    }

    public void setAvdragsfriPeriode(Integer avdragsfriPeriode) {
        this.avdragsfriPeriode = avdragsfriPeriode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
