package br.com.ada.patitas.exception;

public class PacienteJaExisteException extends RuntimeException{
    public PacienteJaExisteException(final String msg){
        super(msg);
    }
}
