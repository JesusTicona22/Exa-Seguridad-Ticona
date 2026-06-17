package pe.edu.upeu.seguridadexa.auth.errors;

public class ConflictException extends ApiException {

    public ConflictException(String message) {
        super(message, 409);
    }
}