/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author David
 */

public class Lista {
    private Nodo pFirst;
    private int size; 
    
   
    public Lista() {
        this.pFirst = null;
        this.size = 0; 
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    /**Primitivas
     * 
     */
    
    /**Funcion para verificar si la lista es vacia
     * 
     * @return 
     */
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    /**Destructor
     * 
     */
    public void destruir(){
        pFirst = null;
        size = 0;
    }
    
    /**Metodo para insertar al final
     * 
     * @param dato 
     */
    public void InsertarFinal(Object dato){
        Nodo pNew = new Nodo(dato);
        if(isEmpty()){
            pFirst = pNew;
        }else{
            Nodo aux = pFirst;
            while (aux.getPnext() != null){
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }
    
    /**
     * Muestra los elementos de la lista en un cuadro de diálogo.
    */
    public void mostrar(){
        if (!isEmpty()){
            Nodo aux = pFirst;
            String expresion = "";
            while(aux != null){
               expresion = expresion + aux.getDato().toString() + "\n";
               aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null,expresion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
    /**Funcion para eliminar al inicio
     * 
     * @return 
     */
    public boolean eliminarInicio(){
        if(!isEmpty()){
            pFirst = pFirst.getPnext();
            size--;
            return true;
        }else{
            return false;
        }
    }
    /**Función para eliminar al final
     * 
     */
    public void eliminarFinal(){
        if(!isEmpty()){
            if (getSize()==1) {
                destruir();
            }else{
                Nodo pointer = getpFirst();
                while(pointer.getPnext() != null && pointer.getPnext().getPnext()!= null){
                    pointer = pointer.getPnext();
                }
                pointer.setPnext(null);
            }
            size --;
        }  
    }
    
    /**Funcion para buscar un elemento en la lista
     * 
     * @param referencia
     * @return 
     */
    public boolean buscar(Object referencia){
        Nodo aux = pFirst;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){ 
                encontrado = true;
            }
            else{
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
    /**
    * Obtiene el valor del elemento en la posición especificada de la lista.
    * @param posicion El índice del elemento a obtener.
    * @return El valor del elemento en la posición indicada, o `null` si la posición es inválida.
    */
    public Object getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
    
    /**
     * Convierte la lista en una cadena de texto, separando los elementos por líneas.
    * @return Una cadena de texto que representa los elementos de la lista, o "Lista vacía" si la lista está vacía.
     */
    public String transformar(){
        if(!isEmpty()){
            
            Nodo aux = pFirst;
            String expresion = "";
            
            for(int i = 0; i <size;i++){
            expresion += aux.getDato().toString() + "\n";
            aux = aux.getPnext();
            }
            return expresion;
        }
        return "Lista vacia";
    }
}
