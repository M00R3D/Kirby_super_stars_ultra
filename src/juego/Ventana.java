package juego;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

import javax.swing.BoxLayout;

public class Ventana extends JFrame {
	public JPanel panelActual;
	private JFrame frame;
	private int kirbyX=50,kirbyY=50;
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
		frame.setBounds(100, 100, 420, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		// MENU DEL JUEGO

		JPanel Menu = new JPanel();
		Menu.setBounds(0, 0, 404, 352);
		frame.getContentPane().add(Menu);
		Menu.setLayout(null);

		ImageIcon img1 = new ImageIcon("Menu.png");
		JLabel im1 = new JLabel(img1);
		im1.setHorizontalAlignment(SwingConstants.LEFT);
		im1.setBounds(0, 0, 404, 352);

		Image esc1 = img1.getImage().getScaledInstance(im1.getWidth(), im1.getHeight(), Image.SCALE_SMOOTH);
		Icon ices1 = new ImageIcon(esc1);
		im1.setIcon(ices1);
		Menu.add(im1);

		

		this.revalidate();
		this.repaint();

		// PULSA START
		JPanel Inicio = new JPanel();
		Inicio.setBounds(0, 0, 404, 352);
		frame.getContentPane().add(Inicio);
		Inicio.setLayout(null);
		
		
		ImageIcon img2 = new ImageIcon("Inicio.png");
		JLabel im2 = new JLabel(img2);
		im2.setHorizontalAlignment(SwingConstants.LEFT);
		im2.setBounds(0, 0, 404, 352);

		Image esc2 = img2.getImage().getScaledInstance(im2.getWidth(), im2.getHeight(), Image.SCALE_SMOOTH);
		Icon ices2 = new ImageIcon(esc2);
		im2.setIcon(ices2);
		Inicio.add(im2);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel Partidas = new JPanel();
		Partidas.setBackground(Color.CYAN);
		Partidas.setBounds(0, 0, 404, 352);
//		frame.getContentPane().add(Partidas);
		Partidas.setLayout(null);

		/// KIRBY 1

		ImageIcon img3 = new ImageIcon("kirby 1.png");
		JButton kirb1 = new JButton(img3);
		kirb1.setSize(223, 42);
		kirb1.setLocation(90, 87);

		Image esc3 = img3.getImage().getScaledInstance(kirb1.getWidth(), kirb1.getHeight(), Image.SCALE_SMOOTH);
		Icon ices3 = new ImageIcon(esc3);
		kirb1.setIcon(ices3);
		
		Partidas.add(kirb1);
		
		
		// KIRBY 2
		ImageIcon img4 = new ImageIcon("kirby 2.png");
		JButton kirb2 = new JButton(img4);
		kirb2.setSize(223, 42);
		kirb2.setLocation(90, 156);

		Image esc4 = img4.getImage().getScaledInstance(kirb2.getWidth(), kirb2.getHeight(), Image.SCALE_SMOOTH);
		Icon ices4 = new ImageIcon(esc4);
		kirb2.setIcon(ices4);
		Partidas.add(kirb2);

		/// KIRBY 3
		ImageIcon img5 = new ImageIcon("kirby 3.png");
		JButton kirb3 = new JButton(img5);
		kirb3.setSize(223, 42);
		kirb3.setLocation(90, 228);

		Image esc5 = img5.getImage().getScaledInstance(kirb3.getWidth(), kirb3.getHeight(), Image.SCALE_SMOOTH);
		Icon ices5 = new ImageIcon(esc5);
		kirb3.setIcon(ices5);
		Partidas.add(kirb3);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// JUGADORES
		JPanel Jugadores = new JPanel();
		Jugadores.setBackground(Color.CYAN);
		Jugadores.setBounds(0, 0, 404, 352);
//		frame.getContentPane().add(Jugadores);
		Jugadores.setLayout(null);

		// JUGADOR 1
		ImageIcon img6 = new ImageIcon("Jugador 1.png");
		JButton im6 = new JButton(img6);
		im6.setSize(223, 42);
		im6.setLocation(90, 87);

		Image esc6 = img6.getImage().getScaledInstance(im6.getWidth(), im6.getHeight(), Image.SCALE_SMOOTH);
		Icon ices6 = new ImageIcon(esc6);
		im6.setIcon(ices6);
		Jugadores.add(im6);

		// JUGADOR 2
		ImageIcon img7 = new ImageIcon("Jugador 2.png");
		JButton im7 = new JButton(img7);
		im7.setSize(223, 42);
		im7.setLocation(90, 156);

		Image esc7 = img7.getImage().getScaledInstance(im7.getWidth(), im7.getHeight(), Image.SCALE_SMOOTH);
		Icon ices7 = new ImageIcon(esc7);
		im7.setIcon(ices7);
		Jugadores.add(im7);

		// REGRESAR AL INICIO
		
		ImageIcon img8 = new ImageIcon("Regresar.png");
		JButton btnRegresar = new JButton(img8);
		btnRegresar.setSize(53, 42);
		btnRegresar.setLocation(322, 273);

		Image esc8 = img8.getImage().getScaledInstance(btnRegresar.getWidth(), btnRegresar.getHeight(), Image.SCALE_SMOOTH);
		Icon ices8 = new ImageIcon(esc8);
		btnRegresar.setIcon(ices8);
		Jugadores.add(btnRegresar);
		
		panelActual=Menu;
	
		
		
		///NIVEL 1
		
		ImageIcon imgKirbyBase = new ImageIcon("kirbyBase.png");

		JPanel Nivel1 = new JPanel();
		Nivel1.setBackground(Color.CYAN);
		Nivel1.setBounds(0, 0, 404, 352);
//		frame.getContentPane().add(Nivel1);
		Nivel1.setLayout(null);
		JLabel labelKirby = new JLabel(imgKirbyBase);
		labelKirby.setBounds(32,32,50,50);
		Nivel1.add(labelKirby);
		
	
		
		kirb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Partidas);
				frame.repaint();
				frame.add(Jugadores);		
				frame.repaint();
			}});
		kirb2.addActionListener(kirb1.getActionListeners()[0]);
		kirb3.addActionListener(kirb1.getActionListeners()[0]);
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Jugadores);
				frame.repaint();
				frame.add(Partidas);		
				frame.repaint();
			}});
		
		im6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Jugadores);
				frame.repaint();
				frame.add(Nivel1);		
				frame.repaint();
			}});
		
		im7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Jugadores);
				frame.repaint();
				frame.add(Nivel1);		
				frame.repaint();
			}});
		

		kirb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Partidas);
				frame.repaint();
				frame.add(Jugadores);		
				frame.repaint();
			}});
		
		kirb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(Partidas);
				frame.repaint();
				frame.add(Jugadores);		
				frame.repaint();
			}});
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(panelActual==Inicio) 
				{
					System.out.println(e.getKeyCode()+""+e.getKeyChar());
					if(e.getKeyCode()==10 ) 
					{
						frame.remove(Inicio);
						frame.repaint();
						frame.add(Partidas);
					}
		
				}
					if(e.getKeyCode()== 87 || e.getKeyCode()==38){//W
						kirbyY-=3;}
						
					if(e.getKeyCode()== 65 || e.getKeyCode()==37){//A
						kirbyX-=3;
					}
					if(e.getKeyCode()== 83 || e.getKeyCode()==40){//S
						kirbyY+=3;
					}
					if(e.getKeyCode()== 68 || e.getKeyCode()==39){//D
						kirbyX+=3;
					}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
		
		
		Timer timerTicks = new Timer();
		TimerTask repintar = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					labelKirby.setBounds(kirbyX, kirbyY, 32, 32);
					System.out.println(kirbyX+""+kirbyY);
					
					if(kirbyY<312) {kirbyY++;}
					
					frame.repaint();
			}
		};
		timerTicks.schedule(repintar, 10, 30);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int tik = 0;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (tik == 0) {
					tik = 1;
				} else {
//					frame.getContentPane().remove(Menu);
					frame.remove(Menu);
					frame.repaint();
					frame.add(Inicio);
//					revalidate();
					frame.repaint();
					panelActual=Inicio;
					timer.cancel();
				}
			}
		};
		timer.schedule(task, 10, 3000);
		

	}

	
	
}
	
	
