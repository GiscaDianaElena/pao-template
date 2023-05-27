package ro.pao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Period;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Promotii {
    private String numePromotie;
    private String descriere;
    private Period perioada;
    private String codPromotional;
    private String restrictii;

    public Promotii(String numePromotie, String descriere, Period perioada, String codPromotional, String restrictii){
        this.numePromotie = numePromotie;
        this.descriere = descriere;
        this.perioada = perioada;
        this.codPromotional = codPromotional;
        this.restrictii = restrictii;
    }

    public String getNumePromotie() {
        return numePromotie;
    }

    public void setNumePromotie(String numePromotie) {
        this.numePromotie = numePromotie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Period getPerioada() {
        return perioada;
    }

    public void setPerioada(Period perioada) {
        this.perioada = perioada;
    }

    public String getCodPromotional() {
        return codPromotional;
    }

    public void setCodPromotional(String codPromotional) {
        this.codPromotional = codPromotional;
    }

    public String getRestrictii() {
        return restrictii;
    }

    public void setRestrictii(String restrictii) {
        this.restrictii = restrictii;
    }

    public String toString(){
        return "Nume Promotie " + numePromotie + ", Descriere: " + descriere + ", Perioada: " + perioada +
                ", Cod Promotional: " + codPromotional + ", Restrictii: " + restrictii;
    }
}
