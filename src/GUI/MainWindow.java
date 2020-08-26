package GUI;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	MainPanel panel;
	public MainWindow() {
		
		setTitle("Simulador de ondas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 900);
		setLocationRelativeTo(null);
		
		initialize();
		features();
		incorporate();
		
	}
	private void initialize() {
		// TODO Auto-generated method stub
		panel = new MainPanel();
		
	}
	private void features() {
		// TODO Auto-generated method stub
		
	}
	private void incorporate() {
		// TODO Auto-generated method stub
		add(panel);
		
	}
	
}
