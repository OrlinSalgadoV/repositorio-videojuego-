package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Obstaculo extends ObjetoJuego {
	private HashMap<String, Animacion>animacionesObstaculo;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int durabilidad;
	
	
	public Obstaculo(int x, int y, String nombreImagen, int velocidad, String animacionActual, int durabilidad) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		this.durabilidad = durabilidad;
		animacionesObstaculo = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	public String getAnimacionActual() {
		return animacionActual;
	}
	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
	
	public int getDurabilidad() {
		return durabilidad;
	}
	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasPuas[]= {
				new Rectangle(14,0,41,43),
				new Rectangle(53,0,41,43),
			};
		
		Animacion animacionPuas= new Animacion(.3,coordenadasPuas);
		animacionesObstaculo.put("puas", animacionPuas);
		
		Rectangle coordenadasCaja[]= {
				new Rectangle(52,49,32,41),
				new Rectangle(50,49,32,41),
			};
		
		Animacion animacionCaja= new Animacion(.3,coordenadasCaja);
		animacionesObstaculo.put("caja", animacionCaja);
		
		Rectangle coordenadasCaja2[]= {
				new Rectangle(86,49,38,41),
				new Rectangle(84,49,38,41),
			};
		
		Animacion animacionCaja2= new Animacion(.3,coordenadasCaja2);
		animacionesObstaculo.put("caja2", animacionCaja2);
		
		Rectangle coordenadasCaja3[]= {
				new Rectangle(127,49,38,41),
				new Rectangle(125,49,38,41),
			};
		
		Animacion animacionCaja3= new Animacion(.3,coordenadasCaja3);
		animacionesObstaculo.put("caja3", animacionCaja3);
		
		Rectangle coordenadasCajaEstatica[]= {
				new Rectangle(52,49,32,41),
			};
		Animacion animacionCajaEstatica= new Animacion(.3,coordenadasCajaEstatica);
		animacionesObstaculo.put("cajaEstatica", animacionCajaEstatica);
		
		Rectangle coordenadasCajaEstatica2[]= {
				new Rectangle(86,49,38,41),		
			};
		Animacion animacionCajaEstatica2= new Animacion(.3,coordenadasCajaEstatica2);
		animacionesObstaculo.put("cajaEstatica2", animacionCajaEstatica2);
		
		Rectangle coordenadasCajaEstatica3[]= {
				new Rectangle(127,49,38,41),		
			};
		Animacion animacionCajaEstatica3= new Animacion(.3,coordenadasCajaEstatica3);
		animacionesObstaculo.put("cajaEstatica3", animacionCajaEstatica3);
		
		Rectangle coordenadasCajaEstatica4[]= {
				new Rectangle(180,49,41,41),		
			};
		Animacion animacionCajaEstatica4= new Animacion(.3,coordenadasCajaEstatica4);
		animacionesObstaculo.put("cajaEstatica4", animacionCajaEstatica4);
		
	}
	public void calcularFrame(double t) {
		Rectangle coordenadas= animacionesObstaculo.get(animacionActual).calcularFrameActual(t);
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

	}
	


}
