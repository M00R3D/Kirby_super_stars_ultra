package juego;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class EntidadProyectil extends Entidad{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String estado="Izquierda";
	public int destruir=0;
	public boolean colisionWal=false;
	public boolean isColisionWal() {
		return colisionWal;
	}
	public void setColisionWal(boolean colisionWal) {
		this.colisionWal = colisionWal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getDestruir() {
		return destruir;
	}
	public void setDestruir(int destruir) {
		this.destruir = destruir;
	}
	public EntidadProyectil(ImageIcon i, int x, int y, int w, int h) {
		super(i, x, y, w, h);
		Timer timerVariables = new Timer();
		TimerTask taskReducirVariables = new TimerTask() {
			@Override
			public void run() {
				//reducir las velocidades a cualquier direccion de kirby con una velocidad menor a la que se repinta
				if(isColisionWal()==true) 
				{
					setBounds(-500,-500,0,0);
					timerVariables.cancel();
				}
				
				
				if(isColisionWal()==false) {
				System.out.println("a");	
					setBounds(getX()+1,getY(),getWidth(),getHeight());
				}
				
				
			}
		};
		timerVariables.schedule(taskReducirVariables, 10, 30);
	}

}