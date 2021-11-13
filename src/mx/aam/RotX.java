package mx.aam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RotX extends JFrame implements ActionListener {
	
	private JLabel label;
	private JPanel panel;
	
	private Timer timer = new Timer(60, this);
	
	private int centerX = 200, centerY = 200;
	private int a = 50, l = 60;
	
	private double caX = 0.0, phi = 0.0;
	
	private int y1 = 0, x = 0;
	
	public static void main(String[] args) {
		
		RotX frame = new RotX();
		frame.setSize(500, 500);
		frame.createGUI();
		frame.setVisible(true);
		
	}
	
	private void createGUI() {
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		label = new JLabel("Rotation about X axis:");
		window.add(label);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.white);
		window.add(panel);
		timer.start();
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		Graphics paper = panel.getGraphics();
		
		drawRectRX(paper);
		
	}
	
	private void drawRectRX(Graphics drawArea) {
		
		caX = Math.abs(((double)l/2)*Math.cos(phi));
		
		y1 = centerY - (int)caX;
		
		x = centerX - a/2;
		
		drawArea.setColor(Color.white);
		drawArea.fillRect(0, 0, 400, 400);
		
		axis(drawArea);
		
		drawArea.setColor(Color.black);
		drawArea.drawRect(x, y1, a, 2*(int)caX);
		
		phi += 1.2*(Math.PI/180);
		
	}
	
	private void axis(Graphics drawArea) {
		
		drawArea.setColor(Color.blue);
		drawArea.drawLine(centerX, centerY, centerX + 50, centerY);
		drawArea.setColor(Color.red);
		drawArea.drawLine(centerX, centerY, centerX, centerY - 50);
		
	}

}
