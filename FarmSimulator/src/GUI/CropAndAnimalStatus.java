package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CropAndAnimalStatus {

	private JFrame frmCropAndAnimal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CropAndAnimalStatus window = new CropAndAnimalStatus();
					window.frmCropAndAnimal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CropAndAnimalStatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCropAndAnimal = new JFrame();
		frmCropAndAnimal.setTitle("Crop and Animal Status");
		frmCropAndAnimal.setBounds(100, 100, 640, 480);
		frmCropAndAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCropAndAnimal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("These are your animals:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(34, 11, 227, 33);
		frmCropAndAnimal.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(16, 51, 241, 151);
		frmCropAndAnimal.getContentPane().add(textArea);
		
		JLabel lblTheseAreYour = new JLabel("These are your crops:");
		lblTheseAreYour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTheseAreYour.setBounds(34, 237, 227, 33);
		frmCropAndAnimal.getContentPane().add(lblTheseAreYour);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(20, 281, 241, 151);
		frmCropAndAnimal.getContentPane().add(textArea_1);
		
		JButton btnNewButton = new JButton("Play with Animal");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(355, 20, 206, 52);
		frmCropAndAnimal.getContentPane().add(btnNewButton);
		
		JButton btnFeedAnimal = new JButton("Feed Animal");
		btnFeedAnimal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFeedAnimal.setBounds(355, 83, 206, 52);
		frmCropAndAnimal.getContentPane().add(btnFeedAnimal);
		
		JButton btnTendToAnimal = new JButton("Tend to Animal");
		btnTendToAnimal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendToAnimal.setBounds(355, 146, 206, 52);
		frmCropAndAnimal.getContentPane().add(btnTendToAnimal);
		
		JButton btnTendToCrops = new JButton("Tend to Crop");
		btnTendToCrops.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendToCrops.setBounds(355, 209, 206, 52);
		frmCropAndAnimal.getContentPane().add(btnTendToCrops);
		
		JButton btnHarvestCrop = new JButton("Harvest Crop");
		btnHarvestCrop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHarvestCrop.setBounds(355, 273, 206, 52);
		frmCropAndAnimal.getContentPane().add(btnHarvestCrop);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(355, 380, 206, 52);
		frmCropAndAnimal.getContentPane().add(btnBack);
	}

}
