package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class  Tile3 extends ObjetoJuego {
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	//private int anchoFinal;
	//private int altoFinal;
	
	public Tile3(int tipoTile, int x, int y, String nombreImagen, int velocidad) {
		super(x, y, nombreImagen, velocidad);
		
		//this.alto= alto;
		//this.ancho= ancho;
		
		switch(tipoTile) {
		case 1:
			this.xImagen = 290;
			this.yImagen= 4;
			this.ancho=220;
			this.alto=290;
			break;
		case 2:
			this.xImagen = 237;
			this.yImagen= 339;
			this.ancho=42;
			this.alto=51;
			break;
		case 3:
			this.xImagen = 297;
			this.yImagen= 348;
			this.ancho=27;
			this.alto=29;
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
	
	public int getTipoTile() {
		return tipoTile;
	}
	public void setTipoTile(int tipoTile) {
		this.tipoTile = tipoTile;
	}
	
	
	@Override
	public void pintar(GraphicsContext graficos) {

		graficos.drawImage(Juego.imagenes.get(nombreImagen), xImagen, yImagen, ancho, alto, x, y,ancho ,alto);
	}
	
	@Override
public void mover() {
	if(Juego.derecha && JugadorAnimado.coordenadaX>720)  
		 x-=720;
		 
	if(Juego.izquierda && JugadorAnimado.coordenadaX<0)  
		 x+=720;
		 
	if(Juego.arriba && JugadorAnimado.cooordenadaY<0)  
		 y+=504;
		 
	if(Juego.abajo && JugadorAnimado.cooordenadaY>504)  
		 y-=504;
		 
		
	}
}
