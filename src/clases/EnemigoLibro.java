package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoLibro extends ObjetoJuego {
	public  int vidas;
	private HashMap<String, Animacion>animacionesEnemigoLibro;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	public  String animacionActual;
	private double hp;
	private AtaqueEnemigoLibro ataqueLibro;
	private int tipo;
	private double distancia;
	private int cont=0;
	private int cont2=0;
	private int jugadorY;
	private boolean choco=false;
	private boolean ataqueActivo=false;
	
	public EnemigoLibro(int x, int y, String nombreImagen, int velocidad, String animacionActual, double hp,
			AtaqueEnemigoLibro ataqueLibro, int tipo, double distancia) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		this.hp = hp;
		this.ataqueLibro = ataqueLibro;
		this.tipo = tipo;
		this.distancia = distancia;
		animacionesEnemigoLibro= new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public HashMap<String, Animacion> getAnimacionesEnemigoLibro() {
		return animacionesEnemigoLibro;
	}
	public void setAnimacionesEnemigoLibro(HashMap<String, Animacion> animacionesEnemigoLibro) {
		this.animacionesEnemigoLibro = animacionesEnemigoLibro;
	}
	public String getAnimacionActual() {
		return animacionActual;
	}
	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public AtaqueEnemigoLibro getAtaqueLibro() {
		return ataqueLibro;
	}
	public void setAtaqueLibro(AtaqueEnemigoLibro ataqueLibro) {
		this.ataqueLibro = ataqueLibro;
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
	public void inicializarAnimaciones(){
		Rectangle coordenadasAtaque1[]= {
				new Rectangle(0,222,38,72),
				new Rectangle(37,222,38,72),
				
			};
		Animacion animacionAtaque1= new Animacion(.5,coordenadasAtaque1);
		animacionesEnemigoLibro.put("localizar", animacionAtaque1);
		
		Rectangle coordenadasAtaque2[]= {
				new Rectangle(77,229,43,57),
				new Rectangle(122,229,43,57),
				new Rectangle(167,229,43,57),
				
			};
		Animacion animacionAtaque2= new Animacion(.5,coordenadasAtaque2);
		animacionesEnemigoLibro.put("ataque1", animacionAtaque2);
		
		Rectangle coordenadasAtaque3[]= {
				new Rectangle(0,294,37,73),
				new Rectangle(41,294,33,73),
				
			};
		Animacion animacionAtaque3= new Animacion(.5,coordenadasAtaque3);
		animacionesEnemigoLibro.put("posevictoria", animacionAtaque3);
		
		Rectangle coordenadasAtaque4[]= {
				new Rectangle(0,73,31,71),
				new Rectangle(33,73,40,71),
				new Rectangle(73,73,35,71),
				new Rectangle(109,73,33,71),
				new Rectangle(143,73,36,71),
				new Rectangle(179,73,33,71),
				
			};
		Animacion animacionAtaque4= new Animacion(.3,coordenadasAtaque4);
		animacionesEnemigoLibro.put("posedescanso", animacionAtaque4);
		}
	
	public void calculaFrame(double t) {
		Rectangle coordenadas= animacionesEnemigoLibro.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		this.anchoImagen=(int)coordenadas.getWidth();
		this.altoImagen=(int)coordenadas.getHeight();
		ataqueLibro.calcularFrame(t);
	}
		
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	@Override
	public void pintar(GraphicsContext graficos) {
		if(this.vidas>0) { 
			graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
			if(!this.choco)
			ataqueLibro.pintar(graficos);
			}
		
if(this.vidas>0 && JugadorAnimado.xTotal==2 && JugadorAnimado.yTotal==0) {
			
	if(this.vidas>=19)		
		graficos.drawImage(Juego.imagenes.get("barravida"), 4,4,120,26, this.x-10,this.y+75,80,15);
	if(this.vidas<19 && this.vidas>=15 )
		graficos.drawImage(Juego.imagenes.get("barravida"), 4,29,120,26,this.x-10,this.y+75,80,15);
	if(this.vidas<15 && this.vidas>=12 )
		graficos.drawImage(Juego.imagenes.get("barravida"), 3,54,120,26,this.x-10,this.y+75,80,15);
	if(this.vidas<12 && this.vidas>=8 )
		graficos.drawImage(Juego.imagenes.get("barravida"), 3,79,120,26, this.x-10,this.y+75,80,15);
	if(this.vidas<8 && this.vidas>=5 )
		graficos.drawImage(Juego.imagenes.get("barravida"), 3,104,120,26, this.x-10,this.y+75,80,15);
	if(this.vidas<5)
		graficos.drawImage(Juego.imagenes.get("barravida"), 3,129,120,26, this.x-10,this.y+75,80,15);
			}
	}
	@Override
	public void mover() {
		this.vidas=(int)this.hp/5;
		if(Juego.derecha && JugadorAnimado.coordenadaX>720) {  
			 this.x-=720;
			 ataqueLibro.setX(ataqueLibro.getX()-720);}
		if(Juego.izquierda && JugadorAnimado.coordenadaX<0) { 
			 this.x+=720;
			 ataqueLibro.setX(ataqueLibro.getX()+720);}
		if(Juego.arriba && JugadorAnimado.cooordenadaY<0) { 
			 this.y+=504;
			 ataqueLibro.setY(ataqueLibro.getY()+504);}
		if(Juego.abajo && JugadorAnimado.cooordenadaY>504) {  
			 this.y-=504;
			 ataqueLibro.setY(ataqueLibro.getY()-504);}
		
		if(this.vidas>0 && this.tipo==1 && JugadorAnimado.xTotal==2 && JugadorAnimado.yTotal==0) {
			if(this.isChoco()) {
				cont2++;
				this.animacionActual="posevictoria";
				if(cont2>10) {
					this.animacionActual="posedescanso";
					this.cont2=0;
					
				}
				
			}
			if((this.x==(ataqueLibro.getX()+50)) && (this.y==ataqueLibro.getY()))
				this.animacionActual="localizar";
			cont++;
			if(cont>15) {
				this.jugadorY=JugadorAnimado.cooordenadaY;
				this.cont=0;}
			if(this.animacionActual=="localizar") {
				if(ataqueLibro.getY()<(this.jugadorY-10))
					ataqueLibro.setY(ataqueLibro.getY()+5);
				if(ataqueLibro.getY()>(this.jugadorY+10))
					ataqueLibro.setY(ataqueLibro.getY()-5);
				if(ataqueLibro.getY()<=(this.jugadorY+10) && ataqueLibro.getY()>=(this.jugadorY-10)) {	
					this.animacionActual="ataque1";
					this.ataqueActivo=true;}
			}
			if(this.ataqueActivo) {
				if(ataqueLibro.getX()>(this.x-this.distancia)) {
					ataqueLibro.mover();
					if(!this.choco) 
						this.animacionActual="posedescanso";
						
					}
				else {
					ataqueLibro.setX(this.x-50);
					ataqueLibro.setY(this.y);
					this.ataqueActivo=false;
					this.animacionActual="localizar";
					this.choco=false;}
			}
				
				
			
		}
		
	}
	
	
	
}
