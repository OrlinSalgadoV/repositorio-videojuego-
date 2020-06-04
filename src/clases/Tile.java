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
			this.xImagen = 0;
			this.yImagen= 48;
			break;
		case 3:
			this.xImagen =24 ;
			this.yImagen= 48;
			break;
		case 4:
			this.xImagen = 72;
			this.yImagen= 24;
			break;
		case 5:
			this.xImagen = 96;
			this.yImagen= 24;
			break;
		case 6:
			this.xImagen = 120;
			this.yImagen= 24;
			break;
		case 7:
			this.xImagen = 72;
			this.yImagen= 48;
			break;
		case 8:
			this.xImagen = 96;
			this.yImagen= 48;
			break;
		case 9:
			this.xImagen = 120;
			this.yImagen= 48;
			break;
		case 10:
			this.xImagen = 192;
			this.yImagen= 24;
			break;
		case 11:
			this.xImagen = 216;
			this.yImagen= 24;
			break;
		case 12:
			this.xImagen = 264;
			this.yImagen= 24;
			break;
		case 13:
			this.xImagen = 0;
			this.yImagen= 96;
			break;
		case 14:
			this.xImagen = 24;
			this.yImagen= 96;
			break;
		case 15:
			this.xImagen = 144;
			this.yImagen= 96;
			break;
		case 16:
			this.xImagen = 168;
			this.yImagen= 96;
			break;
		case 17:
			this.xImagen = 168;
			this.yImagen= 0;
			break;
		case 18:
			this.xImagen = 216;
			this.yImagen= 0;
			break;
		case 19:
			this.xImagen = 216;
			this.yImagen= 48;
			break;
		case 20:
			this.xImagen = 240;
			this.yImagen= 48;
			break;
		case 21:
			this.xImagen = 264;
			this.yImagen= 48;
			break;
		case 22:
			this.xImagen = 216;
			this.yImagen= 72;
			break;
		case 23:
			this.xImagen = 240;
			this.yImagen= 72;
			break;
		case 24:
			this.xImagen = 264;
			this.yImagen= 72;
			break;
		case 25:
			this.xImagen = 144;
			this.yImagen= 48;
			break;
		case 26:
			this.xImagen = 168;
			this.yImagen= 48;
			break;
		case 27:
			this.xImagen = 192;
			this.yImagen= 48;
			break;
		case 28:
			this.xImagen = 144;
			this.yImagen= 72;
			break;
		case 29:
			this.xImagen = 168;
			this.yImagen= 72;
			break;
		case 30:
			this.xImagen = 192;
			this.yImagen= 72;
			break;
		case 31:
			this.xImagen = 0;
			this.yImagen= 72;
			break;
		case 32:
			this.xImagen = 24;
			this.yImagen= 72;
			break;
		case 33:
			this.xImagen = 48;
			this.yImagen= 72;
			break;
		case 34:
			this.xImagen = 48;
			this.yImagen= 0;
			break;
		case 35:
			this.xImagen = 48;
			this.yImagen= 48;
			break;
		case 36:
			this.xImagen = 96;
			this.yImagen= 72;
			break;
		case 37:
			this.xImagen = 240;
			this.yImagen= 24;
			break;
		case 38:
			this.xImagen = 240;
			this.yImagen= 0;
			break;
		case 39:
			this.xImagen = 120;
			this.yImagen= 264;
			break;
		case 40:
			this.xImagen = 96;
			this.yImagen= 288;
			break;
		case 41:
			this.xImagen = 120;
			this.yImagen= 288;
			break;
		case 42:
			this.xImagen = 264;
			this.yImagen= 264;
			break;
		case 43:
			this.xImagen = 144;
			this.yImagen= 288;
			break;
		case 44:
			this.xImagen = 168;
			this.yImagen= 288;
			break;
		case 45:
			this.xImagen = 144;
			this.yImagen= 264;
			break;
		case 46:
			this.xImagen = 168;
			this.yImagen= 264;
			break;
		case 47:
			this.xImagen = 192;
			this.yImagen= 264;
			break;
		case 48:
			this.xImagen = 216;
			this.yImagen= 264;
			break;
		case 49:
			this.xImagen = 24;
			this.yImagen= 288;
			break;
		case 50:
			this.xImagen = 48;
			this.yImagen= 288;
			break;
		case 51:
			this.xImagen = 72;
			this.yImagen= 288;
			break;
		case 52:
			this.xImagen = 96;
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
		if( Juego.derecha && JugadorAnimado.coordenadaX>720) 
			 x-=720;
		if(Juego.izquierda && JugadorAnimado.coordenadaX<0) 
			 x+=720;
		if(Juego.arriba && JugadorAnimado.cooordenadaY<0) 
			 y+=504;
		if(Juego.abajo && JugadorAnimado.cooordenadaY>504) 
			 y-=504;
		
	}
	
}


