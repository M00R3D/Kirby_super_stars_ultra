package juego;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class EntidadEnemigo extends Entidad{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String estado="Izquierda";
	public boolean colisionWal=false;
	public EntidadEnemigo(ImageIcon i, int x, int y, int w, int h) {
		super(i, x, y, w, h);
		Timer timerVariables = new Timer();
		TimerTask taskReducirVariables = new TimerTask() {
			@Override
			public void run() {
				//reducir las velocidades a cualquier direccion de kirby con una velocidad menor a la que se repinta
//				System.out.println("s");
			}
		};
		timerVariables.schedule(taskReducirVariables, 10, 70);
	}

	
	
}
