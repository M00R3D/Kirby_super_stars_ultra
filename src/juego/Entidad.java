package juego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
//En esta clase Entidad creamos un sistema de gravedad
public class Entidad extends JLabel {
	public Entidad(ImageIcon i,int x,int y, int w, int h) 
	{
		this.setIcon(i);
		this.setBounds(x,y,w,h);
	}
	public int gravedad=1,hsp=0,vsp=0,hspWalk=3,vspJump=-6,canJump=0;
	
	
	public boolean colisiona(Entidad otraEntidad) {
        return this.getBounds().intersects(otraEntidad.getBounds());
    }
	//getters y setters
	
	public int getGravedad() {
		return gravedad;
	}
	public void setGravedad(int gravedad) {
		this.gravedad = gravedad;
	}
	public int getHsp() {
		return hsp;
	}
	public void setHsp(int hsp) {
		this.hsp = hsp;
	}
	public int getVsp() {
		return vsp;
	}
	public void setVsp(int vsp) {
		this.vsp = vsp;
	}
	public int getHspWalk() {
		return hspWalk;
	}
	public void setHspWalk(int hspWalk) {
		this.hspWalk = hspWalk;
	}
	public int getVspJump() {
		return vspJump;
	}
	public void setVspJump(int vspJump) {
		this.vspJump = vspJump;
	}
	public int getCanJump() {
		return canJump;
	}
	public void setCanJump(int canJump) {
		this.canJump = canJump;
	}
	

}
