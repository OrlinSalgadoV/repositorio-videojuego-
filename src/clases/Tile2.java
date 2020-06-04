package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Tile2 extends ObjetoJuego{
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	private int ancho;
	private int alto;
	
	//private int anchoFinal;
	//private int altoFinal;
	
	public Tile2(int tipoTile, int x, int y, String nombreImagen, int velocidad) {
		super(x, y, nombreImagen, velocidad);
		this.tipoTile=tipoTile;
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
			this.ancho=43;
			this.alto=51;
			break;
		case 3:
			this.xImagen = 297;
			this.yImagen= 348;
			this.ancho=27;
			this.alto=29;
			break;
		case 4:
			this.xImagen = 24;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 5:
			this.xImagen = 192;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 6:
			this.xImagen = 216;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 7:
			this.xImagen = 96;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 8:
			this.xImagen = 0;
			this.yImagen= 192;
			this.ancho=24;
			this.alto=24;
			break;
		case 9:
			this.xImagen = 264;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 10:
			this.xImagen = 144;
			this.yImagen= 192;
			this.ancho=24;
			this.alto=24;
			break;
		case 11:
			this.xImagen = 264;
			this.yImagen= 192;
			this.ancho=24;
			this.alto=24;
			break;
		case 12:
			this.xImagen = 0;
			this.yImagen= 216;
			this.ancho=24;
			this.alto=24;
			break;
		case 13:
			this.xImagen = 120;
			this.yImagen= 216;
			this.ancho=24;
			this.alto=24;
			break;
		case 14:
			this.xImagen = 144;
			this.yImagen= 216;
			this.ancho=24;
			this.alto=24;
			break;
		case 15:
			this.xImagen = 264;
			this.yImagen= 216;
			this.ancho=24;
			this.alto=24;
			break;
		case 16:
			this.xImagen = 0;
			this.yImagen= 312;
			this.ancho=24;
			this.alto=24;
			break;
		case 17:
			this.xImagen = 48;
			this.yImagen= 312;
			this.ancho=24;
			this.alto=24;
			break;
		case 18:
			this.xImagen = 24;
			this.yImagen= 312;
			this.ancho=24;
			this.alto=24;
			break;
		case 19:
			this.xImagen = 434;
			this.yImagen= 317;
			this.ancho=68;
			this.alto=65;
			break;
		case 20:
			this.xImagen = 264;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 21:
			this.xImagen = 96;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 22:
			this.xImagen = 48;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 23:
			this.xImagen = 72;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 24:
			this.xImagen = 192;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 25:
			this.xImagen = 216;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 26:
			this.xImagen = 48;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 27:
			this.xImagen = 72;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 28:
			this.xImagen = 216;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 29:
			this.xImagen = 24;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 30:
			this.xImagen = 168;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 31:
			this.xImagen = 24;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 32:
			this.xImagen = 168;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 33:
			this.xImagen = 0;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 34:
			this.xImagen = 144;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 35:
			this.xImagen = 0;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 36:
			this.xImagen = 144;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 37:
			this.xImagen = 168;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 38:
			this.xImagen = 240;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 39:
			this.xImagen = 240;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 40:
			this.xImagen = 96;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 41:
			this.xImagen = 120;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 42:
			this.xImagen = 240;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 43:
			this.xImagen = 264;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
			break;
		case 44:
			this.xImagen = 192;
			this.yImagen= 72;
			this.ancho=24;
			this.alto=24;
			break;
		case 45:
			this.xImagen = 120;
			this.yImagen= 120;
			this.ancho=24;
			this.alto=24;
			break;
		case 46:
			this.xImagen = 192;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 47:
			this.xImagen = 192;
			this.yImagen= 168;
			this.ancho=24;
			this.alto=24;
			break;
		case 48:
			this.xImagen = 45;
			this.yImagen= 397;
			this.ancho=39;
			this.alto=38;
			break;
		case 49:
			this.xImagen = 53;
			this.yImagen= 437;
			this.ancho=26;
			this.alto=58;
			break;
		case 50:
			this.xImagen = 9;
			this.yImagen= 420;
			this.ancho=32;
			this.alto=51;
			break;
		case 51:
			this.xImagen = 86;
			this.yImagen= 421;
			this.ancho=34;
			this.alto=52;
			break;
		case 52:
			this.xImagen = 129;
			this.yImagen= 394;
			this.ancho=48;
			this.alto=55;
			break;
		case 53:
			this.xImagen = 188;
			this.yImagen= 398;
			this.ancho=34;
			this.alto=48;
			break;
		case 54:
			this.xImagen = 339;
			this.yImagen= 314;
			this.ancho=45;
			this.alto=67;
			break;
		case 55:
			this.xImagen = 391;
			this.yImagen= 332;
			this.ancho=34;
			this.alto=38;
			break;
		case 56:
			this.xImagen = 143;
			this.yImagen= 451;
			this.ancho=165;
			this.alto=176;
			break;
		case 57:
			this.xImagen = 314;
			this.yImagen= 400;
			this.ancho=189;
			this.alto=226;
			break;
		case 58:
			this.xImagen = 120;
			this.yImagen= 144;
			this.ancho=24;
			this.alto=24;
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

	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	@Override
	public void pintar(GraphicsContext graficos) {

		graficos.drawImage(Juego.imagenes.get(nombreImagen), xImagen, yImagen, ancho, alto, x, y,ancho+(tipoTile==58?2:0) ,alto);
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, ancho, alto-(tipoTile==1?50:0));
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
