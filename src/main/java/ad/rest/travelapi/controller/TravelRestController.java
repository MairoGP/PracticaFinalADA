package ad.rest.travelapi.controller;

import ad.rest.travelapi.domain.Airline;
import ad.rest.travelapi.domain.Airport;
import ad.rest.travelapi.domain.Flight;
import ad.rest.travelapi.domain.Passenger;
import ad.rest.travelapi.exception.PassengerNotFoundException;
import ad.rest.travelapi.repository.*;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TravelRestController {
    private final Log log = LogFactory.getLog(TravelRestController.class);

    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final SeatRepository seatRepository;

    public TravelRestController(AirlineRepository airlineRepository, AirportRepository airportRepository, FlightRepository flightRepository,PassengerRepository passengerRepository , SeatRepository seatRepository) {
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.seatRepository = seatRepository;
    }


    //Listar datos
    @GetMapping("/flights")
    List<Flight> getAllFlights(){
        return (List<Flight>)flightRepository.findAll();
    }

    @GetMapping("/airports")
    List<Airport> getAllAirports(){
        return (List<Airport>) airportRepository.findAll();
    }

    @GetMapping("/airlines")
    List<Airline> getAllAirlines(){
        return (List<Airline>) airlineRepository.findAll();
    }

    @GetMapping("/passengers")
    List<Passenger> getAllPassengers(){
        return (List<Passenger>) passengerRepository.findAll();
    }

    @GetMapping("/passengers/{id}")
    Optional<Passenger> one (@PathVariable Long id){
        return passengerRepository.findById(id);
    }

    //Información paginada u ordenada
    @GetMapping("/passengers-page")
    Page<Passenger> getPagedPassengers(@RequestParam Optional<Integer> nPage, @RequestParam Optional<Integer> size , Pageable pageableIn){
        log.info("PassengersPage");
        //return passengerRepository.findAll(new PageRequest(nPage.orElse(0),size.orElse(20)));

        Pageable pageable = PageRequest.of(nPage.orElse(0),size.orElse(20));
        Page<Passenger> result = passengerRepository.findAll(pageable);
        if(result.isEmpty()){
            throw new PassengerNotFoundException("Error al encontrar pagina de passenger: "+1);
        }else{
            return result;
        }
    }

    @GetMapping("/passengers-sort")
    List<Passenger> getPassengersSorted(@RequestParam Optional<String> order_by, @RequestParam Optional<String> dir){
        Sort.Direction direction = Sort.Direction.ASC;
        if(dir.isEmpty()){

        }else {
            switch (dir.get()) {
                case "asc":
                    direction = Sort.Direction.ASC;
                case "desc":
                    direction = Sort.Direction.DESC;
            }
        }
        return passengerRepository.findAll(Sort.by(direction, order_by.orElse("id")));
    }
}
