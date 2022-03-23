public class Torneo {
    Jugador [] jugadores;

    public Torneo(int cantJugadores) {        
        this.jugadores = new Jugador[cantJugadores];
    }
    
    public void agregarJugador(Jugador j){
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = j;
                break;
            }
        }
    }
    
    
    public String getGanadorDelPunto(int sets){  
        int game0 = 0;
        int game1 = 0;
        
        String resultados = "";
        boolean bandera = false;
        
        int set = 0;
        do {
            int puntosJugador0 = 0;
            int puntosJugador1 = 0;
            String puntos0 = " 0";
            String puntos1= " 0";
        
            int posibilidad0 = 0;
            int posibilidad1 = 0;
        
            do {
                posibilidad0 =jugadores[0].getPosibilidadDeGanar();
                posibilidad1 =jugadores[1].getPosibilidadDeGanar();


                if (posibilidad0 > posibilidad1) {  
                    puntosJugador0 ++;
                    switch (puntosJugador0) {
                        case 1: puntos0 = "15" ; break;
                        case 2: puntos0 = "30"; break;
                        case 3: puntos0 = "40"; break;
                        case 5: puntos0 = "WD"; game0 ++; break;
                    }
                    if (puntosJugador0 == 4) {                    
                        if (puntos1.equals("AD")) {
                            puntosJugador1 = 3;
                            puntosJugador0 = 3;
                            puntos0 = "40";
                            puntos1 = "40";
                        }else{
                            puntos0 = "AD";
                        }   
                    }
                }else if (posibilidad0 < posibilidad1) {  
                    puntosJugador1 ++;
                    switch (puntosJugador1) {
                        case 1: puntos1 = "15"; break;
                        case 2: puntos1 = "30"; break;
                        case 3: puntos1 = "40"; break;
                        case 5: puntos1 = "WD";game1 ++; break;
                    }
                    if (puntosJugador1 == 4) {
                        if (puntos0.equals("AD")) {
                            puntosJugador1 = 3;
                            puntosJugador0 = 3;
                            puntos0 = "40";
                            puntos1 = "40";
                        }else{
                            puntos1 = "AD";  
                        }   
                    }
                }
                resultados += "\n"+puntos0 +"  -  "+ puntos1;
            } while (puntosJugador0 <5 && puntosJugador1 <5 );
            resultados += "\n---------\n "+ game0 + "  -  "+game1+" \n---------\n";
            set ++;
            
            // cuando alguno de los 2 llega al sets, siempre con una ventaja de 2 juegos ganados
            
            
            if ( game0 == sets || game1 == sets ) {
                if (game0 > game1) {
                    
                }
                
                bandera = true;
            }
            
            
        } while (!bandera);    
        return resultados;
    }
    
    


    
    
    
}
