package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends ObjetoJuego {
	private int cantidad;
	private boolean capturado=false;
	private int tipoItem;
	private int xImagen;
	private int yImagen;
	private boolean chocando=false;

	public Item(int x, int y, String nombreImagen, int velocidad, int cantidad, int tipoItem) {
		super(x, y, nombreImagen, velocidad);
		this.cantidad = cantidad;
		this.tipoItem = tipoItem;
		//this.ancho= (int)Juego.imagenes.get("item").getWidth();
		//this.alto= (int)Juego.imagenes.get("item").getHeight();
		
		switch(tipoItem) {
		case 1:
			this.xImagen=15;
			this.yImagen=139;
			this.ancho=24;
			this.alto=36;
			break;
		case 2:
			this.xImagen=39;
			this.yImagen=130;
			this.ancho=22;
			this.alto=44;
			break;
		case 3:
			this.xImagen=14;
			this.yImagen=186;
			this.ancho=37;
			this.alto=49;
			break;
		case 4:
			this.xImagen=65;
			this.yImagen=130;
			this.ancho=22;
			this.alto=39;
			break;
		case 5:
			this.xImagen=86;
			this.yImagen=130;
			this.ancho=30;
			this.alto=42;
			break;
		case 6:
			this.xImagen=11;
			this.yImagen=16;
			this.ancho=25;
			this.alto=27;
			break;
		case 7:
			this.xImagen=42;
			this.yImagen=16;
			this.ancho=25;
			this.alto=27;
			break;
		case 8:
			this.xImagen=109;
			this.yImagen=16;
			this.ancho=25;
			this.alto=27;
			break;
		case 9:
			this.xImagen=141;
			this.yImagen=16;
			this.ancho=25;
			this.alto=27;
			break;
		case 10:
			this.xImagen=11;
			this.yImagen=47;
			this.ancho=25;
			this.alto=27;
			break;
		case 11:
			this.xImagen=41;
			this.yImagen=47;
			this.ancho=25;
			this.alto=27;
			break;
		case 12:
			this.xImagen=177;
			this.yImagen=81;
			this.ancho=25;
			this.alto=27;
			break;
		case 13:
			this.xImagen=10;
			this.yImagen=115;
			this.ancho=25;
			this.alto=27;
			break;
		case 14:
			this.xImagen=77;
			this.yImagen=115;
			this.ancho=25;
			this.alto=27;
			break;
		case 15:
			this.xImagen=108;
			this.yImagen=115;
			this.ancho=25;
			this.alto=27;
			break;
		case 16:
			this.xImagen=142;
			this.yImagen=115;
			this.ancho=25;
			this.alto=27;
			break;
		case 17:
			this.xImagen=9;
			this.yImagen=149;
			this.ancho=25;
			this.alto=27;
			break;
		case 18:
			this.xImagen=109;
			this.yImagen=149;
			this.ancho=25;
			this.alto=27;
			break;
		case 19:
			this.xImagen=174;
			this.yImagen=149;
			this.ancho=25;
			this.alto=27;
			break;
		case 20:
			this.xImagen=10;
			this.yImagen=181;
			this.ancho=25;
			this.alto=27;
			break;
		case 21:
			this.xImagen=41;
			this.yImagen=181;
			this.ancho=25;
			this.alto=27;
			break;
		case 22:
			this.xImagen=10;
			this.yImagen=247;
			this.ancho=25;
			this.alto=27;
			break;
		case 23:
			this.xImagen=110;
			this.yImagen=247;
			this.ancho=25;
			this.alto=27;
			break;
		case 24:
			this.xImagen=43;
			this.yImagen=280;
			this.ancho=25;
			this.alto=27;
			break;
		case 25:
			this.xImagen=109;
			this.yImagen=280;
			this.ancho=25;
			this.alto=27;
			break;
		}
	}
	

	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public boolean isCapturado() {
		return capturado;
	}


	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	


	public int getTipoItem() {
		return tipoItem;
	}


	public void setTipoItem(int tipoItem) {
		this.tipoItem = tipoItem;
	}
	


	public boolean isChocando() {
		return chocando;
	}


	public void setChocando(boolean chocando) {
		this.chocando = chocando;
	}


	@Override
	public void pintar(GraphicsContext graficos) {
		if(this.capturado)
			return;
		else 
			graficos.drawImage(Juego.imagenes.get(nombreImagen), xImagen, yImagen, ancho, alto, x, y, ancho, alto);
		
		if(this.chocando) {
			graficos.drawImage(Juego.imagenes.get("instrucciones"), x+52, y-140);
			
		}
		
	}

	@Override
	public void mover() {
		if(Juego.derecha && JugadorAnimado.coordenadaX>720)  
			 this.x-=720;
		if(Juego.izquierda && JugadorAnimado.coordenadaX<0) 
			 this.x+=720;
		if(Juego.arriba && JugadorAnimado.cooordenadaY<0) 
			 this.y+=504;
		if(Juego.abajo && JugadorAnimado.cooordenadaY>504)  
			 this.y-=504;
			
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, ancho, alto);
	}
}
