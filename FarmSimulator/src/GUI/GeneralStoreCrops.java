package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class GeneralStoreCrops {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreCrops window = new GeneralStoreCrops();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GeneralStoreCrops() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWhichCropAnd = new JLabel("Which crop, and how many do you want to purchase?");
		lblWhichCropAnd.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblWhichCropAnd.setBounds(40, 11, 558, 51);
		frame.getContentPane().add(lblWhichCropAnd);
		
		JLabel label = new JLabel("Sheep:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(40, 125, 110, 59);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Chicken:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBounds(40, 58, 110, 32);
		frame.getContentPane().add(label_1);
		
		JSlider slider = new JSlider();
		slider.setValue(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setMajorTickSpacing(2);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider.setBounds(23, 95, 156, 19);
		frame.getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMinimum(1);
		slider_1.setMaximum(5);
		slider_1.setMajorTickSpacing(2);
		slider_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_1.setBounds(23, 175, 156, 19);
		frame.getContentPane().add(slider_1);
		
		JLabel label_2 = new JLabel("Cow:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_2.setBounds(40, 205, 110, 59);
		frame.getContentPane().add(label_2);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(1);
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMinimum(1);
		slider_2.setMaximum(5);
		slider_2.setMajorTickSpacing(2);
		slider_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_2.setBounds(23, 256, 156, 19);
		frame.getContentPane().add(slider_2);
		
		JButton button = new JButton("Buy");
		button.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button.setBounds(189, 237, 83, 51);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Buy");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_1.setBounds(189, 156, 83, 51);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Buy");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_2.setBounds(189, 74, 83, 51);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Buy");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_3.setBounds(515, 237, 83, 51);
		frame.getContentPane().add(button_3);
		
		JSlider slider_3 = new JSlider();
		slider_3.setValue(1);
		slider_3.setSnapToTicks(true);
		slider_3.setPaintTicks(true);
		slider_3.setMinorTickSpacing(1);
		slider_3.setMinimum(1);
		slider_3.setMaximum(5);
		slider_3.setMajorTickSpacing(2);
		slider_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_3.setBounds(349, 256, 156, 19);
		frame.getContentPane().add(slider_3);
		
		JLabel label_3 = new JLabel("Cow:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_3.setBounds(366, 205, 110, 59);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Sheep:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_4.setBounds(366, 125, 110, 59);
		frame.getContentPane().add(label_4);
		
		JButton button_4 = new JButton("Buy");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_4.setBounds(515, 156, 83, 51);
		frame.getContentPane().add(button_4);
		
		JSlider slider_4 = new JSlider();
		slider_4.setValue(1);
		slider_4.setSnapToTicks(true);
		slider_4.setPaintTicks(true);
		slider_4.setMinorTickSpacing(1);
		slider_4.setMinimum(1);
		slider_4.setMaximum(5);
		slider_4.setMajorTickSpacing(2);
		slider_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_4.setBounds(349, 175, 156, 19);
		frame.getContentPane().add(slider_4);
		
		JButton button_5 = new JButton("Buy");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_5.setBounds(515, 74, 83, 51);
		frame.getContentPane().add(button_5);
		
		JSlider slider_5 = new JSlider();
		slider_5.setValue(1);
		slider_5.setSnapToTicks(true);
		slider_5.setPaintTicks(true);
		slider_5.setMinorTickSpacing(1);
		slider_5.setMinimum(1);
		slider_5.setMaximum(5);
		slider_5.setMajorTickSpacing(2);
		slider_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_5.setBounds(349, 95, 156, 19);
		frame.getContentPane().add(slider_5);
		
		JLabel label_5 = new JLabel("Chicken:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_5.setBounds(366, 58, 110, 32);
		frame.getContentPane().add(label_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 309, 387, 123);
		frame.getContentPane().add(textArea);
		
		JButton button_6 = new JButton("Back");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_6.setBounds(481, 381, 117, 51);
		frame.getContentPane().add(button_6);
	}

}
