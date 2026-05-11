package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.List;

import ar.edu.unahur.obj2.excepciones.excepciones.EstadoInvalidoException;
import ar.edu.unahur.obj2.excepciones.excepciones.UsoDeReservaException;
import ar.edu.unahur.obj2.excepciones.modos.IModoVuelo;
import ar.edu.unahur.obj2.excepciones.modos.ModoEficiente;

public abstract class Helicoptero {


 



    public Double getCombustible() {
        return combustible;
    }



    public Double getKilometraje() {
        return kilometraje;
    }



    public Double getCapacidadTanque() {
        return capacidadTanque;
    }



    public List<String> getBitacora() {
        return bitacora;
    }


    private Double combustible;
    private Double kilometraje = 0.0;
    private final Double capacidadTanque;
    private final List<String> bitacora;
    private IModoVuelo modoVuelo;
    
    
    //Constructor
    public Helicoptero (Double combustible, Double capacidadTanque) {
        if (combustible < 0.0){
            throw new EstadoInvalidoException("No se puede inicializar un helicoptero con combustible negativo," + " valor recibido: " + combustible);
        }
        this.combustible = combustible;
        this.capacidadTanque = capacidadTanque;
        this.modoVuelo = new ModoEficiente();
        this.bitacora = null;
    }



    public Double volar(Double distanciaKm, Boolean volarHastaDondeSePueda){
        validarEstadoDespegue();
        prepararVuelo();
        Double tiempoEstimado = ejecutarVuelo(distanciaKm, volarHastaDondeSePueda);
        finalizarVuelo(kilometraje);

        return tiempoEstimado;
    }

    protected abstract void finalizarVuelo(Double kilometraje2);



    protected void validarEstadoDespegue(){
        if (combustible <= 0.0){
            throw new EstadoInvalidoException("Combustible insuficiente");
        }
    }


    protected abstract void prepararVuelo();

    private Double ejecutarVuelo(Double distancia, Boolean volarHastaDondeSePueda){
        Double combustibleNecesario = modoVuelo.calcularCombustibleNecesario(distancia);
        Boolean usaReserva = consumeReserva(combustibleNecesario);


        if (combustibleNecesario > this.combustible){
            if(volarHastaDondeSePueda){
                return volarParcialmente();
            }
            throw new EstadoInvalidoException("No alcanza el combustible para el vuelo completo");
        }

        this.combustible -= combustibleNecesario;
        kilometraje += distancia;

        Double tiempoEstimado = distancia / modoVuelo.getVelocidadMaximaKm();

        if(usaReserva){
            throw new UsoDeReservaException(getReserva());
        }

        return tiempoEstimado;
    }

    private Double volarParcialmente() {
        Double distanciaRecorrida = combustible * modoVuelo.getRendimientoKmPorLitro();
        kilometraje += distanciaRecorrida;
        combustible = 0.0;
        registrarEnBitacora("Vuelo pacial " + distanciaRecorrida + " km recorridos hasta agotar combustible");
        return distanciaRecorrida / modoVuelo.getVelocidadMaximaKm();
    }



    protected void registrarEnBitacora(String mensaje) {
        bitacora.add(mensaje);
    }



    private Boolean consumeReserva(Double combustibleNecesario){
        return (this.combustible - combustibleNecesario) < getReserva();
    }



    private double getReserva() {
        return capacidadTanque * 0.1;
    }


    public IModoVuelo getModoVuelo() {
        return modoVuelo;
    }



    public void setModoVuelo(IModoVuelo modoVuelo) {
        this.modoVuelo = modoVuelo;
    }


    public Double intentarVolar(Double distanciaKm){
        try {
            volar(distanciaKm, false);
            return distanciaKm;
        } catch (EstadoInvalidoException e){
            System.out.println("Gestion silenciosa, no pudo volar por combustible insuficiente.");
            return 0.0;
        }
    }

}
