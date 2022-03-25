
import java.util.Scanner;

public class Partido {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        

        System.out.println("Bienvenido Ingrese el nombre del torneo");
        String nombreTorneo = sc.next();
        //String nombreTorneo = "Gran Slam";
        
        int cantSets = -1;
        do {
            System.out.println("Indique si se jugarán 3 o 5 Sets");
            cantSets = sc.nextInt();
            //cantSets = 5;

        }while(cantSets != 3 && cantSets != 5);

        int cantJugadores = 2;

        Torneo t = new Torneo(nombreTorneo,cantSets,cantJugadores);
        
        for (int i = 0; i < cantJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador "+ (i+1));
            String nombre = sc.next();
            //String nombre = "Jugador "+ (i+1);
            
            
            System.out.println("Indique la probabilidad que tiene de ganar el jugador "+ nombre);
            int probabilidad = sc.nextInt();
            //int probabilidad = 50 ;
            
            Jugador j = new Jugador(nombre, probabilidad);
            t.agregarJugador(j);            
        }
        
        System.out.println(t.getGanadorDelPunto());

        String revancha = "";
        do{
            System.out.println("¿Quiere jugar revancha?  si - no");
            revancha = sc.next().toLowerCase();
            if(revancha.equals("si")){
                System.out.println(t.getGanadorDelPunto()+ ", revancha finalizada.");
                revancha = "no";
            }
        }while(!revancha.equals("no"));

        sc.close();
    }
    

}
