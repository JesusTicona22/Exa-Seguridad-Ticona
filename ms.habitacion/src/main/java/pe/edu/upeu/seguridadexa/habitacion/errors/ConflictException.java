package pe.edu.upeu.seguridadexa.habitacion.errors;

public class ConflictException extends ApiException {

    public ConflictException(String message) {
        super(message, 409);
    }
}