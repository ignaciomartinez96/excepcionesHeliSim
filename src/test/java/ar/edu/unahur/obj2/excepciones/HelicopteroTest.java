package ar.edu.unahur.obj2.excepciones;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.excepciones.excepciones.EstadoInvalidoException;
import ar.edu.unahur.obj2.excepciones.helicopteros.HelicopteroCivil;
import ar.edu.unahur.obj2.excepciones.helicopteros.HelicopteroMilitar;

public class HelicopteroTest {



    @Test
    void dadoCombustibleNegativo_cuandoSeConstruyeHelicopteroCivil_EntoncesLanzaEstadoInvalidoException(){
        assertThrows(EstadoInvalidoException.class, ()->
        new HelicopteroCivil(-10.0,  200.0));
    }


    @Test
    void dadoCombustibleNegativo_cuandoSeConstruyeHelicopteroMilitar_EntoncesLanzaEstadoInvalidoException(){
        assertThrows(EstadoInvalidoException.class, ()->
        new HelicopteroMilitar(-10.0,  200.0));
    }

}
