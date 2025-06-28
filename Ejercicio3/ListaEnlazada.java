/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Andrew
 */
public class ListaEnlazada {
    private Nodo head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int obtenerTamanio() {
        return size;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.clave + " -->");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = head;
        head = nuevo;
        size++;
    }

    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    public void insertarEnPosicion(int valor, int posicion) {
        if (posicion < 1 || posicion > size + 1) {
            System.out.println("Posición inválida para inserción");
            return;
        }
        if (posicion == 1) {
            insertarInicio(valor);
        } else if (posicion == size + 1) {
            insertarFinal(valor);
        } else {
            Nodo nuevo = new Nodo(valor);
            Nodo actual = head;
            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            size++;
        }
    }

    public void actualizarValor(int valor, int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para actualización");
            return;
        }
        Nodo actual = head;
        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }
        actual.clave = valor;
    }

    public void eliminarInicio() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        head = head.siguiente;
        size--;
    }

    public void eliminarFinal() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        if (head.siguiente == null) {
            head = null;
        } else {
            Nodo actual = head;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
        }
        size--;
    }

    public void eliminarEnPosicion(int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para eliminación");
            return;
        }
        if (posicion == 1) {
            eliminarInicio();
        } else {
            Nodo actual = head;
            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
            size--;
        }
    }

    public void revertir() {
        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }
    
    public void reordenar() {
    if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
    // Paso 1: Encontrar el punto medio
    Nodo lento = head;
    Nodo rapido = head;
    while (rapido.siguiente != null && rapido.siguiente.siguiente != null) {
        lento = lento.siguiente;
        rapido = rapido.siguiente.siguiente;
    }

    // Paso 2: Revertir la segunda mitad
    Nodo segundaMitad = lento.siguiente;
    lento.siguiente = null; // Cortar la lista
    Nodo anterior = null;
    while (segundaMitad != null) {
        Nodo siguiente = segundaMitad.siguiente;
        segundaMitad.siguiente = anterior;
        anterior = segundaMitad;
        segundaMitad = siguiente;
    }

    // Paso 3: Intercalar ambas mitades
    Nodo primera = head;
    Nodo segunda = anterior;
    while (segunda != null) {
        Nodo temp1 = primera.siguiente;
        Nodo temp2 = segunda.siguiente;

        primera.siguiente = segunda;
        segunda.siguiente = temp1;

        primera = temp1;
        segunda = temp2;
    }
}
}
