package ro.pao.model;

import java.time.Period;

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
}
