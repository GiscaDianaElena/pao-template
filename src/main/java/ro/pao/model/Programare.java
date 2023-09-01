package ro.pao.model;

import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
public class Programare {
    private UUID idProgramare;
    private String data;
    private Double pret;

    public Programare(UUID idProgramare, String data, double pret){
        this.idProgramare = idProgramare;
        this.data = data;
        this.pret = pret;
    }


    @Override
    public String toString() {
        return "Appointment: " + data + ", Pret: " + pret;
    }

    public boolean obtinePret() {
        return false;
    }
}