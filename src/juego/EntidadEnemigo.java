package juego;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//En esta clase EntidadEnemigo creamos un sistema de gravedad
public class EntidadEnemigo extends JLabel {
	
	
	String lado="derecha";
		String tipo;
	

	
	public EntidadEnemigo(ImageIcon i,int x,int y, int w, int h) 
	
	
	
	
	{
		super();
		this.setIcon(i);
		this.setBounds(x,y,w,h);
		
	}
	public EntidadEnemigo(EntidadEnemigo e) 
	{
		super();
		this.setIcon(e.getIcon());
		this.setBounds(e.getX(),e.getY(),e.getWidth(),e.getHeight());
		
	}
	public EntidadEnemigo(Icon i, int x, int y, int w, int h) {
		this.setIcon(i);
		this.setBounds(x,y,w,h);
		}
	public int gravedad=2,hsp=0,vsp=0,hspWalk=7,vspJump=-22,canJump=0;
	public boolean HFlag=false,VFlag=false,HCol=false,VCol=false;
	
	public boolean isHFlag() {
		return HFlag;
	}

	public void setHFlag(boolean hFlag) {
		HFlag = hFlag;
	}

	public boolean isVFlag() {
		return VFlag;
	}

	public void setVFlag(boolean vFlag) {
		VFlag = vFlag;
	}

	public boolean isHCol() {
		return HCol;
	}

	public void setHCol(boolean hCol) {
		HCol = hCol;
	}

	public boolean isVCol() {
		return VCol;
	}

	public void setVCol(boolean vCol) {
		VCol = vCol;
	}

	public boolean colision(EntidadEnemigo EntidadEnemigo) {
	    int thisX = this.getX();
	    int thisY = this.getY();
	    int thisWidth = this.getWidth();
	    int thisHeight = this.getHeight();

	    int EntidadEnemigoX = EntidadEnemigo.getX();
	    int EntidadEnemigoY = EntidadEnemigo.getY();
	    int EntidadEnemigoWidth = EntidadEnemigo.getWidth();
	    int EntidadEnemigoHeight = EntidadEnemigo.getHeight();

	    boolean colisionX = thisX + thisWidth >= EntidadEnemigoX && EntidadEnemigoX + EntidadEnemigoWidth >= thisX;
	    boolean colisionY = thisY + thisHeight >= EntidadEnemigoY && EntidadEnemigoY + EntidadEnemigoHeight >= thisY;

	    return colisionX && colisionY;
	}
	
	public void transformarWall() 
	{
		this.setOpaque(true);this.setBackground(Color.pink);this.setIcon(null);
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
		
		
	}
	}