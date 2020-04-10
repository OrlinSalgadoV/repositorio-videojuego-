package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Jugador extends ObjetoJuego{
	private int vidas;
	
	
	public Jugador(int x, int y, String nombreImagen, int velocidad, int vidas) {
		super(x, y, nombreImagen, velocidad);
		this.vidas = vidas;
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen), x, y);
	}
	@Override
	public void mover() {
		if(x>700)
			x=0;
		if(x<0)
			x=700;
		if(y>500)
			y=0;
		if(y<0)
			y=500;
		if(Juego.derecha)
			x+=velocidad;
		if(Juego.izquierda)
			x-=velocidad;
		if(Juego.arriba)
			y-=velocidad;
		if(Juego.abajo)
			y+=velocidad;
			
	}

}
