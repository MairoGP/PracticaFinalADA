package ad.rest.travelapi.repository;

import ad.rest.travelapi.domain.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
}
