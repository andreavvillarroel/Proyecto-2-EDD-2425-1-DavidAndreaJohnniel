/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import ClasesPrincipales.Persona;

/**
 * Representa un árbol genealógico, donde cada nodo contiene información sobre una persona.
 * Permite insertar, buscar y recorrer el árbol de forma eficiente.
 */
public class Arbol {
     /**
     * Raíz del árbol genealógico.
     */
    private NodoA root;

    public Arbol() {
        this.root = null;
    }

    public NodoA getRoot() {
        return root;
    }

    public void setRoot(NodoA root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void asignarRaiz(Persona persona) {
        NodoA newRoot = new NodoA(persona);
        this.setRoot(newRoot);
    }
    /**
     * Inserta una nueva persona en el árbol, como hijo del nodo padre especificado.
     * @param padre El nodo padre donde se insertará el nuevo nodo.
     * @param persona La persona a insertar.
     * @return `true` si la inserción fue exitosa, `false` si la persona ya existe.
     */
    public boolean insertar(NodoA padre, Persona persona) {
        String clave;

        if (persona.getMote() != null) {
            clave = persona.getMote();
            String nombreUnico = persona.getNombre() + " " + persona.getNumeral();
            if (this.buscarPorNombreClave(clave) == null && this.buscarPorNombreClave(nombreUnico) == null) {
                NodoA hijoNuevo = new NodoA(persona);
                hijoNuevo.setPadre(padre);
                padre.insertarHijo(hijoNuevo);
                return true;
            }
            
        } else {
            clave = persona.getNombre() + " " + persona.getNumeral();
            if (this.buscarPorNombreClave(clave) == null) {
                NodoA hijoNuevo = new NodoA(persona);
                hijoNuevo.setPadre(padre);
                padre.insertarHijo(hijoNuevo);
                return true;
            }
        }
        
        return false;
    }
    /**
     * Busca un nodo en el árbol por su nombre o mote.
     * @param nombre El nombre o mote a buscar.
     * @return El nodo encontrado, o `null` si no se encuentra.
     */
    public NodoA buscarPorNombreClave(String nombre) {
        if (this.isEmpty()) {
            return null;
        }

        Cola cola = new Cola();
        cola.encolar(root);

        while (!cola.colaVacia()) {
            NodoA nodoActual = (NodoA) cola.desencolar();
            Persona persona = nodoActual.getPersona();

            if (persona.getMote() != null) {
                if (persona.getMote().equalsIgnoreCase(nombre)) {
                    return nodoActual;
                } else {
                    String nombreComparar = persona.getNombre() + " " + persona.getNumeral();

                    if (nombreComparar.equalsIgnoreCase(nombre)) {
                        return nodoActual;
                    }

                }
            } else {
                String nombreComparar = persona.getNombre() + " " + persona.getNumeral();

                if (nombreComparar.equalsIgnoreCase(nombre)) {
                    return nodoActual;
                }
            }
            Nodo aux = nodoActual.getHijos().getpFirst();
            while (aux != null) {
                NodoA hijo = (NodoA) aux.getDato();
                cola.encolar(hijo);
                aux = aux.getPnext();
            }
        }

        return null;
    }
    /**
     * Obtiene el nivel máximo del árbol.
     * @return El nivel máximo del árbol.
     */
    public int obtenerNivelMaximo() {
        if (this.isEmpty()) {
            return 0; // El árbol está vacío
        }

        int nivelMaximo = 0;
        Cola cola = new Cola();
        cola.encolar(root);

        // Usamos una lista adicional para registrar los niveles actuales de los nodos
        Cola niveles = new Cola();
        niveles.encolar(1); // Nivel inicial de la raíz

        while (!cola.colaVacia()) {
            NodoA nodoActual = (NodoA) cola.desencolar();
            int nivelActual = (int) niveles.desencolar();

            // Actualizar el nivel máximo encontrado
            nivelMaximo = Math.max(nivelMaximo, nivelActual);

            // Encolar los hijos y sus niveles correspondientes
            Nodo hijoNodo = nodoActual.getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoA hijo = (NodoA) hijoNodo.getDato();
                cola.encolar(hijo);
                niveles.encolar(nivelActual + 1); // Incrementar el nivel para los hijos
                hijoNodo = hijoNodo.getPnext();
            }
        }

        return nivelMaximo;
    }

    /**
     * Lista todos los nodos que se encuentran en un nivel específico del árbol.
     * @param nivelBuscado El nivel a buscar.
     * @return Una lista con los nodos encontrados en el nivel especificado.
     */
    public Lista listarNodosEnNivel(int nivelBuscado) {
        Lista nodosNivel = new Lista();

        if (this.isEmpty()) {
            return nodosNivel; // Si el árbol está vacío, retorna una lista vacía
        }

        Cola cola = new Cola();
        cola.encolar(root);

        // Lista adicional para manejar los niveles de los nodos
        Cola niveles = new Cola();
        niveles.encolar(1); // Nivel inicial para la raíz

        while (!cola.colaVacia()) {
            NodoA nodoActual = (NodoA) cola.desencolar();
            int nivelActual = (int) niveles.desencolar();

            // Si el nodo está en el nivel buscado, agregarlo a la lista
            if (nivelActual == nivelBuscado) {
                nodosNivel.InsertarFinal(nodoActual.getPersona());
            }

            // Encolar hijos con su nivel incrementado
            Nodo hijoNodo = nodoActual.getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoA hijo = (NodoA) hijoNodo.getDato();
                cola.encolar(hijo);
                niveles.encolar(nivelActual + 1); // Incrementar nivel
                hijoNodo = hijoNodo.getPnext();
            }
        }

        return nodosNivel;
    }

    /**
     * Muestra el árbol por niveles.
     */
    public void mostrarArbolPorNiveles() {
        if (this.isEmpty()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Cola cola = new Cola();
        cola.encolar(root);

        // Lista auxiliar para manejar niveles
        Cola niveles = new Cola();
        niveles.encolar(1); // Nivel inicial para la raíz

        int nivelActual = 1;
        System.out.println("Nivel " + nivelActual + ":");

        while (!cola.colaVacia()) {
            NodoA nodoActual = (NodoA) cola.desencolar();
            int nivelNodo = (int) niveles.desencolar();

            // Imprimir salto de línea si cambiamos de nivel
            if (nivelNodo > nivelActual) {
                nivelActual = nivelNodo;
                System.out.println("\nNivel " + nivelActual + ":");
            }

            // Imprimir el nodo actual
            Persona persona = (Persona) nodoActual.getPersona();
            System.out.print(persona.getNombre() + "  ");

            // Encolar hijos y sus niveles correspondientes
            Nodo hijoNodo = nodoActual.getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoA hijo = (NodoA) hijoNodo.getDato();
                cola.encolar(hijo);
                niveles.encolar(nivelActual + 1);
                hijoNodo = hijoNodo.getPnext();
            }
        }

        System.out.println();
    }

}
