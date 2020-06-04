package clases;


import java.util.ArrayList;
import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ObjetoJuego{
	private int vidas;
	private HashMap<String, Animacion>animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	public static String animacionActual;
	public static int xTotal=0;
	public static int yTotal=0;
	public static int coordenadaX;
	public static int cooordenadaY;
	public static boolean chocando=false;
	public static boolean chocando2=false;
	public static boolean chocando3=false;
	private int tipoPoder;
	private int temporal;
	public static double puntos=0;
	private int hp;
	//private int direccion=1;
	//int temporal;
	
	public JugadorAnimado(int x, int y, String nombreImagen, int velocidad, int hp, String animacionActual,int vidas) {
		super(x, y, nombreImagen, velocidad);
		this.hp = hp;
		this.vidas=vidas;
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
	
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	//public int getHp() {
		//return hp;
	//}
	//public void setHp(int hp) {
		//this.hp = hp;
//	}
	//public int getDireccion() {
		//return direccion;
	//}
	//public void setDireccion(int direccion) {
	//	this.direccion = direccion;
	//}
	public void inicializarAnimaciones() {
		Rectangle coordenadasCorrer[]= {
			new Rectangle(563,62,38,63),
			new Rectangle(516,62,38,63),
			new Rectangle(472,62,38,63),
			new Rectangle(430,62,38,63),
			new Rectangle(388,62,38,63),
			new Rectangle(342,62,38,63)
			
		};
		Animacion animacionCorrer= new Animacion(.15,coordenadasCorrer);
		animaciones.put("correr", animacionCorrer);
		
		Rectangle coordenadasCorrer2[]= {
				new Rectangle(605,65,38,63),
				new Rectangle(643,65,38,63),
				new Rectangle(693,65,38,63),
				new Rectangle(736,65,38,63),
				new Rectangle(777,65,38,63),
				new Rectangle(821,65,38,63)
			};
			Animacion animacionCorrer2= new Animacion(.15,coordenadasCorrer2);
			animaciones.put("correr2", animacionCorrer2);
			
			Rectangle coordenadasCorrer3[]= {
					new Rectangle(244,62,38,63),
					new Rectangle(201,62,38,63),
					new Rectangle(158,62,38,63),
					new Rectangle(117,62,38,63),
					new Rectangle(81,62,38,63),
					new Rectangle(44,62,38,63)
					
				};
				Animacion animacionCorrer3= new Animacion(.15,coordenadasCorrer3);
				animaciones.put("correr3", animacionCorrer3);
				
				Rectangle coordenadasCorrer4[]= {
						new Rectangle(923,65,38,63),
						new Rectangle(961,65,38,63),
						new Rectangle(1001,65,38,63),
						new Rectangle(1046,65,38,63),
						new Rectangle(1082,65,38,63),
						new Rectangle(1123,65,38,63)
					};
					Animacion animacionCorrer4= new Animacion(.15,coordenadasCorrer4);
					animaciones.put("correr4", animacionCorrer4);
					
					Rectangle coordenadasCorrer5[]= {
							
							new Rectangle(244,62,38,63),
							new Rectangle(201,62,38,63),
							new Rectangle(158,62,38,63),
							new Rectangle(923,65,38,63),
							new Rectangle(961,65,38,63),
							new Rectangle(1001,65,38,63),
							new Rectangle(117,62,38,63),
							new Rectangle(81,62,38,63),
							new Rectangle(44,62,38,63),
							new Rectangle(1046,65,38,63),
							new Rectangle(1082,65,38,63),
							new Rectangle(1123,65,38,63)
						};
						Animacion animacionCorrer5= new Animacion(.15,coordenadasCorrer5);
						animaciones.put("correr5", animacionCorrer5);

						
		Rectangle coordenadasDescanso[]= {
				new Rectangle(342,881,32,59),
				new Rectangle(309,881,32,59),	
		};
		Animacion animacionDescanso= new Animacion(1.5,coordenadasDescanso);
		animaciones.put("descanso", animacionDescanso);
		
		Rectangle coordenadasDescanso2[]= {
				new Rectangle(856,882,32,59),
				new Rectangle(823,882,32,59),	
		};
		Animacion animacionDescanso2= new Animacion(1.5,coordenadasDescanso2);
		animaciones.put("descanso2", animacionDescanso2);
		
		Rectangle coordenadasPuno[]= {
				new Rectangle(466,283,40,60),
				new Rectangle(557,283,40,60),
		};
		Animacion animacionPuno= new Animacion(.2,coordenadasPuno);
		animaciones.put("puno", animacionPuno);
		Rectangle coordenadasPuno2[]= {
				new Rectangle(689,283,40,60),
				new Rectangle(649,283,40,60),
		};
		Animacion animacionPuno2= new Animacion(.2,coordenadasPuno2);
		animaciones.put("puno2", animacionPuno2);
	}
	public void calcularFrame(double t) {
		Rectangle coordenadas= animaciones.get(animacionActual).calcularFrameActual(t);
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
		if(this.vidas!=0)
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
		//graficos.setStroke(Color.RED);
		//graficos.strokeRect(x, y, anchoImagen, altoImagen);
	}
	
	@Override
	public void mover() {
		this.coordenadaX=this.x;
		this.cooordenadaY=this.y;
		if(Juego.derecha && x>720) {  
			this.xTotal++;
			this.x=1;
			}
		if(Juego.izquierda && x<0) { 
			this.xTotal--;
			this.x=719;
			}
		if(Juego.abajo && y>504) {
			this.yTotal++;
			this.y=1;
			}
		if(Juego.arriba && y<0) {
			this.yTotal--;
			this.y=503;
			}
		if(Juego.derecha ) 
			x+=velocidad;
		if(Juego.izquierda ) 
			x-=velocidad;
		if(Juego.arriba ) 
			y-=velocidad;
		if(Juego.abajo ) 
			y+=velocidad;
	
		if( Juego.espacio) {
			animaciones.get("correr").setDuracion(.08);
			animaciones.get("correr2").setDuracion(.08);
			animaciones.get("correr3").setDuracion(.08);
			animaciones.get("correr4").setDuracion(.08);
			animaciones.get("correr5").setDuracion(.08);
			}
		
		else {
			animaciones.get("correr").setDuracion(.15);
			animaciones.get("correr2").setDuracion(.15);
			animaciones.get("correr3").setDuracion(.15);
			animaciones.get("correr4").setDuracion(.15);
			animaciones.get("correr5").setDuracion(.15);
			}
		if(Juego.teclaX) {
			if(this.animacionActual=="correr" || this.animacionActual=="descanso") 
					this.animacionActual="puno";
			if(this.animacionActual=="correr2" || this.animacionActual=="descanso2")
				this.animacionActual="puno2";
			}
		else {
			if(this.animacionActual=="puno")
				this.animacionActual="descanso";
			if(this.animacionActual=="puno2")
				this.animacionActual="descanso2";
		}
			
	
		if(!Juego.arriba && !Juego.abajo) {
			if(Juego.derecha)
				this.animacionActual="correr";
			if(Juego.izquierda)
				this.animacionActual="correr2";
		}
		if(!Juego.derecha && !Juego.izquierda) {
			if(Juego.abajo)
				this.animacionActual="correr";
			if(Juego.arriba)
				this.animacionActual="correr5";
		}
		if(!Juego.izquierda && !Juego.abajo) {
			if(Juego.derecha && Juego.arriba)
				this.animacionActual="correr3";
		}
		if(!Juego.derecha && !Juego.abajo) {
			if(Juego.izquierda && Juego.arriba)
				this.animacionActual="correr4";
		}
		if(!Juego.izquierda && !Juego.arriba) {
			if(Juego.derecha && Juego.abajo)
				this.animacionActual="correr";
		}
		if(!Juego.derecha && !Juego.arriba) {
			if(Juego.izquierda && Juego.abajo)
				this.animacionActual="correr2";
		}
		
		
	}
	
		
	
	
	public void verificarColisiones(Enemigo enemigo, double t, Ataque ataque, AtaqueJugador ataqueJugador, ArrayList<Item>items, ArrayList<Tile2>tiles2, ArrayList<Obstaculo>obstaculos, ArrayList<EnemigoGeneral>enemigosgenerales, EnemigoLibro enemigoLibro, EnemigoFinal enemigoFinal) {
		enemigo.vidas=((int)(enemigo.getHp()/50));
		this.vidas=(int)(this.hp/50);
		if(!ataqueJugador.isPoder1())
			this.tipoPoder=2;
		if(ataqueJugador.isPoder1())
			this.tipoPoder=1;
		if(ataqueJugador.isPoder2())
			this.tipoPoder=2;
		if(ataqueJugador.isPoder3())
			this.tipoPoder=3;
		
		for(int i=0;i<items.size();i++) {
			if(!(items.get(i).isCapturado()) && this.obtenerRectangulo().getBoundsInLocal().intersects(items.get(i).obtenerRectangulo().getBoundsInLocal())) {
				switch(items.get(i).getTipoItem()) {
				case 1:
					this.hp+=50*(items.get(i).getCantidad());
					items.get(i).setCapturado(true);
				break;
				case 2:
					ataqueJugador.setPoder1(true);
					items.get(i).setCapturado(true);
				break;
				case 3:
					items.get(i).setChocando(true);
				break;
				case 4:
					ataqueJugador.setPoder2(true);
					items.get(i).setCapturado(true);
					ataqueJugador.setPoder1(false);
				break;
				case 5:
					ataqueJugador.setPoder3(true);
					items.get(i).setCapturado(true);
					ataqueJugador.setPoder2(false);
				break;
				default:
					if(items.get(i).getTipoItem()==6 || items.get(i).getTipoItem()==15) {
						items.get(i).setCapturado(true);
						this.puntos+=3;}
					if(items.get(i).getTipoItem()==7 || items.get(i).getTipoItem()==11) {
						items.get(i).setCapturado(true);
						this.puntos+=4;}
					if(items.get(i).getTipoItem()==9 || items.get(i).getTipoItem()==10 || items.get(i).getTipoItem()==14) {
						items.get(i).setCapturado(true);
						this.puntos+=5;}
					if(items.get(i).getTipoItem()==13 || items.get(i).getTipoItem()==16 || items.get(i).getTipoItem()==18 || items.get(i).getTipoItem()==21 || items.get(i).getTipoItem()==24) {
						items.get(i).setCapturado(true);
						this.puntos+=7;}
					if(items.get(i).getTipoItem()==8 || items.get(i).getTipoItem()==12 || items.get(i).getTipoItem()==22) {
						items.get(i).setCapturado(true);
						this.puntos+=8;}
					if(items.get(i).getTipoItem()==17 || items.get(i).getTipoItem()==19 || items.get(i).getTipoItem()==20 || items.get(i).getTipoItem()==23 || items.get(i).getTipoItem()==25) {
						items.get(i).setCapturado(true);
						this.puntos+=10;}
					
					
				break;
				
				}
			}
			else
				items.get(i).setChocando(false);
		}
		for(int i=0;i<tiles2.size();i++) {
			if(tiles2.get(i).getTipoTile()!=16 && tiles2.get(i).getTipoTile()!=17 && tiles2.get(i).getTipoTile()!=18 && tiles2.get(i).getTipoTile()!=28 && tiles2.get(i).getTipoTile()!=31 && tiles2.get(i).getTipoTile()!=32&& tiles2.get(i).getTipoTile()!=31 && tiles2.get(i).getTipoTile()!=41 && tiles2.get(i).getTipoTile()!=41 && tiles2.get(i).getTipoTile()!=44 && tiles2.get(i).getTipoTile()!=47) {
				if(this.obtenerRectangulo().getBoundsInLocal().intersects(tiles2.get(i).obtenerRectangulo().getBoundsInLocal())) {
					this.velocidad=2;
					if(this.x<tiles2.get(i).getX())
						this.x=this.x-1;
					if(this.x>tiles2.get(i).getX())
						this.x=this.x+1;
					if(this.y<tiles2.get(i).getY())
						this.y=this.y-1;
					if(this.y>tiles2.get(i).getY())
						this.y=this.y+1;
				}
				
			}
		}
		
		for(int i=0;i<obstaculos.size();i++) {
			if( this.obtenerRectangulo().getBoundsInLocal().intersects(obstaculos.get(i).obtenerRectangulo().getBoundsInLocal())) {
				if(obstaculos.get(i).getAnimacionActual()=="puas" ) {
					this.hp--;
					if(this.puntos>0)
						this.puntos-=0.5;}
				
				}
			if(obstaculos.get(i).getAnimacionActual()!= "puas" && obstaculos.get(i).getDurabilidad()>0 && (this.obtenerRectangulo().getBoundsInLocal().intersects(obstaculos.get(i).obtenerRectangulo().getBoundsInLocal()) || ataqueJugador.obtenerRectangulo().getBoundsInLocal().intersects(obstaculos.get(i).obtenerRectangulo().getBoundsInLocal()))) {
				if(this.animacionActual=="puno" || this.animacionActual=="puno2"){
						int j=obstaculos.get(i).getDurabilidad();
						//if(!ataqueJugador.isPoder2() && !ataqueJugador.isPoder2())
						obstaculos.get(i).setDurabilidad(j-this.tipoPoder);
						this.puntos+=tipoPoder;
						//if(ataqueJugador.isPoder2())
							//obstaculos.get(i).setDurabilidad(j-2);
						//if(ataqueJugador.isPoder3())
							//obstaculos.get(i).setDurabilidad(j-3);
						if(obstaculos.get(i).getDurabilidad()>12)
							obstaculos.get(i).setAnimacionActual("caja");
						if(obstaculos.get(i).getDurabilidad()<=12 && obstaculos.get(i).getDurabilidad()>6)
							obstaculos.get(i).setAnimacionActual("caja2");
						if(obstaculos.get(i).getDurabilidad()<=6 && obstaculos.get(i).getDurabilidad()>0)
							obstaculos.get(i).setAnimacionActual("caja3");
						
				}
				if(obstaculos.get(i).getDurabilidad()<=0)
					obstaculos.get(i).setAnimacionActual("cajaEstatica4");
			}
			if((!this.obtenerRectangulo().getBoundsInLocal().intersects(obstaculos.get(i).obtenerRectangulo().getBoundsInLocal()) && !ataqueJugador.obtenerRectangulo().getBoundsInLocal().intersects(obstaculos.get(i).obtenerRectangulo().getBoundsInLocal()))) {
				if(obstaculos.get(i).getAnimacionActual()!="puas") {
				if(obstaculos.get(i).getDurabilidad()>12)
					obstaculos.get(i).setAnimacionActual("cajaEstatica");
				if(obstaculos.get(i).getDurabilidad()<=12 && obstaculos.get(i).getDurabilidad()>6)
					obstaculos.get(i).setAnimacionActual("cajaEstatica2");
				if(obstaculos.get(i).getDurabilidad()<=6 && obstaculos.get(i).getDurabilidad()>0)
					obstaculos.get(i).setAnimacionActual("cajaEstatica3");
				if(obstaculos.get(i).getDurabilidad()==0)
					obstaculos.get(i).setAnimacionActual("cajaEstatica4");
				}
			}
			if(this.obtenerRectangulo().getBoundsInLocal().intersects(obstaculos.get(i).obtenerRectangulo().getBoundsInLocal()) && obstaculos.get(i).getDurabilidad()>0) {
				this.velocidad=2;
				if(this.x<obstaculos.get(i).getX())
					this.x=this.x-1;
				if(this.x>obstaculos.get(i).getX())
					this.x=this.x+1;
				if(this.y<obstaculos.get(i).getY())
					this.y=this.y-1;
				if(this.y>obstaculos.get(i).getY())
					this.y=this.y+1;
			}
		}
			
		if(enemigo.getVidas()>0 && enemigo.getX()>590) {
			if(this.obtenerRectangulo().getBoundsInLocal().intersects(enemigo.obtenerRectangulo().getBoundsInLocal()) ) {
				this.chocando=true;
				if(Juego.teclaX) {
					temporal=enemigo.getHp();
					enemigo.setHp(temporal-5);
			
				}
			}
			if(!(this.obtenerRectangulo().getBoundsInLocal().intersects(enemigo.obtenerRectangulo().getBoundsInLocal()))) 
				this.chocando=false;
		
			if(this.obtenerRectangulo().getBoundsInLocal().intersects(ataque.obtenerRectangulo().getBoundsInLocal())  /*&& this.xTotal==1 && this.yTotal==1*/) {
					this.hp=this.hp-2;
					if(this.puntos>0)
						this.puntos-=0.5;
			}
		
			if( enemigo.obtenerRectangulo().getBoundsInLocal().intersects(ataqueJugador.obtenerRectangulo().getBoundsInLocal()) ) {
				enemigo.setHp(enemigo.getHp()-20);
				this.puntos+=3;
				enemigo.ataqueChocando = true;
			}
		}
		if(!enemigo.obtenerRectangulo().getBoundsInLocal().intersects(ataqueJugador.obtenerRectangulo().getBoundsInLocal())) {
			enemigo.setVidas((int)(enemigo.getHp()/50));
			enemigo.ataqueChocando = false;
		}
		for(int i=0;i<enemigosgenerales.size();i++) {
			if(enemigosgenerales.get(i).getVidas()>0 && enemigosgenerales.get(i).getAtaqueGeneral().obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal())) {
				this.hp--;
				enemigosgenerales.get(i).setChoco(true);
				if(this.puntos>0)
					this.puntos-=0.5;
			}
			if(ataqueJugador.isAtaqueActivo() || ataqueJugador.isAtaqueActivo2()) {
				if(enemigosgenerales.get(i).getVidas()>0 && ataqueJugador.obtenerRectangulo().getBoundsInLocal().intersects(enemigosgenerales.get(i).obtenerRectangulo().getBoundsInLocal())) {
					enemigosgenerales.get(i).setHp(enemigosgenerales.get(i).getHp()-this.tipoPoder);
					this.puntos++;
				}
			}
		}
		
		if(enemigoLibro.getVidas()>0 && enemigoLibro.getAtaqueLibro().obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal()) ) {
			this.hp--;
			enemigoLibro.setChoco(true);
			if(this.puntos>0)
				this.puntos--;
		}
		if(ataqueJugador.isAtaqueActivo() || ataqueJugador.isAtaqueActivo2()) {
			if(enemigoLibro.getVidas()>0 && ataqueJugador.obtenerRectangulo().getBoundsInLocal().intersects(enemigoLibro.obtenerRectangulo().getBoundsInLocal())) {
				enemigoLibro.setHp(enemigoLibro.getHp()-this.tipoPoder);
				this.puntos+=5;
				ataqueJugador.setChoco(true);
			}
		}
		
		if(enemigoFinal.getVidas()>0) {
			if(enemigoFinal.getContCambioAtaque()<200 && enemigoFinal.getAtaqueEnemigoFinal().obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal()) ) {
				this.hp-=2;
				enemigoFinal.setChoco(true);
				if(this.puntos>0)
					this.puntos-=2;
			}
			for(int i=0;i<enemigoFinal.getAtaquesEnemigoFinal().size();i++) {
				if(enemigoFinal.getContCambioAtaque()>=240 && enemigoFinal.getAtaquesEnemigoFinal().get(i).obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal()) ) {
					this.hp--;
					enemigoFinal.getAtaquesEnemigoFinal().get(i).setChoco(true);
					if(this.puntos>0)
						this.puntos--;
				}
				
				
			}
			if(ataqueJugador.isAtaqueActivo() || ataqueJugador.isAtaqueActivo2()) {
				if(ataqueJugador.obtenerRectangulo().getBoundsInLocal().intersects(enemigoFinal.obtenerRectangulo().getBoundsInLocal())) {
					enemigoFinal.setHp(enemigoFinal.getHp()-this.tipoPoder);
					this.puntos+=10;
					ataqueJugador.setChoco(true);
				}
			}
		}
		
	}
	
public void choques(EnemigoLibro enemigoLibro, EnemigoFinal enemigoFinal) {
		/*if(xTotal<1) {
		if(yTotal<1 && this.y<50)
			this.y=50;
		if(this.x<5)
			this.x=5;
		if(yTotal<1 && this.y>390)
			this.y=390;
		}*/
		if(yTotal<1 && this.y<1 ) 
				this.y=1;
		if(xTotal<1 && this.x<1 ) 
			this.x=1;
		if(yTotal>0 && this.y>503)
			this.y=502;
		if(xTotal>3 && this.x>520 ) 
			this.x=519;
		
			
		if(xTotal==1 && yTotal==1) {
			if(this.y<1)
				this.y=1;
			if(Enemigo.vidas>0) {
				if(this.x>600)
					this.x=600;
				if(this.x<1)
					this.x=1;
			}
			
			/*else {
			if( this.y<200 && this.x>699)
				this.x=699;
			if( this.y>260 && this.x>699)
				this.x=699;
			}*/
		}
		if(xTotal==2 && yTotal==0) {
			if(enemigoLibro.getVidas()>0) {
				if (this.x>700)
					this.x=700;
				if(this.y>504)
					this.y=503;
			}
			if(this.y>504)
				this.y=504;
		}
		if(xTotal==4 && yTotal==0) {
			if(this.y>504)
				this.y=504;

		}
	}
	
}
