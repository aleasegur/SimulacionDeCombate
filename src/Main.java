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
                hit=0,//El daño del ataque
                hitBase=0,//El daño base para atacar
                //variable que cuenta las rondas;
                rondas = 1;
        //condicion para entrar en el combate entre los dos jugadores
        boolean combate = true;
        //Random declarado como rand
        Random rand = new Random();
        //Scanner declarado como sc
        Scanner sc = new Scanner(System.in);

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
            //Cumple la condicion si supera 500 o los valores introducidos son menores a 1 o mayor a 200 PD: SE PUEDE REDUCIR CON UN METODO BOOLEAN
        } while ((sumaAtributos > 500 && sumaAtributos2 > 500) && (velocidad<1 || velocidad>200 || ataqueBase<1 || ataqueBase>200 || vida<1 || vida>200 || defensaBase<1 ||  defensaBase>200 || velocidad2<1 || velocidad2>200 || vida2<1 || vida2>200 || ataqueBase2<1 || ataqueBase2>200 || defensaBase2<1 || defensaBase2>200));

        System.out.println("JUGADOR 1 " + "\nVelocidad " + velocidad + "\nVida " + vida + "\nDefensa " + defensaBase + "\nAtaque " + ataqueBase);
        System.out.println("\nJUGADOR 2 " + "\nVelocidad " + velocidad2 + "\nVida " + vida2 + "\nDefensa " + defensaBase2 + "\nAtaque " + ataqueBase2);


        while (combate) {
            //ESTO SE PODRIA REDUCIR CON UN METODO String
            int barras = vida / 2, barras2 = vida2 / 2;
            //Mofifica y ordena la cadena para que me aparezaca recta con StringBuilder como: --------------------------- en vez de - \n -
            StringBuilder barra = new StringBuilder();
            StringBuilder barra2 = new StringBuilder();
            //Bucle para reccorer la vida del jugador y mostrar la vida de manera grafica
            for (int i = 0; i < barras; i++) {
                barra.append("-");
            }
            for (int i = 0; i < barras2; i++) {
                barra2.append("-");
            }

            System.out.println("\n**********************************************");
            System.out.println("RONDA " + rondas);
            System.out.println("Jugador 1: " + vida + " " + barra);
            System.out.println("Jugador 2: " + vida2 + " " + barra2);


            //determinar quien ataca primero PD: SE PUEDE REDUCIR CON UN METODO INT
            if (velocidad >= velocidad2) {
                //Ataque jugador 1 a jugador 2
                hitBase=ataqueBase-defensaBase2/2;
                hit=hitBase+rand.nextInt(10)-5;
                if (hit<0){
                    hit=0;
                }
                vida2-=hit;
                if (vida2<=0){
                    vida2=0;
                }
                System.out.println("Jugador 1 golpea primero con "+hit+" de daño");
                //Ataque jugador 2 a jugador 1
                if (vida2>0){
                    hitBase=ataqueBase2-defensaBase/2;
                    hit=hitBase+rand.nextInt(10)-5;
                    if (hit<0){
                        hit=0;
                    }
                    vida-=hit;
                    if (vida<0){
                        vida=0;
                    }
                    System.out.println("Jugador 2 golpea primero con "+hit+" de daño");
                }

            } else {
                //Ataque del segundo jugador al jugador 1
                hitBase=ataqueBase2-defensaBase/2;
                hit=hitBase+rand.nextInt(10)-5;
                if (hit<0){
                    hit=0;
                }
                vida-=hit;
                if (vida<0){
                    vida=0;
                }
                System.out.println("Jugador 2 golpea primero con "+hit+" de daño");

                //Ataque del primer jugador al segundo
                if (vida>1){
                    hitBase=ataqueBase-defensaBase2/2;
                    hit=hitBase+rand.nextInt(10)-5;
                    if (hit<0){
                        hit=0;
                    }
                    vida2-=hit;
                    if (vida2<0){
                        vida2=0;
                    }
                    System.out.println("Jugador 1 golpea primero con "+hit+" de daño");
                }
            }
            if (vida <= 0 || vida2 <= 0) {
                combate = false;
            }
            rondas++;
            System.out.println("Introduce cualquier caracter para continuar: " );
            sc.next().charAt(0);

        }
        if (vida2 <= 0) {
            System.out.println(" _   _             _____                       _           ___ _   _ _____  ___ ______ ___________   __  _ \n" +
                    "| | | |           |  __ \\                     | |         |_  | | | |  __ \\/ _ \\|  _  |  _  | ___ \\ /  || |\n" +
                    "| |_| | __ _ ___  | |  \\/ __ _ _ __   __ _  __| | ___       | | | | | |  \\/ /_\\ | | | | | | | |_/ / `| || |\n" +
                    "|  _  |/ _` / __| | | __ / _` | '_ \\ / _` |/ _` |/ _ \\      | | | | | | __|  _  | | | | | | |    /   | || |\n" +
                    "| | | | (_| \\__ \\ | |_\\ | (_| | | | | (_| | (_| | (_) | /\\__/ | |_| | |_\\ | | | | |/ /\\ \\_/ | |\\ \\  _| ||_|\n" +
                    "\\_| |_/\\__,_|___/  \\____/\\__,_|_| |_|\\__,_|\\__,_|\\___/  \\____/ \\___/ \\____\\_| |_|___/  \\___/\\_| \\_| \\___(_)");
        } else {
            System.out.println(" _   _             _____                       _           ___ _   _ _____  ___ ______ ___________   _____ _ \n" +
                    "| | | |           |  __ \\                     | |         |_  | | | |  __ \\/ _ \\|  _  |  _  | ___ \\ / __  | |\n" +
                    "| |_| | __ _ ___  | |  \\/ __ _ _ __   __ _  __| | ___       | | | | | |  \\/ /_\\ | | | | | | | |_/ / `' / /| |\n" +
                    "|  _  |/ _` / __| | | __ / _` | '_ \\ / _` |/ _` |/ _ \\      | | | | | | __|  _  | | | | | | |    /    / / | |\n" +
                    "| | | | (_| \\__ \\ | |_\\ | (_| | | | | (_| | (_| | (_) | /\\__/ | |_| | |_\\ | | | | |/ /\\ \\_/ | |\\ \\  ./ /__|_|\n" +
                    "\\_| |_/\\__,_|___/  \\____/\\__,_|_| |_|\\__,_|\\__,_|\\___/  \\____/ \\___/ \\____\\_| |_|___/  \\___/\\_| \\_| \\_____(_)");
        }
        sc.close();
    }
}