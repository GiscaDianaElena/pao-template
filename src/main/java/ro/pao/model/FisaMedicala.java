package ro.pao.model;

import java.time.LocalDate;

public class FisaMedicala {
    private Pacient pacient;
    private Medici medic;
    private LocalDate data;
    private String medicamente;
    private String alergii;
    private String boliCronice;
    private RezultatAnalize rezultateAnalize;

    public FisaMedicala(Pacient pacient, Medici medic, LocalDate data, String medicamente, String alergii,
                        String boliCronice, RezultatAnalize rezultateAnalize){
        this.pacient = pacient;
        this.medic = medic;
        this.data = data;
        this.medicamente = medicamente;
        this.alergii = alergii;
        this.boliCronice = boliCronice;
        this.rezultateAnalize = rezultateAnalize;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Medici getMedic() {
        return medic;
    }

    public void setMedic(Medici medic) {
        this.medic = medic;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(String medicamente) {
        this.medicamente = medicamente;
    }

    public String getAlergii() {
        return alergii;
    }

    public void setAlergii(String alergii) {
        this.alergii = alergii;
    }

    public String getBoliCronice() {
        return boliCronice;
    }

    public void setBoliCronice(String boliCronice) {
        this.boliCronice = boliCronice;
    }

    public RezultatAnalize getRezultateAnalize() {
        return rezultateAnalize;
    }

    public void setRezultateAnalize(RezultatAnalize rezultateAnalize) {
        this.rezultateAnalize = rezultateAnalize;
    }
}
