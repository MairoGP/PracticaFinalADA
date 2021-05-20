package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {
}
