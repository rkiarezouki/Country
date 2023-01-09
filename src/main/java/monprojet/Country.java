package monprojet;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Proxy;

import java.util.*;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString @Proxy (lazy=false)
@Entity
public class Country {
    @Id @GeneratedValue (Strategy = GeneratedValue.IDENTITY)
    private  Integer id;

    @Column(unique=true)
    @NonNull
    private String code;

    @Column(unique=true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "country")
    @ToString.Exclude
    private List<City> cities = new ArrayList<>();

}
