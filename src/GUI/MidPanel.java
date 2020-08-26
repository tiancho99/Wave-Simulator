package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MidPanel extends Canvas{
	double amplitud;
	double frecuencia;
	double velocidad;
	private Image dibujoAux;
	private Graphics gAux;
	private Dimension dimAux;
	private Dimension dimCanvas;
	long espera;
	int sum =0;
	public MidPanel() {
		this.setSize(new Dimension(760, 900));
		this.setLocation(300, 100);
		dimCanvas = this.getSize();

	}
	@Override
	public void paint(Graphics g) {
		espera = (long) (20-velocidad);
		if (gAux == null || dimAux == null || dimCanvas.width != dimAux.width || dimCanvas.height != dimAux.height) {
			dimAux = dimCanvas;
			dibujoAux = createImage(dimAux.width, dimAux.height);
			gAux = dibujoAux.getGraphics();
			plano();

		}

		if (amplitud != 0 && frecuencia != 0) {

			if(frecuencia >0) {


				double l = 360*frecuencia*3;	
				plano();
				for (int i = 0; i<l; i+=1) {

					double x = i/frecuencia;
					double angulo = Math.toRadians(i);
					double sin = Math.sin(angulo);
					double y = sin*amplitud*100;
					angulo = Math.toRadians(i+1);
					sin = Math.sin(angulo);
					double yp = sin*amplitud*100;
					gAux.setColor(Color.BLACK);
					gAux.drawLine((int)coordx(x), (int)coordy(y), (int)coordx(x+1), (int)coordy(yp));


				}
				try {
//					System.out.println(velocidad);
					espera = (long) (20-velocidad);
					
					Thread.sleep(espera);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if (sum<=l) {
					sum++;
					repaint();
				}

			}

		}else {
			plano();
		}
		g.drawImage(dibujoAux, 0, 0, this);
	}
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	private void plano() {
		gAux.clearRect(0, 0, 1100, 700);
		gAux.setColor(Color.RED);
		gAux.drawLine(30, 30, 30, 630);
		gAux.drawLine(0, 330, 1000, 330);
		gAux.drawLine(25, 30, 35, 30);
		gAux.drawLine(25, 130, 35, 130);
		gAux.drawLine(25, 230, 35, 230);
		gAux.drawLine(25, 430, 35, 430);
		gAux.drawLine(25, 530, 35, 530);
		gAux.drawLine(25, 630, 35, 630);
		gAux.drawLine(391, 325, 391, 335);
		gAux.drawLine(751, 325, 751, 335);
	}



	private double coordy(double y) {
		// TODO Auto-generated method stub
		return y+330;
	}

	private double coordx(double d) {
		// TODO Auto-generated method stub

		if (sum == 360) {
			sum=0;


		}
		double c = d-360+30+sum;
		if (c>760) {
			return 760;
		}
		return c;
	}
	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	public void setAmplitud(double amplitud) {
		this.amplitud = amplitud;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
}
