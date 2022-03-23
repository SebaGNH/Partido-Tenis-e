
public class Jugador {
    private String nombreJugador;
    private int probabilidadGanar;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getProbabilidadGanar() {
        return probabilidadGanar;
    }

    public void setProbabilidadGanar(int probabilidadGanar) {
        this.probabilidadGanar = probabilidadGanar;
    }

    public Jugador(String nombreJugador, int probabilidadGanar) {
        this.nombreJugador = nombreJugador;
        this.probabilidadGanar = probabilidadGanar;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombreJugador + ", Probabilidad de ganar:" + probabilidadGanar;
    }
    
    
    public int getPosibilidadDeGanar(){
        return (int)(Math.random()* this.probabilidadGanar);     
    }
    
    
    public int getSaqueInicial(){
        return (int)(Math.random()* 100);
    }
    
}
