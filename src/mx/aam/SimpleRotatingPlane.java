package mx.aam;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.lang.Math;

public class SimpleRotatingPlane extends JFrame implements ActionListener {
	
	private static JPanel panel;
	private JButton axis, plane, xRot, yRot, xyRot, stop;
	private JLabel rotation;
	
	private int centerX = 200, centerY = 200;
	private int l = 60, a = 50;
	private int x = 0, y = 0; 
	
	private Timer xT = new Timer(500, this), yT = new Timer(500, this), xyT = new Timer(500, this);
	private boolean xB = false, yB = false, xyB = false;
	
	private double theta = 0.0, phi = 0.0;
	
	private double caY = 0.0, caX = 0.0; 
	
	private int x1 = 0, x2 = 0;
	
	public static void main(String[] args) {
		
		SimpleRotatingPlane frame = new SimpleRotatingPlane();
		frame.setSize(500, 550);
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
		axis = new JButton("axis");
		window.add(axis);
		axis.addActionListener(this);
		plane = new JButton("plane");
		window.add(plane);
		plane.addActionListener(this);
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
		stop = new JButton("stop");
		window.add(stop);
		stop.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent event) {
		
		Object source = event.getSource();
		Graphics paper = panel.getGraphics();
		
		if(source == axis) {
		
			axis(paper);
		
		} else if (source == plane) {
			
			drawRectByC(paper);
			
		} else if (source == xRot) {
			
			//xT.start();
			
			xB = true;
			
			drawRectRY(paper);
			
		} else if (source == stop) {
			
			//xT.stop();
			xB = false;
			
		}
		
	}
	
	private void axis(Graphics drawArea) {
		
		drawArea.setColor(Color.blue);
		drawArea.drawLine(centerX, centerY, centerX + 50, centerY);
		drawArea.setColor(Color.red);
		drawArea.drawLine(centerX, centerY, centerX, centerY - 50);
		
	}
	
	private void drawRectByC(Graphics drawArea) { 
		
		x = centerX - a/2;
		y = centerY - l/2;
		
		drawArea.drawRect(x, y, a, l);
		
	}
	
	private void drawRectRY(Graphics drawArea) {
		
		if(xB == true) {
		
		caY = ((double)a/2)*Math.abs(Math.cos(theta));
			
		x1 = (int)(centerX - caY);
			
		drawArea.setColor(Color.white);
		drawArea.fillRect(0, 0, 450, 400);
		axis(drawArea);
		drawArea.setColor(Color.black);
		drawArea.drawRect(x1, y, 2*(int)caY, l);
		
		theta += 10*(Math.PI/180);
		
		}
	}
	
}
