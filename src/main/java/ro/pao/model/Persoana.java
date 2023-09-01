package ro.pao.model;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class Persoana {
    protected String idPersoana;

    protected String nume;
    protected String prenume;
    protected String email;
    protected String CNP;
    protected String numarTelefon;
    protected String adresa;

    @Override
    public String toString() {
        return "Persoana " + nume + " " + prenume + ": " + " email: " + email
                + ", CNP: " + CNP + ", numar telefon: " + numarTelefon + ", adresa: " + adresa;
    }
}
