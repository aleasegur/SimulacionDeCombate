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
                rondas = 1,
                opcionFaccion1,
                opcionFaccion2,
                opcionClase1,
                opcionClase2;
        char accion1,accion2;
        String faccion1="", faccion2="",clase1="",clase2="";
        //Variables para multiplicar el daño en caso de critico(20%)
        double esCritico=0.2,esCritico2=0.2;
        //condicion para entrar en el combate entre los dos jugadores, y para detectar los ataques criticos
        boolean combate = true,critico,critico2,crearPj;
        //Random declarado como rand
        Random rand = new Random();
        //Scanner declarado como sc
        Scanner sc = new Scanner(System.in);

        System.out.println("%*+***************+++***********++***********+++++++*++*******#%********   ********#*************+++++*+********++++++*+*+**+**+++++*****+*++++++* \n" +
                "  *################%%######%###%%##%%%%##%%%%%################## **#*####*####*#**#####%%%##############%####%%%%#%%####################**#**#***  \n" +
                "   #####%##%%####%#%%#########%%##%%%%%#%%%%####################%##############%%%%%##%%%###################%%%%%################%##########*#**   \n" +
                "     *###%%%##%##%#####################%#%########################%##%###%%%####%%%%%%%###########***#######################*#########*####***     \n" +
                "      #**#%#%#%#####%==+#%+==+%#*==*###===*####*=======*##==+###*==##%##+===####%+==####%+==*#+==*####+==+%#=======*%+=======#############**#      \n" +
                "        #%%##%######%+==%#====#%+==%#%+====###%*==%%%+==##==+###*==#####====+###%+===%#%+===*#+===*###===*%#==*%%%%#%+==%%#==+#############        \n" +
                "         #%%%#%#%%%%#*==##====+%==*#%*==%==+%#%*==%%%+==##==+###*==###%+=*#==###%+====%*====*#+====%#====*%#==*#####%+==%%%==+############         \n" +
                "          ####%%%%%%%%==*==*#=+*==%#%+=*%#==#%%*=======*%#=========##%*==#%+==%#%+==========#%+=======+==*%#======+%%+=======##%%####*#*%          \n" +
                "            **#%%%%%%%*+=++%%+=+++%%+++====++%%*==%*=+#%%%=++%%%*==#%%++++===+*%%+=+%=+=*#==#%+==%+=++%++*%#++#%%%%%%+++%+++%#%%#%%#***            \n" +
                "             #%%%%%#%%%+++*%%#+++#%#++*%%%#++*%*++%%*++#%%++*%%%#++#%+++%%%%*++%%+++%%**%#++#%*++#%**%%++*%#+++****#%*++%%+++#%#%%%%##             \n" +
                "               #%%%%#%%*++%%%%+++%%+++%%%%%*++%*++%%%*++#%++*%%%#++##++*%%%%%++*%+++%%%%%#++#%*++%%%%%%++*%%+++++++*%*++%%%+++%%%%%*               \n" +
                "                #%@@%######%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######%%%@%#                \n" +
                "                  ***%%%%%%%#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%=+%%+++=%%%%%=++=@%=+*=%%=++=#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%**#                  \n" +
                "                   #%%%%%%%%%#%%%%%%%%%%@%@@@@@@@@%%%%%%%%*+**%%+#%+#%%%%=%%=%#=%#=%#=%%=#%%%%%%%%%%%%%%%%%%%%@@@%@%%#%%%%%%%%%#                   \n" +
                "                    %#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%#++++#%+#@+#@#%%+@%+%#+%%+%#+%%+#%%%#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#                     \n" +
                "                      #******************************##%%%%%@@%%@%@@%%%%%@%%@%%@%%@%%@%%@%%%##******************************#                      \n" +
                "                                                      #*************************************#");

        System.out.println("EN EL CUADRAGÉSIMO PRIMER MILENIO, LA HUMANIDAD SE ENCUENTRA AL BORDE DE LA ANIQUILACION. \n" +
                "\n" +
                "EL IMPERIO DE LA HUMANIDAD SE EXTIENDE A LO LARGO DE LA GALAXIA Y ESTÁ BAJO LA AMENAZA DE ALIENÍGENAS HOSTILES EN SUS FRONTERAS Y TRAIDORES Y HEREJES EN SU INTERIOR. \n" +
                "\n" +
                "SE TRATA DE UNA ERA DE GUERRA CONSTANTE, UNA NUEVA ERA OSCURA EN LA CUAL LA ILUMINACION SE VE SUSTITUIDA POR LAS SUPERSTICIONES, LA RETÓRICA Y LOS REZOS CIEGOS. VIVIR EN ESTOS TIEMPOS SUPONE SER UNO ENTRE INCONTABLES MILES DE BILLONES QUE EXISTEN EN EL RÉGIMEN MÁS CRUEL Y SANGUINARIO JAMÁS IMAGINABLE. \n" +
                "\n" +
                "LOS MÁS PODEROSOS Y TEMIBLES DEFENSORES DEL IMPERIO SON LOS MARINES ESPACIALES: GUERREROS SOBREHUMANOS CREADOS MEDIANTE BIOINGENIERIA, SON EL ÚLTIMO BASTIÓN DE LA HUMANIDAD ANTE EL HORROR. \n" +
                "\n" +
                "NO HAY TIEMPO PARA LA PAZ. NO HAY RESPIRO NI PERDÓN \n" +
                "\n" +
                "EN LA SOMBRÍA OSCURIDAD DEL FUTURO LEJANO, SÓLO HAY GUERRA ");
        System.out.println("Deseas crear los personajes con sus facciones, clases y atributos(TRUE) o prefiere utilizar personajes ya creados(FALSE): ");
        crearPj=sc.nextBoolean();
        if (crearPj==true) {
            //Realizo un do while para comprobar que la suma de los atributos no supere 500
            do {
                System.out.println("CAPITULOS DE LOS MARINES ESPACIALES: "+"\n1.Lobos Espaciales(VI LEGION)"+"\n2.Angeles Sangrientos(IX LEGION)"+"\n3.Ultramarines(XIII LEGION)");
                opcionFaccion1=sc.nextInt();
                switch (opcionFaccion1){
                    case 1:
                        faccion1="LOBOS ESPACIALES";
                        System.out.println("Los Lobos Espaciales fueron una de las 20 Legiones, en concreto la VI Legión, de Marines Espaciales creadas por el Emperador para su Gran Cruzada. " +
                                "Su Primarca era Leman Russ, el Rey Lobo de Fenris. Los Vlka Fenryka (Lobos de Fenris) se mantuvieron ferozmente leales al Imperio durante la Herejía de Horus, " +
                                "castigando a los Mil Hijos por su abuso de los poderes psíquicos y enfrentándose a las Legiones Traidoras");
                        break;
                    case 2:
                        faccion1="ANGELES SANGRIENTOS";
                        System.out.println("Los Ángeles Sangrientos fueron la IX Legión de Marines Espaciales que el Emperador creó para su Gran Cruzada. Su Primarca era Sanguinius, y su mundo natal es Baal.\n" +
                                "\n" +
                                "En combate, la Legión de los Ángeles Sangrientos era la encarnación de la ira del Emperador hacia aquellos que rechazaban el regalo de la Unidad. Liderados por su angelical Primarca Sanguinius, " +
                                "su venida no era nada menos que un juicio apocalíptico descargado sobre los culpables desde las alturas, y descendiendo de los cielos sobre alas de fuego, la Legión conquistó mundos humanos perdidos tanto por su furia sobrenatural como por el terror y el pasmo que engendraba. " +
                                "Naciones enteras cayeron de rodillas, acobardadas por la furia y el esplendor de estos \"ángeles rojos\", por temor a perecer bajo las brillantes espadas de los Marines Espaciales. " +
                                "A los xenos no se les daba este cuartel, y la ira de la Legión se manifestaba como una marea de carnicería implacable que solo amainaba tras lograr el exterminio absoluto.");
                        break;
                    case 3:
                        faccion1="Ultramarines";
                        System.out.println("Los Ultramarines fueron la XIII Legión de Marines Espaciales creada por el Emperador para su Gran Cruzada. Su Primarca era Roboute Guilliman. La Legión se mantuvo en el bando leal durante la Herejía de Horus, y tras esta, se reorganizó según el Codex Astartes y se dividió en Capítulos.\n" +
                                "\n" +
                                "Desde los antiguos días de la Gran Cruzada, los Ultramarines han combatido en la vanguardia de los ejércitos del Emperador. Son guerreros altamente disciplinados y " +
                                "valientes que han permanecido fieles durante diez mil años a las enseñanzas del sagrado Codex Astartes, la mayor obra de su Primarca." +
                                " Sus victorias se relatan desde su mundo natal, Macragge, hasta en las cámaras sagradas de Terra. " +
                                "Donde los enemigos de la Humanidad amenacen al Imperio, allí estarán los Ultramarines para combatirlos.");
                        break;
                }

                System.out.println(faccion1+"\nELIGE UNA CLASE "+"\n1.Estratega"+"\n2.Asalto"+"\n3.Vanguardia"+"\n4.Bastion"+"\n5.Francotirador"+"\n6.Pesado");
                opcionClase1=sc.nextInt();
                switch (opcionClase1){
                    case 1:
                        clase1="ESTRATEGA";
                        break;
                    case 2:
                        clase1="ASALTO";
                        break;
                    case 3:
                        clase1="VANGUARDIA";
                        break;
                    case 4:
                        clase1="BASTION";
                        break;
                    case 5:
                        clase1="FRANCOTIRADOR";
                        break;
                    case 6:
                        clase1="PESADO";
                        break;
                }

                System.out.println(faccion1);
                System.out.println(clase1);
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
                regenerar = sc.nextInt();
                sumaAtributos = velocidad + vida + defensaBase + ataqueBase + regenerar;

                System.out.println("CAPITULOS DE LOS ASTARTES HEREJES DEL CAOS: "+"\n1.Mil Hijos"+"\n2.Legion Negra"+"\n3Legion Alfa");
                opcionFaccion2=sc.nextInt();
                switch (opcionFaccion2){
                    case 1:
                        faccion2="MIL HIJOS";
                        System.out.println("Los Mil Hijos fueron la XV Legión de Marines Espaciales que el Emperador creó para su Gran Cruzada. Su Primarca era Magnus el Rojo, y su mundo natal, Prospero. " +
                                "Durante la Herejía de Horus, fueron acusados de hechicería y atacados por los Lobos Espaciales, " +
                                "de modo que se entregaron al Caos y lucharon contra el Imperio. Han jurado lealtad a Tzeentch, el Dios del Caos del cambio, la intriga y la hechicería.");
                        break;
                    case 2:
                        faccion2="LEGION NEGRA";
                        System.out.println("La Legión Negra, originalmente conocida como los Lobos Lunares (Luna Wolves en inglés), y luego renombrada Hijos de Horus, fue la XVI Legión de Marines Espaciales creada por el Emperador para la Gran Cruzada. " +
                                "Durante la Herejía de Horus, siguieron a su Primarca Horus, Señor de la Guerra, en la rebelión contra el Imperio, convirtiéndose en Marines Espaciales del Caos. " +
                                "Siempre se reúnen en gran número cuando su actual Señor de la Guerra, Ezekyle Abaddon el Saqueador, lo desea.");
                        break;
                    case 3:
                        faccion2="LEGION ALFA";
                        System.out.println("La Legión Alfa es la Legión Traidora de la que menos se sabe. Antaño fue la XX Legión Astartes, creada durante la Primera Fundación por el Emperador de la Humanidad para llevar a cabo su Gran Cruzada " +
                                "y reunir a toda la raza humana bajo la égida de su Imperio. Son expertos en la infiltración y sus ejércitos contienen a muchos cultistas del Caos además de sus propios Marines Traidores." +
                                " La Legión Alfa tenía dos Primarcas gemelos, Alpharius y Omegon, el segundo de los cuales era mantenido en secreto para todos excepto los miembros de la XX Legión. Al final de la Herejía de Horus, Roboute Guilliman de los Ultramarines mató supuestamente a uno de los dos, o quizá solo a un doble. " +
                                "A pesar de su aparente adoración al Caos Absoluto, un estudio más a fondo de la historia de la Legión Alfa indica que podría ser la mayor mentira que jamás han difundido en el Imperio y quizá entre las propias fuerzas del Caos.");
                        break;
                }

                System.out.println(faccion1+"\nELIGE UNA CLASE "+"\n1.Estratega"+"\n2.Asalto"+"\n3.Vanguardia"+"\n4.Bastion"+"\n5.Francotirador"+"\n6.Pesado");
                opcionClase2=sc.nextInt();
                switch (opcionClase2){
                    case 1:
                        clase2="ESTRATEGA";
                        break;
                    case 2:
                        clase2="ASALTO";
                        break;
                    case 3:
                        clase2="VANGUARDIA";
                        break;
                    case 4:
                        clase2="BASTION";
                        break;
                    case 5:
                        clase2="FRANCOTIRADOR";
                        break;
                    case 6:
                        clase2="PESADO";
                        break;
                }

                System.out.println(faccion2);
                System.out.println(clase2);
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
                regenerar2 = sc.nextInt();
                sumaAtributos2 = velocidad2 + vida2 + defensaBase2 + ataqueBase2 + regenerar2;
                //Cumple la condicion si supera 500 o los valores introducidos son menores a 1 o mayor a 200 PD: SE PUEDE REDUCIR CON UN METODO BOOLEAN
            } while ((sumaAtributos > 500 && sumaAtributos2 > 500) && (velocidad < 1 || velocidad > 200
                    || ataqueBase < 1 || ataqueBase > 200 ||
                    vida < 1 || vida > 200 || defensaBase < 1 || defensaBase > 200 ||
                    velocidad2 < 1 || velocidad2 > 200 || vida2 < 1 || vida2 > 200 ||
                    ataqueBase2 < 1 || ataqueBase2 > 200 || defensaBase2 < 1 || defensaBase2 > 200 ||
                    regenerar < 1 || regenerar > 200 || regenerar2 < 1 || regenerar2 > 200));
        }else {

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

        }

        System.out.println("PLANETA ENER-ILIM ETERIUM \n" +
                "\n" +
                "SECTOR IX/44320/X/IM \n" +
                "\n" +
                "SANTUARIO IMPERIAL \n" +
                "\n" +
                "++INICIALIZANDO MENSAJE ENCRYPTADO++ \n" +
                "\n" +
                "POR LA AUTORIDAD DEL ARCHIMAGOS AOZICK 224 \n" +
                "\n" +
                "PLANETA ENER-ILIM – SISTEMA RECIBIDO ESTA BAJO ATAQUE \n" +
                "\n" +
                "AMENZA: ASTARTES HEREJES DEL CAOS – FACCION "+faccion2+"\n" +
                "\n" +
                "CESAR CUALQUIER PREPARACIÓN DE BOMBARDERO \n" +
                "\n" +
                "SANTUARIO NOVA SANTA EN PELIGRO \n" +
                "\n" +
                "NOVA SANTA VALOR ESTRATEGICO: \n" +
                "\n" +
                "ABSOLUTO \n" +
                "\n" +
                "ASISTENCIA URGENTE REQUERIDA POR LAS FUERZAS "+faccion1+"\n" +
                "\n" +
                "MENSAJE ENCRIPTADO ENVIADO \n" +
                "\n" +
                "ENVIADO AL RELE ASTROPATHIC \n" +
                "\n" +
                "HAIL THE OMNISSIAH, HAIL EL DIOS MAQUINA ");

        System.out.println(faccion1+" \n"+clase1+"\nVelocidad " + velocidad + "\nVida " + vida + "\nDefensa " + defensaBase + "\nAtaque " + ataqueBase+"\nRegenerar "+regenerar);
        System.out.println("\n"+faccion2 +"\n "+clase2+"\nVelocidad " + velocidad2 + "\nVida " + vida2 + "\nDefensa " + defensaBase2 + "\nAtaque " + ataqueBase2+"\nRegenerar "+regenerar);

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
            System.out.println("______ ___________   _____ _       ________  _________ ___________  ___ ______ ___________ \n" +
                    "| ___ \\  _  | ___ \\ |  ___| |     |  ___|  \\/  || ___ \\  ___| ___ \\/ _ \\|  _  \\  _  | ___ \\\n" +
                    "| |_/ / | | | |_/ / | |__ | |     | |__ | .  . || |_/ / |__ | |_/ / /_\\ \\ | | | | | | |_/ /\n" +
                    "|  __/| | | |    /  |  __|| |     |  __|| |\\/| ||  __/|  __||    /|  _  | | | | | | |    / \n" +
                    "| |   \\ \\_/ / |\\ \\  | |___| |____ | |___| |  | || |   | |___| |\\ \\| | | | |/ /\\ \\_/ / |\\ \\ \n" +
                    "\\_|    \\___/\\_| \\_| \\____/\\_____/ \\____/\\_|  |_/\\_|   \\____/\\_| \\_\\_| |_/___/  \\___/\\_| \\_");
        } else {
            System.out.println("___  ____   _ ___________ _____ _____    ___   _      ______ ___   _      _____  _____   ________  _________ ___________  ___ ______ ___________ \n" +
                    "|  \\/  | | | |  ___| ___ \\_   _|  ___|  / _ \\ | |     |  ___/ _ \\ | |    /  ___||  _  | |  ___|  \\/  || ___ \\  ___| ___ \\/ _ \\|  _  \\  _  | ___ \\\n" +
                    "| .  . | | | | |__ | |_/ / | | | |__   / /_\\ \\| |     | |_ / /_\\ \\| |    \\ `--. | | | | | |__ | .  . || |_/ / |__ | |_/ / /_\\ \\ | | | | | | |_/ /\n" +
                    "| |\\/| | | | |  __||    /  | | |  __|  |  _  || |     |  _||  _  || |     `--. \\| | | | |  __|| |\\/| ||  __/|  __||    /|  _  | | | | | | |    / \n" +
                    "| |  | | |_| | |___| |\\ \\  | | | |___  | | | || |____ | |  | | | || |____/\\__/ /\\ \\_/ / | |___| |  | || |   | |___| |\\ \\| | | | |/ /\\ \\_/ / |\\ \\ \n" +
                    "\\_|  |_/\\___/\\____/\\_| \\_| \\_/ \\____/  \\_| |_/\\_____/ \\_|  \\_| |_/\\_____/\\____/  \\___/  \\____/\\_|  |_/\\_|   \\____/\\_| \\_\\_| |_/___/  \\___/\\_| \\_|");
        }
        sc.close();
    }
}