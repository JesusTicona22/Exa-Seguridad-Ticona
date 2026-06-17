package pe.edu.upeu.seguridadexa.auth.errors;

public class NotFoundException extends ApiException {

    public NotFoundException(String message) {
        super(message, 404);
    }
}