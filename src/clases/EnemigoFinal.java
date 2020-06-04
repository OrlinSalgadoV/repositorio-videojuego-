package clases;

import java.util.ArrayList;
import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoFinal extends ObjetoJuego {
	public  int vidas;
	private HashMap<String, Animacion>animacionesEnemigoFinal;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	public  String animacionActual;
	private double hp;
	private AtaqueEnemigoFinal ataqueEnemigoFinal;
	private ArrayList<AtaqueEnemigoFinal> ataquesEnemigoFinal;
	private int tipo;
	private double distancia;
	private double distancia2;
	private int cont=0;
	private int cont2=0;
	private int jugadorY;
	private boolean choco=false;
	private boolean choco2=false;
	private boolean ataqueActivo=false;
	private boolean ataqueActivo2=false;
	private int contCambioAtaque=0;
	public EnemigoFinal(int x, int y, String nombreImagen, int velocidad, String animacionActual, double hp,
			AtaqueEnemigoFinal ataqueEnemigoFinal, ArrayList<AtaqueEnemigoFinal> ataquesEnemigoFinal, int tipo,
			double distancia, int vidas) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual = animacionActual;
		this.hp = hp;
		this.ataqueEnemigoFinal = ataqueEnemigoFinal;
		this.ataquesEnemigoFinal = ataquesEnemigoFinal;
		this.tipo = tipo;
		this.distancia = distancia;
		this.vidas = vidas;
		animacionesEnemigoFinal= new HashMap<String, Animacion>();
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
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public AtaqueEnemigoFinal getAtaqueEnemigoFinal() {
		return ataqueEnemigoFinal;
	}
	public void setAtaqueEnemigoFinal(AtaqueEnemigoFinal ataqueEnemigoFinal) {
		this.ataqueEnemigoFinal = ataqueEnemigoFinal;
	}
	public ArrayList<AtaqueEnemigoFinal> getAtaquesEnemigoFinal() {
		return ataquesEnemigoFinal;
	}
	public void setAtaquesEnemigoFinal(ArrayList<AtaqueEnemigoFinal> ataquesEnemigoFinal) {
		this.ataquesEnemigoFinal = ataquesEnemigoFinal;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	public int getCont2() {
		return cont2;
	}
	public void setCont2(int cont2) {
		this.cont2 = cont2;
	}
	public boolean isChoco() {
		return choco;
	}
	public void setChoco(boolean choco) {
		this.choco = choco;
	}
	public boolean isAtaqueActivo() {
		return ataqueActivo;
	}
	
	
	public boolean isAtaqueActivo2() {
		return ataqueActivo2;
	}
	public void setAtaqueActivo2(boolean ataqueActivo2) {
		this.ataqueActivo2 = ataqueActivo2;
	}
	public void setAtaqueActivo(boolean ataqueActivo) {
		this.ataqueActivo = ataqueActivo;
	}
	
	public int getContCambioAtaque() {
		return contCambioAtaque;
	}
	public void setContCambioAtaque(int contCambioAtaque) {
		this.contCambioAtaque = contCambioAtaque;
	}
	public void inicializarAnimaciones(){
		Rectangle coordenadasDescanso[]= {
				new Rectangle(160,1424,32,70),
				new Rectangle(192,1424,32,70),
				new Rectangle(224,1424,32,70),
				new Rectangle(257,1424,32,70),	
			};
		Animacion animacionDescanso= new Animacion(.5,coordenadasDescanso);
		animacionesEnemigoFinal.put("descanso", animacionDescanso);
		Rectangle coordenadasPoseVictoria[]= {
				new Rectangle(383,1421,36,73),
				new Rectangle(418,1421,36,73),	
			};
		Animacion animacionPoseVictoria= new Animacion(.8,coordenadasPoseVictoria);
		animacionesEnemigoFinal.put("poseVictoria", animacionPoseVictoria);
		
		Rectangle coordenadasPoseTriste[]= {
				new Rectangle(449,586,35,69),
				new Rectangle(484,586,35,65),	
			};
		Animacion animacionPoseTriste= new Animacion(.5,coordenadasPoseTriste);
		animacionesEnemigoFinal.put("poseTriste", animacionPoseTriste);
		
		Rectangle coordenadasAtaque1[]= {
				new Rectangle(74,802,44,57),
				new Rectangle(120,802,44,57),	
			};
		Animacion animacionAtaque1= new Animacion(.5,coordenadasAtaque1);
		animacionesEnemigoFinal.put("ataque1", animacionAtaque1);
		
		Rectangle coordenadasAtaque2[]= {
				new Rectangle(115,586,49,66),
				new Rectangle(163,586,49,66),
				new Rectangle(211,586,49,66),
			};
		Animacion animacionAtaque2= new Animacion(.5,coordenadasAtaque2);
		animacionesEnemigoFinal.put("ataque2", animacionAtaque2);
		
		Rectangle coordenadasLocalizar[]= {
				new Rectangle(6,908,40,70),
				new Rectangle(46,908,40,70),
			};
		Animacion animacionLocalizar= new Animacion(.5,coordenadasLocalizar);
		animacionesEnemigoFinal.put("localizar", animacionLocalizar);
		
		Rectangle coordenadasLocalizar2[]= {
				new Rectangle(0,795,37,67),
				new Rectangle(37,795,37,67),
			};
		Animacion animacionLocalizar2= new Animacion(.5,coordenadasLocalizar2);
		animacionesEnemigoFinal.put("localizar2", animacionLocalizar2);
	}
	public void calculaFrame(double t) {
		Rectangle coordenadas= animacionesEnemigoFinal.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		this.anchoImagen=(int)coordenadas.getWidth();
		this.altoImagen=(int)coordenadas.getHeight();
		ataqueEnemigoFinal.calcularFrame(t);
		for(int i=0;i<ataquesEnemigoFinal.size();i++) {
			ataquesEnemigoFinal.get(i).calcularFrame(t);
		}
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	@Override
	public void pintar(GraphicsContext graficos) {
		if(this.vidas>0) { 
			graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen,altoImagen, x, y, anchoImagen, altoImagen);
			if(!this.choco && this.contCambioAtaque<200)
			ataqueEnemigoFinal.pintar(graficos);
		if(this.contCambioAtaque>=240) {	
			for(int i=0;i<this.ataquesEnemigoFinal.size();i++) {
				if(!ataquesEnemigoFinal.get(i).isChoco())
					ataquesEnemigoFinal.get(i).pintar(graficos);
			}
		}
		if(JugadorAnimado.xTotal==4 && JugadorAnimado.yTotal==0) {
			
			if(this.vidas>=28)		
				graficos.drawImage(Juego.imagenes.get("barravida"), 4,4,120,26, this.x-30,this.y+75,80,15);
			if(this.vidas<28 && this.vidas>=22 )
				graficos.drawImage(Juego.imagenes.get("barravida"), 4,29,120,26,this.x-30,this.y+75,80,15);
			if(this.vidas<22 && this.vidas>=15 )
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,54,120,26,this.x-30,this.y+75,80,15);
			if(this.vidas<15 && this.vidas>=10 )
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,79,120,26, this.x-30,this.y+75,80,15);
			if(this.vidas<10 && this.vidas>=5 )
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,104,120,26, this.x-30,this.y+75,80,15);
			if(this.vidas<5)
				graficos.drawImage(Juego.imagenes.get("barravida"), 3,129,120,26, this.x-30,this.y+75,80,15);
					}
		}
		
		
	}
	@Override
	public void mover() {
		this.vidas=(int)this.hp/5;
		for(int j=0;j<ataquesEnemigoFinal.size();j++) {
			ataquesEnemigoFinal.get(j).colocar();
		}
		if(Juego.derecha && JugadorAnimado.coordenadaX>720) {  
			 this.x-=720;
			 ataqueEnemigoFinal.setX(ataqueEnemigoFinal.getX()-720);}
		if(Juego.izquierda && JugadorAnimado.coordenadaX<0) { 
			 this.x+=720;
			 ataqueEnemigoFinal.setX(ataqueEnemigoFinal.getX()+720);}
		if(Juego.arriba && JugadorAnimado.cooordenadaY<0) { 
			 this.y+=504;
			 ataqueEnemigoFinal.setY(ataqueEnemigoFinal.getY()+504);}
		if(Juego.abajo && JugadorAnimado.cooordenadaY>504) {  
			 this.y-=504;
			 ataqueEnemigoFinal.setY(ataqueEnemigoFinal.getY()-504);}
		
		if(this.vidas>0  && JugadorAnimado.xTotal>3 && JugadorAnimado.yTotal<1) {
			contCambioAtaque++;
			if(this.isChoco()) {
				cont2++;
				this.animacionActual="poseVictoria";
				if(cont2>5) {
					this.animacionActual="descanso";
					this.cont2=0;
					
				}
				
			}
			if(/*ataqueEnemigoFinal.getTipoAtaque()==3 &&*/ this.contCambioAtaque<200) {
			if((this.x==(ataqueEnemigoFinal.getX()+60)) && (this.y==ataqueEnemigoFinal.getY()))
				this.animacionActual="localizar";
			cont++;
			if(cont>15) {
				this.jugadorY=JugadorAnimado.cooordenadaY;
				this.cont=0;}
			if(this.animacionActual=="localizar") {
				if(ataqueEnemigoFinal.getY()<(this.jugadorY-10))
					ataqueEnemigoFinal.setY(ataqueEnemigoFinal.getY()+5);
				if(ataqueEnemigoFinal.getY()>(this.jugadorY+10))
					ataqueEnemigoFinal.setY(ataqueEnemigoFinal.getY()-5);
				if(ataqueEnemigoFinal.getY()<=(this.jugadorY+10) && ataqueEnemigoFinal.getY()>=(this.jugadorY-10)) {	
					this.animacionActual="ataque1";
					this.ataqueActivo=true;}
			}
			if(this.ataqueActivo) {
				if(ataqueEnemigoFinal.getX()>(this.x-this.distancia)) {
					ataqueEnemigoFinal.mover();
					if(!this.choco) 
						this.animacionActual="descanso";
						
					}
				else {
					ataqueEnemigoFinal.setX(this.x-60);
					ataqueEnemigoFinal.setY(this.y);
					this.ataqueActivo=false;
					this.animacionActual="localizar";
					this.choco=false;}
			}
				
				
		}
			if(this.contCambioAtaque >= 200 && this.contCambioAtaque < 220) {
				this.animacionActual="localizar2";
				ataqueEnemigoFinal.setX(this.x-60);
				ataqueEnemigoFinal.setY(this.y);
				}
			if(this.contCambioAtaque >= 220 && this.contCambioAtaque < 240)
				this.animacionActual="ataque2";
			
			if(/*ataqueEnemigoFinal.getTipoAtaque()!=3 && */this.contCambioAtaque >= 240 ) {
				for(int i=0;i<ataquesEnemigoFinal.size();i++) {
					if(ataquesEnemigoFinal.get(i).getTipoAtaque()==1 ) {
						if(ataquesEnemigoFinal.get(i).getX()>(720-this.distancia)) {
							ataquesEnemigoFinal.get(i).mover();
							if(!ataquesEnemigoFinal.get(i).isChoco()) 
								this.animacionActual="descanso";}
						else {
							
							ataquesEnemigoFinal.get(i).setX((720));
							ataquesEnemigoFinal.get(i).setChoco(false);
							}
							
					}
					if(ataquesEnemigoFinal.get(i).getTipoAtaque()==4 ) {
						if(ataquesEnemigoFinal.get(i).getX()>(920-this.distancia)) {
							ataquesEnemigoFinal.get(i).mover();
							if(!ataquesEnemigoFinal.get(i).isChoco()) 
								this.animacionActual="descanso";}
						else {
							
							ataquesEnemigoFinal.get(i).setX((920));
							ataquesEnemigoFinal.get(i).setChoco(false);
							}		
					}
					
					if(ataquesEnemigoFinal.get(i).getTipoAtaque()==2) {
						if(ataquesEnemigoFinal.get(i).getY()<(this.distancia-80))
						ataquesEnemigoFinal.get(i).mover();	
						else {
							ataquesEnemigoFinal.get(i).setY(-80);
							ataquesEnemigoFinal.get(i).setChoco(false);}
							//this.contCambioAtaque=0;
					}
					
					if(ataquesEnemigoFinal.get(i).getTipoAtaque()==5) {
						if(ataquesEnemigoFinal.get(i).getY()<(this.distancia-280))
						ataquesEnemigoFinal.get(i).mover();	
						else {
							ataquesEnemigoFinal.get(i).setY(-280);
							ataquesEnemigoFinal.get(i).setChoco(false);
							this.contCambioAtaque=0;}
					}
				}
				
			}
		}

		
	}
	
	
	
	
}
