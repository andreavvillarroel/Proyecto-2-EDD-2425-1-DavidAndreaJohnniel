/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author David
 */
/**
 * Representa a una persona con información genealógica.
 */
public class Persona {
    private String nombre;
    private String numeral;
    private String padre;
    private String madre;
    private String mote;
    private String titulo;
    private String esposa;
    private String colorOjos;
    private String colorCabello;
    private String comentariosVida;
    private String comentariosMuerte;

    /**
     * Constructor que inicializa todos los atributos con valores nulos.
     * @param nombre El nombre de la persona.
     */
    public Persona(String nombre) {
        this.nombre = nombre;
        this.numeral = null;
        this.padre = null;
        this.madre = null;
        this.mote = null;
        this.titulo = null;
        this.esposa = null;
        this.colorOjos = null;
        this.colorCabello = null;
        this.comentariosVida = null;
        this.comentariosMuerte = null;
    }
    /**
     *   Constructor que inicializa todos los atributos con los valores proporcionados.
     *
     */
    public Persona(String nombre, String numeral, String padre, String madre, String mote, String titulo, String esposa, String colorOjos, String colorCabello, String comentariosVida, String comentariosMuerte) {
        this.nombre = nombre;
        this.numeral = numeral;
        this.padre = padre;
        this.madre = madre;
        this.mote = mote;
        this.titulo = titulo;
        this.esposa = esposa;
        this.colorOjos = colorOjos;
        this.colorCabello = colorCabello;
        this.comentariosVida = comentariosVida;
        this.comentariosMuerte = comentariosMuerte;
    }
    
    /**
     *   Getters y setters para cada atributo
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEsposa() {
        return esposa;
    }

    public void setEsposa(String esposa) {
        this.esposa = esposa;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    public String getComentariosVida() {
        return comentariosVida;
    }

    public void setComentariosVida(String comentariosVida) {
        this.comentariosVida = comentariosVida;
    }

    public String getComentariosMuerte() {
        return comentariosMuerte;
    }

    public void setComentariosMuerte(String comentariosMuerte) {
        this.comentariosMuerte = comentariosMuerte;
    }
    
    public String getNameUnique(){
        if(this.mote != null){
            return this.mote;
        }
        
        return this.nombre + " " + this.numeral;
    }
    
    /**
     * Devuelve una representación en cadena de la persona, incluyendo todos sus atributos.
     * @return La representación en cadena de la persona.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalles Miembro:");
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nNumeral: ").append(numeral);
        sb.append("\nPadre: ").append(padre);
        sb.append("\nMadre: ").append(madre);
        sb.append("\nMote:").append(mote);
        sb.append("\nTitulo: ").append(titulo);
        sb.append("\nEsposa: ").append(esposa);
        sb.append("\nColor de Ojos: ").append(colorOjos);
        sb.append("\nColor de Cabello: ").append(colorCabello);
        sb.append("\nComentarios de su Vida: ").append(comentariosVida);
        sb.append("\nComentarios de su Muerte: ").append(comentariosMuerte);
        return sb.toString();
    }
    
    
    
}
