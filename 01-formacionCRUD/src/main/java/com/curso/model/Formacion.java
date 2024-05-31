package com.curso.model;

import java.util.Objects;

public class Formacion {

    private String curso;
	
    private int asignaturas;
    private double precio;
    private int duracion;

    public Formacion() {
        super();
    }

    public Formacion(String curso, int asignaturas, double precio, int duracion) {
        super();
        this.curso = curso;
        this.asignaturas = asignaturas;
        this.precio = precio;
        this.duracion = duracion; 
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(asignaturas, curso, precio, duracion); // Añadir duración
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Formacion other = (Formacion) obj;
        return asignaturas == other.asignaturas && Objects.equals(curso, other.curso)
                && Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
                && duracion == other.duracion; // Comparar duración
    }

    @Override
    public String toString() {
        return "Formacion [curso=" + curso + ", asignaturas=" + asignaturas + ", precio=" + precio + ", duracion=" + duracion + "]"; // Añadir duración
    }
}
