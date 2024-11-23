/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import ClasesPrincipales.Persona;
import EDD.Arbol;
import EDD.HashTable;
import EDD.NodoA;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author David
 */
/**  
 * La clase Cargar maneja la carga de datos desde un archivo JSON  
 * y organiza esta información en un árbol y una tabla hash.  
 */  
public class Cargar {
    private Arbol arbol;
    private HashTable hashTable;
    private String nombreLinaje;
    private int errores = 0;
    private int nombreRepetido = 0;
    
    
    /**
     * Constructor por defecto que inicializa el árbol genealógico y la tabla hash.
     */
    public Cargar() {
        this.arbol = new Arbol();
        this.hashTable = new HashTable(100);
    }
    
    /**Getters y setters
     * 
     * @return 
     */
    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public HashTable getHashTable() {
        return hashTable;
    }

    public void setHashTable(HashTable hashTable) {
        this.hashTable = hashTable;
    }

    public String getNombreLinaje() {
        return nombreLinaje;
    }

    public void setNombreLinaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }
    
    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getNombreRepetido() {
        return nombreRepetido;
    }

    public void setNombreRepetido(int nombreRepetido) {
        this.nombreRepetido = nombreRepetido;
    }
    
    /**
     * Verifica si la carga de datos fue exitosa.
     *
     * @return `true` si la carga fue exitosa, `false` en caso contrario.
     */
    public boolean cargaExitosa(){
        return errores == 0 && nombreRepetido == 0;
    }
        
     /**
     * Carga datos de un archivo JSON.
     *
     * @param rutaArchivo La ruta del archivo JSON a cargar.
     */
    public void cargar(String rutaArchivo) {
        this.setErrores(0);
        this.setNombreRepetido(0);
        
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);
            
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray miembros = jsonObj.getAsJsonArray(nombreCasa);
                this.setNombreLinaje(nombreCasa);
                for (JsonElement miembro : miembros) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.agregarHashTable(personaObj);
                }
            }
            
            
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray miembros = jsonObj.getAsJsonArray(nombreCasa);
                for (JsonElement miembro : miembros) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.agregarArbol(personaObj);
                }
            }
            
            if(errores != 0 || nombreRepetido!= 0){
                this.arbol = new Arbol();
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
        
    /**
     * Agrega una persona al árbol genealógico.
     *
     * @param personaObj El objeto JSON que representa a la persona.
     */
    private void agregarArbol(JsonObject personaObj){
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray atributos = personaObj.getAsJsonArray(nombreCompleto);

        Persona personaNueva = crearPersona(nombreCompleto, atributos);
        
        
        if (personaNueva.getPadre().equalsIgnoreCase("[Unknown]")){
           this.arbol.asignarRaiz(personaNueva);
        }else{
            if(personaNueva.getPadre().contains("of his name")){
                personaNueva.setPadre(personaNueva.getPadre().replaceAll("of his name", "").replaceAll(",", "").trim());
                
                NodoA padre = this.arbol.buscarPorNombreClave(personaNueva.getPadre());
                if(padre != null){
                    if(!this.arbol.insertar(padre, personaNueva)){
                        nombreRepetido++;
                    }
                }else{
                   errores++; 
                }
            }else{
                NodoA padre = this.arbol.buscarPorNombreClave(personaNueva.getPadre());
                if(padre != null){
                    if(!this.arbol.insertar(padre, personaNueva)){
                        nombreRepetido++;
                    }
                }else{
                    errores++;
                }
            }
        }
    }
    
     /**
     * Agrega una persona a la tabla hash.
     *
     * @param personaObj El objeto JSON que representa a la persona.
     */
    private void agregarHashTable(JsonObject personaObj) {
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray atributos = personaObj.getAsJsonArray(nombreCompleto);

        Persona personaNueva = crearPersona(nombreCompleto, atributos);
        
        if(personaNueva.getMote() != null){
            String clave = personaNueva.getMote();
            this.hashTable.insertar(clave, personaNueva);
        }else{
            String clave = personaNueva.getNombre()+" "+ personaNueva.getNumeral();
            this.hashTable.insertar(clave, personaNueva);
        }
    }
    
    /**
     * Crea una instancia de la clase `Persona` a partir de un objeto JSON.
     *
     * @param nombreCompleto El nombre completo de la persona.
     * @param atributos Los atributos de la persona en formato JSON.
     * @return Una instancia de la clase `Persona`.
     */
    private Persona crearPersona(String nombreCompleto, JsonArray atributos) {
        String numeral = null;
        String padre = null;
        String madre = null;
        String mote = null;
        String titulo = null;
        String esposa = null;
        String colorOjos = null;
        String colorCabello = null;
        String comentariosVida = null;
        String comentariosMuerte = null;
        
        for (JsonElement atributoElem : atributos) {
            JsonObject atributo = atributoElem.getAsJsonObject();
            if(atributo.has("Of his name")){
                numeral = atributo.get("Of his name").getAsString();
            }else if(atributo.has("Born to")){
                String parent = atributo.get("Born to").getAsString();
                if(padre == null){
                    padre = parent;
                }else{
                    madre = parent;
                }
            }else if(atributo.has("Known throughout as")){
               mote = atributo.get("Known throughout as").getAsString();
            }else if(atributo.has("Held title")){
                titulo = atributo.get("Held title").getAsString();
            }else if(atributo.has("Wed to")){
                esposa = atributo.get("Wed to").getAsString();
            }else if(atributo.has("Of eyes")){
                 colorOjos = atributo.get("Of eyes").getAsString();
            }else if(atributo.has("of hair")){
                colorCabello = atributo.get("of hair").getAsString();
            }else if(atributo.has("of hair")){
                colorCabello = atributo.get("of hair").getAsString();
            }else if(atributo.has("of hair")){
                colorCabello = atributo.get("of hair").getAsString();
            }else if(atributo.has("Notes")){
                comentariosVida = atributo.get("Notes").getAsString();
            }else if(atributo.has("Fate")){
                comentariosMuerte = atributo.get("Fate").getAsString();
            }
        }
        return new Persona(nombreCompleto, numeral, padre, madre, mote, titulo, esposa, colorOjos, colorCabello, comentariosVida, comentariosMuerte);
    }

}
