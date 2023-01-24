package it.unimol.gelid.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}