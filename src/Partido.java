
import java.util.Scanner;

public class Partido {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        

        //System.out.println("Bienvenido Ingrese el nombre del torneo");
        //String nombreTorneo = sc.next();
        String nombreTorneo = "Gran Slam";
        
        //System.out.println("Indique la cantidad de sets");
        //int cantSets = sc.nextInt();
        int cantSets = 5;

        int cantJugadores = 2;

        Torneo t = new Torneo(nombreTorneo,cantSets,cantJugadores);
        
        
        
        
        for (int i = 0; i < cantJugadores; i++) {
            //System.out.println("Ingrese el nombre del jugador "+ (i+1));
            //String nombre = sc.next();
            String nombre = "Jugador "+ (i+1);
            
            
            //System.out.println("Indique la probabilidad que tiene de ganar el jugador "+ nombre);
            //int probabilidad = sc.nextInt();
            int probabilidad = 50 ;
            
            Jugador j = new Jugador(nombre, probabilidad);
            t.agregarJugador(j);            
        }
        
        
        
        //System.out.println(t.getGanadorDelPunto(cantSets));
        System.out.println(t.getGanadorDelPunto());
        
        
        
        
        
        sc.close();
    }
    

}
