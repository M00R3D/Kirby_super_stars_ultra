/*NOMBRE COMPLETOS : FLORES SANCHEZ JOSE RAMON , MOORE GARAY JOB Y SALGADO CASTILLO ISAIAS
 * TEAM: EQUIPO KIRBY
 * CARRERA : INGENERIA EN DESARROLLO DE SOFTWARE
 * MATERIA : PROGRAMACION III
 * TURNO : VESPERTINO
 * SEMESTRE : 4
 */
package juego;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextField;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;

public class Ventana extends JFrame {

	public JPanel panelActual;
	private JFrame frame;
	private int kirbyX = 200, kirbyY = 110;
	private String kirbyLado = "derecha";/// estado de kirby(a donde esta mirando)
	private Boolean kirbyColisionH = false, kirbyColisionV = false;/// estado de kirby(colisiones vertical y horizontal)
	private boolean bloqueH = false, bloqueV = false;
	private String estomagoKirby = "vacio";
	private boolean aireShootR = false;
	private boolean aireShootL = false;
	private int fondoContadorX=0;
	//// teclas
	private boolean derecha = false, izquierda = false, arriba = false, k = false,j=false,p=false;
	private boolean juegoPlay = true;
	private int nivelParte = 1, coolDownTransicion = 0, coolDownSalto = 0;;
	private int nivel=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 474, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// MENU DEL JUEGO
		JPanel Menu = new JPanelPersonalizado("Menu");
		frame.getContentPane().add(Menu);
		this.revalidate();
		this.repaint();
		// PULSA START
		JPanel Inicio = new JPanelPersonalizado("Inicio");
		frame.getContentPane().add(Inicio);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JPanel Partidas = new JPanelPersonalizado("Partidas");
		/// KIRBY 1
		ImageIcon img3 = new ImageIcon("kirby 1.png");
		JButton kirb1 = new JButton(img3);
		kirb1.setSize(223, 42);
		kirb1.setLocation(120, 45);
		Image esc3 = img3.getImage().getScaledInstance(kirb1.getWidth(), kirb1.getHeight(), Image.SCALE_SMOOTH);
		Icon ices3 = new ImageIcon(esc3);
		kirb1.setIcon(ices3);
		Partidas.add(kirb1);
		// KIRBY 2
		ImageIcon img4 = new ImageIcon("kirby 2.png");
		JButton kirb2 = new JButton(img4);
		kirb2.setSize(223, 42);
		kirb2.setLocation(120, 125);
		Image esc4 = img4.getImage().getScaledInstance(kirb2.getWidth(), kirb2.getHeight(), Image.SCALE_SMOOTH);
		Icon ices4 = new ImageIcon(esc4);
		kirb2.setIcon(ices4);
		Partidas.add(kirb2);
		/// KIRBY 3
		ImageIcon img5 = new ImageIcon("kirby 3.png");
		JButton kirb3 = new JButton(img5);
		kirb3.setSize(223, 42);
		kirb3.setLocation(120, 205);
		Image esc5 = img5.getImage().getScaledInstance(kirb3.getWidth(), kirb3.getHeight(), Image.SCALE_SMOOTH);
		Icon ices5 = new ImageIcon(esc5);
		kirb3.setIcon(ices5);
		Partidas.add(kirb3);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// JUGADORES
		JPanel Jugadores = new JPanelPersonalizado("Jugadores");
		// JUGADOR 1
		ImageIcon img6 = new ImageIcon("Jugador 1.png");
		JButton im6 = new JButton(img6);
		im6.setSize(223, 42);
		im6.setLocation(120, 45);
		Image esc6 = img6.getImage().getScaledInstance(im6.getWidth(), im6.getHeight(), Image.SCALE_SMOOTH);
		Icon ices6 = new ImageIcon(esc6);
		im6.setIcon(ices6);
		Jugadores.add(im6);
		// JUGADOR 2
		ImageIcon img7 = new ImageIcon("Jugador 2.png");
		JButton im7 = new JButton(img7);
		im7.setSize(223, 42);
		im7.setLocation(120, 126);
		Image esc7 = img7.getImage().getScaledInstance(im7.getWidth(), im7.getHeight(), Image.SCALE_SMOOTH);
		Icon ices7 = new ImageIcon(esc7);
		im7.setIcon(ices7);
		Jugadores.add(im7);
		// REGRESAR AL INICIO
		ImageIcon img8 = new ImageIcon("Regresar.png");
		JButton btnRegresar = new JButton(img8);
		btnRegresar.setSize(53, 42);
		btnRegresar.setLocation(400, 243);
		Image esc8 = img8.getImage().getScaledInstance(btnRegresar.getWidth(), btnRegresar.getHeight(),
				Image.SCALE_SMOOTH);
		Icon ices8 = new ImageIcon(esc8);
		btnRegresar.setIcon(ices8);
		Jugadores.add(btnRegresar);
		panelActual = Menu;

		/// NIVEL 1 Y 2
		// Creamos un panel y añadimos a kirby ademas una prueba para las colisiones
		ImageIcon imgKirbyBase = new ImageIcon("kirbyStand.gif");
		ImageIcon imgKirbyBaseLeft = new ImageIcon("kirbyStandLeft.gif");
		ImageIcon imgKirbyWalkRight = new ImageIcon("kirbyWalk.gif");
		ImageIcon imgKirbyWalkLeft = new ImageIcon("kirbyWalkLeft.gif");
		ImageIcon imgKirbyFly = new ImageIcon("kirbyFly.gif");
		ImageIcon imgKirbyFlyLeft = new ImageIcon("kirbyFlyLeft.gif");
		ImageIcon imgKirbyAbsorb = new ImageIcon("kirbyAbsorb.gif");
		ImageIcon imgKirbyAbsorbLeft = new ImageIcon("kirbyAbsorbLeft.gif");

		ImageIcon imgFondo1_1_1 = new ImageIcon("imgFondoNivel1.png");
		ImageIcon imgFondo1_1_2 = new ImageIcon("");
		ImageIcon imgFondo1_1_3 = new ImageIcon("");
		ImageIcon imgFondo1_1_4 = new ImageIcon("imgFondo1_1_4.png");
		ImageIcon imgFondo1_1_5 = new ImageIcon("imgFondo1_1_5.png");
		ImageIcon imgFondo1_1_6 = new ImageIcon("imgFondo1_1_6.png");
		ImageIcon imgFondo1_1_7 = new ImageIcon("imgFondo1_1_7.png");
		ImageIcon imgFondo2_1_1 = new ImageIcon("imgFondo2_1_1.png");
		ImageIcon imgFondo2_1_2 = new ImageIcon("imgFondo2_1_2.png");
		ImageIcon imgFondo2_1_3 = new ImageIcon("imgFondo2_1_3.png");
		ImageIcon imgFondo2_1_4 = new ImageIcon("imgFondo2_1_4.png");
		ImageIcon imgFondo2_1_5 = new ImageIcon("imgFondo2_1_5.png");
		ImageIcon imgFondo2_1_6 = new ImageIcon("imgFondo2_1_6.png");
		ImageIcon imgFondo2_1_7 = new ImageIcon("imgFondo2_1_7.png");
		ImageIcon imgFondo2_1_8 = new ImageIcon("imgFondo2_1_8.png");
		ImageIcon imgFondo2_1_9 = new ImageIcon("imgFondo2_1_9.png");
		ImageIcon piso1 = new ImageIcon("piso1.png");
		ImageIcon piso2 = new ImageIcon("piso2.png");
		ImageIcon imgAire = new ImageIcon("Aire.gif");
		ImageIcon imgAireIzq = new ImageIcon("AireIzq.gif");
		ImageIcon imgBloqueEstrella = new ImageIcon("bloqueEstrella.png");
		ImageIcon imgItemGalleta = new ImageIcon("imgItemGalleta.png");
		ImageIcon imgFinish = new ImageIcon("Finish.gif");

		JPanel Nivel1 = new JPanelPersonalizado("Nivel1");
		JPanel Hudkirby = new JPanelPersonalizado("Hudkirby");
		JLayeredPane capas = new JLayeredPane();
		frame.getContentPane().add(capas);
		capas.setBounds(capas.getX(),capas.getY()-50,capas.getWidth(),capas.getHeight());
		capas.add(Hudkirby, JLayeredPane.DEFAULT_LAYER);
		JLabel estadosLado = new JLabel("kirbyLado" + kirbyLado);
		estadosLado.setBounds(40, 40, 150, 150);
		JLabel estadosEstomago = new JLabel("estomago:" + estomagoKirby);
		estadosEstomago.setBounds(40, 60, 150, 150);
		JLabel estadosColisionH = new JLabel("kirbyColisionH" + kirbyColisionH);
		estadosColisionH.setBounds(40, 80, 150, 150);
		JLabel estadosColisionV = new JLabel("kirbyColisionV" + kirbyColisionV);
		estadosColisionV.setBounds(40, 120, 150, 150);
		JLabel estadosNivelParte = new JLabel("NivelParte" + nivelParte);
		estadosNivelParte.setBounds(40, 50, 150, 150);

		Entidad EntKirby = new Entidad(imgKirbyBase, 22, 22, 65, 60);

//		 FONDO DE IMAGEN 2_1_9 PNG POR 530 X 433

		Entidad prueba = new Entidad(piso1, 0, 290, 300, 12);
		prueba.transformarWall();
		Entidad prueba2 = new Entidad(piso1, 0, 0, 10, 622);
		prueba2.transformarWall();
		Entidad prueba3 = new Entidad(piso1, 480, 120, 70, 162);
		prueba3.transformarWall();
		Entidad prueba4 = new Entidad(piso1, 320, 260, 280, 82);
		prueba4.transformarWall();
		Entidad prueba5 = new Entidad(piso1, 0 + 500, 255, 300, 22);
		prueba5.transformarWall();
		Entidad prueba6 = new Entidad(piso1, 310 + 460,20+ 285, 270, 24);
		prueba6.transformarWall();
		Entidad prueba7 = new Entidad(piso1, 480 + 460,20+ 240, 50, 32);
		prueba7.transformarWall();
		Entidad prueba8 = new Entidad(piso2, 520 + 460,20+ 190, 40, 42);
		prueba8.transformarWall();
		Entidad prueba9 = new Entidad(piso1, 0 + 500 + 480, 205, 50, 322);
		prueba9.transformarWall();
		Entidad prueba10 = new Entidad(piso1, 130 + 500 + 480 + 20, 210, 230, 324);
		prueba10.transformarWall();

		Entidad puerta1 = new Entidad(imgFinish, 1170, 128, 60, 70);
//		puerta1.transformarWall();
		puerta1.setVisible(true);
		Nivel1.add(puerta1);
		
		
		/////ENEMIGOS DEL ROOM 1 AL 3
		EntidadEnemigo escoba = new EntidadEnemigo(piso1, 279, 53, 50, 50);
		escoba.tipo="Escoba";
		escoba.gravitar();
		Nivel1.add(escoba);
		
		EntidadEnemigo pajarito = new EntidadEnemigo(piso1, 100, 53, 350, 50);
		pajarito.tipo="Twizzy";
		pajarito.gravitar();
		Nivel1.add(pajarito);
		

		EntidadEnemigo Brunto = new EntidadEnemigo(piso1, 0, 53, 50, 50);
		Brunto.tipo="Brunto";
		Brunto.gravitar();
		Nivel1.add(Brunto);
		
	
		EntidadEnemigo Cappy = new EntidadEnemigo(piso1, 100, 53, 50, 50);
		Cappy.tipo="Cappy";
		Cappy.gravitar();
		Nivel1.add(Cappy);
		
		
		

		
		
		
		
		
		
		
		
		
		///// SON 3 BLOQUE PARA ESTE ROOM
		Entidad Walls[] = new Entidad[10];
		Walls[0] = prueba;
		Walls[1] = prueba2;
		Walls[2] = prueba3;
		Walls[3] = prueba4;
		Walls[4] = prueba5;
		Walls[5] = prueba6;
		Walls[6] = prueba7;
		Walls[7] = prueba8;
		Walls[8] = prueba9;
		Walls[9] = prueba10;
//		Walls[10] = prueba11;
//		Walls[11] = prueba12;
//		Walls[12] = prueba13;
//		Walls[13]=prueba14;

		for (int a = 0; a < Walls.length; a++) {
			Nivel1.add(Walls[a]);
			Walls[a].setLocation(Walls[a].getX()-50, Walls[a].getY());
//			Walls[a].setOpaque(false);
		}
		
		/////////FONDO 4 Y 5
		Entidad pruebaLV2_ = new Entidad(piso1,0,280,322,32);
		pruebaLV2_. transformarWall();
		Entidad pruebaLV2_2 = new Entidad(piso1,300,280,422,32);
		pruebaLV2_2. transformarWall();
		 Entidad pruebaLV2_3 = new Entidad(piso1,720,200,122,32);
		pruebaLV2_3. transformarWall();
		 Entidad pruebaLV2_4 = new Entidad(piso1,720,220,24,152);
		pruebaLV2_4. transformarWall();
		Entidad pruebaLV2_5 = new Entidad(piso1, 50+862, 280, 152, 32);
		pruebaLV2_5.transformarWall();
		Entidad pruebaLV2_6 = new Entidad(piso1, 420+862, 210, 282, 22);
		pruebaLV2_6.transformarWall();
		Entidad pruebaLV2_7 = new Entidad(piso1, 180+862, 160, 50, 132);
		pruebaLV2_7.transformarWall();
		Entidad pruebaLV2_8 = new Entidad(piso1, 10+862, 160, 50, 132);
		pruebaLV2_8.transformarWall();
		Entidad pruebaLV2_9 = new Entidad(piso1, 200+862, 245, 150, 22);
		pruebaLV2_9.transformarWall();
		Entidad pruebaLV2_10 = new Entidad(piso1, 330+862, 243, 50, 22);
		pruebaLV2_10.transformarWall();
		Entidad pruebaLV2_11 = new Entidad(piso1, 380+862, 235, 80, 22);
		pruebaLV2_11.transformarWall();
		Entidad pruebaLV2_12 = new Entidad(piso2, 650+862, 110, 52, 122);
		pruebaLV2_12.transformarWall();
		Entidad Walls2[] = new Entidad[12];
		Walls2[0]=pruebaLV2_;
		Walls2[1]=pruebaLV2_2;
		Walls2[2]=pruebaLV2_3;
		Walls2[3]=pruebaLV2_4;
		Walls2[4]=pruebaLV2_5;
		Walls2[5]=pruebaLV2_6;
		Walls2[6]=pruebaLV2_7;
		Walls2[7]=pruebaLV2_8;
		Walls2[8]=pruebaLV2_9;
		Walls2[9]=pruebaLV2_10;
		Walls2[10]=pruebaLV2_11;
		Walls2[11]=pruebaLV2_12;
		
		
		EntidadEnemigo pajarito1 = new EntidadEnemigo(piso1, 100, 53, 350, 50);
		pajarito1.tipo="Twizzy";
		pajarito1.gravitar();
		Nivel1.add(pajarito1);
		
	
		for (int a = 0; a < Walls2.length; a++) {
//			Walls2[a].setLocation(Walls[a].getX()-50, Walls[a].getY());
			Walls2[a].transformarWall();
			Walls2[a].setOpaque(true);
			
		}	
		
		//////FONDO 6
			Entidad pruebaLV3_ = new Entidad(piso1,0,280,322,32);
			pruebaLV3_. transformarWall();
			Entidad pruebaLV3_2 = new Entidad(piso1,300,280,422,32);
			pruebaLV3_2. transformarWall();
			 Entidad pruebaLV3_3 = new Entidad(piso1,720,200,122,32);
			pruebaLV2_3. transformarWall();
			 Entidad pruebaLV3_4 = new Entidad(piso1,720,220,24,152);
			pruebaLV3_4. transformarWall();
			Entidad pruebaLV3_5 = new Entidad(piso1, 50+862, 280, 152, 32);
			pruebaLV2_5.transformarWall();
			Entidad pruebaLV3_6 = new Entidad(piso1, 420+862, 210, 282, 22);
			pruebaLV3_6.transformarWall();
			Entidad pruebaLV3_7 = new Entidad(piso1, 180+862, 160, 50, 132);
			pruebaLV3_7.transformarWall();
			Entidad pruebaLV3_8 = new Entidad(piso1, 10+862, 160, 50, 132);
			pruebaLV3_8.transformarWall();
			Entidad pruebaLV3_9 = new Entidad(piso1, 200+862, 245, 150, 22);
			pruebaLV3_9.transformarWall();
			Entidad pruebaLV3_10 = new Entidad(piso1, 330+862, 243, 50, 22);
			pruebaLV3_10.transformarWall();
			Entidad pruebaLV3_11 = new Entidad(piso1, 380+862, 235, 80, 22);
			pruebaLV3_11.transformarWall();
			Entidad pruebaLV3_12 = new Entidad(piso2, 650+862, 110, 52, 122);
			pruebaLV3_12.transformarWall();
			Entidad Walls3[] = new Entidad[12];
			Walls3[0]=pruebaLV3_;
			Walls3[1]=pruebaLV3_2;
			Walls3[2]=pruebaLV3_3;
			Walls3[3]=pruebaLV3_4;
			Walls3[4]=pruebaLV3_5;
			Walls3[5]=pruebaLV3_6;
			Walls3[6]=pruebaLV3_7;
			Walls3[7]=pruebaLV3_8;
			Walls3[8]=pruebaLV3_9;
			Walls3[9]=pruebaLV3_10;
			Walls3[10]=pruebaLV3_11;
			Walls3[11]=pruebaLV3_12;
			
			
			for (int a = 0; a < Walls3.length; a++) {
//				Walls2[a].setLocation(Walls[a].getX()-50, Walls[a].getY());
				Walls3[a].transformarWall();
				Walls3[a].setOpaque(true);	
			}
				//////FONDO 7
					Entidad pruebaLV4_ = new Entidad(piso1,0,280,322,32);
					pruebaLV4_. transformarWall();
					Entidad pruebaLV4_2 = new Entidad(piso1,300,280,422,32);
					pruebaLV4_2. transformarWall();
					 Entidad pruebaLV4_3 = new Entidad(piso1,720,200,122,32);
					pruebaLV4_3. transformarWall();
					 Entidad pruebaLV4_4 = new Entidad(piso1,720,220,24,152);
					pruebaLV4_4. transformarWall();
					Entidad pruebaLV4_5 = new Entidad(piso1, 50+862, 280, 152, 32);
					pruebaLV4_5.transformarWall();
					Entidad pruebaLV4_6 = new Entidad(piso1, 420+862, 210, 282, 22);
					pruebaLV4_6.transformarWall();
					Entidad pruebaLV4_7 = new Entidad(piso1, 180+862, 160, 50, 132);
					pruebaLV4_7.transformarWall();
					Entidad pruebaLV4_8 = new Entidad(piso1, 10+862, 160, 50, 132);
					pruebaLV4_8.transformarWall();
					Entidad pruebaLV4_9 = new Entidad(piso1, 200+862, 245, 150, 22);
					pruebaLV4_9.transformarWall();
					Entidad pruebaLV4_10 = new Entidad(piso1, 330+862, 243, 50, 22);
					pruebaLV4_10.transformarWall();
					Entidad pruebaLV4_11 = new Entidad(piso1, 380+862, 235, 80, 22);
					pruebaLV4_11.transformarWall();
					Entidad pruebaLV4_12 = new Entidad(piso2, 650+862, 110, 52, 122);
					pruebaLV4_12.transformarWall();
					Entidad Walls4[] = new Entidad[12];
					Walls4[0]=pruebaLV4_;
					Walls4[1]=pruebaLV4_2;
					Walls4[2]=pruebaLV4_3;
					Walls4[3]=pruebaLV4_4;
					Walls4[4]=pruebaLV4_5;
					Walls4[5]=pruebaLV4_6;
					Walls4[6]=pruebaLV4_7;
					Walls4[7]=pruebaLV4_8;
					Walls4[8]=pruebaLV4_9;
					Walls4[9]=pruebaLV4_10;
					Walls4[10]=pruebaLV4_11;
					Walls4[11]=pruebaLV4_12;
					
					
					for (int a = 0; a < Walls4.length; a++) {
//						Walls2[a].setLocation(Walls[a].getX()-50, Walls[a].getY());
						Walls4[a].transformarWall();
						Walls4[a].setOpaque(true);	
					}
	
			
		
		Entidad bloqueEstrella = new Entidad(imgBloqueEstrella, 180, 180, 75, 65);

		///// ESTO ES PARA QUE NO SE VEA LOS BLOQUES ROJOS Y VERDES

		Entidad transicionDerecha = new Entidad(piso1, 562, 40, 64, 352);
		transicionDerecha.transformarWall();
		transicionDerecha.setBackground(Color.red);
//		 Nivel1.add(transicionDerecha);
		Entidad transicionIzquierda = new Entidad(piso1, -66, 40, 64, 352);
		transicionIzquierda.transformarWall();
		transicionIzquierda.setBackground(Color.green);
//		 Nivel1.add(transicionIzquierda);

		///// IMAGENES DEL NIVEL 1 Y 2
		Entidad fondo = new Entidad(imgFondo1_1_1, 0, 0, 1563, 400);
		Entidad fondo2 = new Entidad(imgFondo1_1_2, 542, 0, 563, 371);
		Entidad fondo3 = new Entidad(imgFondo1_1_3, 542 + 542, 0, 563, 371);
		Entidad fondo4 = new Entidad(imgFondo1_1_4, 0, 0, 863, 371);
		Entidad fondo5 = new Entidad(imgFondo1_1_5, 0, 0, 744, 371);
		Entidad fondo6 = new Entidad(imgFondo1_1_6, 0, 0, 680, 974);
		Entidad fondo7 = new Entidad(imgFondo1_1_7, 0, 0, 352, 974);
		Entidad fondo8 = new Entidad(imgFondo2_1_1, 0, 0, 927, 900);
		Entidad fondo9 = new Entidad(imgFondo2_1_2, 0, 0, 927, 774);
		Entidad fondo10 = new Entidad(imgFondo2_1_3, 0, 0, 850, 351);
		Entidad fondo11 = new Entidad(imgFondo2_1_4, 0, 0, 850, 307);
		Entidad fondo12 = new Entidad(imgFondo2_1_5, 0, 0, 280, 900);
		Entidad fondo13 = new Entidad(imgFondo2_1_6, 0, 0, 500, 622);
		Entidad fondo14 = new Entidad(imgFondo2_1_7, 0, 0, 500, 447);
		Entidad fondo15 = new Entidad(imgFondo2_1_8, 0, 0, 500, 418);
		Entidad fondo16 = new Entidad(imgFondo2_1_9, 0, 0, 530, 433);

		Entidad aireProy = new Entidad(imgAire, -202, -220, 50, 30);
		Entidad aireProyIzq = new Entidad(imgAireIzq, -202, -220, 50, 30);

		Entidad itemGalleta = new Entidad(imgItemGalleta, EntKirby.getX() + 30, EntKirby.getY() - 50, 40, 40);
		itemGalleta.gravitar();
		
		Entidad items[] = new Entidad[3];
		items[0] = new Entidad(imgItemGalleta, EntKirby.getX() + 30, EntKirby.getY() - 50, 40, 40);
		items[1] = new Entidad(imgItemGalleta, EntKirby.getX() + 60, EntKirby.getY() - 50, 40, 40);
		items[2] = new Entidad(imgItemGalleta, EntKirby.getX() + 80, EntKirby.getY() - 50, 40, 40);
		for (int a = 0; a < items.length; a++) {
			items[a].gravitar();
			Nivel1.add(items[a]);
		}
		Entidad kirbyCam=new Entidad(EntKirby);
		kirbyCam.setVisible(false);
		frame.add(kirbyCam);
		Nivel1.add(aireProy);
		Nivel1.add(aireProyIzq);

		Nivel1.add(bloqueEstrella);

		Nivel1.add(estadosColisionH);
		Nivel1.add(estadosColisionV);
		Nivel1.add(estadosLado);
		Nivel1.add(estadosNivelParte);
		Nivel1.add(estadosEstomago);
		Nivel1.add(EntKirby);
//		Nivel1.add(itemGalleta);
		///// ESTO PARA QUE AGARRE EL FONDO 2_1_9
		Nivel1.add(fondo);
		Nivel1.add(fondo2);
		Nivel1.add(fondo3);
//		Nivel1.add(fondo4);		
//		Nivel1.add(fondo5);
//		Nivel1.add(fondo6);
//		Nivel1.add(fondo7);
//		Nivel1.add(fondo8);
//  	Nivel1.add(fondo9);
//		Nivel1.add(fondo10);
//		Nivel1.add(fondo11);
//		Nivel1.add(fondo12);
//		Nivel1.add(fondo13);
//		Nivel1.add(fondo14);
//		Nivel1.add(fondo15);
//		Nivel1.add(fondo16);

		// En este panel navegamos por el menu de guardado
		kirb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Partidas);
				frame.repaint();
				frame.add(Jugadores);
				frame.repaint();
			}
		});
		kirb2.addActionListener(kirb1.getActionListeners()[0]);
		kirb3.addActionListener(kirb1.getActionListeners()[0]);
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Jugadores);
				frame.repaint();
				frame.add(Partidas);
				frame.repaint();
			}
		});
		im6.addActionListener(new ActionListener() {
			@Override
			///// PARA EL FONDO 2_1_9
			public void actionPerformed(ActionEvent e) {
				frame.remove(Jugadores);
				frame.repaint();
				frame.add(Nivel1, BorderLayout.CENTER);
				frame.add(Hudkirby, BorderLayout.PAGE_END);
				frame.setBounds(100, 100, 563, 495);
				ReproducirSonido("Gourmet-Race-Kirby.wav");
				frame.repaint();
			}
		});

		im7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Jugadores);
				frame.repaint();
				frame.add(Nivel1);
//				ReproducirSonido("Gourmet-Race-Kirby.wav");
				frame.setBounds(100, 100, 255, 371);
				frame.repaint();
			}
		});
		kirb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Partidas);
				frame.repaint();
				frame.add(Jugadores);
				frame.repaint();
			}
		});
		kirb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Partidas);
				frame.repaint();
				frame.add(Jugadores);
				frame.repaint();
			}
		});
		frame.setFocusable(true);

		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			// W
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (panelActual == Inicio) {
//					System.out.println(e.getKeyCode()+""+e.getKeyChar());
					if (e.getKeyCode() == 10) {
						frame.remove(Inicio);
						frame.repaint();
						frame.add(Partidas);
					}
				}
				if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {// W
					arriba = true;
				}
				if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {// A
					izquierda = true;
				}
				if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {// S
				}
				if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {// D
					derecha = true;
				}
				if (e.getKeyCode() == 75) {
					k = true;
				}
				if (e.getKeyCode() == 74) {
					j = true;
				}
				if (e.getKeyCode() == 80) {
					p = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {// W
					for (int a = 0; a < 9; a++) {
						kirbyY -= 1;
						arriba = false;
					}
				}
				if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {// A
					izquierda = false;
				}
				if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {// S
				}
				if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {// D
					derecha = false;
				}
				if (e.getKeyCode() == 75) {//
					k = false;
				}
				if (e.getKeyCode() == 74) {
					j = false;
				}
				if (e.getKeyCode() == 80) {
					p = false;
				}
			}
		});
		Timer timerTicks = new Timer();
		TimerTask repintar = new TimerTask() {
			@Override
			public void run() {
				if(p==true) {System.out.println("kirbyX:  " + EntKirby.getX()+"kirbyY:  " + EntKirby.getY());}
				if(puerta1.colision(EntKirby)==true && arriba==true) {Nivel1.removeAll();
				nivel=2;
//				EntKirby.setLocation(50, 50);
				kirbyX=50;
				kirbyY=-150;
				fondo5.setBounds(fondo4.getWidth(), 0,fondo5.getWidth(),fondo5.getHeight());
				
				for (int a = 0; a < Walls2.length; a++) {
					Nivel1.add(Walls2[a]);}
				Nivel1.add(EntKirby);
				Nivel1.add(fondo4);
				Nivel1.add(fondo5);
				}
				
			
					
		
			
//				escoba.setHFlag(false);escoba.setVFlag(false);

				
				boolean kirbyColisionHFlag = false;
				boolean kirbyColisionVFlag = false;
				boolean bloqueHFlag = false;
				boolean bloqueVFlag = false;

				estadosLado.setText("kirbyLado" + kirbyLado);
				estadosColisionH.setText("kirbyColisionH" + kirbyColisionH);
				estadosColisionV.setText("kirbyColisionV" + kirbyColisionV);
				estadosNivelParte.setText("NivelParte" + nivelParte);
				estadosEstomago.setText("estomago:" + estomagoKirby);
				// Reacomodar el label de kirby(entidad)
				EntKirby.setBounds(kirbyX, kirbyY, EntKirby.getWidth(), EntKirby.getHeight());
				// dependiendo del estado lado, se modifica la variable hsp de la entidad kirby
				if (derecha == true) {
					kirbyLado = "derecha";
					EntKirby.setHsp(EntKirby.getHspWalk());
				}
				if (izquierda == true) {
					kirbyLado = "izquierda";
					EntKirby.setHsp(EntKirby.getHspWalk() * (-1));
				}
				// salto
				if (j == true && coolDownSalto == 0) {
					EntKirby.setVsp(EntKirby.vspJump);
					coolDownSalto = 4;
					estomagoKirby = "aire";
				}
					// bajar el label de kirby sumandole la gravedad
					if (juegoPlay == true) {
						EntKirby.setVsp(EntKirby.getVsp() + EntKirby.getGravedad());
					}

				for (int a = 0; a < Walls.length; a++) {
					if (aireProy.colision(Walls[a])) {
						aireShootR = false;
						aireProy.setLocation(-200, -200);
					}

				}
				
				
				for (int a =0;a<items.length;a++) 
				{
					if(items[a].colision(EntKirby)) 
					{
						items[a].setBounds(-3,-3, 0, 0);
					}
				}
				
				if(nivel==1)
				{
						for (int a = 0; a < Walls.length; a++) {
							if (aireProyIzq.colision(Walls[a])) {
								aireShootL = false;
								aireProyIzq.setLocation(-200, -200);
							}
		
							if (new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
									EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls[a])
									|| new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
											EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
								kirbyColisionHFlag = true;
							}
							if (new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
									EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls[a])
									|| new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
											EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
								kirbyColisionVFlag = true;
							}
							///////ENEMIGOS EN EL ROOM
		
							if (new Entidad(piso1, escoba.getX() + escoba.getHsp(),
									escoba.getY(), escoba.getWidth(), escoba.getHeight())
									.colision(Walls[a])) {
								escoba.setHFlag(true);
								escoba.cambiarLado();
							}else {escoba.setVFlag(false);}
							if (new Entidad(piso1, escoba.getX(),
									escoba.getY() + escoba.getVsp(), escoba.getWidth(),
									escoba.getHeight()).colision(Walls[a])) {
								escoba.setVFlag(true);
								escoba.setLocation(escoba.getX(), escoba.getY()-escoba.getHsp());
							}else {escoba.setVFlag(false);}
							
							if (new Entidad(piso1, pajarito.getX() + pajarito.getHsp(),
									pajarito.getY(), pajarito.getWidth(), pajarito.getHeight())
									.colision(Walls[a])) {
								pajarito.setHFlag(true);
								pajarito.cambiarLado();
							}else {pajarito.setVFlag(false);}
							if (new Entidad(piso1, pajarito.getX(),
									pajarito.getY() + pajarito.getVsp(), pajarito.getWidth(),
									pajarito.getHeight()).colision(Walls[a])) {
								pajarito.setVFlag(true);
								pajarito.setLocation(pajarito.getX(), pajarito.getY()-pajarito.getHsp());
							}else {pajarito.setVFlag(false);}
							
							
							if (new Entidad(piso1, Brunto.getX() + Brunto.getHsp(),
									Brunto.getY(), Brunto.getWidth(), Brunto.getHeight())
									.colision(Walls[a])) {
								Brunto.setHFlag(true);
								Brunto.cambiarLado();
							}else {Brunto.setVFlag(false);}
							if (new Entidad(piso1, Brunto.getX(),
									Brunto.getY() + Brunto.getVsp(), Brunto.getWidth(),
									Brunto.getHeight()).colision(Walls[a])) {
								Brunto.setVFlag(true);
								Brunto.setLocation(Brunto.getX(), Brunto.getY()-Brunto.getHsp());
							}else {Brunto.setVFlag(false);}
							
							
							if (new Entidad(piso1, Cappy.getX() + Cappy.getHsp(),
									Cappy.getY(), Cappy.getWidth(), Cappy.getHeight())
									.colision(Walls[a])) {
								Cappy.setHFlag(true);
								Cappy.cambiarLado();
							}else {Cappy.setVFlag(false);}
							if (new Entidad(piso1, Cappy.getX(),
									Cappy.getY() + Cappy.getVsp(), Cappy.getWidth(),
									Cappy.getHeight()).colision(Walls[a])) {
								Cappy.setVFlag(true);
								Cappy.setLocation(Cappy.getX(), Cappy.getY()-Cappy.getHsp());
							}else {Cappy.setVFlag(false);}
		
							
							
							
							if (new Entidad(piso1, pajarito1.getX() + pajarito1.getHsp(),
									pajarito1.getY(), pajarito1.getWidth(), pajarito1.getHeight())
									.colision(Walls2[a])) {
								pajarito1.setHFlag(true);
								pajarito1.cambiarLado();
							}else {pajarito1.setVFlag(false);}
							if (new Entidad(piso1, pajarito1.getX(),
									pajarito1.getY() + pajarito1.getVsp(), pajarito1.getWidth(),
									pajarito1.getHeight()).colision(Walls2[a])) {
								pajarito1.setVFlag(true);
								pajarito1.setLocation(pajarito1.getX(), pajarito1.getY()-pajarito1.getHsp());
							}else {pajarito1.setVFlag(false);}
							
						
						
					
							
							
							for (int a1 = 0; a1 < items.length; a1++) {
								if (new Entidad(items[a1].getIcon(), items[a1].getX() + items[a1].getHsp(), items[a1].getY(),
										items[a1].getWidth(), items[a1].getHeight()).colision(Walls[a])) {
									items[a1].setHFlag(true);
								}
								if (new Entidad(items[a1].getIcon(), items[a1].getX(), items[a1].getY() + items[a1].getVsp(),
										items[a1].getWidth(), items[a1].getHeight()).colision(Walls[a])) {
									items[a1].setVFlag(true);
								}
							}
		
						}
			}
				
				//nivel2
				if(nivel==2)
				{
						for (int a = 0; a < Walls2.length; a++) {
							if (aireProyIzq.colision(Walls2[a])) {
								aireShootL = false;
								aireProyIzq.setLocation(-200, -200);
							}
		
							if (new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
									EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls2[a])
									|| new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
											EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
								kirbyColisionHFlag = true;
							}
							if (new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
									EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls2[a])
									|| new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
											EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
								kirbyColisionVFlag = true;
							}
							
							
					
						
							
							

							//nivel3
							if(nivel==3)
							{
									for (int a1 = 0; a1 < Walls3.length; a1++) {
										if (aireProyIzq.colision(Walls3[a1])) {
											aireShootL = false;
											aireProyIzq.setLocation(-200, -200);
										}
					
										if (new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
												EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls3[a1])
												|| new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
														EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
											kirbyColisionHFlag = true;
										}
										if (new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
												EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls3[a1])
												|| new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
														EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
											kirbyColisionVFlag = true;
										}
										
									}
									
							}
							
							
							//nivel4 Y CONTRA EL JEFE FINAL
							if(nivel==4)
							{
									for (int a2 = 0; a2 < Walls4.length; a2++) {
										if (aireProyIzq.colision(Walls3[a2])) {
											aireShootL = false;
											aireProyIzq.setLocation(-200, -200);
										}
					
										if (new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
												EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls3[a2])
												|| new Entidad(imgKirbyBase, EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY(),
														EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
											kirbyColisionHFlag = true;
										}
										if (new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
												EntKirby.getWidth(), EntKirby.getHeight()).colision(Walls3[a2])
												|| new Entidad(imgKirbyBase, EntKirby.getX(), EntKirby.getY() + EntKirby.getVsp(),
														EntKirby.getWidth(), EntKirby.getHeight()).colision(bloqueEstrella)) {
											kirbyColisionVFlag = true;
										}
										
									}
									
							}
							
							
		
							///////ENEMIGOS EN EL ROOM
		
//							if (new Entidad(piso1, escoba.getX() + escoba.getHsp(),
//									escoba.getY(), escoba.getWidth(), escoba.getHeight())
//									.colision(Walls2[a])) {
//								escoba.setHFlag(true);
//								escoba.cambiarLado();
//							}else {escoba.setVFlag(false);}
//							if (new Entidad(piso1, escoba.getX(),
//									escoba.getY() + escoba.getVsp(), escoba.getWidth(),
//									escoba.getHeight()).colision(Walls2[a])) {
//								escoba.setVFlag(true);
//								escoba.setLocation(escoba.getX(), escoba.getY()-escoba.getHsp());
//							}else {escoba.setVFlag(false);}
//							
//							if (new Entidad(piso1, pajarito.getX() + pajarito.getHsp(),
//									pajarito.getY(), pajarito.getWidth(), pajarito.getHeight())
//									.colision(Walls2[a])) {
//								pajarito.setHFlag(true);
//								pajarito.cambiarLado();
//							}else {pajarito.setVFlag(false);}
//							if (new Entidad(piso1, pajarito.getX(),
//									pajarito.getY() + pajarito.getVsp(), pajarito.getWidth(),
//									pajarito.getHeight()).colision(Walls2[a])) {
//								pajarito.setVFlag(true);
//								pajarito.setLocation(pajarito.getX(), pajarito.getY()-pajarito.getHsp());
//							}else {pajarito.setVFlag(false);}
//							
							
//							if (new Entidad(piso1, Brunto.getX() + Brunto.getHsp(),
//									Brunto.getY(), Brunto.getWidth(), Brunto.getHeight())
//									.colision(Walls2[a])) {
//								Brunto.setHFlag(true);
//								Brunto.cambiarLado();
//							}else {Brunto.setVFlag(false);}
//							if (new Entidad(piso1, Brunto.getX(),
//									Brunto.getY() + Brunto.getVsp(), Brunto.getWidth(),
//									Brunto.getHeight()).colision(Walls2[a])) {
//								Brunto.setVFlag(true);
//								Brunto.setLocation(Brunto.getX(), Brunto.getY()-Brunto.getHsp());
//							}else {Brunto.setVFlag(false);}
//							
//							
//							if (new Entidad(piso1, Cappy.getX() + Cappy.getHsp(),
//									Cappy.getY(), Cappy.getWidth(), Cappy.getHeight())
//									.colision(Walls2[a])) {
//								Cappy.setHFlag(true);
//								Cappy.cambiarLado();
//							}else {Cappy.setVFlag(false);}
//							if (new Entidad(piso1, Cappy.getX(),
//									Cappy.getY() + Cappy.getVsp(), Cappy.getWidth(),
//									Cappy.getHeight()).colision(Walls2[a])) {
//								Cappy.setVFlag(true);
//								Cappy.setLocation(Cappy.getX(), Cappy.getY()-Cappy.getHsp());
//							}else {Cappy.setVFlag(false);}
//		
//							for (int a1 = 0; a1 < items.length; a1++) {
//								if (new Entidad(items[a1].getIcon(), items[a1].getX() + items[a1].getHsp(), items[a1].getY(),
//										items[a1].getWidth(), items[a1].getHeight()).colision(Walls2[a])) {
//									items[a1].setHFlag(true);
//								}
//								if (new Entidad(items[a1].getIcon(), items[a1].getX(), items[a1].getY() + items[a1].getVsp(),
//										items[a1].getWidth(), items[a1].getHeight()).colision(Walls2[a])) {
//									items[a1].setVFlag(true);
//								}
//							}
		
						}
				}
				
				
				
				
				
				
				
				
				if (kirbyColisionHFlag == true) {
					kirbyColisionH = true;
				} else {
					kirbyColisionH = false;
				}
				if (kirbyColisionVFlag == true) {
					estomagoKirby = "vacio";
					kirbyColisionV = true;
				} else {
					kirbyColisionV = false;
				}
				if (bloqueHFlag == true) {
					bloqueH = true;
				} else {
					bloqueH = false;
				}
				if (bloqueVFlag == true) {
					bloqueV = true;
				} else {
					bloqueV = false;
				}

				if (estomagoKirby == "aire") {
					EntKirby.setGravedad(1);
					if (k == true) {
						if (kirbyLado == "derecha") {
							aireProy.setLocation(EntKirby.getX(), EntKirby.getY() - 5);
							aireShootR = true;
						} else if (kirbyLado == "izquierda") {
							aireProyIzq.setLocation(EntKirby.getX() - EntKirby.getWidth(), EntKirby.getY() - 5);
							aireShootL = true;
						}
						estomagoKirby = "vacio";
					}
				} else {
					EntKirby.setGravedad(3);
				}

				if (kirbyColisionH == true) {
					EntKirby.setHsp(0);
				}
				if (kirbyColisionH == false && juegoPlay == true) {
					kirbyX += EntKirby.getHsp();
				}
				if (kirbyColisionV == true) {
					EntKirby.setVsp(0);
				}
				if (kirbyColisionV == false && juegoPlay == true) {
					kirbyY += EntKirby.getVsp();
				}
				if (juegoPlay == false) {
					EntKirby.setHsp(0);
					EntKirby.setVsp(0);
				}
				if (bloqueH == true) {
					bloqueEstrella.setHsp(0);
				}
				if (bloqueV == true) {
					bloqueEstrella.setVsp(0);
				}
				if (bloqueH == false) {
					bloqueEstrella.setBounds(bloqueEstrella.getX() + bloqueEstrella.getHsp(), bloqueEstrella.getY(),
							bloqueEstrella.getWidth(), bloqueEstrella.getHeight());
				}
				if (bloqueV == false) {
					bloqueEstrella.setVsp(2);
					bloqueEstrella.setBounds(bloqueEstrella.getX(), bloqueEstrella.getY() + bloqueEstrella.getVsp(),
					bloqueEstrella.getWidth(), bloqueEstrella.getHeight());
				}
				
				if (aireShootR == true) {aireProy.setLocation(aireProy.getX() + 14, aireProy.getY());}
				if (aireShootL == true) {aireProyIzq.setLocation(aireProyIzq.getX() - 14, aireProyIzq.getY());}
				
				EntKirby.setBounds(EntKirby.getX() + EntKirby.getHsp(), EntKirby.getY() + EntKirby.getVsp(),
						EntKirby.getWidth(), EntKirby.getHeight());
				// ANIMACION
				// reestablecer la imagen dependiendo del estado del lado de kirby(el lado al
				// que esta volteando)

				
				
				///////////CAMARA
if(EntKirby.getX()-fondoContadorX>frame.getWidth()-EntKirby.getWidth() )
{
	Nivel1.setBounds(Nivel1.getX()-12, Nivel1.getY(), Nivel1.getWidth(), Nivel1.getHeight());
	fondoContadorX+=12;
}if(EntKirby.getX()-fondoContadorX<0+EntKirby.getWidth()-40 )
{
	Nivel1.setBounds(Nivel1.getX()+12, Nivel1.getY(), Nivel1.getWidth(), Nivel1.getHeight());
	fondoContadorX-=12;
}
///////////CAMARA
				
				
				
				if (kirbyLado == "derecha") {
					EntKirby.setIcon(imgKirbyWalkRight);
				}
				if (kirbyLado == "izquierda") {
					EntKirby.setIcon(imgKirbyWalkLeft);
				}
				// reestablecer el estado del lado de kirby(el lado al que esta volteando)
				if (kirbyLado == "derecha") {
					EntKirby.setIcon(imgKirbyWalkRight);
				}
				if (kirbyLado == "izquierda") {
					EntKirby.setIcon(imgKirbyWalkLeft);
				}
				if (EntKirby.getVsp() != 0) {
					if (kirbyLado == "derecha") {

						EntKirby.setIcon(imgKirbyFly);
					}
					if (kirbyLado == "izquierda") {
						EntKirby.setIcon(imgKirbyFlyLeft);
					}
				} else// (si esta quieto y en el piso)
				{
					if (k == true) {// absorcion derecha
						if (kirbyLado == "derecha") {

							EntKirby.setIcon(imgKirbyAbsorb);
							if (bloqueEstrella.getX() - EntKirby.getX() < 155
									&& bloqueEstrella.getX() > EntKirby.getX() + 30) {
								if (bloqueEstrella.colision(EntKirby)) {
									bloqueEstrella.setBounds(-500, -500, 0, 0);
								}
								bloqueEstrella.setHsp(bloqueEstrella.getHsp() - 4);
								bloqueEstrella.setBounds(bloqueEstrella.getX() + bloqueEstrella.getHsp(),
										bloqueEstrella.getY() + bloqueEstrella.getVsp(), bloqueEstrella.getWidth(),
										bloqueEstrella.getHeight());
							}

						} else if (kirbyLado == "izquierda") {
							EntKirby.setIcon(imgKirbyAbsorbLeft);
							if (bloqueEstrella.getX() - EntKirby.getX() > -155
									&& bloqueEstrella.getX() < EntKirby.getX() - 30) {
								if (bloqueEstrella.colision(EntKirby)) {
									bloqueEstrella.setBounds(-500, -500, 0, 0);
								}
								bloqueEstrella.setHsp(bloqueEstrella.getHsp() + 4);
								bloqueEstrella.setBounds(bloqueEstrella.getX() + bloqueEstrella.getHsp(),
										bloqueEstrella.getY() + bloqueEstrella.getVsp(), bloqueEstrella.getWidth(),
										bloqueEstrella.getHeight());
							}
						}
					} else {
						if (EntKirby.getHsp() == 0) {
							// absorcion izquierda
							if (kirbyLado == "derecha") {
								EntKirby.setIcon(imgKirbyBase);
							}
							if (kirbyLado == "izquierda") {
								EntKirby.setIcon(imgKirbyBaseLeft);
							}
						}
					}
					// ANIMACION
				}
				frame.repaint();
				frame.revalidate();
			}
		};
		timerTicks.schedule(repintar, 10, 30);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int tik = 0;

			@Override
			public void run() {
				if (tik == 0) {
					tik += 1;
				} else {
					frame.remove(Menu);
					frame.repaint();
					frame.add(Inicio);
					frame.repaint();
					panelActual = Inicio;
					timer.cancel();
				}
			}
		};
		timer.schedule(task, 10, 3000);
		Timer timerVariables = new Timer();
		TimerTask taskReducirVariables = new TimerTask() {
			@Override
			public void run() {
				// reducir las velocidades a cualquier direccion de kirby con una velocidad
				// menor a la que se repinta
				if (EntKirby.getHsp() > 0) {
					EntKirby.setHsp(EntKirby.getHsp() - 1);
				}
				if (EntKirby.getVsp() > 0) {
					EntKirby.setVsp(EntKirby.getVsp() - 1);
				}
				if (EntKirby.getHsp() < 0) {
					EntKirby.setHsp(EntKirby.getHsp() + 1);
				}
				if (EntKirby.getVsp() < 0) {
					EntKirby.setVsp(EntKirby.getVsp() + 1);
				}
				if (coolDownTransicion > 0) {
					coolDownTransicion--;
				}
				if (coolDownSalto > 0) {
					coolDownSalto--;
				}
			}
		};
		timerVariables.schedule(taskReducirVariables, 10, 70);

	}

	public void ReproducirSonido(String nombreSonido1) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File(nombreSonido1).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error al reproducir el sonido.");
		}
	}

////////// FONDOS MAS LO SBLOQUES VACIOS DE CADA ROOM DEL NIVEL 1

//	private int kirbyX = 50, kirbyY = 50;

/////// FONDO DE IMAGEN 1_1_7 PNG POR 352 X 973

//		Entidad prueba = new Entidad(piso1, 0, 900, 230, 22);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 30, 490, 60, 22);
//		prueba2.transformarWall();
//		Entidad prueba3 = new Entidad(piso1, 10, 290, 20, 222);
//		prueba3.transformarWall();
//		Entidad prueba4 = new Entidad(piso1, 0, 0, 30, 302);
//		prueba4.transformarWall();
//		Entidad prueba5 = new Entidad(piso1, 0, 105, 220, 22);
//		prueba5.transformarWall();
//		Entidad prueba6 = new Entidad(piso1, 290, 113, 50, 22);
//		prueba6.transformarWall();
//		Entidad prueba7 = new Entidad(piso1, 0, 280, 120, 22);
//		prueba7.transformarWall();
//		Entidad prueba8 = new Entidad(piso2,  210, 280, 180, 22);
//		prueba8.transformarWall();

///// SON 8 BLOQUES PARA ESTE ROOM
//		Entidad Walls[] = new Entidad[8];
//		Walls[0] = prueba;
//		Walls[1] = prueba2;
//		Walls[2] = prueba3;
//		Walls[3] = prueba4;
//		Walls[4] = prueba5;
//		Walls[5] = prueba6;
//		Walls[6] = prueba7;
//		Walls[7] = prueba8;
//	
//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 1_1_6
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 352, 974);
//			frame.repaint();

/////////////////////////////////////////////////////////////

////////FONDO DE IMAGEN 1_1_4 PNG POR 863 X 371

	/// POSESION DEL KIrBY DE ESTE ROOM
//	private int kirbyX = 50, kirbyY = 50;

//	Entidad prueba = new Entidad(piso1,0,280,322,32);
//	prueba. transformarWall();
//	Entidad prueba2 = new Entidad(piso1,300,280,422,32);
//	prueba2. transformarWall();
//	 Entidad prueba3 = new Entidad(piso1,720,200,122,32);
//	prueba3. transformarWall();
//	 Entidad prueba4 = new Entidad(piso1,720,220,24,152);
//	prueba4. transformarWall();
//	

	///// SON 4 BLOQUES PARA ESTE ROOM
//	Entidad Walls[] = new Entidad[4];
//	Walls[0] = prueba;
//	Walls[1] = prueba2;
//	Walls[2] = prueba3;
//	Walls[3] = prueba4;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 1_1_4
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 863, 371);
//			frame.repaint();
//		}
//	});

/////////////////////////////////////////////////////////////////////

///////FONDO DE IMAGEN 1_1_5 PNG POR 744 X 371

	/// POSESION DEL KIrBY DE ESTE ROOM
//	private int kirbyX = 10, kirbyY = 50;

//		Entidad prueba = new Entidad(piso1, 50, 280, 152, 32);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 420, 210, 282, 22);
//		prueba2.transformarWall();
//		Entidad prueba3 = new Entidad(piso1, 180, 160, 50, 132);
//		prueba3.transformarWall();
//		Entidad prueba4 = new Entidad(piso1, 10, 160, 50, 132);
//		prueba4.transformarWall();
//		Entidad prueba5 = new Entidad(piso1, 200, 245, 150, 22);
//		prueba5.transformarWall();
//		Entidad prueba6 = new Entidad(piso1, 330, 243, 50, 22);
//		prueba6.transformarWall();
//		Entidad prueba7 = new Entidad(piso1, 380, 235, 80, 22);
//		prueba7.transformarWall();
//		Entidad prueba8 = new Entidad(piso2, 650, 110, 52, 122);
//		prueba8.transformarWall();
//	

///// SON 8 BLOQUES PARA ESTE ROOM
//		Entidad Walls[] = new Entidad[8];
//		Walls[0] = prueba;
//		Walls[1] = prueba2;
//		Walls[2] = prueba3;
//		Walls[3] = prueba4;
//		Walls[4] = prueba5;
//		Walls[5] = prueba6;
//		Walls[6] = prueba7;
//		Walls[7] = prueba8;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 1_1_5
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 744, 371);
//			frame.repaint();
//		}
//	});
//	
///////////////////////////////////////////////////////////////////////////////////	

/////// FONDO DE IMAGEN 1_1_6 PNG POR 680 X 973

	/// POSESION DEL KIrBY DE ESTE ROOM
	// private int kirbyX = 270, kirbyY = 50;

//		Entidad prueba = new Entidad(piso1, 110, 820, 452, 32);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 410, 740, 140, 22);
//		prueba2.transformarWall();
//		Entidad prueba3 = new Entidad(piso1, 70, 690, 50, 132);
//		prueba3.transformarWall();
//		Entidad prueba4 = new Entidad(piso1, 550, 690, 50, 132);
//		prueba4.transformarWall();
//		Entidad prueba5 = new Entidad(piso1, 250, 645, 150, 22);
//		prueba5.transformarWall();
//		Entidad prueba6 = new Entidad(piso1, 260, 203, 150, 22);
//		prueba6.transformarWall();
//		Entidad prueba7 = new Entidad(piso1, 0, 585, 250, 22);
//		prueba7.transformarWall();
//		Entidad prueba8 = new Entidad(piso2, 260, 390, 220, 22);
//		prueba8.transformarWall();
//		Entidad prueba9 = new Entidad(piso1, 420, 300, 50, 12);
//		prueba9.transformarWall();
//		Entidad prueba10 = new Entidad(piso1, 220, 300, 50, 10);
//		prueba10.transformarWall();
//		prueba9.transformarWall();
//		Entidad prueba11 = new Entidad(piso1, 90, 350, 20, 152);
//		prueba11.transformarWall();
//		Entidad prueba12 = new Entidad(piso1, 500, 630, 50, 52);
//		prueba12.transformarWall();
//		Entidad prueba13 = new Entidad(piso1, 550, 430, 20, 222);
//		prueba13.transformarWall();
//	

///// SON 13 BLOQUES PARA ESTE ROOM
//		Entidad Walls[] = new Entidad[13];
//		Walls[0] = prueba;
//		Walls[1] = prueba2;
//		Walls[2] = prueba3;
//		Walls[3] = prueba4;
//		Walls[4] = prueba5;
//		Walls[5] = prueba6;
//		Walls[6] = prueba7;
//		Walls[7] = prueba8;
//		Walls[8] = prueba9;
//		Walls[9] = prueba10;
//		Walls[10] = prueba11;
//		Walls[11] = prueba12;
//		Walls[12] = prueba13;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 1_1_6
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 680, 973);
//			frame.repaint();
//		}
//	});

//////////////////////////////////////////////////////////////////////////////////////

	/// POSESION DE KIRBY EN ESTE ROOM
//	private int kirbyX = 50, kirbyY = 50;

	/////// FONDO DE IMAGEN 2_1_1 PNG POR 927 X 900
//
//		Entidad prueba = new Entidad(piso1, 600, 130, 310, 22);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 250, 160, 60, 722);
//		prueba2.transformarWall();
//		Entidad prueba3 = new Entidad(piso1, 300, 400, 150, 22);
//		prueba3.transformarWall();
//		Entidad prueba4 = new Entidad(piso1, 300, 520, 150, 22);
//		prueba4.transformarWall();
//		Entidad prueba5 = new Entidad(piso1, 0, 135, 320, 22);
//		prueba5.transformarWall();
//		Entidad prueba6 = new Entidad(piso1, 300, 633, 150, 22);
//		prueba6.transformarWall();
//		Entidad prueba7 = new Entidad(piso1, 300, 750, 150, 22);
//		prueba7.transformarWall();
//		Entidad prueba8 = new Entidad(piso2, 300, 280, 150, 22);
//		prueba8.transformarWall();
//		Entidad prueba9 = new Entidad(piso1, 580, 160, 50, 802);
//		prueba9.transformarWall();

	///// SON 9 BLOQUES PARA ESTE ROOM
//	Entidad Walls[] = new Entidad[9];
//	Walls[0] = prueba;
//	Walls[1] = prueba2;
//	Walls[2] = prueba3;
//	Walls[3] = prueba4;
//	Walls[4] = prueba5;
//	Walls[5] = prueba6;
//	Walls[6] = prueba7;
//	Walls[7] = prueba8;
//	Walls[8] = prueba9;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_1
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 927, 900);
//			frame.repaint();
//		}
//	});

///////////////////////////////////////////////////////////////////////////////////////////////////////

	/// POSESION DE KIRBY EN ESTE ROOM
//	private int kirbyX = 50, kirbyY = 50;

	/////// FONDO DE IMAGEN 2_1_2 PNG POR 927 X 777

//	Entidad prueba = new Entidad(piso1, 50, 220, 90, 12);
//	prueba.transformarWall();
//	Entidad prueba2 = new Entidad(piso1, 620, 210, 230, 22);
//	prueba2.transformarWall();
//	Entidad prueba3 = new Entidad(piso1, 140, 450, 290, 22);
//	prueba3.transformarWall();
//	Entidad prueba4 = new Entidad(piso1, 420, 230, 110, 12);
//	prueba4.transformarWall();
//	Entidad prueba5 = new Entidad(piso1, 370, 80, 200, 22);
//	prueba5.transformarWall();
//	Entidad prueba6 = new Entidad(piso1, 500, 453, 152, 22);
//	prueba6.transformarWall();
//	Entidad prueba7 = new Entidad(piso1, 270, 40, 50, 330);
//	prueba7.transformarWall();
//	Entidad prueba8 = new Entidad(piso2, 140, 0, 50, 122);
//	prueba8.transformarWall();
//	Entidad prueba9 = new Entidad(piso1, 570, 550, 320, 12);
//	prueba9.transformarWall();
//	Entidad prueba10 = new Entidad(piso1, 840, 40, 20, 160);
//	prueba10.transformarWall();
//	prueba9.transformarWall();
//	Entidad prueba11 = new Entidad(piso1, 50, 490, 90, 22);
//	prueba11.transformarWall();
//	Entidad prueba12 = new Entidad(piso1, 170, 250, 10, 152);
//	prueba12.transformarWall();

	///// SON 12 BLOQUES PARA ESTE ROOM
//	Entidad Walls[] = new Entidad[12];
//	Walls[0] = prueba;
//	Walls[1] = prueba2;
//	Walls[2] = prueba3;
//	Walls[3] = prueba4;
//	Walls[4] = prueba5;
//	Walls[5] = prueba6;
//	Walls[6] = prueba7;
//	Walls[7] = prueba8;
//	Walls[8] = prueba9;
//	Walls[9] = prueba10;
//	Walls[10] = prueba11;
//	Walls[11] = prueba12;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_1
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 927, 774);
//			frame.repaint();
//		}
//	});

////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// POSESION DE KIRBY EN ESTE ROOM
//	private int kirbyX = 50, kirbyY = 50;

/////// FONDO DE IMAGEN 2_1_3 PNG POR 850 X 307

//		Entidad prueba = new Entidad(piso1, 0, 250, 250, 12);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 240, 210, 230, 22);
//		prueba2.transformarWall();
//		Entidad prueba3 = new Entidad(piso1, 760, 170, 170, 22);
//		prueba3.transformarWall();
//		Entidad prueba4 = new Entidad(piso1, 520, 230, 250, 12);
//		prueba4.transformarWall();
//		Entidad prueba5 = new Entidad(piso1, 440, 190, 70, 22);
//		prueba5.transformarWall();
//		Entidad prueba6 = new Entidad(piso1, 0, 40, 12, 222);
//		prueba6.transformarWall();
//	

	///// SON 6 BLOQUES PARA ESTE ROOM
//	Entidad Walls[] = new Entidad[6];
//	Walls[0] = prueba;
//	Walls[1] = prueba2;
//	Walls[2] = prueba3;
//	Walls[3] = prueba4;
//	Walls[4] = prueba5;	
//	Walls[5] = prueba6;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_3
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 850, 307);
//			frame.repaint();
//		}
//	});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/// POSESION DE KIRBY EN ESTE ROOM
//	private int kirbyX = 0, kirbyY = 50;

	/////// FONDO DE IMAGEN 2_1_4 PNG POR 850 X 307
//
//	Entidad prueba = new Entidad(piso1, 0, 140, 30, 12);
//	prueba.transformarWall();
//	Entidad prueba2 = new Entidad(piso1, 30, 190, 150, 22);
//	prueba2.transformarWall();
//	Entidad prueba3 = new Entidad(piso1, 170, 130, 70, 22);
//	prueba3.transformarWall();
//	Entidad prueba4 = new Entidad(piso1, 340, 160, 400, 12);
//	prueba4.transformarWall();
//	Entidad prueba5 = new Entidad(piso1, 250, 190, 100, 22);
//	prueba5.transformarWall();
//	Entidad prueba6 = new Entidad(piso1, 740, 40, 12, 302);
//	prueba6.transformarWall();
//	

	///// SON 6 BLOQUES PARA ESTE ROOM
//	Entidad Walls[] = new Entidad[6];
//	Walls[0] = prueba;
//	Walls[1] = prueba2;
//	Walls[2] = prueba3;
//	Walls[3] = prueba4;
//	Walls[4] = prueba5;
//	Walls[5] = prueba6;	
//	

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_4
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 850, 307);
//			frame.repaint();
//		}
//	});

/////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/// POSESION DE KIRBY EN ESTE ROOM
//	private int kirbyX = 90, kirbyY = 700;

	/////// FONDO DE IMAGEN 2_1_5 PNG POR 280 X 900
//
//	Entidad prueba = new Entidad(piso1, 0, 850, 309, 12);
//	prueba.transformarWall();
//	Entidad prueba2 = new Entidad(piso1, 0, 190, 20, 822);
//	prueba2.transformarWall();
//	Entidad prueba3 = new Entidad(piso1, 250, 190, 20, 822);
//	prueba3.transformarWall();
//	

	///// SON 3 BLOQUES PARA ESTE ROOM
//	
//	
//	Entidad Walls[] = new Entidad[3];
//	Walls[0] = prueba;
//	Walls[1] = prueba2;
//	Walls[2] = prueba3;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_5
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 280, 900);
//			frame.repaint();
//		}
//	});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// POSESION DE KIRBY EN ESTE ROOM
//	private int kirbyX = 50, kirbyY = 50;

/////// FONDO DE IMAGEN 2_1_6 PNG POR 500 X 622

//		Entidad prueba = new Entidad(piso1, 10, 440, 600, 12);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 0, 190, 20, 822);
//		prueba2.transformarWall();		

///// SON 2 BLOQUES PARA ESTE ROOM
//		Entidad Walls[] = new Entidad[2];
//		Walls[0] = prueba;
//		Walls[1] = prueba2;
//	

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_6
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100, 500, 622);
//			frame.repaint();
//		}
//	});

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// POSESION DE KIRBY EN ESTE ROOM
//	private int kirbyX = 50, kirbyY = 50;

/////// FONDO DE IMAGEN 2_1_7 PNG POR 500 X 447

//		Entidad prueba = new Entidad(piso1, 0, 310, 370, 12);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 350, 100, 20, 222);
//		prueba2.transformarWall();
//		

	///// SON 2 BLOQUES PARA ESTE ROOM
//	Entidad Walls[] = new Entidad[2];
//	Walls[0] = prueba;
//	Walls[1] = prueba2;
//	

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_7
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100,500, 447);
//			frame.repaint();
//		}
//	});

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/// POSESION DE KIRBY EN ESTE ROOM

//	private int kirbyX = 200, kirbyY = 110;

/////// FONDO DE IMAGEN 2_1_8 PNG POR 500 X 418

//		Entidad prueba = new Entidad(piso1, 0, 90, 180, 12);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 320, 90, 210, 12);
//		prueba2.transformarWall();
//		Entidad prueba3 = new Entidad(piso1, 0, 270, 620, 12);
//		prueba3.transformarWall();
//		Entidad prueba4 = new Entidad(piso1, 130, 170, 220, 12);
//		prueba4.transformarWall();
//		Entidad prueba5 = new Entidad(piso1, 0, 0, 10, 622);
//		prueba5.transformarWall();
//		Entidad prueba6 = new Entidad(piso1,  470, 0, 10, 622);
//		prueba6.transformarWall();
//	

///// SON 6 BLOQUES PARA ESTE ROOM
//		Entidad Walls[] = new Entidad[6];
//		Walls[0] = prueba;
//		Walls[1] = prueba2;
//		Walls[2] = prueba3;
//		Walls[3] = prueba4;
//		Walls[4] = prueba5;
//		Walls[5] = prueba6;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_8
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100,500, 418);
//			frame.repaint();
//		}
//	});
//	

////////////////////////////////////////////////////////////////////////////////////////////////

/// POSESION DE KIRBY EN ESTE ROOM

//	private int kirbyX = 200, kirbyY = 110;

/////// FONDO DE IMAGEN 2_1_9 PNG POR 530 X 433

//		Entidad prueba = new Entidad(piso1, 0, 270, 680, 12);
//		prueba.transformarWall();
//		Entidad prueba2 = new Entidad(piso1, 0, 0, 10, 622);
//		prueba2.transformarWall();
//		Entidad prueba3 = new Entidad(piso1, 500, 0, 10, 622);
//		prueba3.transformarWall();
//

///// SON 3 BLOQUEA PARA ESTE ROOM
//		Entidad Walls[] = new Entidad[3];
//		Walls[0] = prueba;
//		Walls[1] = prueba2;
//		Walls[2] = prueba3;

//	im6.addActionListener(new ActionListener() {
//		@Override
//		///// PARA EL FONDO 2_1_9
//		public void actionPerformed(ActionEvent e) {
//			frame.remove(Jugadores);
//			frame.repaint();
//			frame.add(Nivel1);
//			frame.setBounds(100, 100,530, 433);
//			frame.repaint();
//		}
//	});

////////////////////////////////////////////////////////////////////////////////////////////////////////

}