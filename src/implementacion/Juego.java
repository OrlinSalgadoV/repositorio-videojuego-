package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.Fondo;
import clases.Item;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Juego extends Application{
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas lienzo;
	private int x=0;
	private int y=0;
	//private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	private Fondo fondo;
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	public static boolean espacio;
	public static HashMap<String, Image>imagenes;
	private Item item;
	//private Tile tile;
	private ArrayList<Tile>tiles;
	private int tilemap[][] = { 
			{0,0,0,0,1,2,3,4,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,1,1,1,1,1,1,0,0,0},
			{0,0,0,1,4,5,6,1,4,5,6,1,0,0,0},
			{0,0,0,1,7,8,9,1,7,8,9,1,0,0,0},
			{0,0,0,1,1,1,1,1,1,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			
			
	};
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		gestionEventos();
		
		ventana.setScene(escena);
		ventana.setTitle("Wind Protector");
		ventana.show();
		cicloJuego();
	}
	public void cicloJuego() {
		long tiempoInicial=System.nanoTime();
		AnimationTimer animationTimer=new AnimationTimer() {

			@Override
			public void handle(long tiempoActual) {
			 double t=(tiempoActual-tiempoInicial)/1000000000.0;
			// System.out.println(t);
			 actualizarEstado(t);
			 pintar();	
			}
			
		};
		animationTimer.start();
		
	}
	public void actualizarEstado(double t) {
		//jugador.mover();
		jugadorAnimado.verificarColisiones(item);
		jugadorAnimado.calcularFrame(t);
		jugadorAnimado.mover();
		fondo.mover();
	}
	public void inicializarComponentes() {
		imagenes= new HashMap<String, Image>();
		cargarImagenes();
		//jugador = new Jugador(0, 0, "boreas1",5, 0);
		jugadorAnimado = new JugadorAnimado(0, 0, "boreas",3, 20,"descanso");
		fondo = new Fondo(0 ,0 ,"fondograma","fondograma2",1);
		inicializarTiles();
		item= new Item(400,200,"item",0,1);
		//tile= new Tile(0,0,"tilemap1",0,94,94,50,50);
		root = new Group();
		lienzo = new Canvas(700, 500);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
		escena = new Scene(root, 700, 500);
	}
	public void inicializarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<tilemap.length;i++) {
			for(int j=0; j<tilemap[i].length;j++) {
				if(tilemap[i][j]!=0)
					this.tiles.add(new Tile(tilemap[i][j], j*48, i*48,"tilemap1", 0, 48, 48));
				
			}
		}
	}
	public void cargarImagenes() {
		imagenes.put("boreas1",new Image ("boreas1.png"));
		imagenes.put("fondograma", new Image("fondograma.jpg"));
		imagenes.put("fondograma2", new Image("fondograma2.jpg"));
		imagenes.put("tilemap1", new Image("tilemap1.png"));
		imagenes.put("boreas", new Image("boreassprites.png"));
		imagenes.put("item", new Image("item2.png"));
	}
	public void pintar() {
		
		fondo.pintar(graficos);
		for(int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		//tile.pintar(graficos);
		//jugador.pintar(graficos);
		jugadorAnimado.pintar(graficos);
		item.pintar(graficos);
		graficos.fillText("vidas: "+jugadorAnimado.getVidas(), 20, 20);
	}
	
	public void gestionEventos() {
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				
				switch(evento.getCode().toString()){
				case "RIGHT":
					derecha = true;
					jugadorAnimado.setAnimacionActual("correr");
					jugadorAnimado.setDireccion(-1);
					
					break;
				case "LEFT":
					izquierda = true;
					jugadorAnimado.setAnimacionActual("correr");
					jugadorAnimado.setDireccion(1);
					
					break;
				case "UP":
					arriba = true;
					jugadorAnimado.setAnimacionActual("correr");
					break;
				case "DOWN":
					abajo = true;
					jugadorAnimado.setAnimacionActual("correr");
					break;
				case "SPACE":
					espacio=true;
					//jugador.setVelocidad(10);
					jugadorAnimado.setVelocidad(10);
					
					
					break;
				}
				
			}
			
		});
		escena.setOnKeyReleased(new  EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				switch(evento.getCode().toString()){
				case "RIGHT":
					derecha = false;
					jugadorAnimado.setAnimacionActual("descanso");
					break;
				case "LEFT":
					izquierda = false;
					jugadorAnimado.setAnimacionActual("descanso");
					break;
				case "UP":
					arriba = false;
					jugadorAnimado.setAnimacionActual("descanso");
					break;
				case "DOWN":
					abajo = false;
					jugadorAnimado.setAnimacionActual("descanso");
					break;
				case "SPACE":
					espacio=false;
					//jugador.setVelocidad(5);
					jugadorAnimado.setVelocidad(5);
					
					
					break;
				}
			}
			
		});
	}
}
