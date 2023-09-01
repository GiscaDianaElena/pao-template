package ro.pao.model;

import lombok.experimental.SuperBuilder;
import ro.pao.model.Tratament;
import java.util.List;
import lombok.*;
// import ro.pao.model.tool.ToolCardiolog;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public non-sealed class Cardiolog extends Medici {

    @Override
    public String toString() {
        return "Cardiolog " + getPrenume() + " " + getNume() + ": " + " email: " + getEmail()
                + ", CNP: " + getCNP() + ", numar telefon: " + getNumarTelefon() + ", adresa: " + getAdresa()
                + ", data angajare: " + getData_angajare() + ", experienta: " + getExperienta()
                + ", salariu: " + getSalariu() + ", Programari: " + getProgramareList();
    }
}
