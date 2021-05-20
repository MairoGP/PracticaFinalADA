package ad.rest.travelapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "origin")
    @JsonIgnore
    private Set<Flight> arrivals = new HashSet<>();

    @OneToMany(mappedBy = "destination")
    @JsonIgnore
    private Set<Flight> departures = new HashSet<>();
}
