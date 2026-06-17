package pe.edu.upeu.seguridadexa.hotel.errors;

public class BadRequestException extends ApiException {

    public BadRequestException(String message) {
        super(message, 400);
    }
}