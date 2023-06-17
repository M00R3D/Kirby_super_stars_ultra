package juego;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//En esta clase EntidadEnemigo creamos un sistema de gravedad
public class EntidadEnemigo extends JLabel {

	String lado = "derecha";
	String tipo;

	public EntidadEnemigo(ImageIcon i, int x, int y, int w, int h)

	{
		super();
		this.setIcon(i);
		this.setBounds(x, y, w, h);

	}

	public EntidadEnemigo(EntidadEnemigo e) {
		super();
		this.setIcon(e.getIcon());
		this.setBounds(e.getX(), e.getY(), e.getWidth(), e.getHeight());

	}

	public EntidadEnemigo(Icon i, int x, int y, int w, int h) {
		this.setIcon(i);
		this.setBounds(x, y, w, h);
	}

	public int gravedad = 2, hsp = 0, vsp = 0, hspWalk = 7, vspJump = -22, canJump = 0;
	public boolean HFlag = false, VFlag = false, HCol = false, VCol = false;

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

	public void transformarWall() {
		this.setOpaque(true);
		this.setBackground(Color.pink);
		this.setIcon(null);
	}

	public void gravitar() {
		switch (tipo) {
		case "Escoba":
			ImageIcon imgDer = new ImageIcon("imgEscoba.gif");
			ImageIcon imgIzq = new ImageIcon("imgEscobaIzq.gif");
			setIcon(imgDer);
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {

					if (isHFlag() == true) {
						setHCol(true);
					} else {
						setHCol(false);
					}
					if (isVFlag() == true) {
						setVCol(true);
					} else {
						setHCol(false);
					}

					setBounds(getX() + getHsp(), getY() + getVsp(), getWidth(), getHeight());
					if (lado == "derecha") {
						setIcon(imgDer);
					}
					if (lado == "izquierda") {
						setIcon(imgIzq);
					}
					if (lado == "derecha") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(3);
						}
					} else if (lado == "izquierda") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(-3);
						}
					}
					// else {setHsp(3);}
					if (isVCol() == true) {
						setVsp(0);
					} else {
						setVsp(3);
					} // caer
				}
			};
			timer.schedule(task, 10, 70);
			Timer mover = new Timer();
			TimerTask taskmover = new TimerTask() {
				@Override
				public void run() {
					cambiarLado();
				}
			};
			mover.schedule(taskmover, 10, 300);
			break;

		case "Twizzy":
			ImageIcon imgDer1 = new ImageIcon("imgTwizzyDer.gif");
			ImageIcon imgIzq1 = new ImageIcon("imgTwizzyIzq.gif");
			setIcon(imgDer1);
			Timer timer1 = new Timer();
			TimerTask task1 = new TimerTask() {
				@Override
				public void run() {

					if (isHFlag() == true) {
						setHCol(true);
					} else {
						setHCol(false);
					}
					if (isVFlag() == true) {
						setVCol(true);
					} else {
						setHCol(false);
					}

					setBounds(getX() + getHsp(), getY() + getVsp(), getWidth(), getHeight());
					if (lado == "derecha") {
						setIcon(imgDer1);
					}
					if (lado == "izquierda") {
						setIcon(imgIzq1);
					}
					if (lado == "derecha") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(3);
						}
					} else if (lado == "izquierda") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(-3);
						}
					}
					// else {setHsp(3);}
					if (isVCol() == true) {
						setVsp(0);
					} else {
						setVsp(3);
					} // caer
				}
			};
			timer1.schedule(task1, 10, 70);
			Timer mover1 = new Timer();
			TimerTask taskmover1 = new TimerTask() {
				@Override
				public void run() {
					cambiarLado();
				}
			};
			mover1.schedule(taskmover1, 10, 300);
			break;

		case "Brunto":
			ImageIcon imgDer2 = new ImageIcon("imgBruntoDer.gif");
			ImageIcon imgIzq2 = new ImageIcon("imgBruntoIzq.gif");
			setIcon(imgDer2);
			Timer timer2 = new Timer();
			TimerTask task2 = new TimerTask() {
				@Override
				public void run() {

					if (isHFlag() == true) {
						setHCol(true);
					} else {
						setHCol(false);
					}
					if (isVFlag() == true) {
						setVCol(true);
					} else {
						setHCol(false);
					}

					setBounds(getX() + getHsp(), getY() + getVsp(), getWidth(), getHeight());
					if (lado == "derecha") {
						setIcon(imgDer2);
					}
					if (lado == "izquierda") {
						setIcon(imgIzq2);
					}
					if (lado == "derecha") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(3);
						}
					} else if (lado == "izquierda") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(-3);
						}
					}
					// else {setHsp(3);}
					if (isVCol() == true) {
						setVsp(0);
					} else {
						setVsp(3);
					} // caer
				}
			};
			timer2.schedule(task2, 10, 70);
			Timer mover2 = new Timer();
			TimerTask taskmover2 = new TimerTask() {
				@Override
				public void run() {
					cambiarLado();
				}
			};
			mover2.schedule(taskmover2, 10, 300);
			break;

		case "Cappy":
			ImageIcon imgDer3 = new ImageIcon("imgCappyDer.gif");
			ImageIcon imgIzq3 = new ImageIcon("imgCappyIzq.gif");
			setIcon(imgDer3);
			Timer timer3 = new Timer();
			TimerTask task3 = new TimerTask() {
				@Override
				public void run() {

					if (isHFlag() == true) {
						setHCol(true);
					} else {
						setHCol(false);
					}
					if (isVFlag() == true) {
						setVCol(true);
					} else {
						setHCol(false);
					}

					setBounds(getX() + getHsp(), getY() + getVsp(), getWidth(), getHeight());
					if (lado == "derecha") {
						setIcon(imgDer3);
					}
					if (lado == "izquierda") {
						setIcon(imgIzq3);
					}
					if (lado == "derecha") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(3);
						}
					} else if (lado == "izquierda") {
						if (isHCol() == true) {
							setHsp(0);
						} else {
							setHsp(-3);
						}
					}
					// else {setHsp(3);}
					if (isVCol() == true) {
						setVsp(0);
					} else {
						setVsp(3);
					} // caer
				}
			};
			timer3.schedule(task3, 10, 70);
			Timer mover3 = new Timer();
			TimerTask taskmover3 = new TimerTask() {
				@Override
				public void run() {
					cambiarLado();
				}
			};
			mover3.schedule(taskmover3, 10, 300);
			break;

		}
	}

	// getters y setters
	public void cambiarLado() {
		if (lado == "derecha") {
			lado = "izquierda";
		}
		if (lado == "izquierda") {
			lado = "derecha";
		}
	}

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
}