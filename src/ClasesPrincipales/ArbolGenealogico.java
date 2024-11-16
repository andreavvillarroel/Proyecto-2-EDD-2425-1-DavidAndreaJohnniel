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
public class ArbolGenealogico {
    private HashTable hashTable;
    private Arbol arbol;

    public ArbolGenealogico() {
        this.hashTable = new HashTable(100);
        this.arbol = new Arbol();
    }

    public HashTable getHashTable() {
        return hashTable;
    }

    public void setHashTable(HashTable hashTable) {
        this.hashTable = hashTable;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    } 
    
}
