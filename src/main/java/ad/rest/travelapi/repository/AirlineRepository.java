package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Airline;
import org.springframework.data.repository.CrudRepository;

public interface AirlineRepository extends CrudRepository<Airline, Long> {

}
