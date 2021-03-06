package ocajuego;
import java.util.Scanner;
import java.util.Random;
/**
 * @author Juan Antonio Rodríguez Cabrera
 */
public class JuegoOcaV2 {
        public static void main(String[] args) {
            //Declaracion de variables
            Random r = new Random();
            Scanner pause = new Scanner(System.in);
            
            //variables que utilizo
            int dado,turno=1,jugador,jugador1=0,jugador2=0, contador1=0, contador2=0;
            String ganador = " ",oca = "¡El jugador ha caido en una oca, avanza a la siguiente y vuelve a tirar!";
            boolean fin = false, repite = true,J1pierde1Turno= false, J2pierde1Turno= false, J1pierde2Turnos = false, J2pierde2Turnos=false; 
                
            //Bucle general que controla la partida 
            do {     
                //Seccion de código que controla las pérdidas de turno
                if (turno == 1 && J1pierde1Turno) {
                    turno =0 ;
                    J1pierde1Turno = false;
                }
                if (turno==0 && J2pierde1Turno){
                    turno = 1;
                    J2pierde1Turno = false;
                }
                if (turno == 1 && J1pierde2Turnos) {
                    turno =0 ;
                    contador1--;
                    if(contador1==0)
                    J1pierde2Turnos = false;
                }
                if (turno==0 && J2pierde2Turnos){
                    turno = 1;
                    contador2--;
                    if(contador2==0)
                    J2pierde2Turnos = false;
                }
                        //Bloque de tiradas, si turno es igual a 1 el jugador actual pasa a ser el jugado 1
                        //Si el turno no es uno el jugador actual pasa a ser el jugador 2
                        if (turno==1) {
                        System.out.println("");
                        System.out.println("Turno de Jugador 1");
                        System.out.println("Casilla Actual -> "+jugador1);
                        System.out.println("¡Pulsa Enter para tirar!");
                        pause.nextLine();
                        dado = r.nextInt(6)+1;
                        System.out.println("Tirada -> "+dado);
                        jugador=jugador1+dado;
                        if(jugador <= 63)
                        System.out.println("El jugador se desplaza a la casilla: "+jugador);
                        }else{
                        System.out.println("");
                        System.out.println("Turno de Jugador 2");
                        System.out.println("Casilla Actual -> "+jugador2);

                        System.out.println("¡Pulsa Enter para tirar!");
                        pause.nextLine();
                        dado = r.nextInt(6)+1;
                        System.out.println("Tirada -> "+dado);
                        jugador=jugador2+dado;
                        if(jugador <= 63)
                        System.out.println("El jugador se desplaza a la casilla: "+jugador);
                        }

                    //Este bucle controla las caídas en casillas especiales
                    while (repite){
 
                        switch (jugador) {
                        case 5:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 9 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("Ha sacado un "+dado+" en la tirada extra");
                            jugador =9+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 6:
                            System.out.println("El jugador ha caído en el puente bueno, va a la casilla 12 y vuelve a tirar");
                            dado = r.nextInt(6)+1;
                            System.out.println("Ha sacado un "+dado+" en la tirada extra");
                            jugador = 12+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 9:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 14 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("Ha sacado un "+dado+" en la tirada extra");
                            jugador =14+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 12:
                            System.out.println("El jugador ha caído en el puente malo, vuelve a la casilla 6");
                            dado = r.nextInt(6)+1;
                            System.out.println("Ha sacado un "+dado+" en la tirada extra");
                            jugador = 6+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 13:    
                            System.out.println("El jugador ha caído en La Comba. Pierde un turno... :(");
                            if(turno == 1){
                                jugador1 = jugador;
                                turno = 0;
                                J1pierde1Turno = true;
                                repite = false;
                            }else{
                                jugador2=jugador;
                                turno = 1;
                                J2pierde1Turno = true;
                                repite = false;
                            }
                            break;
                        case 14:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 18 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =18+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 18:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 23 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =23+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 23:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 27 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =27+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 26:
                            System.out.println("El jugador ha caído en el la casilla de dados, viaja a la casilla 53 y tira otra vez");
                            jugador = 53;
                            dado = r.nextInt(6)+1;
                            System.out.println("Ha sacado un "+dado+" en la tirada extra");
                            jugador += dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 27:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 32 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =32+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 31:
                            System.out.println("El jugador ha caído en El Pozo. Pierde un turno... :( ");
                            if(turno == 1){
                                jugador1 = jugador;
                                turno = 0;
                                J1pierde1Turno = true;
                                repite = false;
                            }else{
                                jugador2 = jugador;
                                turno = 1;
                                J2pierde1Turno = true;
                                repite = false;
                            }
                            break;
                        case 32:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 36 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =36+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 36:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 41 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =41+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 41:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 45 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =45+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 42:
                            System.out.println("El jugador ha caído en El Laberinto. Pierde un turno... :(");
                            if(turno == 1){
                                jugador1 = jugador;
                                turno = 0;
                                J1pierde1Turno = true;
                                repite = false;
                            }else{
                                jugador2 = jugador;
                                turno = 1;
                                J2pierde1Turno = true;
                                repite = false;
                            }
                            break;
                        case 45:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 50 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =50+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 50:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 54 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =54+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 52:
                            System.out.println("El jugador ha caído en La Prision. Pierde dos turnos... :(");
                            if(turno == 1){
                                jugador1 = jugador;
                                turno = 0;
                                J1pierde2Turnos = true;
                                contador1=2;
                                repite = false;
                            }else{
                                jugador2 = jugador;
                                turno = 1;
                                J2pierde2Turnos = true;
                                contador2=2;
                                repite = false;
                            }
                            break;
                        case 53:
                            System.out.println("El jugador ha caído en la casilla de dados, vuelve a la casilla 26 y tira otra vez");
                            jugador = 26;
                            dado = r.nextInt(6)+1;
                            System.out.println("Ha sacado un "+dado+" en la tirada extra");
                            jugador += dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 54:
                            System.out.println(oca);
                            System.out.println("El jugador avanza a la 59 y tira");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =59+dado;
                            System.out.println("El jugador se desplaza a la casilla: "+jugador);
                            break;
                        case 59:
                            System.out.println("¡El jugador ha caido en una oca y vuelve a tirar");
                            dado = r.nextInt(6)+1;
                            System.out.println("¡Ha sacado un "+dado+" en la tirada extra!");
                            jugador =59+dado;
                            break;
                        default:
                            if (turno == 1) {
                                jugador1 = jugador;
                                if (jugador1 == 63) {
                                    ganador = "Jugador1";
                                    fin = true;
                                }else if(jugador1 > 63){
                                    jugador1 = 63 - (jugador1-63);
                                }
                                turno =0;
                            }else{
                                jugador2 = jugador;
                                if (jugador2 == 63) {
                                    ganador = "Jugador2";
                                    fin = true;
                                }else if(jugador2 > 63){
                                    jugador2 = 63 - (jugador2-63);         
                                }
                                turno =1;
                            }
                            repite = false;
                            break;
                        }
                    }//fin bucle casillas especiales y reseteo "repite" a true para que compruebe las ocas en la siguiente tirada
                    repite=true;
 
            }while(!fin);
            System.out.println("******** Ganador de la partida ********");
            System.out.println("-------> "+ganador+" <--------");
        } 
}