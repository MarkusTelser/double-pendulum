import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Gui extends JFrame {
	private final int WIDTH = 1400;
	private final int HEIGHT = 1000;
	private final int CONTAINER_WIDTH = 900;
	private final int CONTAINER_HEIGHT = 900;

	private DoublePendulumContainer dc;
	private JSlider slider1;
	private JSlider slider2;
	private JSlider slider3;
	private JSlider slider4;
	private JSlider slider5;
	private JSlider slider6;
	private JSlider slider7;
	private JSlider slider8;
	private JCheckBox checkbox1;
	private JCheckBox checkbox2;
	private JButton button1;
	private JButton button2;

	public static void main(String[] args) {
		Gui g = new Gui();
	}

	public Gui() {
		Font f1 = new Font("", Font.PLAIN, 18);
		
		// initialize window
		Dimension d = this.getToolkit().getDefaultToolkit().getScreenSize();
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(d.width / 2 - WIDTH / 2, d.height / 2 - HEIGHT / 2);
		this.setTitle("Double Pendulum");
		this.setLayout(null);

		// add draw container
		dc = new DoublePendulumContainer(CONTAINER_WIDTH, CONTAINER_HEIGHT);
		dc.setLocation(30, 30);
		this.add(dc);

		// add slider for m1
		DefaultBoundedRangeModel model1 = new DefaultBoundedRangeModel(50, 0, 0, 100);
		slider1 = new JSlider(model1);
		slider1.setMajorTickSpacing(24);
		slider1.setMinorTickSpacing(5);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setLocation(1000, 50);
		slider1.setSize(300, 60);
		slider1.addChangeListener(new MyChangeListener());
		this.add(slider1);

		// add label for m1
		JLabel label1 = new JLabel("mass on pendulum 1:");
		label1.setBounds(1070, 27, 200, 30);
		label1.setFont(f1);
		this.add(label1);

		// add slider for m2
		DefaultBoundedRangeModel model2 = new DefaultBoundedRangeModel(50, 0, 0, 100);
		slider2 = new JSlider(model2);
		slider2.setMajorTickSpacing(24);
		slider2.setMinorTickSpacing(5);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.setLocation(1000, 150);
		slider2.setSize(300, 60);
		slider2.addChangeListener(new MyChangeListener());
		this.add(slider2);

		// add label for m2
		JLabel label2 = new JLabel("mass on pendulum 2:");
		label2.setBounds(1070, 127, 200, 30);
		label2.setFont(f1);
		this.add(label2);

		// add slider for l1
		DefaultBoundedRangeModel model3 = new DefaultBoundedRangeModel(125, 0, 50, 200);
		slider3 = new JSlider(model3);
		slider3.setMajorTickSpacing(50);
		slider3.setMinorTickSpacing(10);
		slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		slider3.setLocation(1000, 250);
		slider3.setSize(300, 60);
		slider3.addChangeListener(new MyChangeListener());
		this.add(slider3);

		// add label for l1
		JLabel label3 = new JLabel("lenght of pendulum 1:");
		label3.setBounds(1065, 227, 200, 30);
		label3.setFont(f1);
		this.add(label3);

		// add slider for l2
		DefaultBoundedRangeModel model4 = new DefaultBoundedRangeModel(125, 0, 50, 200);
		slider4 = new JSlider(model4);
		slider4.setMajorTickSpacing(50);
		slider4.setMinorTickSpacing(10);
		slider4.setPaintTicks(true);
		slider4.setPaintLabels(true);
		slider4.setLocation(1000, 350);
		slider4.setSize(300, 60);
		slider4.addChangeListener(new MyChangeListener());
		this.add(slider4);

		// add label for l2
		JLabel label4 = new JLabel("lenght of pendulum 2:");
		label4.setBounds(1065, 327, 200, 30);
		label4.setFont(f1);
		this.add(label4);

		// add slider for start angel1
		DefaultBoundedRangeModel model5 = new DefaultBoundedRangeModel(180, 0, 0, 360);
		slider5 = new JSlider(model5);
		slider5.setMajorTickSpacing(90);
		slider5.setMinorTickSpacing(30);
		slider5.setPaintTicks(true);
		slider5.setPaintLabels(true);
		slider5.setLocation(1000, 450);
		slider5.setSize(300, 60);
		slider5.addChangeListener(new MyChangeListener());
		this.add(slider5);

		// add label for start angle1
		JLabel label5 = new JLabel("angle of pendulum 1:");
		label5.setBounds(1070, 427, 200, 30);
		label5.setFont(f1);
		this.add(label5);

		// add slider for start angle2
		DefaultBoundedRangeModel model6 = new DefaultBoundedRangeModel(90, 0, 0, 360);
		slider6 = new JSlider(model6);
		slider6.setMajorTickSpacing(90);
		slider6.setMinorTickSpacing(30);
		slider6.setPaintTicks(true);
		slider6.setPaintLabels(true);
		slider6.setLocation(1000, 550);
		slider6.setSize(300, 60);
		slider6.addChangeListener(new MyChangeListener());
		this.add(slider6);

		// add label for start angle2
		JLabel label6 = new JLabel("angle of pendulum 2:");
		label6.setBounds(1070, 527, 200, 30);
		label6.setFont(f1);
		this.add(label6);

		// add slider for gravitational constant
		DefaultBoundedRangeModel model7 = new DefaultBoundedRangeModel(1, 0, 0, 20);
		slider7 = new JSlider(model7);
		slider7.setMajorTickSpacing(5);
		slider7.setMinorTickSpacing(1);
		slider7.setPaintTicks(true);
		slider7.setPaintLabels(true);
		slider7.setLocation(1000, 650);
		slider7.setSize(300, 60);
		slider7.addChangeListener(new MyChangeListener());
		this.add(slider7);

		// add slider for gravitational constant
		JLabel label7 = new JLabel("gravitational constant:");
		label7.setBounds(1060, 627, 200, 30);
		label7.setFont(f1);
		this.add(label7);

		// add slider for frames per second
		DefaultBoundedRangeModel model8 = new DefaultBoundedRangeModel(60, 0, 0, 120);
		slider8 = new JSlider(model8);
		slider8.setMajorTickSpacing(30);
		slider8.setMinorTickSpacing(6);
		slider8.setPaintTicks(true);
		slider8.setPaintLabels(true);
		slider8.setLocation(1000, 750);
		slider8.setSize(300, 60);
		slider8.addChangeListener(new MyChangeListener());
		this.add(slider8);

		// add slider for frames per second
		JLabel label8 = new JLabel("frames per second:");
		label8.setBounds(1070, 730, 200, 30);
		label8.setFont(f1);
		this.add(label8);

		// add checkbox for drag
		checkbox1 = new JCheckBox("add friction");
		checkbox1.setBounds(1090, 830, 200, 30);
		checkbox1.addActionListener(new MyActionListener());
		checkbox1.setFont(f1);
		this.add(checkbox1);
		
		// add pause/resume button
		button1 = new JButton("pause");
		button1.addActionListener(new MyActionListener());
		button1.setBounds(1010, 880, 150, 30);
		button1.setFont(f1);
		this.add(button1);
		
		// add pause/resume button
		button2 = new JButton("reset");
		button2.addActionListener(new MyActionListener());
		button2.setBounds(1190, 880, 150, 30);
		button2.setFont(f1);
		this.add(button2);

		this.setVisible(true);

		// simulation loop
		dc.simulate();
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == Gui.this.checkbox1) {
				dc.dragOn = Gui.this.checkbox1.isSelected();
			}else if (ae.getSource() == Gui.this.checkbox2) {
				// TODO
			}else if(ae.getSource() == Gui.this.button1) {
				if(dc.pause) {
					Gui.this.button1.setText("pause");
					dc.pause = false;
				}else {
					Gui.this.button1.setText("resume");
					dc.pause = true;
				}
			}else if(ae.getSource() == Gui.this.button2) {
				dc.reset = true;
			}
		}
	}
	
	class MyChangeListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent ae) {
			if (ae.getSource() == Gui.this.slider1 && Gui.this.slider1.getValue() != 0) {
				dc.m1 = Gui.this.slider1.getValue();
			} else if (ae.getSource() == Gui.this.slider2 && Gui.this.slider2.getValue() != 0) {
				dc.m2 = Gui.this.slider2.getValue();
			} else if (ae.getSource() == Gui.this.slider3) {
				dc.l1 = Gui.this.slider3.getValue();
			} else if (ae.getSource() == Gui.this.slider4) {
				dc.l2 = Gui.this.slider4.getValue();
			} else if (ae.getSource() == Gui.this.slider5) {
				dc.start_a1 = Math.PI * (Gui.this.slider5.getValue() / 180) ;
			} else if (ae.getSource() == Gui.this.slider6) {
				dc.start_a2 = Math.PI * (Gui.this.slider6.getValue() / 180) ;
			} else if (ae.getSource() == Gui.this.slider7) {
				dc.G = Gui.this.slider7.getValue();
			} else if (ae.getSource() == Gui.this.slider8) {
				if(Gui.this.slider8.getValue() != 0) {
					dc.pause = false;
					dc.FPS = Gui.this.slider8.getValue();
				}else
					dc.pause = true;
			}
		}
		
	}
}
