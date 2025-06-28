/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

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
        System.out.println(" null");
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
    
    public static ListaEnlazada restarListas(ListaEnlazada l1, ListaEnlazada l2) {
        // Paso 1: Revertir ambas listas
        l1.revertir();
        l2.revertir();

        // Paso 2: Comparar cuál lista representa el número mayor
        boolean l1Mayor = compararListas(l1.head, l2.head);

        Nodo mayor;
        Nodo menor;

        if (l1Mayor) {
            mayor = l1.head;
            menor = l2.head;
        } else {
            mayor = l2.head;
            menor = l1.head;
        }


        // Paso 3: Restar dígito por dígito
        Nodo resultado = null;
        Nodo resultadoActual = null;
        int prestamo = 0;

        while (mayor != null) {
            int m = mayor.clave;
            int s = (menor != null) ? menor.clave : 0;

            int resta = m - s - prestamo;
            if (resta < 0) {
                resta += 10;
                prestamo = 1;
            } else {
                prestamo = 0;
            }

            Nodo nuevo = new Nodo(resta);
            if (resultado == null) {
                resultado = nuevo;
                resultadoActual = nuevo;
            } else {
                resultadoActual.siguiente = nuevo;
                resultadoActual = nuevo;
            }

            mayor = mayor.siguiente;
            if (menor != null) {
                menor = menor.siguiente;
            }
        }

        // Paso 4: Revertir el resultado
        resultado = revertirLista(resultado);

        // Paso 5: Eliminar ceros a la izquierda
        while (resultado != null && resultado.clave == 0 && resultado.siguiente != null) {
            resultado = resultado.siguiente;
        }

        // Crear la lista final
        ListaEnlazada resultadoLista = new ListaEnlazada();
        Nodo actual = resultado;
        while (actual != null) {
            resultadoLista.insertarFinal(actual.clave);
            actual = actual.siguiente;
        }

        return resultadoLista;
    }

// Compara dos listas revertidas y devuelve true si l1 >= l2
    private static boolean compararListas(Nodo l1, Nodo l2) {
        int len1 = 0, len2 = 0;
        Nodo a = l1, b = l2;
        while (a != null) {
            len1++;
            a = a.siguiente;
        }
        while (b != null) {
            len2++;
            b = b.siguiente;
        }

        if (len1 != len2) {
            return len1 > len2;
        }

        a = l1;
        b = l2;
        while (a != null && b != null) {
            if (a.clave != b.clave) {
                return a.clave > b.clave;
            }
            a = a.siguiente;
            b = b.siguiente;
        }
        return true; // Son iguales
    }

// Reversión auxiliar sin modificar la lista original
    private static Nodo revertirLista(Nodo head) {
        Nodo anterior = null;
        Nodo actual = head;
        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        return anterior;
    }

}
