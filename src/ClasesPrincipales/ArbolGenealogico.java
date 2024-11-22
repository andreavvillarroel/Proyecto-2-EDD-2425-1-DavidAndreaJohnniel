/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

import EDD.Arbol;
import EDD.HashTable;

/**
 *
 * @author David
 */

/**
 * Representa un árbol genealógico, almacenando información sobre las relaciones familiares de un linaje específico.
 * Esta clase utiliza una tabla hash (`HashTable`) para mapear individuos a sus nodos correspondientes en la estructura del árbol (`Arbol`).
 * 
 */
public class ArbolGenealogico {
    private HashTable hashTable;
    private Arbol arbol;
    private String nombreLinaje;

    
    /**
     * Construye una nueva instancia de `ArbolGenealogico`.
     * Inicializa la `HashTable` con una capacidad de 100 y crea una nueva instancia de `Arbol`.
     */
    public ArbolGenealogico() {
        this.hashTable = new HashTable(100);
        this.arbol = new Arbol();
    }
    
    /**
     * Obtiene la tabla hash utilizada para almacenar individuos y sus nodos correspondientes.
     * @return La tabla hash.
     */
    public HashTable getHashTable() {
        return hashTable;
    }
    
    /**
     * Establece la tabla hash utilizada para almacenar individuos y sus nodos correspondientes.
     * @param hashTable La nueva tabla hash.
     */
    public void setHashTable(HashTable hashTable) {
        this.hashTable = hashTable;
    }
    
    /**
     * Obtiene el árbol genealógico que representa las relaciones familiares.
     * @return El árbol genealógico.
     */
    public Arbol getArbol() {
        return arbol;
    }
    
    /**
     * Establece el árbol genealógico que representa las relaciones familiares.
     * @param arbol El nuevo árbol genealógico.
     */
    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    } 
    
    /**
     * Obtiene el nombre del linaje asociado con este árbol genealógico.
     * @return El nombre del linaje.
     */
    public String getNombreLinaje() {
        return nombreLinaje;
    }
    
    /**
     * Establece el nombre del linaje asociado con este árbol genealógico.
     * @param nombreLinaje El nuevo nombre del linaje.
     */
    public void setNombreLinaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }
    
    
    
}
