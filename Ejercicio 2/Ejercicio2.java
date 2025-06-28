/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Andrew
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada l1 = new ListaEnlazada();
        l1.insertarFinal(1);
        l1.insertarFinal(2);
        l1.insertarFinal(0);
        l1.mostrar();

        ListaEnlazada l2 = new ListaEnlazada();
        l2.insertarFinal(1);
        l2.insertarFinal(0);
        l2.mostrar();

        ListaEnlazada resultado = ListaEnlazada.restarListas(l1, l2);
        resultado.mostrar(); // Debería imprimir: 8 --> 8 --> null
    }

}
