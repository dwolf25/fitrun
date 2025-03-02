package Main_package;

//FitRun , programa para calcular el IMC según tu peso(kg) y tu altura (M)

//aqui exportamos  la utilidad de scanner
import java.util.Scanner;
//esta utilidad que exportamos 
import java.util.InputMismatchException;
//import desde el paquete de la clase Persona
import Persona_package.Persona;

/**
 * Clase principal ejecutable para calcular el IMC.
 * Esta clase proporciona la interfaz de usuario para interactuar con la aplicación,
 * solicitando el peso y la altura del usuario, creando un objeto Persona
 * y mostrando el resultado del cálculo del IMC con un mensaje personalizado.
 * Incluye validación de entradas para manejar datos incorrectos.
 * 
 * @author Deiker Atehortua
 * @version 1.0
 * @since 2025-03-02
 */
public class Main {
    
    /**
     * Método principal que inicia la ejecución del programa.
     * Controla el flujo de la aplicación, la entrada de datos,
     * la validación y el procesamiento para calcular el IMC.
     * 
     * @param 
     */
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Variables para almacenar peso y altura
        double peso = 0;
        double altura = 0;
        boolean entradaValida = false;
        
        // metodo para dar bienvenida al programa.
        mostrarBienvenida();
        
        // establecemos el valor de la var según la información ingresada
        peso = obtenerPesoValido(scanner);
        
        // igualmente  lo de arriba pero para la altura
        altura = obtenerAlturaValida(scanner);
        
        //  procedemos a cerrar el scanner para evitar fugas de recursos
        scanner.close();
        
        try {
            // Creamos un objeto "Persona" con los datos proporcionados
            Persona persona = new Persona(peso, altura);
            
            // Calcular el IMC y obtener el mensaje personalizado
            String mensaje = persona.obtenerMensajeIMC();
            
            // Mostrar el resultado
            System.out.println("\nResultado:");
            System.out.println(mensaje);
            
            // Mostrar información adicional sobre categorías de IMC
            mostrarInformacionIMC();
        } catch (Exception e) {
            System.out.println("Error inesperado al calcular el IMC: " + e.getMessage());
        }
    }
    
    /**
     * Muestra un mensaje de bienvenida al usuario explicando
     * el propósito del programa.
     */
    private static void mostrarBienvenida() {
        System.out.println("=============================================");
        System.out.println("CALCULADORA DE ÍNDICE DE MASA CORPORAL (IMC)");
        System.out.println("=============================================");
        System.out.println("Esta aplicación calculará tu IMC basado en tu peso y altura,");
        System.out.println("y te proporcionará una evaluación personalizada.");
        System.out.println("Por favor, sigue las instrucciones a continuación.");
        System.out.println("=============================================\n");
    }
    
    /**
     * Solicita y valida la entrada del peso del usuario.
     * Continúa solicitando hasta que se introduce un valor válido.
     * 
     * @param scanner Objeto Scanner para leer la entrada del usuario
     * @return El peso válido ingresado por el usuario
     */
    
    //excepción  realizada con condicionales para validar que la entrada de datos siempre cumple
    //los requisitos para que no interrupa el funcionamiento del programa.
    private static double obtenerPesoValido(Scanner scanner) {
        double peso = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print("Introduce tu peso en kilogramos: ");
                peso = scanner.nextDouble();
                
                if (peso <= 0) {
                    System.out.println("Error: El peso debe ser un valor positivo mayor que cero.");
                    continue;
                }
                
                entradaValida = true;
                //estos catch permiten capturar diferencias del formato del evento
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número para el peso. No se admiten letras ni caracteres especiales.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
        
        return peso;
    }
    
    /**
     * Solicita y valida la entrada de la altura del usuario.
     * Continúa solicitando hasta que se introduce un valor válido.
     * Incluye verificación adicional para valores inusualmente altos.
     * 
     * @param scanner Objeto Scanner para leer la entrada del usuario
     * @return La altura válida ingresada por el usuario
     */
    
    //lo  mismo pero para la altura
    private static double obtenerAlturaValida(Scanner scanner) {
        double altura = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print("Introduce tu altura en metros: ");
                altura = scanner.nextDouble();
                
                if (altura <= 0) {
                    System.out.println("Error: La altura debe ser un valor positivo mayor que cero.");
                    continue;
                }
                
                if (altura > 3) {
                    System.out.println("Advertencia: Has introducido una altura de " + altura + " metros. ¿Es correcto? (s/n)");
                    scanner.nextLine(); // Limpiar el buffer
                    String confirmacion = scanner.nextLine().toLowerCase();
                    
                    if (!confirmacion.equals("s") && !confirmacion.equals("si") && !confirmacion.equals("sí")) {
                        System.out.println("Por favor, introduce tu altura nuevamente.");
                        continue;
                    }
                }
                
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número para la altura. No se admiten letras ni caracteres especiales.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
        
        return altura;
    }
    // me parecio interesante poder realizar un feedback dependiendo del IMC que la persona
    //me este ingresando para darle mas dinamismo al programa y funcionalidad.
    /**
     * Muestra información adicional sobre las categorías de IMC
     * y recomendaciones generales de salud.
     */
    private static void mostrarInformacionIMC() {
        System.out.println("\nInformación sobre categorías de IMC:");
        System.out.println("- Bajo peso: IMC < 18.5");
        System.out.println("- Peso normal: 18.5 <= IMC <= 24.9");
        System.out.println("- Sobrepeso: 25 <= IMC <= 29.9");
        System.out.println("- Obesidad: IMC >= 30");
        System.out.println("\nRecuerda que el IMC es solo un indicador y no tiene en cuenta");
        System.out.println("factores como la composición corporal, la edad o el sexo.");
        System.out.println("Para una evaluación más completa, consulta con un profesional de la salud.");
    }
}