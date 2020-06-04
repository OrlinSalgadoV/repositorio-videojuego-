package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoGeneral extends ObjetoJuego {
	public  int vidas;
	private HashMap<String, Animacion>animacionesEnemigoGeneral;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	public  String animacionActual;
	private double hp;
	private int tipo;
	private boolean choco = false;
	private AtaqueEnemigoGeneral ataqueGeneral;
	private double distancia;
	public EnemigoGeneral(int x, int y, String nombreImagen, int velocidad, String animacionActual, double hp,
			AtaqueEnemigoGeneral ataqueGeneral, int tipo, double distancia) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		this.hp = hp;
		this.ataqueGeneral = ataqueGeneral;
		this.tipo = tipo;
		this.distancia = distancia;
		animacionesEnemigoGeneral= new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public AtaqueEnemigoGeneral getAtaqueGeneral() {
		return ataqueGeneral;
	}
	public void setAtaqueGeneral(AtaqueEnemigoGeneral ataqueGeneral) {
		this.ataqueGeneral = ataqueGeneral;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public boolean isChoco() {
		return choco;
	}
	public void setChoco(boolean choco) {
		this.choco = choco;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasAtaque1[]= {
				new Rectangle(65,144,63,62),
				new Rectangle(127,139,64,66),
				new Rectangle(192,136,70,68),
			};
		Animacion animacionAtaque1= new Animacion(.8,coordenadasAtaque1);
		animacionesEnemigoGeneral.put("ataque1", animacionAtaque1);
		Rectangle coordenadasAtaque2[]= {
				new Rectangle(277,339,63,89),
			};
		Animacion animacionAtaque2= new Animacion(.5,coordenadasAtaque2);
		animacionesEnemigoGeneral.put("ataque2", animacionAtaque2);
		
		Rectangle coordenadasAtaque3[]= {
				new Rectangle(61,276,71,64),
				new Rectangle(237,204,84,62),
				
			};
		Animacion animacionAtaque3= new Animacion(.5,coordenadasAtaque3);
		animacionesEnemigoGeneral.put("ataque3", animacionAtaque3);
		
		Rectangle coordenadasAtaque4[]= {
				new Rectangle(274,681,66,80),
			};
		Animacion animacionAtaque4= new Animacion(.5,coordenadasAtaque4);
		animacionesEnemigoGeneral.put("ataque4", animacionAtaque4);
		
		Rectangle coordenadasAtaque5[]= {
				new Rectangle(130,680,72,76),
				new Rectangle(2,680,64,78),
			};
		Animacion animacionAtaque5= new Animacion(.5,coordenadasAtaque5);
		animacionesEnemigoGeneral.put("ataque5", animacionAtaque5);
	}
	public void calculaFrame(double t) {
		Rectangle coordenadas= animacionesEnemigoGeneral.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		this.anchoImagen=(int)coordenadas.getWidth();
		this.altoImagen=(int)coordenadas.getHeight();
		ataqueGeneral.calcularFrame(t);
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	@Override
	public void pintar(GraphicsContext graficos) {
			if(this.vidas>0) { 
			graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
			if(!this.choco)
			ataqueGeneral.pintar(graficos);
			}
	}
	@Override
	public void mover() {
		
		this.vidas=(int)this.hp/4;
		if(Juego.derecha && JugadorAnimado.coordenadaX>720)  
			 this.x-=720;
		if(Juego.izquierda && JugadorAnimado.coordenadaX<0) 
			 this.x+=720;
		if(Juego.arriba && JugadorAnimado.cooordenadaY<0) 
			 this.y+=504;
		if(Juego.abajo && JugadorAnimado.cooordenadaY>504)  
			 this.y-=504;
		if(this.tipo==1 && this.vidas>0) {
				if(ataqueGeneral.getX()>(this.x-this.distancia)) {
					ataqueGeneral.mover();
			
					if(ataqueGeneral.getX()<(this.x-50) && ataqueGeneral.getX()>=(this.x-350))
						this.animacionActual="ataque1";
					if(ataqueGeneral.getX()<(this.x-(this.distancia+50)))
						this.animacionActual="ataque2";
				}
				else {
					this.choco = false;
					ataqueGeneral.x=this.x;
					this.animacionActual="ataque3";}
			
		}
		if(this.tipo==2) {
			if(this.vidas>0 && ataqueGeneral.getY()<(this.y+this.distancia)) {
				ataqueGeneral.mover();
			
				if(this.vidas>0 && (ataqueGeneral.getY()>(this.y+50) && ataqueGeneral.getY()<=(this.y+350)))
					this.animacionActual="ataque1";
				if(this.vidas>0 && ataqueGeneral.getY()>(this.y+this.distancia-50))
					this.animacionActual="ataque4";
			}
			else {
				this.choco = false;
				ataqueGeneral.y=this.y;
				this.animacionActual="ataque5";}
		}
	}
	
	
}
