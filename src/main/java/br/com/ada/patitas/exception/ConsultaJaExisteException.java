package br.com.ada.patitas.exception;

public class ConsultaJaExisteException extends RuntimeException{
    public ConsultaJaExisteException(final String msg){
        super(msg);
    }
}
