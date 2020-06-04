package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class AtaqueEnemigoGeneral extends ObjetoJuego{
	private HashMap<String, Animacion>animacionesAtaqueGeneral;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int tipoAtaque;
	public AtaqueEnemigoGeneral(int x, int y, String nombreImagen, int velocidad, String animacionActual, int tipoAtaque) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		this.tipoAtaque = tipoAtaque;
		animacionesAtaqueGeneral= new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	public String getAnimacionActual() {
		return animacionActual;
	}
	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
	
	public int getTipoAtaque() {
		return tipoAtaque;
	}
	public void setTipoAtaque(int tipoAtaque) {
		this.tipoAtaque = tipoAtaque;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasAtaque1[]= {
				new Rectangle(192,656,20,24),
				new Rectangle(213,656,20,24),
				
			};
		Animacion animacionAtaque1= new Animacion(.3,coordenadasAtaque1);
		animacionesAtaqueGeneral.put("ataque1", animacionAtaque1);
	}
	public void calcularFrame(double t) {
		Rectangle coordenadas= animacionesAtaqueGeneral.get(animacionActual).calcularFrameActual(t);
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
		
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
		
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
		if(this.tipoAtaque==1)
		this.x-=this.velocidad;
		
		if(this.tipoAtaque==2)
			this.y+=this.velocidad;
		
	}
	
	
}
