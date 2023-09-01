package ro.pao.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ro.pao.model.Medici;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Clinici{
    private UUID id;
    private String nume;
    private String adresa;
    private List<Medici> Medici;

    public Clinici(String nume, String adresa){
        this.nume = nume;
        this.adresa = adresa;
        Medici = new ArrayList<>();
    }
}