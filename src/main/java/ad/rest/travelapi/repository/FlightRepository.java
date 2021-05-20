package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
}
