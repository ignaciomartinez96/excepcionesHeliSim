package ar.edu.unahur.obj2.excepciones.modos;

public class ModoAgresivo implements IModoVuelo {

    @Override
    public Double getRendimientoKmPorLitro() {
        return 6.0;
    }

    @Override
    public Double getVelocidadMaximaKm() {
        return 280.0;
    }

    @Override
    public String getNombre() {
        return "Agresivo";
    }

}
