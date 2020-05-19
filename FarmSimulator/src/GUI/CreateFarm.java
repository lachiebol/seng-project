package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;

import Farms.Farm;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class CreateFarm {
	
	private JFrame frame;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField farmNameTextField;
	private GameManager manager;
	
	public CreateFarm(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeSetupScreen(this);
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateFarm window = new CreateFarm();
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
	public CreateFarm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String farmType;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Farmer!\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 181, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblWhatIsYour = new JLabel("What is your name?\r\n");
		lblWhatIsYour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhatIsYour.setBounds(10, 71, 181, 29);
		frame.getContentPane().add(lblWhatIsYour);
		
		JLabel lblWhatIsYour_1 = new JLabel("What is your age?\r\n");
		lblWhatIsYour_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhatIsYour_1.setBounds(10, 111, 181, 29);
		frame.getContentPane().add(lblWhatIsYour_1);
		
		JLabel lblPickAName = new JLabel("Pick a name for your farm:");
		lblPickAName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickAName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickAName.setBounds(10, 151, 240, 37);
		frame.getContentPane().add(lblPickAName);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(286, 79, 204, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(286, 119, 59, 20);
		frame.getContentPane().add(ageTextField);
		
		farmNameTextField = new JTextField();
		farmNameTextField.setColumns(10);
		farmNameTextField.setBounds(286, 163, 240, 20);
		frame.getContentPane().add(farmNameTextField);
		
		JLabel nameErrorLabel = new JLabel("");
		nameErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameErrorLabel.setBounds(286, 54, 328, 14);
		frame.getContentPane().add(nameErrorLabel);
		
		JLabel ageErrorLabel = new JLabel("");
		ageErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ageErrorLabel.setBounds(355, 122, 259, 14);
		frame.getContentPane().add(ageErrorLabel);
		
		JLabel farmNameErrorLabel = new JLabel("\r\n");
		farmNameErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		farmNameErrorLabel.setBounds(286, 194, 328, 14);
		frame.getContentPane().add(farmNameErrorLabel);
		
		JTextPane txtpnPickAFarm = new JTextPane();
		txtpnPickAFarm.setEditable(false);
		txtpnPickAFarm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnPickAFarm.setText("Pick a farm type, each farm gives bonuses for owning things that belong on that farm\r\n");
		txtpnPickAFarm.setBackground(SystemColor.menu);
		txtpnPickAFarm.setBounds(10, 218, 231, 109);
		frame.getContentPane().add(txtpnPickAFarm);
		
		JLabel pickedFarmTypeLabel = new JLabel("");
		pickedFarmTypeLabel.setBounds(10, 338, 240, 14);
		frame.getContentPane().add(pickedFarmTypeLabel);
		
		JButton btnChickenFarm = new JButton("Chicken Farm");
		btnChickenFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pickedFarmTypeLabel.setText("You have picked a Chicken Farm");
				manager.setFarmType("Chicken Farm");
			}
		});
		btnChickenFarm.setBounds(286, 221, 125, 37);
		frame.getContentPane().add(btnChickenFarm);
		
		JButton btnCropFarm = new JButton("Crop Farm\r\n");
		btnCropFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pickedFarmTypeLabel.setText("You have picked a Crop Farm");
				manager.setFarmType("Crop Farm");
				
			}
		});
		btnCropFarm.setBounds(286, 255, 125, 37);
		frame.getContentPane().add(btnCropFarm);
		
		JButton btnSheepFarm = new JButton("Sheep Farm\r\n");
		btnSheepFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pickedFarmTypeLabel.setText("You have picked a Sheep Farm");
				manager.setFarmType("Sheep Farm");
			}
		});
		btnSheepFarm.setBounds(286, 289, 125, 37);
		frame.getContentPane().add(btnSheepFarm);
		
		JButton btnDairyFarm = new JButton("Dairy Farm\r\n");
		btnDairyFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pickedFarmTypeLabel.setText("You have picked a Dairy Farm");
				manager.setFarmType("Dairy Farm");
			}
		});
		btnDairyFarm.setBounds(286, 324, 125, 37);
		frame.getContentPane().add(btnDairyFarm);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ageInput = ageTextField.getText();
				int age = 0;
				
				String name = nameTextField.getText();				
				String farmName = farmNameTextField.getText();
				
				boolean typePicked = false;
				
				try {
					age = Integer.parseInt(ageInput);
					
					if(age < 18 || age >= 100) {
						ageErrorLabel.setText("Incorrect Input, age must be between 18 and 100");
					}else{
						ageErrorLabel.setText("");
					}
					
				} catch (NumberFormatException nfe) {
					ageErrorLabel.setText("That isn't a number");
				}
				
		
				

				
				if (name.matches(".*\\d.*")) {
					nameErrorLabel.setText("No numbers allowed");
				}else if (name.length() < 3 || name.length() > 15) {
					nameErrorLabel.setText("Your name must be between 3 and 15 characters");
				}else {
					nameErrorLabel.setText("");
				}
				
				if (farmName.matches(".*\\d.*")) {
					farmNameErrorLabel.setText("No numbers allowed");
				}else if (farmName.length() < 3 || farmName.length() > 30) {
					farmNameErrorLabel.setText("Your farm name must be between 3 and 30 characters");
				}else {
					farmNameErrorLabel.setText("");
				}
				
				System.out.println(manager.farmType);
				if (manager.farmType == null) {
					pickedFarmTypeLabel.setText("You have to pick a farm type");
				}else {
					typePicked = true;
				}
				
				
				
				if(nameErrorLabel.getText() == "" && ageErrorLabel.getText() == "" 
						&& farmNameErrorLabel.getText() == "" && typePicked && manager.gameLength != 0) {
					manager.setAge(age);
					manager.setFarmName(farmName);
					manager.setName(name);
					
					finishedWindow();
				}
				
				
			}
		});
		btnNewButton.setBounds(469, 254, 145, 63);
		frame.getContentPane().add(btnNewButton);
		
		JLabel pickedGameLengthLabel = new JLabel("");
		pickedGameLengthLabel.setBounds(441, 382, 173, 37);
		frame.getContentPane().add(pickedGameLengthLabel);
		
		JTextPane txtpnPickTheDuration = new JTextPane();
		txtpnPickTheDuration.setText("Pick the duration of your game");
		txtpnPickTheDuration.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnPickTheDuration.setEditable(false);
		txtpnPickTheDuration.setBackground(SystemColor.menu);
		txtpnPickTheDuration.setBounds(10, 369, 169, 63);
		frame.getContentPane().add(txtpnPickTheDuration);
		
		JButton daysButton5 = new JButton("5 Days");
		daysButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.gameLength = 5;
				pickedGameLengthLabel.setText("5 day game selected");
			}
		});
		daysButton5.setBounds(180, 382, 125, 37);
		frame.getContentPane().add(daysButton5);
		
		JButton daysButton10 = new JButton("10 Days");
		daysButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.gameLength = 10;
				pickedGameLengthLabel.setText("10 day game selected");
			}
		});
		daysButton10.setBounds(306, 382, 125, 37);
		frame.getContentPane().add(daysButton10);
		


		

	}
}
