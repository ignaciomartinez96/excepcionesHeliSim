package ar.edu.unahur.obj2.excepciones.modos;

public class ModoEficiente implements IModoVuelo{

    @Override
    public Double getRendimientoKmPorLitro() {
        return 14.0;
    }

    @Override
    public Double getVelocidadMaximaKm() {
        return 180.0;
    }

    @Override
    public String getNombre() {
        return "Eficiente";
    }

}
