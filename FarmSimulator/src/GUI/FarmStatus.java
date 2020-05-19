package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class FarmStatus {

	private JFrame frame;
	private GameManager manager;
	private JTextField feedback;
	
	public FarmStatus(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeFarmStatusScreen(this);
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmStatus window = new FarmStatus();
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
	public FarmStatus() {
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
		
		JLabel playerDetailsLabel = new JLabel(manager.player.name + ", " + manager.player.age);
		playerDetailsLabel.setBackground(Color.WHITE);
		playerDetailsLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		playerDetailsLabel.setBounds(10, 11, 279, 97);
		frame.getContentPane().add(playerDetailsLabel);
		
		JLabel farmDetailsLabel = new JLabel(manager.playerFarm.name + ", " + manager.playerFarm.type);
		farmDetailsLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		farmDetailsLabel.setBounds(335, 11, 279, 97);
		frame.getContentPane().add(farmDetailsLabel);
		
		JLabel playerMoneyLabel = new JLabel("You currently have $" + manager.playerFarm.money);
		playerMoneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playerMoneyLabel.setBounds(10, 119, 279, 45);
		frame.getContentPane().add(playerMoneyLabel);
		
		JLabel freeSpaceLabel = new JLabel("Your farm currently has " + manager.playerFarm.freeSpace +  " free space");
		freeSpaceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		freeSpaceLabel.setBounds(10, 158, 422, 45);
		frame.getContentPane().add(freeSpaceLabel);
		
		JLabel lblYouHavelength = new JLabel("You have " + manager.playerFarm.listOfAnimals.size() + " animals");
		lblYouHavelength.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYouHavelength.setBounds(10, 214, 422, 45);
		frame.getContentPane().add(lblYouHavelength);
		
		JLabel lblYouHavelength_1 = new JLabel("You have " + manager.playerFarm.listOfCrops.size() + " crops");
		lblYouHavelength_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYouHavelength_1.setBounds(10, 249, 422, 45);
		frame.getContentPane().add(lblYouHavelength_1);
		
		JLabel lblYouHavelength_2 = new JLabel("You have " + manager.playerFarm.listOfItems.size() + " crop items");
		lblYouHavelength_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYouHavelength_2.setBounds(10, 283, 422, 45);
		frame.getContentPane().add(lblYouHavelength_2);
		
		feedback = new JTextField();
		feedback.setBackground(SystemColor.control);
		feedback.setEditable(false);
		feedback.setBounds(171, 386, 177, 29);
		frame.getContentPane().add(feedback);
		feedback.setColumns(10);
		
		JLabel lblYouHavelength_3 = new JLabel("You have " + manager.playerFarm.listOfFood.size() + " food items");
		lblYouHavelength_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYouHavelength_3.setBounds(10, 318, 422, 45);
		frame.getContentPane().add(lblYouHavelength_3);
		
		JButton btnTendToLand = new JButton("Tend to land\r\n");
		btnTendToLand.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendToLand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(manager.playerFarm.freeSpace);
				manager.playerFarm.tendToLand();
				freeSpaceLabel.setText("Your farm currently has " + manager.playerFarm.freeSpace +  " free space");
				feedback.setText(manager.playerFarm.output);
				
			}
		});
		btnTendToLand.setBounds(10, 374, 151, 45);
		frame.getContentPane().add(btnTendToLand);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFarmScreen();
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(463, 374, 151, 45);
		frame.getContentPane().add(btnBack);
		

	}
}
