package ad.rest.travelapi.domain;

import javax.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String idNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    private String email;

    @Column(nullable = false)
    private char gender;

    @OneToOne
    @JoinColumn(name="seat_id")
    private Seat seat;
}
