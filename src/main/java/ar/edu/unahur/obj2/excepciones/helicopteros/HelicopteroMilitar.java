package ar.edu.unahur.obj2.excepciones.helicopteros;

import ar.edu.unahur.obj2.excepciones.excepciones.MissionAbortadaException;
import ar.edu.unahur.obj2.excepciones.modos.IModoVuelo;
import ar.edu.unahur.obj2.excepciones.modos.ModoAgresivo;

public class HelicopteroMilitar extends Helicoptero{


    private static final Double minimoAgresivo = 20.0;


    public HelicopteroMilitar(Double combustible, Double capacidadTanque) {
        super(combustible, capacidadTanque);
    }

    @Override
    protected void finalizarVuelo(Double kilometraje2) {
        //TODO
    }

    @Override
    protected void prepararVuelo() {
        //TODO
    }

    @Override
    protected void validarEstadoDespegue(){
        super.validarEstadoDespegue();
        boolean esAgresivo = getModoVuelo() instanceof ModoAgresivo;
        Boolean combustibleBajo = getCombustible() < minimoAgresivo;

        if (esAgresivo && combustibleBajo){
            throw new MissionAbortadaException()
        }
    }


}
