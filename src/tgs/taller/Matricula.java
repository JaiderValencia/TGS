/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgs.taller;

/**
 *
 * @author Ilder
 */
public class Matricula {

    // Campos (atributos) de la clase
    private String nombre, genero, deporte;  // Nombre del estudiante

    private int id;         // Identificación o número de matrícula (Entero)
    private boolean estado, mfr; // Estado de la matrícula (true = Activa, false = Inactiva)

    // --- 1. Constructor ---
    // Se utiliza para inicializar los objetos de la clase
    public Matricula(String nombre, String genero, int id, boolean estado) {
        this.nombre = nombre;
        this.genero = genero;
        this.id = id;
        this.estado = estado;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isMfr() {
        return mfr;
    }

    public void setMfr(boolean mfr) {
        this.mfr = mfr;
    }

    // --- 2. Métodos Getters (para obtener los valores de los campos) ---
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public String toString() {
        String estadoTexto = this.estado ? "ACTIVA" : "INACTIVA";
        String mfrTexto = this.mfr ? "SI" : "NO";

        return "ID: " + this.id
                + " | Nombre: " + this.nombre
                + " | Género: " + this.genero
                + " | Deporte: " + this.deporte
                + " | Estado: " + estadoTexto
                + " | MFR: " + mfrTexto; // Incluimos todos los nuevos campos
    }
}
