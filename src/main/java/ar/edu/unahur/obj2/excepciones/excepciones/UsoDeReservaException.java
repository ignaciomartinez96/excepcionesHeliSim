package ar.edu.unahur.obj2.excepciones.excepciones;

public class UsoDeReservaException extends RuntimeException{

    public UsoDeReservaException(Double reserva){
        super("El vuelo uso la reserva de combustible margen: " 
        + reserva + " litros - Reargas entres del próximo vuelo.");
    }

}
