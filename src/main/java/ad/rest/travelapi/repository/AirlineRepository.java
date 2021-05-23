package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Airline;
import ad.rest.travelapi.domain.Airport;
import ad.rest.travelapi.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Long> {


}
