package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego{
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	public Tile(int tipoTile, int x, int y, String nombreImagen, int velocidad,  int ancho, int alto) {
		super(x, y, nombreImagen, velocidad);
		
		this.alto= alto;
		this.ancho= ancho;
		
		switch(tipoTile) {
		case 1:
			this.xImagen = 0;
			this.yImagen= 0;
			break;
		case 2:
			this.xImagen = 144;
			this.yImagen= 0;
			break;
		case 3:
			this.xImagen =96 ;
			this.yImagen= 48;
			break;
		case 4:
			this.xImagen = 144;
			this.yImagen= 48;
			break;
		case 5:
			this.xImagen = 192;
			this.yImagen= 48;
			break;
		case 6:
			this.xImagen = 240;
			this.yImagen= 48;
			break;
		case 7:
			this.xImagen = 144;
			this.yImagen= 96;
			break;
		case 8:
			this.xImagen = 192;
			this.yImagen= 96;
			break;
		case 9:
			this.xImagen = 240;
			this.yImagen= 96;
			break;
		}
	}
	public int getxImagen() {
		return xImagen;
	}
	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}
	public int getyImagen() {
		return yImagen;
	}
	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}
	@Override
	public void pintar(GraphicsContext graficos) {

		graficos.drawImage(Juego.imagenes.get(nombreImagen), xImagen, yImagen, ancho, alto, x, y, ancho, alto);
	}
	@Override
	public void mover() {
		
		
	}
	
		
}


