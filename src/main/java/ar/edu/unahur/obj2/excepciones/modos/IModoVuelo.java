package ar.edu.unahur.obj2.excepciones.modos;

public interface IModoVuelo {

    Double getRendimientoKmPorLitro();
    Double getVelocidadMaximaKm();
    String getNombre();

    default Double calcularCombustibleNecesario(Double distanciaKm){
        return distanciaKm / getRendimientoKmPorLitro();
    }


}
