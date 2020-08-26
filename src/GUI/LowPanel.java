package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class LowPanel extends JPanel{

	
	 JLabel lblAmplitude;
	 JLabel lblFrequency;
	 JLabel lblSpeed;
	 JSpinner spnAmplitude;
	 JSpinner spnFrequency;
	 JSpinner spnSpeed;
	 
	 public LowPanel() {
		 
		setLayout(new FlowLayout());
		initialize();
		features();
		incorporate();
		
	 }

	private void initialize() {
		// TODO Auto-generated method stub
		lblAmplitude = new JLabel("Amplitude");
		lblFrequency = new JLabel("Frequency");
		lblSpeed = new JLabel("Speed");
		SpinnerNumberModel modelAmplitude = new SpinnerNumberModel(0.0, 0.0, 3.5, 0.5);  
		SpinnerNumberModel modelFrecuency = new SpinnerNumberModel(0.0, 0.0, 10.0, 1.0); 
		SpinnerNumberModel modelSpeed = new SpinnerNumberModel(0.0, 0.0, 20.0, 1.0); 
		spnAmplitude = new JSpinner(modelAmplitude);
		spnFrequency = new JSpinner(modelFrecuency);
		spnSpeed = new JSpinner(modelSpeed);
	}

	private void features() {
		// TODO Auto-generated method stub
		lblAmplitude.setPreferredSize(new Dimension(80, 30));
		spnAmplitude.setPreferredSize(new Dimension(50, 30));
		lblFrequency.setPreferredSize(new Dimension(80, 30));
		spnFrequency.setPreferredSize(new Dimension(50, 30));
		
		lblSpeed.setPreferredSize(new Dimension(80, 30));
		spnSpeed.setPreferredSize(new Dimension(50, 30));
		
	}

	private void incorporate() {
		// TODO Auto-generated method stub
		add(BorderLayout.SOUTH,lblAmplitude);
		add(BorderLayout.SOUTH,spnAmplitude);
	
		add(BorderLayout.SOUTH,lblFrequency);
		add(BorderLayout.SOUTH,spnFrequency);
		
		add(BorderLayout.SOUTH,lblSpeed);
		add(BorderLayout.SOUTH,spnSpeed);
	}

	public JSpinner getSpnAmplitude() {
		return spnAmplitude;
	}

	public JSpinner getSpnFrequency() {
		return spnFrequency;
	}

	public JSpinner getSpnSpeed() {
		return spnSpeed;
	}

	

}
