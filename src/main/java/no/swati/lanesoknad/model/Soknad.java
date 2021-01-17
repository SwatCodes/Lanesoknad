package no.swati.lanesoknad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Soknad {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Lanetakere> lanetakere = new ArrayList<>();

    private Long laneBelop;

    private String behov;

    private String lopeTid;

    private Integer avdragsFriPeriode;

    private String loanType;

    public Soknad() {
    }

    public Soknad(List<Lanetakere> lanetakere, Long laneBelop, String behov, String lopeTid, Integer avdragsFriPeriode, String loanType ){
        this.lanetakere = lanetakere;
        this.behov = behov;
        this.lopeTid = lopeTid;
        this.avdragsFriPeriode = avdragsFriPeriode;
        this.loanType = loanType;
        this.laneBelop = laneBelop;
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

    public Long getLaneBelop() {
        return laneBelop;
    }

    public void setLaneBelop(Long laneBelop) {
        this.laneBelop = laneBelop;
    }

    public String getBehov() {
        return behov;
    }

    public void setBehov(String behov) {
        this.behov = behov;
    }

    public String getLopeTid() {
        return lopeTid;
    }

    public void setLopeTid(String lopeTid) {
        this.lopeTid = lopeTid;
    }

    public Integer getAvdragsFriPeriode() {
        return avdragsFriPeriode;
    }

    public void setAvdragsFriPeriode(Integer avdragsFriPeriode) {
        this.avdragsFriPeriode = avdragsFriPeriode;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    @Override
    public String toString() {
        return "Soknad{" +
                "id=" + id +
                ", lanetakere=" + lanetakere +
                ", laneBelop=" + laneBelop +
                ", behov='" + behov + '\'' +
                ", lopeTid='" + lopeTid + '\'' +
                ", avdragsFriPeriode=" + avdragsFriPeriode +
                ", loanType='" + loanType + '\'' +
                '}';
    }
}
