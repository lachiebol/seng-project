package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GeneralStoreAnimals {

	private JFrame frmGeneralStore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreAnimals window = new GeneralStoreAnimals();
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
	public GeneralStoreAnimals() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneralStore = new JFrame();
		frmGeneralStore.setTitle("General Store - Animals");
		frmGeneralStore.setBounds(100, 100, 640, 480);
		frmGeneralStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneralStore.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chicken:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(55, 73, 110, 59);
		frmGeneralStore.getContentPane().add(lblNewLabel);
		
		JLabel lblSheep = new JLabel("Sheep:");
		lblSheep.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSheep.setBounds(55, 198, 110, 59);
		frmGeneralStore.getContentPane().add(lblSheep);
		
		JLabel lblCow = new JLabel("Cow:");
		lblCow.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCow.setBounds(55, 321, 110, 59);
		frmGeneralStore.getContentPane().add(lblCow);
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(2);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinimum(1);
		slider.setValue(1);
		slider.setMinorTickSpacing(1);
		slider.setMaximum(5);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider.setBounds(20, 143, 200, 19);
		frmGeneralStore.getContentPane().add(slider);
		
		JLabel lblNewLabel_1 = new JLabel("Which animal, and how many do you want to purchase?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 11, 606, 51);
		frmGeneralStore.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(230, 123, 104, 51);
		frmGeneralStore.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Buy");
		button.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button.setBounds(230, 246, 104, 51);
		frmGeneralStore.getContentPane().add(button);
		
		JButton button_1 = new JButton("Buy");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_1.setBounds(230, 370, 104, 51);
		frmGeneralStore.getContentPane().add(button_1);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMinimum(1);
		slider_1.setMaximum(5);
		slider_1.setMajorTickSpacing(2);
		slider_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_1.setBounds(20, 268, 200, 19);
		frmGeneralStore.getContentPane().add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(1);
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMinimum(1);
		slider_2.setMaximum(5);
		slider_2.setMajorTickSpacing(2);
		slider_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_2.setBounds(20, 391, 200, 19);
		frmGeneralStore.getContentPane().add(slider_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(370, 96, 231, 246);
		frmGeneralStore.getContentPane().add(textArea);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_1.setBounds(484, 381, 117, 51);
		frmGeneralStore.getContentPane().add(btnNewButton_1);
	}
}
