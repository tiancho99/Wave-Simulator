package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainPanel extends JPanel implements ChangeListener{
	LowPanel low;
	MidPanel mid;
	public MainPanel() {
		setLayout(new BorderLayout());
		
		initialize();
		features();
		incorporate();
		addControl();
	}
	private void addControl() {
		low.getSpnAmplitude().addChangeListener(this);
		low.getSpnFrequency().addChangeListener(this);
		low.getSpnSpeed().addChangeListener(this);
	}
	private void initialize() {
		// TODO Auto-generated method stub
		low = new LowPanel();
		mid = new MidPanel();
	}

	private void features() {
		// TODO Auto-generated method stub
		
	}

	private void incorporate() {
		// TODO Auto-generated method stub
		add(BorderLayout.SOUTH, low);
		add(BorderLayout.CENTER, mid);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		double amplitud = Double.parseDouble(low.getSpnAmplitude().getValue().toString());
		double frecuencia = Double.parseDouble(low.getSpnFrequency().getValue().toString());
		double velocidad = Double.parseDouble(low.getSpnSpeed().getValue().toString());
		if (velocidad > 20) {
			low.getSpnSpeed().setValue("19");
		}
//		System.out.println("velocidad "+velocidad);
		mid.setFrecuencia(frecuencia);
		mid.setAmplitud(amplitud);
		mid.setVelocidad(velocidad);
		mid.repaint();
		
		
		}
	
	
}
