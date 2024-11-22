/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author David
 */
/**
 * Representa una cola, una estructura de datos FIFO (First-In-First-Out).
 *
 * Esta clase permite agregar elementos al final de la cola (encolar) y eliminar elementos del principio (desencolar).
 */
public class Cola {
    private Nodo head;
    private Nodo tail;
    private int size;

    public Cola() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Nodo getCabeza() {
        return head;
    }

    public void setCabeza(Nodo cabeza) {
        this.head = cabeza;
    }

    public Nodo getCola() {
        return tail;
    }

    public void setCola(Nodo cola) {
        this.tail = cola;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean colaVacia() {
        return this.head == null;
    }

    /**
     * Agrega un nuevo elemento al final de la cola.
     * @param dato El elemento a agregar.
     */
    public void encolar(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (this.colaVacia()) {
            this.setCabeza(pNew);
            this.setCola(pNew);
        } else {
            this.tail.setPnext(pNew);
            this.setCola(pNew);
        }
        size++;
    }

    /**
     * Elimina y devuelve el elemento al principio de la cola.
     * @return El elemento eliminado, o `null` si la cola está vacía.
     */
    public Object desencolar() {
        if (this.colaVacia()) {
            Object quitar = this.head.getDato();
            this.setCabeza(null);
            this.setCola(null);
            size--;
            return quitar;

        } else {
            Object quitar = this.head.getDato();
            this.setCabeza(this.head.getPnext());
            size--;
            return quitar;
        }

    }

     /**
     * Elimina todos los elementos de la cola.
     */
    public void destruir() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Enlista los elementos de la cola en orden de llegada.
     */
    public void listar() {
        Nodo aux = head;
        String pila = "COLA:\n";
        while (aux != null) {
            pila = pila + aux.getDato() + "\n";
            aux = aux.getPnext();
        }
        System.out.println(pila);
    }
}
