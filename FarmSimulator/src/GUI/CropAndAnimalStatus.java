package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CropAndAnimalStatus {

	private JFrame window;
	private GameManager manager;
	
	public CropAndAnimalStatus(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeCropAndAnimalStatus(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CropAndAnimalStatus window = new CropAndAnimalStatus();
					window.window.setVisible(true);
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
		window = new JFrame();
		window.setTitle("Crop and Animal Status");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("These are your animals:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(34, 11, 227, 33);
		window.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(16, 51, 241, 151);
		window.getContentPane().add(textArea);
		
		JLabel lblTheseAreYour = new JLabel("These are your crops:");
		lblTheseAreYour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTheseAreYour.setBounds(34, 237, 227, 33);
		window.getContentPane().add(lblTheseAreYour);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(20, 281, 241, 151);
		window.getContentPane().add(textArea_1);
		
		JButton btnNewButton = new JButton("Play with Animal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchPlayWithAnimal();
				finishedWindow();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(355, 20, 206, 52);
		window.getContentPane().add(btnNewButton);
		
		JButton btnFeedAnimal = new JButton("Feed Animal");
		btnFeedAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFeedAnimal();
				finishedWindow();
			}
		});
		btnFeedAnimal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFeedAnimal.setBounds(355, 83, 206, 52);
		window.getContentPane().add(btnFeedAnimal);
		
		JButton btnTendToAnimal = new JButton("Tend to Animal");
		btnTendToAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchTendToAnimal();
				finishedWindow();
			}
		});
		btnTendToAnimal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendToAnimal.setBounds(355, 146, 206, 52);
		window.getContentPane().add(btnTendToAnimal);
		
		JButton btnTendToCrops = new JButton("Tend to Crop");
		btnTendToCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchTendToCrop();
				finishedWindow();
			}
		});
		btnTendToCrops.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendToCrops.setBounds(355, 209, 206, 52);
		window.getContentPane().add(btnTendToCrops);
		
		JButton btnHarvestCrop = new JButton("Harvest Crop");
		btnHarvestCrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchHarvestCrop();
				finishedWindow();
			}
		});
		btnHarvestCrop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHarvestCrop.setBounds(355, 273, 206, 52);
		window.getContentPane().add(btnHarvestCrop);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFarmScreen();
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(355, 380, 206, 52);
		window.getContentPane().add(btnBack);
	}

}
