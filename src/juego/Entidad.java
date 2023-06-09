package juego;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//En esta clase Entidad creamos un sistema de gravedad
public class Entidad extends JLabel {
	public Entidad(ImageIcon i,int x,int y, int w, int h) 
	{
		super();
		this.setIcon(i);
		this.setBounds(x,y,w,h);
		
	}
	public Entidad(Entidad e) 
	{
		super();
		this.setIcon(e.getIcon());
		this.setBounds(e.getX(),e.getY(),e.getWidth(),e.getHeight());
		
	}
	public Entidad(Icon i, int x, int y, int w, int h) {
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
	
	public boolean colisionEnm(EntidadEnemigo entidad) {
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

	public void gravitar() 
	{
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
					
			@Override
			public void run() {
				if (isHFlag()==true) {setHCol(true);}else {setHCol(false);}
				if (isVFlag()==true) {setVCol(true);}else {setHCol(false);}
				if(isHCol()==true) {setHsp(0);}//else {setHsp(3);}
				if(isVCol()==true) {setVsp(0);}else {setVsp(3);}//caer
				setBounds(getX()+getHsp(),getY()+getVsp(),getWidth(),getHeight());
//				setHFlag(false);setVFlag(false);
			}
		};
		timer.schedule(task, 10, 90);
	}
	

}


