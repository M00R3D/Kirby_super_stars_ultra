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
			
			
			this.setBounds(0, 0, 400, 352);
			this.setLayout(null);
			ImageIcon img1 = new ImageIcon("Menu.png");
			JLabel im1 = new JLabel(img1);
			im1.setHorizontalAlignment(SwingConstants.LEFT);
			im1.setBounds(0, 0, 404, 352);
			Image esc1 = img1.getImage().getScaledInstance(im1.getWidth(), im1.getHeight(), Image.SCALE_SMOOTH);
			Icon ices1 = new ImageIcon(esc1);
			im1.setIcon(ices1);
			this.add(im1);
			break;

		case "Inicio":
			this.setBounds(0, 0, 404, 352);
			this.setLayout(null);
			ImageIcon img2 = new ImageIcon("Inicio.png");
			JLabel im2 = new JLabel(img2);
			im2.setHorizontalAlignment(SwingConstants.LEFT);
			im2.setBounds(0, 0, 404, 352);
			Image esc2 = img2.getImage().getScaledInstance(im2.getWidth(), im2.getHeight(), Image.SCALE_SMOOTH);
			Icon ices2 = new ImageIcon(esc2);
			im2.setIcon(ices2);
			this.add(im2);
			break;
		case "Partidas":
			this.setBackground(Color.decode("#002190"));
			this.setBounds(0, 0, 404, 352);
//			frame.getContentPane().add(Partidas);
			this.setLayout(null);
			break;
		case "Jugadores":
			this.setBackground(Color.decode("#002190"));
			this.setBounds(0, 0, 404, 352);
//			frame.getContentPane().add(Jugadores);
			this.setLayout(null);
			break;

		case "Nivel1":
			this.setBackground(Color.decode("#002190"));
			this.setBounds(0, 0, 500, 418);
//			frame.getContentPane().add(Nivel1);
			this.setLayout(null);
			break;

		
		}

	}

}
