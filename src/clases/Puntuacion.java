package clases;

import java.io.Serializable;

public class Puntuacion implements Serializable {
	private String nombre;
	private double puntuacionfinal;
	public Puntuacion(String nombre, double puntuacionfinal) {
		super();
		this.nombre = nombre;
		this.puntuacionfinal = puntuacionfinal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPuntuacionfinal() {
		return puntuacionfinal;
	}
	public void setPuntuacionfinal(double puntuacionfinal) {
		this.puntuacionfinal = puntuacionfinal;
	}
	@Override
	public String toString() {
		return "Puntuaciones [nombre=" + nombre + ", puntuacionfinal=" + puntuacionfinal + "]";
	}
	
}
