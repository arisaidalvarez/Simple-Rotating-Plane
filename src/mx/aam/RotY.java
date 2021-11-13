package mx.aam;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.lang.Math;

public class RotY extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel label;
	
	private int centerX = 200, centerY = 200;
	private int l = 60, a = 50;
	private int y = 0; 
	
	private Timer yT = new Timer(60, this);
	
	private double theta = 0.0;
	
	private double caY = 0.0; 
	
	private int x1 = 0;

	public static void main(String[] args) {

		RotY frame = new RotY();
		frame.setSize(500, 500);
		frame.createGUI();
		frame.setVisible(true);

	}

	private void createGUI() {

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		label = new JLabel("Rotation about Y axis:");
		window.add(label);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.white);
		window.add(panel);
		yT.start();

	}
	
	public void actionPerformed (ActionEvent event) {
		
		Graphics paper = panel.getGraphics();
		
		drawRectRY(paper);
		
	}
	
	private void drawRectRY(Graphics drawArea) {
		
		caY = Math.abs(((double)a/2)*Math.cos(theta));
			
		x1 = centerX - (int)caY;
		
		y = centerY - l/2;
			
		drawArea.setColor(Color.white);
		drawArea.fillRect(0, 0, 450, 400);
		axis(drawArea);
		drawArea.setColor(Color.black);
		drawArea.drawRect(x1, y, 2*(int)caY, l);
		
		theta += 1.2*(Math.PI/180);
		
	}
	
	private void axis(Graphics drawArea) {
		
		drawArea.setColor(Color.blue);
		drawArea.drawLine(centerX, centerY, centerX + 50, centerY);
		drawArea.setColor(Color.red);
		drawArea.drawLine(centerX, centerY, centerX, centerY - 50);
		
	}
	
}
