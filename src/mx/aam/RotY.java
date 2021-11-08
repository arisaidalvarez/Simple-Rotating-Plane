package mx.aam;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.lang.Math;

public class RotY extends JFrame implements ActionListener {

	private static JPanel panel;
	
	private int centerX = 200, centerY = 200;
	private int l = 60, a = 50;
	private int x = 0, y = 0; 
	
	private Timer xT = new Timer(500, this), yT = new Timer(60, this), xyT = new Timer(500, this);
	
	private boolean xB = false, yB = false, xyB = false;
	
	private double theta = 0.0, phi = 0.0;
	
	private double caY = 0.0, caX = 0.0; 
	
	private int x1 = 0, x2 = 0;

	public static void main(String[] args) {

		RotY frame = new RotY();
		frame.setSize(500, 500);
		frame.createGUI();
		frame.setVisible(true);

	}

	private void createGUI() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 400));
		panel.setBackground(Color.white);
		window.add(panel);
		yT.start();

	}
	
	public void actionPerformed (ActionEvent event) {
		
		Graphics paper = panel.getGraphics();
		
		axis(paper);
		
		drawRectRY(paper);
		
	}
	
	private void axis(Graphics drawArea) {
		
		drawArea.setColor(Color.blue);
		drawArea.drawLine(centerX, centerY, centerX + 50, centerY);
		drawArea.setColor(Color.red);
		drawArea.drawLine(centerX, centerY, centerX, centerY - 50);
		
	}
	
	private void drawRectRY(Graphics drawArea) {
		
		caY = ((double)a/2)*Math.abs(Math.cos(theta));
			
		x1 = (int)(centerX - caY);
		
		y = centerY - l/2;
			
		drawArea.setColor(Color.white);
		drawArea.fillRect(0, 0, 450, 400);
		axis(drawArea);
		drawArea.setColor(Color.black);
		drawArea.drawRect(x1, y, 2*(int)caY, l);
		
		theta += 1.2*(Math.PI/180);
		
	}
	
}
