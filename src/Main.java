import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        //las variables acabadas en 2 son para el jugador2
        int velocidad,
                velocidad2,
                ataqueBase,
                ataqueBase2,
                defensaBase,
                defensaBase2,
                vida,
                vida2,
                sumaAtributos = 0,
                sumaAtributos2 = 0,
                realizarAtaque=0,
                rondas=0;//variable que cuenta las rondas;
        //condicion para entrar en el combate entre los dos jugadores
        boolean combate = true;
        //Random declarado como rand
        Random rand=new Random(500);
        //Scanner declarado como sc
        Scanner sc = new Scanner(System.in);
        realizarAtaque=rand.nextInt(500);

        //Realizo un do while para comprobar que la suma de los atributos no supere 500
        do {
            System.out.println("JUGADOR 1");
            System.out.println("Introduce los valores para velocidad,vida,defensa,ataque(La suma de los atributos no debe ser mayor a 500): " + "\nCada uno de los atributos debe ser entre 1-200");
            System.out.println("Velocidad: ");
            velocidad = sc.nextInt();
            System.out.println("Vida: ");
            vida = sc.nextInt();
            System.out.println("Defensa: ");
            defensaBase = sc.nextInt();
            System.out.println("Ataque: ");
            ataqueBase = sc.nextInt();
            sumaAtributos = velocidad + vida + defensaBase + ataqueBase;

            System.out.println("JUGADOR 2 ");
            System.out.println("Introduce los valores para velocidad,vida,defensa,ataque(La suma de los atributos no debe ser mayor a 500): ");
            System.out.println("Velocidad: ");
            velocidad2 = sc.nextInt();
            System.out.println("Vida: ");
            vida2 = sc.nextInt();
            System.out.println("Defensa: ");
            defensaBase2 = sc.nextInt();
            System.out.println("Ataque: ");
            ataqueBase2 = sc.nextInt();
            sumaAtributos2 = velocidad2 + vida2 + defensaBase2 + ataqueBase2;
        } while (sumaAtributos > 500 && sumaAtributos2 > 500);

        while (combate) {
            if (velocidad>velocidad2){
                realizarAtaque=ataqueBase-(defensaBase2/2);
            }else{
                realizarAtaque=ataqueBase2-(defensaBase/2);
            }
            for (int i = 1; i <= vida; i++) {
                System.out.println("\n-");
            }


            if (vida <= 0 || vida2 <= 0) {
                combate = false;
            }
        }
        sc.close();
    }
}