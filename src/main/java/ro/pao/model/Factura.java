package ro.pao.model;

import java.time.LocalDateTime;

public class Factura {
    private int numarFactura;
    private LocalDateTime dataEmiterii;
    private Pacient pacient;
    private ServiciiMedicale serviciiMedicale;
    private double total;
    private Status status;

    public Factura(int numarFactura, LocalDateTime dataEmiterii, Pacient pacient, ServiciiMedicale serviciiMedicale,
                   double total, Status status){
        this.numarFactura = numarFactura;
        this.dataEmiterii = dataEmiterii;
        this.pacient = pacient;
        this.serviciiMedicale = serviciiMedicale;
        this.total = total;
        this.status = status;
    }

    public int getNumarFactura() {
        return numarFactura;
    }

    public void setNumarFactura(int numarFactura) {
        this.numarFactura = numarFactura;
    }

    public LocalDateTime getDataEmiterii() {
        return dataEmiterii;
    }

    public void setDataEmiterii(LocalDateTime dataEmiterii) {
        this.dataEmiterii = dataEmiterii;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public ServiciiMedicale getServiciiMedicale() {
        return serviciiMedicale;
    }

    public void setServiciiMedicale(ServiciiMedicale serviciiMedicale) {
        this.serviciiMedicale = serviciiMedicale;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
