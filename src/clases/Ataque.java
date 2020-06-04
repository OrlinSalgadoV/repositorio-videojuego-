package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Ataque extends ObjetoJuego {
	private HashMap<String, Animacion>animacionesAtaque;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int conteo=0;
	private int yJugador;
	private int xJugador;
	public Ataque(int x, int y, String nombreImagen, int velocidad, String animacionActual) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		animacionesAtaque = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	public String getAnimacionActual() {
		return animacionActual;
	}
	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasFuego[]= {
				new Rectangle(8,140,66,41),
				new Rectangle(83,140,66,41),
				new Rectangle(162,140,66,41),
				new Rectangle(240,140,66,41),
			};
		Animacion animacionFuego= new Animacion(.3,coordenadasFuego);
		animacionesAtaque.put("fuego", animacionFuego);
		Rectangle coordenadasFuego2[]= {
				new Rectangle(317,140,66,41),
				new Rectangle(395,140,66,41),
				new Rectangle(476,140,66,41),
				new Rectangle(551,140,66,41),
			};
		Animacion animacionFuego2= new Animacion(.3,coordenadasFuego2);
		animacionesAtaque.put("fuego2", animacionFuego2);
		
	}
	public void calcularFrame(double t) {
		Rectangle coordenadas= animacionesAtaque.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		
		this.anchoImagen=(int)coordenadas.getWidth();
		this.altoImagen=(int)coordenadas.getHeight();
		}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, anchoImagen, altoImagen);
	}
	@Override
	public void pintar(GraphicsContext graficos) {
		if(JugadorAnimado.xTotal==1 && JugadorAnimado.yTotal==1) {
			if(this.animacionActual=="fuego2"  && Enemigo.vidas!=0)
				graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
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
		
		if(JugadorAnimado.xTotal==1 && JugadorAnimado.yTotal==1) {
			conteo++;
			if(conteo>20) {
				this.xJugador=JugadorAnimado.coordenadaX;
				this.yJugador=JugadorAnimado.cooordenadaY;
				conteo=0;
			}
			if(Enemigo.animacionActual=="fuego2" ) {
				if(this.x>(xJugador)) { 
	 			this.animacionActual="fuego2";
				if(JugadorAnimado.coordenadaX<500)
	 			this.x-=3;
				if(JugadorAnimado.coordenadaX>50)
		 			this.x-=1;
				if(Enemigo.cooordenadaY>yJugador && this.y>yJugador )
					this.y=this.y-4;
				if(Enemigo.cooordenadaY<yJugador && this.y<yJugador)
					this.y=this.y+4;
				//else
					//this.y=this.y-0;
			}
			else {
				this.x=Enemigo.coordenadaX;
				this.y=Enemigo.cooordenadaY;
			}
		}

	}
	}
	
}
