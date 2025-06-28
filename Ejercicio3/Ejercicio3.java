/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Andrew
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.insertarFinal(1);
        lista.insertarFinal(7);
        lista.insertarFinal(3);
        lista.insertarFinal(4);
        /*lista.insertarFinal(4);
        lista.insertarFinal(5);*/

        System.out.println("Antes de reordenar:");
        lista.mostrar();

        lista.reordenar();

        System.out.println("Después de reordenar:");
        lista.mostrar();

    }
    
}
