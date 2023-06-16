package juego;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.Timer;
import java.util.TimerTask;



public class JPanelPersonalizado extends JPanel {

	public JPanelPersonalizado(String tipo) {
		switch (tipo) {
		
		
		case "Menu":
			
			this.setBounds(0, 0, 474, 305);

			ImageIcon img1 = new ImageIcon("Menu.gif");
			JLabel im1 = new JLabel(img1);
			im1.setHorizontalAlignment(SwingConstants.LEFT);
			im1.setBounds(0, 0, 474, 305);
			Image esc1 = img1.getImage().getScaledInstance(im1.getWidth(), im1.getHeight(), Image.SCALE_SMOOTH);
			im1.setIcon(img1);
			this.add(im1);
			break;

		case "Inicio":
			this.setBounds(0, 0, 474, 352);
			this.setLayout(null);
			
			ImageIcon img2 = new ImageIcon("PULSA_START.gif");
			JLabel im2 = new JLabel(img2);
			im2.setHorizontalAlignment(SwingConstants.LEFT);
			im2.setBounds(0, 0, 474, 352);
			Image esc2 = img2.getImage().getScaledInstance(im2.getWidth(), im2.getHeight(), Image.SCALE_SMOOTH);
			im2.setIcon(img2);
			this.add(im2);
			break;
			
		case "Partidas":
			this.setBackground(Color.decode("#002190"));
			this.setBounds(0, 0, 474, 352);
//			frame.getContentPane().add(Partidas);
			this.setLayout(null);
			break;
		case "Jugadores":
			this.setBackground(Color.decode("#002190"));
			this.setBounds(0, 0, 474, 352);
//			frame.getContentPane().add(Jugadores);
			this.setLayout(null);
			break;

		case "Video":
			this.setBounds(0, 0, 474, 352);
			this.setLayout(null);
			
//			ImageIcon img3 = new ImageIcon("PRESENTACION.gif");
//			JLabel im3 = new JLabel(img3);
//			im3.setHorizontalAlignment(SwingConstants.LEFT);
//			im3.setBounds(0, 0, 474, 352);
//			Image esc3 = img3.getImage().getScaledInstance(im3.getWidth(), im3.getHeight(), Image.SCALE_SMOOTH);
//			im3.setIcon(img3);
//			this.add(im3);
//			break;

		case "Nivel1":
			this.setBackground(Color.decode("#002190"));
			this.setBounds(0, 0, 1763, 370);
//			frame.getContentPane().add(Nivel1);
			this.setLayout(null);
			break;
			
		case "Hudkirby":
			ImageIcon Kirby_hud =new ImageIcon("kirby_HUD1.jpg");
			JLabel Hud_estructura = new JLabel(Kirby_hud);
			Hud_estructura.setBounds(0, 0, 690, 400);
			this.add(Hud_estructura);
			this.setBounds(0, 360, 540, 200);

		}

	}

}
		