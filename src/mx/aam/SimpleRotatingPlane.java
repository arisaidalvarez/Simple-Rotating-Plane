package mx.aam;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleRotatingPlane extends JFrame implements ActionListener {
	
	private JButton xRot, yRot, yRotXZView;
	private JLabel rotation;
	
	public static void main(String[] args) {
		
		SimpleRotatingPlane frame = new SimpleRotatingPlane();
		frame.setSize(500, 100);
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
		yRotXZView = new JButton("y Axis XZ view");
		window.add(yRotXZView);
		yRotXZView.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent event) {
		
		Object source = event.getSource();
		
		if (source == yRot) {
			
			RotY.main(null);
		
		} else if (source == xRot) {
			
			RotX.main(null);
			
		} else if (source == yRotXZView ) {
			
			RotYViewXZ.main(null);
			
		}
	
	}
	
}