import java.awt.Color;
import java.awt.Graphics;
import java.time.Instant;

import javax.swing.JPanel;

public class DoublePendulumContainer extends JPanel{
	private final int WIDTH;
	private final int  HEIGHT;
	
	public boolean dragOn = false;
	public boolean pause = false;
	public boolean reset = false;
	public double l1 = 200;
	public double l2 = 200;
	public double m1 = 40;
	public double m2 = 40;
	public double start_a1 = Math.PI / 2;
	public double start_a2 = Math.PI / 2;
	public double G = 1;
	public int FPS = 30;
	
	public double a1 = start_a1;
	public double a2 = start_a2;
	private double a1_v = 0;
	private double a2_v = 0;
	private double a1_a = 0;
	private double a2_a = 0;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	
	public DoublePendulumContainer(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.setSize(width, height);
		this.setVisible(true);
	}
	
	public void simulate() {		
		while(true) {
			//reset values and start again
			if(reset) {
				a1 = start_a1;
				a2 = start_a2;
				a1_v = 0;
				a2_v = 0;
				a1_a = 0;
				a2_a = 0;
				break;
			}
			
			// wait until resumed
			while(pause) {	
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
			
			Instant until = Instant.now();
			until = until.plusMillis(1000 / FPS);
			
			calculateAcceleration();
			calculatePositions();
			this.repaint();
			calculateAngle();
			sleepUntil(until);
		}
		
		if(reset) {
			reset = false;
			simulate();
		}
	}
	
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		int midthX = Math.round(this.WIDTH / 2);
		int midthY = Math.round(this.HEIGHT / 2);
		
		//draw a red middle point
		g.setColor(Color.RED);
		g.fillOval(midthX - 10, midthY - 10, 20, 20);
		
		// draw lines for pendulums
		g.setColor(Color.BLACK);
		g.drawLine(midthX, midthY, midthX + x1, midthY + y1);
		g.drawLine(midthX + x1, midthY + y1, midthX + x2, midthY + y2);
		
		//draw circles for mass hanging on the end of pendulums
		g.fillOval((int)(midthX + x1 - m1/2),(int)(midthY + y1 - m1/2), (int)m1, (int)m1);
		g.fillOval((int)(midthX + x2 - m2/2),(int)(midthY + y2 - m2/2), (int)m2, (int)m2);
	}
	
	private void calculatePositions() {
		x1 = (int)(l1 * Math.sin(a1));
		y1 = (int)(l1 * Math.cos(a1));
		
		x2 = (int)(x1 + l2 * Math.sin(a2));
		y2 = (int)(y1 + l2 * Math.cos(a2));
	}
	
	private void calculateAngle() {
		a1_v += a1_a;
		a2_v += a2_a;
		
		// as momentum increases, slowly pendulum comes to rest
		if(dragOn) {
			a1_v *= 0.99;
			a2_v *= 0.99;
		}
		
		a1 += a1_v;
		a2 += a2_v;
	}
	
	private void calculateAcceleration() {
		double dividend1 = (-G * (2 * m1 + m2) * Math.sin(a1)) + (-m2 * G * Math.sin(a1 - 2 * a2)) + (-2 * Math.sin(a1 - a2) * m2) * (a2_v * a2_v * l2 + a1_v * a1_v * l1 * Math.cos(a1 -a2)); 
		double divisor1 = l1 * (2 *  m1 + m2 - m2 * Math.cos(2 * a1 - 2 * a2));
		a1_a = dividend1 / divisor1;
		
		double dividend2 = (2 * Math.sin(a1 - a2)) * ((a1_v * a1_v * l1 * (m1 + m2)) + (G * (m1 + m2) * Math.cos(a1)) + (a2_v * a2_v * l2 * m2 * Math.cos(a1 - a2)));
		double divisor2 = l2 * (2 * m1 + m2 - m2 * Math.cos(2 * a1 - 2 * a2));
		a2_a = dividend2 / divisor2;
	}
	
	public void sleepUntil(Instant until){
		long now = Instant.now().toEpochMilli();
		if (until.toEpochMilli() - now > 0)
			try {
				Thread.sleep(until.toEpochMilli() - now);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
