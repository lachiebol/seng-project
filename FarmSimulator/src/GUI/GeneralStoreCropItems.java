package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class GeneralStoreCropItems {

	private JFrame frmGeneralStore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreCropItems window = new GeneralStoreCropItems();
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
	public GeneralStoreCropItems() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneralStore = new JFrame();
		frmGeneralStore.setTitle("General Store - Crop Items");
		frmGeneralStore.setBounds(100, 100, 640, 480);
		frmGeneralStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneralStore.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(385, 96, 231, 246);
		frmGeneralStore.getContentPane().add(textArea);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button.setBounds(499, 381, 117, 51);
		frmGeneralStore.getContentPane().add(button);
		
		JLabel lblWhichCropItem = new JLabel("Which crop item, and how many do you want to purchase?");
		lblWhichCropItem.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblWhichCropItem.setBounds(10, 11, 616, 51);
		frmGeneralStore.getContentPane().add(lblWhichCropItem);
		
		JLabel lblAutomaticSprinkler = new JLabel("Scare Crow:");
		lblAutomaticSprinkler.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAutomaticSprinkler.setBounds(41, 73, 179, 59);
		frmGeneralStore.getContentPane().add(lblAutomaticSprinkler);
		
		JSlider slider = new JSlider();
		slider.setValue(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setMajorTickSpacing(2);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider.setBounds(20, 141, 200, 19);
		frmGeneralStore.getContentPane().add(slider);
		
		JLabel lblAutomaticSprinkler_1 = new JLabel("Automatic Sprinkler:");
		lblAutomaticSprinkler_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAutomaticSprinkler_1.setBounds(20, 196, 250, 59);
		frmGeneralStore.getContentPane().add(lblAutomaticSprinkler_1);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMinimum(1);
		slider_1.setMaximum(5);
		slider_1.setMajorTickSpacing(2);
		slider_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_1.setBounds(20, 266, 200, 19);
		frmGeneralStore.getContentPane().add(slider_1);
		
		JLabel lblFertilizer = new JLabel("Fertilizer:");
		lblFertilizer.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblFertilizer.setBounds(55, 319, 110, 59);
		frmGeneralStore.getContentPane().add(lblFertilizer);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(1);
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMinimum(1);
		slider_2.setMaximum(5);
		slider_2.setMajorTickSpacing(2);
		slider_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider_2.setBounds(20, 389, 200, 19);
		frmGeneralStore.getContentPane().add(slider_2);
		
		JButton button_1 = new JButton("Buy");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_1.setBounds(230, 368, 104, 51);
		frmGeneralStore.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Buy");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_2.setBounds(230, 244, 104, 51);
		frmGeneralStore.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Buy");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button_3.setBounds(230, 121, 104, 51);
		frmGeneralStore.getContentPane().add(button_3);
	}

}
