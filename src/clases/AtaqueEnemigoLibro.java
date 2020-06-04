package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class AtaqueEnemigoLibro extends ObjetoJuego {
	private HashMap<String, Animacion>animacionesAtaqueLibro;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int tipoAtaque;
	public AtaqueEnemigoLibro(int x, int y, String nombreImagen, int velocidad, String animacionActual,
			int tipoAtaque) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		this.tipoAtaque = tipoAtaque;
		animacionesAtaqueLibro = new HashMap<String, Animacion>();
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
				new Rectangle(130,532,53,52),
				new Rectangle(183,532,48,55),
				new Rectangle(96,532,34,46),
				new Rectangle(56,532,39,45),
				
			};
		Animacion animacionAtaque1= new Animacion(.3,coordenadasAtaque1);
		animacionesAtaqueLibro.put("ataque1", animacionAtaque1);
	}
	public void calcularFrame(double t) {
		Rectangle coordenadas= animacionesAtaqueLibro.get(animacionActual).calcularFrameActual(t);
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
		//if(this.tipoAtaque==1)
			this.x-=this.velocidad;
		
	}
	
	
	
}
