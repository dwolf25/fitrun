package Persona_package;

/**
 * Clase que representa a una persona con su peso y altura
 * para el cálculo del Índice de Masa Corporal (IMC).
 * 
 * @author Deiker Atehortua
 * @version 1.0
 * @since 2025-03-02
 */
public class Persona {
    /**
     * Peso de la persona en kilogramos.
     * Debe ser un valor positivo.
     */
    private double peso;
    
    /**
     * Altura de la persona en metros.
     * Debe ser un valor positivo.
     */
    private double altura;
    
    /**
     * Constructor de la clase Persona.
     * Inicializa los atributos de peso y altura con los valores proporcionados.
     * 
     * @param peso Peso de la persona en kilogramos
     * @param altura Altura de la persona en metros
     * @throws IllegalArgumentException Si el peso o la altura son valores negativos o cero
     */
    public Persona(double peso, double altura) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo mayor que cero");
        }
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo mayor que cero");
        }
        this.peso = peso;
        this.altura = altura;
    }
    
    /**
     * Método para obtener el peso de la persona.
     * 
     * @return El peso en kilogramos
     */
    public double getPeso() {
        return peso;
    }
    
    /**
     * Método para establecer el peso de la persona.
     * 
     * @param peso El peso en kilogramos a establecer
     * @throws IllegalArgumentException Si el peso es un valor negativo o cero
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo mayor que cero");
        }
        this.peso = peso;
    }
    
    /**
     * Método para obtener la altura de la persona.
     * 
     * @return La altura en metros
     */
    public double getAltura() {
        return altura;
    }
    
    /**
     * Método para establecer la altura de la persona.
     * 
     * @param altura La altura en metros a establecer
     * @throws IllegalArgumentException Si la altura es un valor negativo o cero
     */
    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo mayor que cero");
        }
        this.altura = altura;
    }
    
    /**
     * Calcula el Índice de Masa Corporal (IMC) de la persona.
     * La fórmula utilizada es: IMC = peso (kg) / altura² (m)
     * Esta medida se utiliza para evaluar si el peso de una persona
     * es adecuado en relación con su altura.
     * 
     * @return El valor del IMC calculado
     */
    public double calcularIMC() {
        return peso / (altura * altura);
    }
    
    /**
     * Genera un mensaje personalizado basado en el valor del IMC calculado.
     * Basado en las categorías estándar de IMC:
     * - Bajo peso: IMC < 18.5
     * - Peso normal: 18.5 <= IMC <= 24.9
     * - Sobrepeso: IMC > 24.9
     * 
     * @return Mensaje personalizado según el rango del IMC
     */
    public String obtenerMensajeIMC() {
        double imc = calcularIMC();
        String mensaje;
        
        if (imc < 18.5) {
            mensaje = String.format("Tu IMC es %.1f. Estás por debajo del peso normal. ¡Consulta con un médico!", imc);
        } else if (imc <= 24.9) {
            mensaje = String.format("Tu IMC es %.1f. Tienes un peso saludable. ¡Buen trabajo!", imc);
        } else {
            mensaje = String.format("Tu IMC es %.1f. Tienes sobrepeso. ¡Cuida tu salud!", imc);
        }
        
        return mensaje;
    }
    
    /**
     * Devuelve una representación en cadena de texto del objeto Persona.
     * 
     * @return Cadena que contiene el peso y la altura de la persona
     */
    @Override
    public String toString() {
        return "Persona [peso=" + peso + " kg, altura=" + altura + " m, IMC=" + String.format("%.2f", calcularIMC()) + "]";
    }
}