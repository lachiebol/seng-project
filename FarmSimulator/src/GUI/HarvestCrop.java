package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HarvestCrop {

	private JFrame frmHarvestCrop;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HarvestCrop window = new HarvestCrop();
					window.frmHarvestCrop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HarvestCrop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHarvestCrop = new JFrame();
		frmHarvestCrop.setTitle("Harvest Crop");
		frmHarvestCrop.setBounds(100, 100, 640, 480);
		frmHarvestCrop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHarvestCrop.getContentPane().setLayout(null);
		
		JLabel lblWhichCropWould = new JLabel("Which crop would you like to harvest?");
		lblWhichCropWould.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhichCropWould.setBounds(10, 11, 370, 31);
		frmHarvestCrop.getContentPane().add(lblWhichCropWould);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(36, 80, 242, 269);
		frmHarvestCrop.getContentPane().add(textArea);
		
		JLabel label_1 = new JLabel("Enter the number corresponding");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(298, 110, 236, 37);
		frmHarvestCrop.getContentPane().add(label_1);
		
		JLabel lblToTheCrop = new JLabel("to the crop.");
		lblToTheCrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheCrop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToTheCrop.setBounds(352, 131, 123, 37);
		frmHarvestCrop.getContentPane().add(lblToTheCrop);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(366, 159, 96, 44);
		frmHarvestCrop.getContentPane().add(textField);
		
		JButton btnHarvest = new JButton("Harvest");
		btnHarvest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHarvest.setBounds(352, 214, 123, 44);
		frmHarvestCrop.getContentPane().add(btnHarvest);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(317, 281, 196, 68);
		frmHarvestCrop.getContentPane().add(textArea_1);
		
		JButton button_1 = new JButton("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(508, 358, 96, 56);
		frmHarvestCrop.getContentPane().add(button_1);
	}

}
