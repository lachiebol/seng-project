package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneralStore {

	private JFrame window;
	private GameManager manager;
	
	public GeneralStore(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGeneralStore(this);
	}
	/**
	 * Launch the application.
	 * @param args .
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStore window = new GeneralStore();
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
	public GeneralStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("General Store");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the General Store. What would you like to look at?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 28, 572, 38);
		window.getContentPane().add(lblNewLabel);
		
		JButton animalsButton = new JButton("Animals");
		animalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				manager.launchGeneralStoreAnimals();
				finishedWindow();
			}
		});
		animalsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		animalsButton.setBounds(60, 95, 206, 106);
		window.getContentPane().add(animalsButton);
		
		JButton cropsButton = new JButton("Crops");
		cropsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchGeneralStoreCrops();
				finishedWindow();
			}
		});
		cropsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cropsButton.setBounds(315, 95, 206, 106);
		window.getContentPane().add(cropsButton);
		
		JButton cropItemsButton = new JButton("Crop Items");
		cropItemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchGeneralStoreCropItems();
				finishedWindow();
			}
		});
		cropItemsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cropItemsButton.setBounds(315, 243, 206, 106);
		window.getContentPane().add(cropItemsButton);
		
		JButton foodButton = new JButton("Food");
		foodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchGeneralStoreFood();
				finishedWindow();
			}
		});
		foodButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		foodButton.setBounds(60, 243, 206, 106);
		window.getContentPane().add(foodButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFarmScreen();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(457, 371, 137, 46);
		window.getContentPane().add(backButton);
	}
}
