package ar.edu.unahur.obj2.excepciones.excepciones;

public class EstadoInvalidoException extends RuntimeException{

    private String message;

    public EstadoInvalidoException(String message){
        this.message = message;
    }


}
