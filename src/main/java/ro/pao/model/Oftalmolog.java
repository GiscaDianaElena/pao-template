package ro.pao.model;
// import ro.pao.model.Tratament.Medicament;
import java.util.List;
import lombok.experimental.SuperBuilder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public non-sealed class Oftalmolog extends Medici {

    @Override
    public String toString() {
        return "Ophthalmologist " + getPrenume() + " " + getNume() + ": " + " email: " + getEmail()
                + ", CNP: " + getCNP() + ", numar telefon: " + getNumarTelefon() + ", adresa: " + getAdresa()
                + ", data angajare: " + getData_angajare() + ", experienta: " + getExperienta()
                + ", salariu: " + getSalariu() + ", Programari: " + getProgramareList();
    }
}