package mx.aam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.lang.Math;

public class RotYViewXZ extends JFrame implements ActionListener {
	
	private JLabel label;
	private JPanel panel;
	
	private Timer yXZView = new Timer(60, this);
	
	private int centerX = 200, centerY = 200, a = 50, x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	
	private double theta = 0.0;
	
	public static void main(String[] args) {
		
		RotYViewXZ frame = new RotYViewXZ();
		frame.setSize(500, 500);
		frame.createGUI();
		frame.setVisible(true);
		
	}
	
	private void createGUI() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		label = new JLabel("Rotation about Y axis, XZ view:");
		window.add(label);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.white);
		window.add(panel);
		yXZView.start();
		
	}
	
	public void actionPerformed (ActionEvent event) {
		
		Graphics paper = panel.getGraphics();
		
		drawLineByC(paper);
		
	}
	
	private void drawLineByC(Graphics drawArea) {
		
		x1 = (int)(centerX - (a/1)*(Math.cos(theta)));
		y1 = (int)(centerY + (a/1)*(Math.sin(theta)));
		
		x2 = (int)(centerX + (a/1)*(Math.cos(theta)));
		y2 = (int)(centerY - (a/1)*(Math.sin(theta)));
		
		drawArea.setColor(Color.white);
		drawArea.fillRect(0, 0, 400, 400);
		
		axis(drawArea);
		
		drawArea.setColor(Color.black);
		drawArea.drawLine(x1, y1, x2, y2);
		
		theta += 1.2*(Math.PI/180);
		
	}
	
	private void axis (Graphics drawArea) {
		
		drawArea.setColor(Color.blue);
		drawArea.drawLine(centerX, centerY, centerX + 50, centerY);
		drawArea.setColor(Color.green);
		drawArea.drawLine(centerX, centerY, centerX, centerY + 50);
		
	}
	
}
