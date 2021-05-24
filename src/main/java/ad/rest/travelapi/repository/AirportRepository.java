package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Airline;
import ad.rest.travelapi.domain.Airport;
import ad.rest.travelapi.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query(value="SELECT DISTINCT(AIRPORT.* )" +
            "FROM AIRPORT " +
            "  INNER JOIN" +
            "    flight AS f" +
            "    ON airport.id = f.destination_airport_id OR airport.id = f.origin_airport_id" +
            "  INNER JOIN" +
            "    airline AS al" +
            "    ON f.airline = ?1"
            , nativeQuery = true)
    List<Airport> findAirportsByAirline(Long id);

    List<Airport> findByNameContaining(String keyword);
}
