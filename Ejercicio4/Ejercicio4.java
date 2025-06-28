/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Andrew
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

    // Insertamos manualmente los valores: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    lista.insertarFinal(1);
    lista.insertarFinal(2);
    lista.insertarFinal(3);
    lista.insertarFinal(4);
    lista.insertarFinal(5);
    lista.insertarFinal(6);
    lista.mostrar();

    // Invertimos desde la posición 2 hasta la 4
    lista.invertirSublista(1, 5);

    // Mostramos el resultado: debería ser 1 -> 4 -> 3 -> 2 -> 5 -> 6
    lista.mostrar();

    }
    
}
