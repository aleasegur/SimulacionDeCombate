import java.util.Random;
import java.util.Scanner;

//ALEJANDRO ASENCIO GURAU
/*IMPLEMENTACION FUTURA un nuevo atributo que se llame regenerar, dos nuevas variables que seria las acciones de cada turno tanto para el jugador 1
 * como para el jugador 2. Añadir un switch en el bucle principal dentro de los if donde la accion que es de tipo char el usuario elegiria A(atacar)
 * C(curar), en curacion si la vida es mayor a 200, debe ser igual a 200 y en caso que no seleccione ninguno pierde el turno el jugador seleccionado.
 * Luego añdir un ataque critico en el booleano con un random.nextDouble()
 * si es menor a esCritico se multiplica por dos el daño */
public class Main {
    public static void main(String[] args) {
        //Random declarado como rand
        Random rand = new Random();
        //Scanner declarado como sc
        Scanner sc = new Scanner(System.in);
        //Variable final que pone un limite de daño
        //final int limiteDamage=40;
        //las variables acabadas en 2 son para el jugador2
        int velocidad1=0,
                velocidad2=0,
                ataqueBase1=0,
                ataqueBase2=0,
                defensaBase1=0,
                defensaBase2=0,
                vida1=0,
                vida2=0,
                sumaAtributos1,
                sumaAtributos2,
                hit1,//El daño del ataque
                hitBase1,//El daño base para atacar
                hit2,
                hitBase2,
                regenerar1=0,
                regenerar2=0,
                //variable que cuenta las rondas;
                rondas = 1;
        //opciones para que el usurio introduzca
        int opcionFaccion1,
                opcionFaccion2,
                opcionClase1,
                opcionClase2,
                opcionJug1,
                opcionJug2;
        //acciones para que el usurio introduzca
        char accion1,accion2;
        //cadenas de texto en el que pone nombre a los jugadores
        String faccion1 = "",
                faccion2 = "",
                clase1 = "",
                clase2 = "";
        char crearPersonaje;
        //Variables para multiplicar el daño en caso de critico(20%)
        int esCritico1 = rand.nextInt(100),
                esCritico2 = rand.nextInt(100),
                probabilidadCritico = 8;
        //condicion para entrar en el combate entre los dos jugadores, y si quiere crear al personaje o no
        boolean combate = true, crearFac1=true,crearClase1=true,crearFac2=true,crearClase2=true;

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

        System.out.println("EN EL CUADRAGÉSIMO PRIMER MILENIO, LA HUMANIDAD SE ENCUENTRA AL BORDE DE LA ANIQUILACION.\n" +
                "EL IMPERIO DE LA HUMANIDAD SE EXTIENDE A LO LARGO DE LA GALAXIA Y ESTÁ BAJO LA AMENAZA DE ALIENÍGENAS HOSTILES\n" +
                "EN SUS FRONTERAS Y TRAIDORES Y HEREJES EN SU INTERIOR.\n" +
                "SE TRATA DE UNA ERA DE GUERRA CONSTANTE, UNA NUEVA ERA OSCURA \n" +
                "EN LA CUAL LA ILUMINACION SE VE SUSTITUIDA\n" +
                "POR LAS SUPERSTICIONES, LA RETÓRICA Y LOS REZOS CIEGOS.\n" +
                "VIVIR EN ESTOS TIEMPOS SUPONE SER UNO ENTRE INCONTABLES MILES DE BILLONES \n" +
                "QUE EXISTEN EN EL RÉGIMEN MÁS CRUEL Y SANGUINARIO JAMÁS IMAGINABLE\n" +
                "LOS MÁS PODEROSOS Y TEMIBLES DEFENSORES DEL IMPERIO SON LOS MARINES ESPACIALES: \n" +
                "GUERREROS SOBREHUMANOS CREADOS MEDIANTE BIOINGENIERIA\n" +
                "SON EL ÚLTIMO BASTIÓN DE LA HUMANIDAD ANTE EL HORROR.\n" +
                "EN LA SOMBRÍA OSCURIDAD DEL FUTURO LEJANO, SÓLO HAY GUERRA ");
        System.out.println("Deseas crear los personajes con sus facciones, clases y atributos(Ibtroduce Y(SI)/N(NO)): ");
        crearPersonaje=sc.next().toUpperCase().charAt(0);
        if (crearPersonaje=='Y') {

            //Realizo un do while para comprobar que la suma de los atributos no supere 500(JUAGDOR1)
            do {
                while (crearFac1) {
                    System.out.println("CAPITULOS DE LOS MARINES ESPACIALES: " + "\n1.Lobos Espaciales(VI LEGION)" + "\n2.Angeles Sangrientos(IX LEGION) " + "\n3.Ultramarines(XIII LEGION)");
                    opcionFaccion1 = sc.nextInt();
                    switch (opcionFaccion1) {
                        case 1:
                            faccion1 = "LOBOS ESPACIALES";
                            System.out.println("Los Lobos Espaciales fueron una de las 20 Legiones, en concreto la VI Legión, de Marines Espaciales creadas por el Emperador para su Gran Cruzada. " +
                                    "Su Primarca era Leman Russ, el Rey Lobo de Fenris. Los Vlka Fenryka (Lobos de Fenris) se mantuvieron ferozmente leales al Imperio durante la Herejía de Horus, " +
                                    "castigando a los Mil Hijos por su abuso de los poderes psíquicos y enfrentándose a las Legiones Traidoras");
                            crearFac1 = false;
                            break;
                        case 2:
                            faccion1 = "ANGELES SANGRIENTOS";
                            System.out.println("Los Ángeles Sangrientos fueron la IX Legión de Marines Espaciales que el Emperador creó para su Gran Cruzada. Su Primarca era Sanguinius, y su mundo natal es Baal.\n" +
                                    "En combate, la Legión de los Ángeles Sangrientos era la encarnación de la ira del Emperador hacia aquellos que rechazaban el regalo de la Unidad. Liderados por su angelical Primarca Sanguinius, " +
                                    "su venida no era nada menos que un juicio apocalíptico descargado sobre los culpables desde las alturas, y descendiendo de los cielos sobre alas de fuego, la Legión conquistó mundos humanos perdidos tanto por su furia sobrenatural como por el terror y el pasmo que engendraba. " +
                                    "Naciones enteras cayeron de rodillas, acobardadas por la furia y el esplendor de estos \"ángeles rojos\", por temor a perecer bajo las brillantes espadas de los Marines Espaciales. " +
                                    "A los xenos no se les daba este cuartel, y la ira de la Legión se manifestaba como una marea de carnicería implacable que solo amainaba tras lograr el exterminio absoluto.");
                            crearFac1 = false;
                            break;
                        case 3:
                            faccion1 = "Ultramarines";
                            System.out.println("Los Ultramarines fueron la XIII Legión de Marines Espaciales creada por el Emperador para su Gran Cruzada. Su Primarca era Roboute Guilliman. La Legión se mantuvo en el bando leal durante la Herejía de Horus, y tras esta, se reorganizó según el Codex Astartes y se dividió en Capítulos.\n" +
                                    "Desde los antiguos días de la Gran Cruzada, los Ultramarines han combatido en la vanguardia de los ejércitos del Emperador. Son guerreros altamente disciplinados y " +
                                    "valientes que han permanecido fieles durante diez mil años a las enseñanzas del sagrado Codex Astartes, la mayor obra de su Primarca." +
                                    " Sus victorias se relatan desde su mundo natal, Macragge, hasta en las cámaras sagradas de Terra. " +
                                    "Donde los enemigos de la Humanidad amenacen al Imperio, allí estarán los Ultramarines para combatirlos.");
                            crearFac1 = false;
                            break;
                        default:
                            System.err.println("ERROR: LA FACCION NO RECONOCIDA.¡VUELVA A INTRODUCIRLO!");
                            crearFac1=true;
                    }
                }
                /*cada clase cierta habilidad  especial que en combate puede por ejemplo estratega previene el ataque del enemigo, asalto golpea dos veces,
                vanguardia bloquea el ataque del enemigo, bastion reduce el atque del enemigo pero da 1 golpe por 3,
                francontirador se vuelve invisible y de lo pueden atacar y pesado refuerza la defensa pero puede matar de un golpe */
                while (crearClase1) {
                    System.out.println(faccion1 + "\nELIGE UNA CLASE " + "\n1.Estratega" + "\n2.Asalto" + "\n3.Vanguardia" + "\n4.Francotirador");
                    opcionClase1 = sc.nextInt();
                    switch (opcionClase1) {
                        case 1:
                            clase1 = "ESTRATEGA";
                            crearClase1 = false;
                            break;
                        case 2:
                            clase1 = "ASALTO";
                            crearClase1 = false;
                            break;
                        case 3:
                            clase1 = "VANGUARDIA";
                            crearClase1 = false;
                            break;
                        case 4:
                            clase1 = "FRANCOTIRADOR";
                            crearClase1 = false;
                            break;
                        default:
                            System.err.println("ERROR: EN LA SELECCION DE CLASE.¡VUELVE A INTRODUCIR LA CLASE!");
                            crearClase1 = true;
                    }
                }

                System.out.println(faccion1);
                System.out.println(clase1);
                System.out.println("Introduce los valores para velocidad1,vida1,defensa,ataque(La suma de los atributos no debe ser mayor a 500): " + "\nCada uno de los atributos debe ser entre (1-200) ");
                System.out.println("Velocidad: ");
                velocidad1 = sc.nextInt();
                System.out.println("Vida: ");
                vida1 = sc.nextInt();
                System.out.println("Defensa: ");
                defensaBase1 = sc.nextInt();
                System.out.println("Ataque: ");
                ataqueBase1 = sc.nextInt();
                System.out.println("Regenerar: ");
                regenerar1 = sc.nextInt();
                sumaAtributos1 = velocidad1 + vida1 + defensaBase1 + ataqueBase1 + regenerar1;
                if ((sumaAtributos1 > 500) && (velocidad1 >= 1 && velocidad1 <= 200 && ataqueBase1 >= 1 && ataqueBase1 <= 200 &&
                        vida1 >= 1 && vida1 <= 200 && defensaBase1 >= 1 && defensaBase1 <= 200)){
                    System.err.println("ERROR: LA SUMA DE LOS ATRIBUTOS O LOS VALORES INTRODUCIDOS NO CUMPLEN EL REQUISITO.¡VUELVA A CREAR LOS PERSONAJES!");
                }
                System.out.println(faccion1+" \n"+clase1+"\nVelocidad " + velocidad1 + "\nVida " + vida1 + "\nDefensa " + defensaBase1 + "\nAtaque " + ataqueBase1+"\nRegenerar "+regenerar1);
            }while ((sumaAtributos1 > 500) && (velocidad1 >= 1 && velocidad1 <= 200 && ataqueBase1 >= 1 && ataqueBase1 <= 200 &&
                    vida1 >= 1 && vida1 <= 200 && defensaBase1 >= 1 && defensaBase1 <= 200));

            //BUCLE PARA EL JUGADOR 2
            do {
                while (crearFac2) {
                    System.out.println("CAPITULOS DE LOS ASTARTES HEREJES DEL CAOS: "+"\n1.Mil Hijos"+"\n2.Legion Negra"+"\n3Legion Alfa");
                    opcionFaccion2=sc.nextInt();
                    switch (opcionFaccion2) {
                        case 1:
                            faccion2 = "MIL HIJOS";
                            System.out.println("Los Mil Hijos fueron la XV Legión de Marines Espaciales que el Emperador creó para su Gran Cruzada. Su Primarca era Magnus el Rojo, y su mundo natal, Prospero. " +
                                    "Durante la Herejía de Horus, fueron acusados de hechicería y atacados por los Lobos Espaciales, " +
                                    "de modo que se entregaron al Caos y lucharon contra el Imperio. Han jurado lealtad a Tzeentch, el Dios del Caos del cambio, la intriga y la hechicería.");
                            crearFac2=false;
                            break;
                        case 2:
                            faccion2 = "LEGION NEGRA";
                            System.out.println("La Legión Negra, originalmente conocida como los Lobos Lunares (Luna Wolves en inglés), y luego renombrada Hijos de Horus, fue la XVI Legión de Marines Espaciales creada por el Emperador para la Gran Cruzada. " +
                                    "Durante la Herejía de Horus, siguieron a su Primarca Horus, Señor de la Guerra, en la rebelión contra el Imperio, convirtiéndose en Marines Espaciales del Caos. " +
                                    "Siempre se reúnen en gran número cuando su actual Señor de la Guerra, Ezekyle Abaddon el Saqueador, lo desea.");
                            crearFac2=false;
                            break;
                        case 3:
                            faccion2 = "LEGION ALFA";
                            System.out.println("La Legión Alfa es la Legión Traidora de la que menos se sabe. Antaño fue la XX Legión Astartes, creada durante la Primera Fundación por el Emperador de la Humanidad para llevar a cabo su Gran Cruzada " +
                                    "y reunir a toda la raza humana bajo la égida de su Imperio. Son expertos en la infiltración y sus ejércitos contienen a muchos cultistas del Caos además de sus propios Marines Traidores." +
                                    " La Legión Alfa tenía dos Primarcas gemelos, Alpharius y Omegon, el segundo de los cuales era mantenido en secreto para todos excepto los miembros de la XX Legión. Al final de la Herejía de Horus, Roboute Guilliman de los Ultramarines mató supuestamente a uno de los dos, o quizá solo a un doble. " +
                                    "A pesar de su aparente adoración al Caos Absoluto, un estudio más a fondo de la historia de la Legión Alfa indica que podría ser la mayor mentira que jamás han difundido en el Imperio y quizá entre las propias fuerzas del Caos.");
                            crearFac2=false;
                            break;
                        default:
                            System.err.println("ERROR: LA FACCION NO RECONOCIDA.¡VUELVA A INTRODUCIRLO!");
                            crearFac2=true;
                    }
                }
                while (crearClase2) {
                    System.out.println(faccion1 + "\nELIGE UNA CLASE " + "\n1.Estratega" + "\n2.Asalto" + "\n3.Vanguardia" + "\n4.Francotirador");
                    opcionClase2 = sc.nextInt();
                    switch (opcionClase2) {
                        case 1:
                            clase2 = "ESTRATEGA";
                            crearClase2=false;
                            break;
                        case 2:
                            clase2 = "ASALTO";
                            crearClase2=false;
                            break;
                        case 3:
                            clase2 = "VANGUARDIA";
                            crearClase2=false;
                            break;
                        case 4:
                            clase2 = "FRANCOTIRADOR";
                            crearClase2=false;
                            break;
                        default:
                            System.err.println("ERROR: LA CLASE NO RECONOCIDA.¡VUELVA A INTRODUCIRLO!");
                            crearClase2=true;
                    }
                }

                System.out.println(faccion2);
                System.out.println(clase2);
                System.out.println("Introduce los valores para velocidad1,vida1,defensa,ataque(La suma de los atributos no debe ser mayor a 500): ");
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
                if ((sumaAtributos2 > 500) && (velocidad2 >= 1 && velocidad2 <= 200 && ataqueBase2 >= 1 && ataqueBase2 <= 200 &&
                        vida2 >= 1 && vida2 <= 200 && defensaBase2 >= 1 && defensaBase2 <= 200)){
                    System.err.println("ERROR: LA SUMA DE LOS ATRIBUTOS O LOS VALORES INTRODUCIDOS NO CUMPLEN EL REQUISITO.¡VUELVA A CREAR LOS PERSONAJES!");
                }
                System.out.println("\n"+faccion2 +"\n "+clase2+"\nVelocidad " + velocidad2 + "\nVida " + vida2 + "\nDefensa " + defensaBase2 + "\nAtaque " + ataqueBase2+"\nRegenerar "+regenerar1);
                //Cumple la condicion si supera 500 o los valores introducidos son menores a 1 o mayor a 200 PD: SE PUEDE REDUCIR CON UN METODO BOOLEAN
            } while ((sumaAtributos2 > 500) && (velocidad2 >= 1 && velocidad2 <= 200 && ataqueBase2 >= 1 && ataqueBase2 <= 200 &&
                    vida2 >= 1 && vida2 <= 200 && defensaBase2 >= 1 && defensaBase2 <= 200));
        }else {
            //PLANTILLA DEFINIDA PARA LOS JUGADORES(REALIZAR PRUEBAS)
            //Plantilla de jugador 1, para realizar pruebas
            System.out.println("IMPERIO DE LA HUMANIDAD:");
            System.out.println("1.LOBO ESPACIAL -> CLASE: ESTRATEGA"+"\n2.ANGEL SANGRIENTO -> CLASE: ASALTO"+"\n3.ULTRAMARINE -> CLASE: VANGUARDIA");
            System.out.println("Selecciona un marine espacial: ");
            opcionJug1=sc.nextInt();
            switch (opcionJug1){
                case 1:
                    faccion1="LOBO ESPACIAL";
                    clase1="ESTRATEGA";
                    velocidad1=150;
                    vida1=100;
                    defensaBase1=100;
                    ataqueBase1=100;
                    regenerar1=50;
                    break;
                case 2:
                    faccion1="ANGEL SANGRIENTO";
                    clase1="ASALTO";
                    velocidad1=100;
                    vida1=100;
                    defensaBase1=150;
                    ataqueBase1=50;
                    regenerar1=50;
                    break;
                case 3:
                    faccion1="ULTRAMARINE";
                    clase1="VANGUARDIA";
                    velocidad1=150;
                    vida1=100;
                    defensaBase1=120;
                    ataqueBase1=50;
                    regenerar1=50;
                    break;

            }

            System.out.println("HEREJES DEL CAOS");
            System.out.println("1.MIL HIJOS -> CLASE: FRANCOTIRADOR "+"\n2.LEGION NEGRA -> CLASE: ESTRATEGA"+"\n3.LEGION ALFA -> CLASE:VANGUARDIA");
            System.out.println("Selecione un hereje del caos: ");
            opcionJug2=sc.nextInt();
            switch (opcionJug2){
                case 1:
                    faccion2="MIL HIJOS";
                    clase2="FRANCOTIRADOR";
                    velocidad2=100;
                    vida2=100;
                    defensaBase2=100;
                    ataqueBase2=150;
                    regenerar2=50;
                    break;
                case 2:
                    faccion2="LEGION NEGRA";
                    clase2="ESTRATEGA";
                    velocidad2=200;
                    vida2=100;
                    defensaBase2=100;
                    ataqueBase2=50;
                    regenerar2=50;
                    break;
                case 3:
                    faccion2="LEGION ALFA";
                    clase2="VANGUARDIA";
                    velocidad2=50;
                    vida2=50;
                    defensaBase2=300;
                    ataqueBase2=50;
                    regenerar2=50;
                    break;
            }

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

        System.out.println(faccion1+" \n"+clase1+"\nVelocidad " + velocidad1 + "\nVida " + vida1 + "\nDefensa " + defensaBase1 + "\nAtaque " + ataqueBase1+"\nRegenerar "+regenerar1);
        System.out.println("\n"+faccion2 +"\n "+clase2+"\nVelocidad " + velocidad2 + "\nVida " + vida2 + "\nDefensa " + defensaBase2 + "\nAtaque " + ataqueBase2+"\nRegenerar "+regenerar1);

        while (combate) {
            //ESTO SE PODRIA REDUCIR CON UN METODO String
            int barras = vida1 / 2, barras2 = vida2 / 2;
            //Mofifica y ordena la cadena para que me aparezaca recta con StringBuilder como: --------------------------- en vez de - \n -
            StringBuilder barra = new StringBuilder();
            StringBuilder barra2 = new StringBuilder();
            //Bucle para reccorer la vida1 del jugador y mostrar la vida1 de manera grafica
            for (int i = 0; i < barras; i++) {
                barra.append("\uD83E\uDD0D");//CORAZON NEGRO
            }
            for (int i = 0; i < barras2; i++) {
                barra2.append("\uD83E\uDD0D");//CORAZON NEGRO
            }

            System.out.println("\n**********************************************");
            System.out.println("RONDA " + rondas);
            System.out.println(faccion1 + " CLASE: "+ clase1+ " VIDA: " + vida1 + " " + barra);
            System.out.println(faccion2 + " CLASE: "+ clase2+ " VIDA: " + vida2 + " " + barra2);


            //determinar quien ataca primero PD: SE PUEDE REDUCIR CON UN METODO INT
            if (velocidad1 >= velocidad2) {
                System.out.println(faccion1 + " Realiza una accion: "+"\nA.Atacar" + "\nC.Curar: ");
                accion1=sc.next().toUpperCase().charAt(0);
                //Ataque jugador 1 a jugador 2
                switch (accion1){
                    case 'A':
                        if (defensaBase2 > ataqueBase1) {
                            hitBase1 = defensaBase2 - ataqueBase1;  // La defensa bloquea el daño, incluso "inflige" daño negativo
                        } else {
                            hitBase1 = ataqueBase1 - defensaBase2 / 2;  // Caso estándar, el ataque es mayor que la defensa
                        }
                        hit1 = Math.max(0, hitBase1 + rand.nextInt(3));
                        // Verificar si es un ataque crítico
                        if (esCritico1 < probabilidadCritico) {
                            hit1 = (int) (hit1 * 1.3); // Aplica el multiplicador de daño crítico
                            System.out.println(faccion1 + " realiza un ataque CRÍTICO!");
                        }
                        //hit1=Math.min(hit1,limiteDamage);//Utilizo Math.min para que tenga un rango de atque aceptable
                        vida2 -= hit1;
                        vida2 = Math.max(0, vida2); // Evitar que vida2 sea negativa
                        System.out.println(faccion1+" golpea primero con "+hit1+" de daño");
                        //Ataque jugador 2 a jugador 1
                        if (vida2>0){
                            System.out.println(faccion2+ " Reailza una accion: "+"\nA.Atacar"+"\nC.Curar");
                            accion2=sc.next().toUpperCase().charAt(0);
                            switch (accion2) {
                                case 'A':
                                    if (defensaBase1 > ataqueBase2) {
                                        hitBase2 = defensaBase1 - ataqueBase2;  // La defensa bloquea el daño, incluso "inflige" daño negativo
                                    } else {
                                        hitBase2 = ataqueBase2 - defensaBase1 / 2;  // Caso estándar, el ataque es mayor que la defensa
                                    }
                                    hit2 = Math.max(0, hitBase2 + rand.nextInt(3));
                                    // Verificar si es un ataque crítico
                                    if (esCritico2 < probabilidadCritico) {
                                        hit2 = (int) (hit2 * 1.3); // Aplica el multiplicador de daño crítico
                                        System.out.println(faccion2 + " realiza un ataque CRÍTICO!");
                                    }
                                    //hit2 = Math.min(hit2, limiteDamage);
                                    vida1 -= hit2;
                                    vida1 = Math.max(0, vida1); // Evitar que vida2 sea negativa
                                    System.out.println(faccion2 + " golpea primero con " + hit1 + " de daño");
                                    break;

                                case 'C':
                                    vida2 += regenerar2;
                                    vida2 = Math.min(vida2, 200); // Evitar que vida1 supere 200
                                    System.out.println(faccion2 + " se cura, + ");
                                    break;
                                default:
                                    System.out.println("Accion no reconocida");
                            }
                        }
                        break;
                    case 'C':
                        vida1 += regenerar1;
                        vida1 = Math.min(vida1, 200); // Evitar que vida1 supere 200
                        System.out.println(faccion1 + " se cura, + ");
                        break;
                    default:
                        System.out.println("Caracter no valido, turno no valido");
                }

            } else {
                System.out.println(faccion2 + " Realiza una accion: " + "\nA.Atacar" + "\nC.Curar: ");
                accion2=sc.next().toUpperCase().charAt(0);
                switch (accion2){
                    case 'A':
                        //Ataque del segundo jugador al jugador 1
                        if (defensaBase1 > ataqueBase2) {
                            hitBase2 = defensaBase1 - ataqueBase2;  // La defensa bloquea el daño, incluso "inflige" daño negativo
                        } else {
                            hitBase2 = ataqueBase2 - defensaBase1 / 2;  // Caso estándar, el ataque es mayor que la defensa
                        }
                        hit2 = Math.max(0, hitBase2 + rand.nextInt(3));

                        if (esCritico2 < probabilidadCritico) {
                            hit2 = (int) (hit2 * 1.3);
                            System.out.println(faccion2 + " realiza un ataque CRÍTICO!");
                        }
                        //hit2=Math.min(hit2,limiteDamage);
                        vida1 -= hit2;
                        vida1 = Math.max(0, vida1);
                        System.out.println(faccion2+" golpea primero con "+hit2+" de daño");

                        //Ataque del primer jugador al segundo
                        if (vida1>0){
                            System.out.println(faccion1+ " Reailza una accion: "+"\nA.Atacar"+"\nC.Curar");
                            accion1=sc.next().toUpperCase().charAt(0);
                            switch (accion1) {
                                case 'A':
                                    if (defensaBase2 > ataqueBase1) {
                                        hitBase1 = defensaBase2 - ataqueBase1;  // La defensa bloquea el daño, incluso "inflige" daño negativo
                                    } else {
                                        hitBase1 = ataqueBase1 - defensaBase2 / 2;  // Caso estándar, el ataque es mayor que la defensa
                                    }
                                    hit1 = Math.max(0, hitBase1 + rand.nextInt(3));
                                    // Verificar si es un ataque crítico
                                    if (esCritico1 < probabilidadCritico) {
                                        hit1 = (int) (hit1 * 1.5); // Aplica el multiplicador de daño crítico
                                        System.out.println(faccion1 + " realiza un ataque CRÍTICO!");
                                    }
                                    //hit1 = Math.min(hit1, limiteDamage);
                                    vida2 -= hit1;
                                    vida2 = Math.max(0, vida2); // Evitar que vida2 sea negativa
                                    System.out.println(faccion1 + " golpea primero con " + hit1 + " de daño");
                                    break;
                                case 'C':
                                    vida1 += regenerar1;
                                    vida1 = Math.min(vida1, 200); // Evitar que vida1 supere 200
                                    System.out.println(faccion1 + " se cura, + " + vida1);
                                    break;
                                default:
                                    System.out.println("Accion no reconocida");
                            }
                        }
                        break;
                    case 'C':
                        vida2 += regenerar1;
                        vida2 = Math.min(vida2, 200); // Evitar que vida1 supere 200
                        System.out.println(faccion2 + " se cura, + " + vida2);
                        break;
                    default:
                        System.err.println("Caracter no valido, turno perdido");
                }
            }
            if (vida1 <= 0 || vida2 <= 0) {
                combate = false;
            }
            rondas++;

        }
        if (vida2 <= 0) {
            System.out.println(faccion1+" ¡VICTORIA!");
            System.out.println("______ ___________   _____ _       ________  _________ ___________  ___ ______ ___________ \n" +
                    "| ___ \\  _  | ___ \\ |  ___| |     |  ___|  \\/  || ___ \\  ___| ___ \\/ _ \\|  _  \\  _  | ___ \\\n" +
                    "| |_/ / | | | |_/ / | |__ | |     | |__ | .  . || |_/ / |__ | |_/ / /_\\ \\ | | | | | | |_/ /\n" +
                    "|  __/| | | |    /  |  __|| |     |  __|| |\\/| ||  __/|  __||    /|  _  | | | | | | |    / \n" +
                    "| |   \\ \\_/ / |\\ \\  | |___| |____ | |___| |  | || |   | |___| |\\ \\| | | | |/ /\\ \\_/ / |\\ \\ \n" +
                    "\\_|    \\___/\\_| \\_| \\____/\\_____/ \\____/\\_|  |_/\\_|   \\____/\\_| \\_\\_| |_/___/  \\___/\\_| \\_");
        } else {
            System.out.println(faccion2+ "¡VICTORIA!");
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
