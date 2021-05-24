package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * " +
            "FROM flight " +
            "WHERE (ORIGIN_AIRPORT_ID = ?1 OR DESTINATION_AIRPORT_ID = ?1) AND AIRLINE = ?2", nativeQuery = true)
    List<Flight> findFlightsByAirportAirline(Long id_airport,Long airline_id);


}
