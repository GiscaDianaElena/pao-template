package ro.pao.model;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Medicament {
    private String tipMedicament;
    private UUID id;
    private String nume;
    private double pret;

    public String toString() {
        return "Medicament: " + id + ", Nume: " + nume + ", Tip medicament: " + tipMedicament +", Pret: " + pret;
    }
}