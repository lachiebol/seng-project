package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GeneralStoreFood {

	private JFrame frmGeneralStore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreFood window = new GeneralStoreFood();
					window.frmGeneralStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GeneralStoreFood() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneralStore = new JFrame();
		frmGeneralStore.setTitle("General Store - Food");
		frmGeneralStore.getContentPane().setLayout(null);
		
		JLabel lblCarrot = new JLabel("Carrot:");
		lblCarrot.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCarrot.setBounds(58, 84, 110, 59);
		frmGeneralStore.getContentPane().add(lblCarrot);
		
		JSlider slider = new JSlider();
		slider.setValue(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setMajorTickSpacing(2);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider.setBounds(23, 154, 200, 19);
		frmGeneralStore.getContentPane().add(slider);
		
		JLabel lblSeeds = new JLabel("Seeds:");
		lblSeeds.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSeeds.setBounds(58, 209, 110, 59);
		frmGeneralStore.getContentPane().add(lblSeeds);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMinimum(1);
		slider_1.setMaximum(5);
		slider_1.setMajorTickSpacing(2);
		slider_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_1.setBounds(23, 279, 200, 19);
		frmGeneralStore.getContentPane().add(slider_1);
		
		JLabel lblHay = new JLabel("Hay:");
		lblHay.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHay.setBounds(58, 332, 110, 59);
		frmGeneralStore.getContentPane().add(lblHay);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(1);
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMinimum(1);
		slider_2.setMaximum(5);
		slider_2.setMajorTickSpacing(2);
		slider_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_2.setBounds(23, 402, 200, 19);
		frmGeneralStore.getContentPane().add(slider_2);
		
		JButton button = new JButton("Buy");
		button.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button.setBounds(233, 381, 104, 51);
		frmGeneralStore.getContentPane().add(button);
		
		JButton button_1 = new JButton("Buy");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_1.setBounds(233, 257, 104, 51);
		frmGeneralStore.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Buy");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_2.setBounds(233, 134, 104, 51);
		frmGeneralStore.getContentPane().add(button_2);
		
		JLabel lblWhichFoodAnd = new JLabel("Which food, and how much do you want to purchase?");
		lblWhichFoodAnd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWhichFoodAnd.setBounds(20, 11, 606, 51);
		frmGeneralStore.getContentPane().add(lblWhichFoodAnd);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(385, 96, 231, 246);
		frmGeneralStore.getContentPane().add(textArea);
		
		JButton button_3 = new JButton("Back");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_3.setBounds(499, 381, 117, 51);
		frmGeneralStore.getContentPane().add(button_3);
	}

}
