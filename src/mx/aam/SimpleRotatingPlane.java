package mx.aam;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleRotatingPlane extends JFrame implements ActionListener {
	
	private JButton xRot, yRot, xyRot;
	private JLabel rotation;
	
	public static void main(String[] args) {
		
		SimpleRotatingPlane frame = new SimpleRotatingPlane();
		frame.setSize(450, 100);
		frame.createGUI();
		frame.setVisible(true);
	
	}
	
	private void createGUI() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		rotation = new JLabel(" Rotation about: ");
		window.add(rotation);
		xRot = new JButton("x Axis");
		window.add(xRot);
		xRot.addActionListener(this);
		yRot = new JButton("y Axis");
		window.add(yRot);
		yRot.addActionListener(this);
		xyRot = new JButton("x & y Axis");
		window.add(xyRot);
		xyRot.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent event) {
		
		Object source = event.getSource();
		
		if (source == yRot) {
			
			RotY.main(null);
		
		}
	
	}
	
}