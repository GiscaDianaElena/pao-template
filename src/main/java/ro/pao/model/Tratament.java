package ro.pao.model;

import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Tratament {
    private UUID idTratament;
    private String nume;
    private Date dataPrescrierii;
    private List<Medicament> medicamentList;

    @Override
    public String toString() {
        return "Tratament: " + idTratament + ", Nume: " + nume + ", Data prescrierii: " + dataPrescrierii +
                ", Lista Medicamente: " + medicamentList;
    }
}