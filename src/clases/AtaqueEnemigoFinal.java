package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class AtaqueEnemigoFinal extends ObjetoJuego {
	private HashMap<String, Animacion>animacionesAtaqueFinal;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int tipoAtaque;
	private boolean choco=false;
	public AtaqueEnemigoFinal(int x, int y, String nombreImagen, int velocidad,
			 String animacionActual, int tipoAtaque) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		this.tipoAtaque = tipoAtaque;
		animacionesAtaqueFinal = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	public HashMap<String, Animacion> getAnimacionesAtaquefinal() {
		return animacionesAtaqueFinal;
	}
	public void setAnimacionesAtaqueFinal(HashMap<String, Animacion> animacionesAtaquefinal) {
		this.animacionesAtaqueFinal = animacionesAtaquefinal;
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
	
	public boolean isChoco() {
		return choco;
	}
	public void setChoco(boolean choco) {
		this.choco = choco;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasAtaque1[]= {
				new Rectangle(3,402,73,23),
				new Rectangle(78,402,71,23),
				new Rectangle(150,402,71,23),
				new Rectangle(224,402,73,23),
				new Rectangle(300,402,70,23),
				new Rectangle(371,402,73,23),
				
			};
		Animacion animacionAtaque1= new Animacion(.1,coordenadasAtaque1);
		animacionesAtaqueFinal.put("ataque1", animacionAtaque1);
		
		Rectangle coordenadasAtaque2[]= {
				new Rectangle(873,514,23,73),
				new Rectangle(873,439,23,71),
				new Rectangle(873,367,23,71),
				new Rectangle(873,292,23,73),
				new Rectangle(873,219,23,70),
				new Rectangle(873,145,23,73),
				
			};
		Animacion animacionAtaque2= new Animacion(.1,coordenadasAtaque2);
		animacionesAtaqueFinal.put("ataque2", animacionAtaque2);
		
		Rectangle coordenadasAtaque3[]= {
				new Rectangle(3,662,56,95),
				new Rectangle(63,662,57,93),
				new Rectangle(120,662,65,91),
				new Rectangle(186,662,63,90),
			};
		Animacion animacionAtaque3= new Animacion(.3,coordenadasAtaque3);
		animacionesAtaqueFinal.put("ataque3", animacionAtaque3);
	}
	
	public void calcularFrame(double t) {
		Rectangle coordenadas= animacionesAtaqueFinal.get(animacionActual).calcularFrameActual(t);
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
		if(tipoAtaque==1 || tipoAtaque==3 || tipoAtaque==4 )
			this.x-=this.velocidad;
		if(tipoAtaque==2 || tipoAtaque==5)
			this.y+=this.velocidad;
		
	}
	public void colocar() {
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
