package monprojet;

import jakarta.persistence.*;
import lombok.*;
import monprojet.entity.Country;
import javax.*

@Getter @Setter @ToString @RequiredArgsConstructor @NoArgsConstructor @Entity
public class City {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private integer id;
    @Column(unique = true)
    @NonNull
    private String name;

    private int population;

    @ManyToOne(optional = false)
    private Country country;
}
