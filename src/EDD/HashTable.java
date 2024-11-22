/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import ClasesPrincipales.Persona;

/**
 *
 * @author David
 */
/**
 * Representa una tabla hash, una estructura de datos que permite almacenar y recuperar elementos de forma eficiente.
 *
 * Esta implementación utiliza listas enlazadas para manejar colisiones.
 */
public class HashTable {
    private Lista[] tabla;
    private int max;

    /**
     * Constructor que inicializa la tabla hash con el tamaño especificado.
     * @param max El tamaño máximo de la tabla hash.
     */
    public HashTable(int max) {
        this.max = max;
        this.tabla = new Lista[max];
        for (int i = 0; i < max; i++) {
            tabla[i] = new Lista();
        }
    }
    
    /**
     *   Getters y setters para cada atributo
     */
    
    public Lista[] getTabla() {
        return tabla;
    }

    public void setTabla(Lista[] tabla) {
        this.tabla = tabla;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    /**
     * Calcula el índice en la tabla hash para una clave dada.
     * @param clave La clave del elemento.
     * @return El índice correspondiente en la tabla hash.
     */
    public int getIndex(String clave){
       return Math.abs(clave.hashCode()) % max;
    }
    
    /**
     * Inserta un elemento en la tabla hash.
     * @param clave La clave del elemento.
     * @param persona El elemento a insertar.
     */
    public void insertar(String clave, Persona persona){
    
    }
    /**
     * Busca un elemento en la tabla hash por su clave.
     * @param clave La clave del elemento a buscar.
     * @return El elemento encontrado, o `null` si no se encuentra.
     */
    public Persona buscar(String clave){
        return null;
    }
    
    /**
     * Muestra el contenido de la tabla hash.
     */
    public void mostrar(){
    
    }
    
    /**
     * Elimina todos los elementos de la tabla hash.
     */
    public void destruir(){
    
    }
}
