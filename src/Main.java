import java.util.Scanner;
import java.util.Random;

//ALEJANDRO ASENCIO GURAU
/*IMPLEMENTACION FUTURA un nuevo atributo que se llame regenerar, dos nuevas variables que seria las acciones de cada turno tanto para el jugador 1
* como para el jugador 2. Añadir un switch en el bucle principal dentro de los if donde la accion que es de tipo char el usuario elegiria A(atacar)
* C(curar), en curacion si la vida es mayor a 200, debe ser igual a 200 y en caso que no seleccione ninguno pierde el turno el jugador seleccionado.
* Luego añdir un ataque critico en el booleano con un random.nextDouble()
* si es menor a esCritico se multiplica por dos el daño */
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
                hit2=0,
                hitBase2=0,
                regenerar,
                regenerar2,
                //variable que cuenta las rondas;
                rondas = 1;
        char accion1,accion2;
        //Variables para multiplicar el daño en caso de critico(20%)
        double esCritico=0.2,esCritico2=0.2;
        //condicion para entrar en el combate entre los dos jugadores, y para detectar los ataques criticos
        boolean combate = true,critico,critico2;
        //Random declarado como rand
        Random rand = new Random();
        //Scanner declarado como sc
        Scanner sc = new Scanner(System.in);
        System.out.println("░▒▓███████▓▒░▒▓█▓▒░▒▓██████████████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░       ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓███████▓▒░       ░▒▓███████▓▒░░▒▓████████▓▒░       ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓██████████████▓▒░░▒▓███████▓▒░ ░▒▓██████▓▒░▒▓████████▓▒░▒▓████████▓▒░ \n" +
                "░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░   ░▒▓█▓▒░        \n" +
                "░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░   ░▒▓█▓▒░        \n" +
                " ░▒▓██████▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓████████▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░        ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓████████▓▒░ ░▒▓█▓▒░   ░▒▓██████▓▒░   \n" +
                "       ░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░   ░▒▓█▓▒░        \n" +
                "       ░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░   ░▒▓█▓▒░        \n" +
                "░▒▓███████▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░      ░▒▓███████▓▒░░▒▓████████▓▒░       ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░   ░▒▓████████▓▒░ \n" +
                "                                                                                                                                                                                                                                                                      \n" +
                "                                                                                                                                                                                                                                                                      ");
        //Realizo un do while para comprobar que la suma de los atributos no supere 500
        do {
            System.out.println("JUGADOR 1");
            System.out.println("Introduce los valores para velocidad,vida,defensa,ataque(La suma de los atributos no debe ser mayor a 500): " + "\nCada uno de los atributos debe ser entre (1-200) ");
            System.out.println("Velocidad: ");
            velocidad = sc.nextInt();
            System.out.println("Vida: ");
            vida = sc.nextInt();
            System.out.println("Defensa: ");
            defensaBase = sc.nextInt();
            System.out.println("Ataque: ");
            ataqueBase = sc.nextInt();
            System.out.println("Regenerar: ");
            regenerar=sc.nextInt();
            sumaAtributos = velocidad + vida + defensaBase + ataqueBase+regenerar;

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
            System.out.println("Regenerar: ");
            regenerar2=sc.nextInt();
            sumaAtributos2 = velocidad2 + vida2 + defensaBase2 + ataqueBase2+regenerar2;
            //Cumple la condicion si supera 500 o los valores introducidos son menores a 1 o mayor a 200 PD: SE PUEDE REDUCIR CON UN METODO BOOLEAN
        } while ((sumaAtributos > 500 && sumaAtributos2 > 500) && (velocidad<1 || velocidad>200
                || ataqueBase<1 || ataqueBase>200 ||
                vida<1 || vida>200 || defensaBase<1 ||  defensaBase>200 ||
                velocidad2<1 || velocidad2>200 || vida2<1 || vida2>200 ||
                ataqueBase2<1 || ataqueBase2>200 || defensaBase2<1 || defensaBase2>200 ||
                regenerar<1 || regenerar>200 || regenerar2<1 || regenerar2>200));
        /*
        //PLANTILLA DEFINIDA PARA LOS JUGADORES(REALIZAR PRUEBAS)
        //Plantilla de jugador 1, para realizar pruebas
        velocidad=150;
        vida=100;
        defensaBase=100;
        ataqueBase=100;
        regenerar=50;

        //Plantilla del jugador2 para relizar pruebas
        velocidad2=100;
        vida2=100;
        defensaBase2=150;
        ataqueBase2=50;
        regenerar2=50;
        */

        System.out.println("JUGADOR 1 " + "\nVelocidad " + velocidad + "\nVida " + vida + "\nDefensa " + defensaBase + "\nAtaque " + ataqueBase+"\nRegenerar "+regenerar);
        System.out.println("\nJUGADOR 2 " + "\nVelocidad " + velocidad2 + "\nVida " + vida2 + "\nDefensa " + defensaBase2 + "\nAtaque " + ataqueBase2+"\nRegenerar "+regenerar);

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
                System.out.println("Jugador 1.Introduce un caracter A(Atacar), C(Curar) y cualquier caracter diferente pierde la ronda para continuar: ");
                accion1=sc.next().toUpperCase().charAt(0);
                //Ataque jugador 1 a jugador 2
                switch (accion1){
                    case 'A':
                        hitBase=ataqueBase-defensaBase2/2;
                        hit=hitBase+rand.nextInt(10);
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
                            hitBase2=ataqueBase2-defensaBase/2;
                            hit2=hitBase2+rand.nextInt(10);
                            if (hit2<0){
                                hit2=0;
                            }
                            vida-=hit2;
                            if (vida<0){
                                vida=0;
                            }
                            System.out.println("Jugador 2 golpea primero con "+hit2+" de daño");
                        }
                        break;
                    case 'C':
                        vida+=regenerar;
                        if (vida>200){
                            vida=200;
                        }
                        break;
                    default:
                        System.out.println("Caracter no valido, turno no valido");
                }

            } else {
                System.out.println("Jugador 2.Introduce un caracter A(Atacar), C(Curar) y cualquier caracter diferente pierde la ronda para continuar: ");
                accion2=sc.next().toUpperCase().charAt(0);
                switch (accion2){
                    case 'A':
                        //Ataque del segundo jugador al jugador 1
                        hitBase2=ataqueBase2-defensaBase/2;
                        hit2=hitBase2+rand.nextInt(10);
                        if (hit<0){
                            hit=0;
                        }
                        vida-=hit2;
                        if (vida<0){
                            vida=0;
                        }
                        System.out.println("Jugador 2 golpea primero con "+hit2+" de daño");
                        //Ataque del primer jugador al segundo
                        if (vida>1){
                            hitBase=ataqueBase-defensaBase2/2;
                            hit=hitBase+rand.nextInt(10);
                            if (hit<0){
                                hit=0;
                            }
                            vida2-=hit;
                            if (vida2<0){
                                vida2=0;
                            }
                            System.out.println("Jugador 1 golpea primero con "+hit+" de daño");
                        }
                        break;
                    case 'C':
                        vida2+=regenerar2;
                        if (vida2>200){
                            vida2=200;
                        }
                        break;
                    default:
                        System.err.println("Caracter no valido, turno perdido");
                }
            }
            if (vida <= 0 || vida2 <= 0) {
                combate = false;
            }
            rondas++;

        }
        if (vida2 <= 0) {
            System.out.println("  ______    ______   __    __   ______   _______    ______   _______            _____  __    __   ______    ______   _______    ______   _______     __   \n" +
                    " /      \\  /      \\ /  \\  /  | /      \\ /       \\  /      \\ /       \\          /     |/  |  /  | /      \\  /      \\ /       \\  /      \\ /       \\  _/  |  \n" +
                    "/$$$$$$  |/$$$$$$  |$$  \\ $$ |/$$$$$$  |$$$$$$$  |/$$$$$$  |$$$$$$$  |         $$$$$ |$$ |  $$ |/$$$$$$  |/$$$$$$  |$$$$$$$  |/$$$$$$  |$$$$$$$  |/ $$ |  \n" +
                    "$$ | _$$/ $$ |__$$ |$$$  \\$$ |$$ |__$$ |$$ |  $$ |$$ |  $$ |$$ |__$$ |            $$ |$$ |  $$ |$$ | _$$/ $$ |__$$ |$$ |  $$ |$$ |  $$ |$$ |__$$ |$$$$ |  \n" +
                    "$$ |/    |$$    $$ |$$$$  $$ |$$    $$ |$$ |  $$ |$$ |  $$ |$$    $$<        __   $$ |$$ |  $$ |$$ |/    |$$    $$ |$$ |  $$ |$$ |  $$ |$$    $$<   $$ |  \n" +
                    "$$ |$$$$ |$$$$$$$$ |$$ $$ $$ |$$$$$$$$ |$$ |  $$ |$$ |  $$ |$$$$$$$  |      /  |  $$ |$$ |  $$ |$$ |$$$$ |$$$$$$$$ |$$ |  $$ |$$ |  $$ |$$$$$$$  |  $$ |  \n" +
                    "$$ \\__$$ |$$ |  $$ |$$ |$$$$ |$$ |  $$ |$$ |__$$ |$$ \\__$$ |$$ |  $$ |      $$ \\__$$ |$$ \\__$$ |$$ \\__$$ |$$ |  $$ |$$ |__$$ |$$ \\__$$ |$$ |  $$ | _$$ |_ \n" +
                    "$$    $$/ $$ |  $$ |$$ | $$$ |$$ |  $$ |$$    $$/ $$    $$/ $$ |  $$ |      $$    $$/ $$    $$/ $$    $$/ $$ |  $$ |$$    $$/ $$    $$/ $$ |  $$ |/ $$   |\n" +
                    " $$$$$$/  $$/   $$/ $$/   $$/ $$/   $$/ $$$$$$$/   $$$$$$/  $$/   $$/        $$$$$$/   $$$$$$/   $$$$$$/  $$/   $$/ $$$$$$$/   $$$$$$/  $$/   $$/ $$$$$$/");
        } else {
            System.out.println("  ______    ______   __    __   ______   _______    ______   _______            _____  __    __   ______    ______   _______    ______   _______    ______  \n" +
                    " /      \\  /      \\ /  \\  /  | /      \\ /       \\  /      \\ /       \\          /     |/  |  /  | /      \\  /      \\ /       \\  /      \\ /       \\  /      \\ \n" +
                    "/$$$$$$  |/$$$$$$  |$$  \\ $$ |/$$$$$$  |$$$$$$$  |/$$$$$$  |$$$$$$$  |         $$$$$ |$$ |  $$ |/$$$$$$  |/$$$$$$  |$$$$$$$  |/$$$$$$  |$$$$$$$  |/$$$$$$  |\n" +
                    "$$ | _$$/ $$ |__$$ |$$$  \\$$ |$$ |__$$ |$$ |  $$ |$$ |  $$ |$$ |__$$ |            $$ |$$ |  $$ |$$ | _$$/ $$ |__$$ |$$ |  $$ |$$ |  $$ |$$ |__$$ |$$____$$ |\n" +
                    "$$ |/    |$$    $$ |$$$$  $$ |$$    $$ |$$ |  $$ |$$ |  $$ |$$    $$<        __   $$ |$$ |  $$ |$$ |/    |$$    $$ |$$ |  $$ |$$ |  $$ |$$    $$<  /    $$/ \n" +
                    "$$ |$$$$ |$$$$$$$$ |$$ $$ $$ |$$$$$$$$ |$$ |  $$ |$$ |  $$ |$$$$$$$  |      /  |  $$ |$$ |  $$ |$$ |$$$$ |$$$$$$$$ |$$ |  $$ |$$ |  $$ |$$$$$$$  |/$$$$$$/  \n" +
                    "$$ \\__$$ |$$ |  $$ |$$ |$$$$ |$$ |  $$ |$$ |__$$ |$$ \\__$$ |$$ |  $$ |      $$ \\__$$ |$$ \\__$$ |$$ \\__$$ |$$ |  $$ |$$ |__$$ |$$ \\__$$ |$$ |  $$ |$$ |_____ \n" +
                    "$$    $$/ $$ |  $$ |$$ | $$$ |$$ |  $$ |$$    $$/ $$    $$/ $$ |  $$ |      $$    $$/ $$    $$/ $$    $$/ $$ |  $$ |$$    $$/ $$    $$/ $$ |  $$ |$$       |\n" +
                    " $$$$$$/  $$/   $$/ $$/   $$/ $$/   $$/ $$$$$$$/   $$$$$$/  $$/   $$/        $$$$$$/   $$$$$$/   $$$$$$/  $$/   $$/ $$$$$$$/   $$$$$$/  $$/   $$/ $$$$$$$$/");
        }
        sc.close();
    }
}