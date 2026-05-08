package ar.edu.unahur.obj2.excepciones.helicopteros;



public class HelicopteroCivil extends Helicoptero{

    public HelicopteroCivil(Double combustible, Double capacidadTanque) {
        super(combustible, capacidadTanque);
    }

    @Override
    protected void finalizarVuelo(Double kilometraje2) {
        registrarEnBitacora("vuelo civil completado " + kilometraje2);
    }

    @Override
    protected void prepararVuelo() {
        registrarEnBitacora("Pasajeros y equipajes verificados. Listo para despegue");
    }

}
