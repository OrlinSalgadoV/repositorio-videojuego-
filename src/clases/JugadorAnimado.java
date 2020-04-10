package clases;


import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ObjetoJuego{
	private int vidas;
	private HashMap<String, Animacion>animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int direccion=-1;
	
	public JugadorAnimado(int x, int y, String nombreImagen, int velocidad, int vidas, String animacionActual) {
		super(x, y, nombreImagen, velocidad);
		this.vidas = vidas;
		this.animacionActual = animacionActual;
		animaciones = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public String getAnimacionActual() {
		return animacionActual;
	}
	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
	
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	public void inicializarAnimaciones() {
		Rectangle coordenadasCorrer[]= {
			new Rectangle(6,87,51,84),
			new Rectangle(56,87,51,84),
			new Rectangle(120,87,51,84),
			new Rectangle(180,87,51,84),
			new Rectangle(233,87,51,84),
			new Rectangle(292,87,51,84)
		};
		Animacion animacionCorrer= new Animacion(.15,coordenadasCorrer);
		animaciones.put("correr", animacionCorrer);
		
		Rectangle coordenadasDescanso[]= {
				new Rectangle(299,1176,43,79),
				new Rectangle(343,1176,43,79),
				//new Rectangle(86,1256,43,81),
				//new Rectangle(131,1256,45,81),
				//new Rectangle(180,1256,45,81),
				//new Rectangle(224,1256,45,81),
				//new Rectangle(266,1256,45,81),
				//new Rectangle(310,1256,43,81),
				//new Rectangle(353,1256,43,81),
				//new Rectangle(395,1256,43,81),
				
				
		};
		Animacion animacionDescanso= new Animacion(1.5,coordenadasDescanso);
		animaciones.put("descanso", animacionDescanso);
	}
	public void calcularFrame(double t) {
		Rectangle coordenadas= animaciones.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		
		this.anchoImagen=(int)coordenadas.getWidth();
		this.altoImagen=(int)coordenadas.getHeight();
		}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, (direccion*anchoImagen)-10, altoImagen);
	}
	@Override
	public void pintar(GraphicsContext graficos) {
		
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x+(direccion==-1?anchoImagen:0), y, direccion*anchoImagen, altoImagen);
		//graficos.setStroke(Color.RED);
		//graficos.strokeRect(x, y, anchoImagen, altoImagen);
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
		
	if( Juego.espacio)
			animaciones.get("correr").setDuracion(.01);
		
	else
			animaciones.get("correr").setDuracion(.15);
		
			
	}
	public void verificarColisiones(Item item) {
		if(!item.isCapturado() && this.obtenerRectangulo().getBoundsInLocal().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
			this.vidas += item.getCantidadVidas();
			item.setCapturado(true);
			//System.out.println("estan colisionando");
		}
	}

}
