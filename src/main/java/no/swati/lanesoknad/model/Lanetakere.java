package no.swati.lanesoknad.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Lanetakere {
    @Id
    private String fnr;
    private String navn;

    public Lanetakere() {
    }
    public Lanetakere(String fnr, String navn) {
        this.fnr = fnr;
        this.navn = navn;
    }

    public String getFnr() {
        return fnr;
    }

    public void setFnr(String fnr) {
        this.fnr = fnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lanetakere that = (Lanetakere) o;
        return Objects.equals(fnr, that.fnr) &&
                Objects.equals(navn, that.navn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fnr, navn);
    }

    @Override
    public String toString() {
        return "Lanetakere{" +
                "fnr='" + fnr + '\'' +
                ", navn='" + navn + '\'' +
                '}';
    }
}
