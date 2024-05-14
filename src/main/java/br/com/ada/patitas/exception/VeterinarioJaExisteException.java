package br.com.ada.patitas.exception;

public class VeterinarioJaExisteException extends RuntimeException{
    public VeterinarioJaExisteException(final String msg){
        super(msg);
    }
}
