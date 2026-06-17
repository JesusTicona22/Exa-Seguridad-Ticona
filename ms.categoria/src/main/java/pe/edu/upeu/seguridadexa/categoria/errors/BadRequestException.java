package pe.edu.upeu.seguridadexa.categoria.errors;

public class BadRequestException extends ApiException {

    public BadRequestException(String message) {
        super(message, 400);
    }
}