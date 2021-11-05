package mx.aam;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;

public class SimpleRotatingPlane extends JFrame{
	
	private JPanel panel;
	
	public static void main(String[] args) {
		
		SimpleRotatingPlane frame = new SimpleRotatingPlane();
		frame.setSize(450, 450);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.white);
		window.add(panel);
	}
	
}
