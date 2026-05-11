package ar.edu.unahur.obj2.excepciones.helicopteros;

import ar.edu.unahur.obj2.excepciones.excepciones.MissionAbortadaException;
import ar.edu.unahur.obj2.excepciones.modos.ModoAgresivo;

public class HelicopteroMilitar extends Helicoptero{


    private static final Double minimoAgresivo = 20.0;


    public HelicopteroMilitar(Double combustible, Double capacidadTanque) {
        super(combustible, capacidadTanque);
    }

    @Override
    protected void finalizarVuelo(Double kilometraje2) {
        registrarEnBitacora("vuelo militar completado " + kilometraje2);
    }

    @Override
    protected void prepararVuelo() {
        validarEstadoDespegue();
        registrarEnBitacora("Armamento y municiones verificados. Listo para despegue");
    }

    @Override
    protected void validarEstadoDespegue(){
        super.validarEstadoDespegue();
        boolean esAgresivo = getModoVuelo() instanceof ModoAgresivo;
        Boolean combustibleBajo = getCombustible() < minimoAgresivo;

        if (esAgresivo && combustibleBajo){
            throw new MissionAbortadaException("No se puede iniciar el vuelo, el helicoptero esta en modo agresivo y el combustible es menor a " + minimoAgresivo);
        }
    }


}
