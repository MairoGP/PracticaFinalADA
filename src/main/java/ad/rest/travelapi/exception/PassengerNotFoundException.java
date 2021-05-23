package ad.rest.travelapi.exception;

public class PassengerNotFoundException extends RuntimeException{
    public PassengerNotFoundException(String message){
        super(message);
    }
}

