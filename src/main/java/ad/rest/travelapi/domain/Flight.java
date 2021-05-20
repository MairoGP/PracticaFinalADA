package ad.rest.travelapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String flightNumber;

    @Column(nullable = false)
    private Date departureDate;

    @Column(nullable = false)
    private Date arrivalDate;

    @Column(nullable = false)
    private Time departureTime;

    @Column(nullable = false)
    private Time arrivalTime;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name="origin_airport_id")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name="destination_airport_id")
    private Airport destination;

    @ManyToOne
    @JoinColumn(name="airline", unique = true)
    private Airline airline;

    @OneToMany
    @JoinColumn(name="flight_id")
    private Set<Passenger> passengers = new HashSet<>();
}
