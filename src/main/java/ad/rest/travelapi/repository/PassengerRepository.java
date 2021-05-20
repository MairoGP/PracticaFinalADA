package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
}
