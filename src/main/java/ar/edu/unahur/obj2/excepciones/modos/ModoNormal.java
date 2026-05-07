package ar.edu.unahur.obj2.excepciones.modos;

public class ModoNormal implements IModoVuelo{

    @Override
    public Double getRendimientoKmPorLitro() {
        return 9.0;
    }

    @Override
    public Double getVelocidadMaximaKm() {
        return 220.0;
    }

    @Override
    public String getNombre() {
        return "Normal";
    }



}
