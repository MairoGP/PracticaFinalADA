package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(value="SELECT count(*) SEATS, p.flight_id FLIGHT_NUMBER " +
            "FROM seat " +
            "INNER JOIN passenger AS p ON p.seat_id = seat.id AND p.flight_id = ?1", nativeQuery = true)
    Integer findSeatsInFlight(Long flightId);
}
