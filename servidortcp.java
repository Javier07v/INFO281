import java.net.*;
import java.io.*;

public class servidortcp {
  private static int count = 0;
  public static void main(String argv[]) {

// declaramos un objeto ServerSocket para realizar la comunicación
 ServerSocket socket;
 boolean fin = false;
 System.out.println("Bienvenido al servidor TCP");

// Declaramos un bloque try y catch para controlar la ejecución del subprograma
 try {

// Instanciamos un ServerSocket con la dirección del destino y el
// puerto que vamos a utilizar para la comunicación

 socket = new ServerSocket(6000);

// Creamos un socket_cli al que le pasamos el contenido del objeto socket después
// de ejecutar la función accept que nos permitirá aceptar conexiones de clientes
 Socket socket_cli = socket.accept();
 count+=1;
 System.out.println(count+" Clientes conectados");

// Declaramos e instanciamos el objeto DataInputStream
// que nos valdrá para recibir datos del cliente

 DataInputStream in =
 new DataInputStream(socket_cli.getInputStream());

// Creamos un bucle do while en el que recogemos el mensaje
// que nos ha enviado el cliente y después lo mostramos
// por consola

 do {
 String mensaje ="";
 mensaje = in.readUTF();
 System.out.println(mensaje);
 } while (1>0);
 }
// utilizamos el catch para capturar los errores que puedan surgir
 catch (Exception e) {

// si existen errores los mostrará en la consola y después saldrá del
// programa
 System.err.println(e.getMessage());
 System.exit(1);
 }
 }
}
