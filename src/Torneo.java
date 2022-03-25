public class Torneo {

    private String nombreTorneo;
    private int cantSets;
    private Jugador [] jugadores;

    
    
    public String getNombreTorneo() {
        return nombreTorneo;
    }
    
    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }
    
    public int getCantSets() {
        return cantSets;
    }
    
    public void setCantSets(int cantSets) {
        this.cantSets = cantSets;
    }
    
    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Torneo(String nombreTorneo, int cantSets, int cantJugadores) {
        this.jugadores = jugadores;
        this.nombreTorneo = nombreTorneo;
        this.cantSets = cantSets;
        this.jugadores = new Jugador[cantJugadores];
    }

    @Override
    public String toString() {
        return "Torneo{" + "jugadores=" + jugadores + ", nombreTorneo=" + nombreTorneo + ", cantSets=" + cantSets + '}';
    }
    
    
    
    public void agregarJugador(Jugador j){
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = j;
                break;
            }
        }
    }


    // Metodos ---------------------------------------------------------------------------------------------------------------
    
    
    public String getGanadorDelPunto(){  
        int game0 = 0;
        int game1 = 0;
        
        String resultados = "";
        boolean bandera = false;
        
        int set = 0;
        String nombreJugador = "";
        String ganadorTorneo = "";
        

        do {
            
            nombreJugador = this.getJugadorQueTieneSaque(nombreJugador);
            resultados += "\nTiene el saque el jugador: "+ nombreJugador;
            resultados += "\n"+jugadores[0].getNombreJugador()+" - "+jugadores[1].getNombreJugador();

            int puntosJugador0 = 0;
            int puntosJugador1 = 0;
            String puntos0 = "  0";
            String puntos1 = " 0 ";
            
            int posibilidad0 = 0;
            int posibilidad1 = 0;
        
            do {
                posibilidad0 = jugadores[0].getPosibilidadDeGanar();
                posibilidad1 = jugadores[1].getPosibilidadDeGanar();


                if (posibilidad0 > posibilidad1) {  
                    puntosJugador0 ++;
                    switch (puntosJugador0) {
                        case 1: puntos0 = " 15" ; break;
                        case 2: puntos0 = " 30"; break;
                        case 3: puntos0 = " 40"; break;
                        case 5: puntos0 = "Win"; game0 ++; break;
                    }
                    if (puntosJugador0 == 4) {                    
                        if (puntos1.equals("AD ")) {
                            puntosJugador1 = 3;
                            puntosJugador0 = 3;
                            puntos0 = " 40";
                            puntos1 = "40 ";
                        }else{
                            puntos0 = " AD";
                        }   
                    }
                }else if (posibilidad0 < posibilidad1) {  
                    puntosJugador1 ++;
                    switch (puntosJugador1) {
                        case 1: puntos1 = "15 "; break;
                        case 2: puntos1 = "30 "; break;
                        case 3: puntos1 = "40 "; break;
                        case 5: puntos1 = "Win";game1 ++; break;
                    }
                    if (puntosJugador1 == 4) {
                        if (puntos0.equals(" AD")) {
                            puntosJugador1 = 3;
                            puntosJugador0 = 3;
                            puntos0 = " 40";
                            puntos1 = "40 ";
                        }else{
                            puntos1 = "AD ";  
                        }   
                    }
                }
                resultados += "\n"+puntos0 +"  -  "+ puntos1;
            } while (puntosJugador0 <5 && puntosJugador1 <5 );

            resultados += "\n ---------\n Resultado\n "+ game0 + "  -  "+game1+" \n ---------\n";
            set ++;
            
            
            
            
            if ( game0 >= this.cantSets || game1 >= this.cantSets ) {
                if (game0  > (game1 +1)) {
                    ganadorTorneo = jugadores[0].getNombreJugador();
                    bandera = true;
                }else if((game0 +1) < game1){
                    ganadorTorneo = jugadores[1].getNombreJugador();
                    bandera = true;
                }else{
                    System.out.println("No ganó ninguno");
                    bandera = false;
                }
            } 
        } while (!bandera); 
        
        resultados +="\nEl ganador del torneo es: "+ ganadorTorneo;
        return resultados;
    }
    
    
    public String getJugadorQueTieneSaque(String nombreJugador){
        String jugador = nombreJugador;
        boolean salida = true;
        
        if (jugador.equals("")) {
        do {  
            if (jugadores[0].getSaqueInicial() > jugadores[1].getSaqueInicial() ) {
                jugador = jugadores[0].getNombreJugador();
                salida = false;
            }else if (jugadores[0].getSaqueInicial() < jugadores[1].getSaqueInicial()) {
                jugador = jugadores[1].getNombreJugador();
                salida = false;
            }else{
                salida = true;
            }
        } while (salida);
        
        }else if(jugador.equals(jugadores[1].getNombreJugador())){
                jugador = jugadores[0].getNombreJugador();
            
                }else if(jugador.equals(jugadores[0].getNombreJugador())){
                    jugador = jugadores[1].getNombreJugador();
                }
        return jugador;
    }
}
