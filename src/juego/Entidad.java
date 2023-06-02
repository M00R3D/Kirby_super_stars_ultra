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
	public int gravedad=2,hsp=0,vsp=0,hspWalk=7,vspJump=-22,canJump=0;
	
	
	public boolean colision(Entidad entidad) {
	    int thisX = this.getX();
	    int thisY = this.getY();
	    int thisWidth = this.getWidth();
	    int thisHeight = this.getHeight();

	    int entidadX = entidad.getX();
	    int entidadY = entidad.getY();
	    int entidadWidth = entidad.getWidth();
	    int entidadHeight = entidad.getHeight();

	    boolean colisionX = thisX + thisWidth >= entidadX && entidadX + entidadWidth >= thisX;
	    boolean colisionY = thisY + thisHeight >= entidadY && entidadY + entidadHeight >= thisY;

	    return colisionX && colisionY;
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
