package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemigo extends ObjetoJuego {
	public static int vidas;
	private HashMap<String, Animacion>animacionesEnemigo;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	public static String animacionActual;
	private int hp;
	public static int coordenadaX;
	public static int cooordenadaY;
	public boolean ataqueChocando=false;
	public Enemigo(int x, int y, String nombreImagen, int velocidad, /*int vidas,*/String animacionActual, int hp) {
		super(x, y, nombreImagen, velocidad);
		this.hp = hp;
		this.vidas=this.hp/50;
		this.animacionActual = animacionActual;
		animacionesEnemigo = new HashMap<String, Animacion>();
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
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public boolean isAtaqueChocando() {
		return ataqueChocando;
	}
	public void setAtaqueChocando(boolean ataqueChocando) {
		this.ataqueChocando = ataqueChocando;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasCaminar[]= {
				new Rectangle(518,372,68,88),
				new Rectangle(585,372,68,88),
			};
		Animacion animacionCaminar= new Animacion(.3,coordenadasCaminar);
		animacionesEnemigo.put("caminar", animacionCaminar);
		Rectangle coordenadasVolar[]= {
				new Rectangle(585,372,68,88),
			};
		Animacion animacionVolar= new Animacion(.3,coordenadasVolar);
		animacionesEnemigo.put("volar", animacionVolar);
		Rectangle coordenadasFuego[]= {
				new Rectangle(715,294,57,79),
				new Rectangle(487,294,57,79),
				new Rectangle(658,294,57,79),
				new Rectangle(600,294,57,79),
				new Rectangle(543,294,57,79),
				new Rectangle(424,294,57,79),
				new Rectangle(715,294,57,79),
			};
		Animacion animacionFuego= new Animacion(.3,coordenadasFuego);
		animacionesEnemigo.put("fuego", animacionFuego);
		Rectangle coordenadasFuego2[]= {
				new Rectangle(1057,294,57,79),
				new Rectangle(943,294,57,79),
				new Rectangle(885,294,57,79),
				new Rectangle(829,294,57,79),
				new Rectangle(1001,294,57,79),
				new Rectangle(772,294,57,79),
				
			};
		Animacion animacionFuego2= new Animacion(.2,coordenadasFuego2);
		animacionesEnemigo.put("fuego2", animacionFuego2);
		
		
	}
	public void calculaFrame(double t) {
		Rectangle coordenadas= animacionesEnemigo.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		this.anchoImagen=(int)coordenadas.getWidth();
		this.altoImagen=(int)coordenadas.getHeight();
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x+16, y+35, anchoImagen-17, altoImagen-43);
	}
	
	@Override
	public void pintar(GraphicsContext graficos) {
		if(JugadorAnimado.xTotal==1 && JugadorAnimado.yTotal==1) {
		if(this.vidas>0) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
		graficos.setFill(Color.RED);
		if(JugadorAnimado.chocando && Juego.teclaX)
			graficos.fillText("-1", Enemigo.coordenadaX,Enemigo.cooordenadaY-3);
		if(this.isAtaqueChocando() )
			graficos.fillText("-1", Enemigo.coordenadaX,Enemigo.cooordenadaY-3);
		}
		}
		//graficos.setStroke(Color.RED);
		//graficos.strokeRect(x+16, y+35, anchoImagen-17, altoImagen-43);
		
if(this.vidas>0 && JugadorAnimado.xTotal==1 && JugadorAnimado.yTotal==1) {
			
			switch(this.vidas) {
			case 6:
				graficos.drawImage(Juego.imagenes.get("barravida"), 4,4,120,26, this.x-10,this.y+85,80,15);
				break;
			case 5:
				graficos.drawImage(Juego.imagenes.get("barravida"), 4,29,120,26,this.x-10,this.y+85,80,15);
				break;
			case 4:
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,54,120,26,this.x-10,this.y+85,80,15);
				break;
			case 3:
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,79,120,26, this.x-10,this.y+85,80,15);
				break;
			case 2:
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,104,120,26, this.x-10,this.y+85,80,15);
				break;
			case 1:
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,129,120,26, this.x-10,this.y+85,80,15);
				break;
			}
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
		
		this.coordenadaX=this.x;
		this.cooordenadaY=this.y;
		if(JugadorAnimado.xTotal==1 && JugadorAnimado.yTotal==1) {
			if(this.x<600) {
				if(JugadorAnimado.coordenadaX>0 && JugadorAnimado.cooordenadaY>2  ) 
					this.animacionActual="caminar";
				if(JugadorAnimado.coordenadaX>=20 && JugadorAnimado.cooordenadaY>10) {
					this.animacionActual="volar";
					this.x=x+5;
				}
			}
		
		
			if(this.x>590 && this.x<601) 
				this.animacionActual="fuego2";
		
			
	
		}
	}
}
