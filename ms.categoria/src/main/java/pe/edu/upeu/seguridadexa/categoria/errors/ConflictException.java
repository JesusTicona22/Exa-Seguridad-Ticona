package pe.edu.upeu.seguridadexa.categoria.errors;

public class ConflictException extends ApiException {

    public ConflictException(String message) {
        super(message, 409);
    }
}