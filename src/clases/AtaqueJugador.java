package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class AtaqueJugador extends ObjetoJuego {
	private HashMap<String, Animacion>animacionesAtaque;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private boolean ataqueActivo=false;
	private boolean ataqueActivo2=false;
	private boolean poder1=false;
	private boolean poder2=false;
	private boolean poder3=false;
	private boolean choco=false;
	public AtaqueJugador(int x, int y, String nombreImagen, int velocidad, String animacionActual) {
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
	
	public boolean isPoder1() {
		return poder1;
	}
	public void setPoder1(boolean poder1) {
		this.poder1 = poder1;
	}
	
	public boolean isPoder2() {
		return poder2;
	}
	public void setPoder2(boolean poder2) {
		this.poder2 = poder2;
	}
	public boolean isPoder3() {
		return poder3;
	}
	public void setPoder3(boolean poder3) {
		this.poder3 = poder3;
	}
	
	public boolean isAtaqueActivo() {
		return ataqueActivo;
	}
	public void setAtaqueActivo(boolean ataqueActivo) {
		this.ataqueActivo = ataqueActivo;
	}
	public boolean isAtaqueActivo2() {
		return ataqueActivo2;
	}
	public void setAtaqueActivo2(boolean ataqueActivo2) {
		this.ataqueActivo2 = ataqueActivo2;
	}
	
	public boolean isChoco() {
		return choco;
	}
	public void setChoco(boolean choco) {
		this.choco = choco;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasFuego[]= {
				new Rectangle(28,18,19,13),
				new Rectangle(59,18,19,13),
				
			};
		Animacion animacionFuego= new Animacion(.3,coordenadasFuego);
		animacionesAtaque.put("fuego", animacionFuego);
		Rectangle coordenadasFuego2[]= {
				new Rectangle(581,18,19,13),
				new Rectangle(549,18,19,13),
				
			};
		Animacion animacionFuego2= new Animacion(.3,coordenadasFuego2);
		animacionesAtaque.put("fuego2", animacionFuego2);
		
		Rectangle coordenadasPoder2[]= {
				new Rectangle(112,5,54,13),
				new Rectangle(112,19,54,13),
				
			};
		Animacion animacionPoder2= new Animacion(.3,coordenadasPoder2);
		animacionesAtaque.put("poder2", animacionPoder2);
		
		Rectangle coordenadasPoder22[]= {
				new Rectangle(467,5,54,13),
				new Rectangle(467,19,54,13),
				
			};
		Animacion animacionPoder22= new Animacion(.3,coordenadasPoder22);
		animacionesAtaque.put("poder22", animacionPoder22);
		
		Rectangle coordenadasPoder3[]= {
				new Rectangle(20,48,61,41),
				new Rectangle(95,48,61,41),
				new Rectangle(165,48,61,41),
				new Rectangle(239,48,61,41),
				
			};
		Animacion animacionPoder3= new Animacion(.3,coordenadasPoder3);
		animacionesAtaque.put("poder3", animacionPoder3);
		
		Rectangle coordenadasPoder33[]= {
				new Rectangle(543,48,61,41),
				new Rectangle(470,48,61,41),
				new Rectangle(399,48,61,41),
				new Rectangle(327,48,61,41),
				
			};
		Animacion animacionPoder33= new Animacion(.3,coordenadasPoder33);
		animacionesAtaque.put("poder33", animacionPoder33);
		
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
		if((this.ataqueActivo || this.ataqueActivo2) && !this.choco) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
		}
		
	}
	@Override
	public void mover() {
		if(!ataqueActivo && !ataqueActivo2 ) {
			this.x=JugadorAnimado.coordenadaX+10;
			this.y=JugadorAnimado.cooordenadaY+20;
			}
		
		if(JugadorAnimado.animacionActual== "puno" && !ataqueActivo2 && (this.poder1 || this.poder2 || this.poder3)) { 
			this.ataqueActivo=true;
			this.ataqueActivo2=false;
			}
		if(JugadorAnimado.animacionActual=="puno2" && !ataqueActivo && (this.poder1 || this.poder2 || this.poder3)) {
			this.ataqueActivo2=true;
			this.ataqueActivo=false;
			}
		if(this.ataqueActivo) {
			this.x=this.x+10;
			if(this.poder1)
			this.animacionActual="fuego";
			if(this.poder2)
				this.animacionActual="poder2";
			if(this.poder3)
				this.animacionActual="poder3";
		}
		if(this.ataqueActivo2) { 
				this.x=this.x-10;
				if(this.poder1)
				this.animacionActual="fuego2";
				if(this.poder2)
					this.animacionActual="poder22";
				if(this.poder3)
					this.animacionActual="poder33";
		}
		
			if( this.ataqueActivo && (this.x>(JugadorAnimado.coordenadaX+400) || (this.x>Enemigo.coordenadaX+2 && Enemigo.vidas!=0 && JugadorAnimado.xTotal==1 && JugadorAnimado.yTotal==1)) ) {
				ataqueActivo = false;
				this.choco = false;
				
			}
			if(this.ataqueActivo2 && this.x<(JugadorAnimado.coordenadaX-400) ) {
				ataqueActivo2=false;
				this.x=JugadorAnimado.coordenadaX;
				this.y=JugadorAnimado.cooordenadaY+20;
			}
				
		
	
	}
}
