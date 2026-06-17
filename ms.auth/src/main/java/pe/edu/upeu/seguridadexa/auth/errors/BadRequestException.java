package pe.edu.upeu.seguridadexa.auth.errors;

public class BadRequestException extends ApiException {

    public BadRequestException(String message) {
        super(message, 400);
    }
}