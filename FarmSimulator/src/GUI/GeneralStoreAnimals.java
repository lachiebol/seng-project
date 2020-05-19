package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextArea;

import animal.Chicken;
import animal.Cow;
import animal.Sheep;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneralStoreAnimals {

	private JFrame window;
	private GameManager manager;
	private JLabel freeSpaceLabel;
	
	GeneralStoreAnimals(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGeneralStoreAnimals(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreAnimals window = new GeneralStoreAnimals();
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
	public GeneralStoreAnimals() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("General Store - Animals");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chicken - $30:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(30, 73, 180, 59);
		window.getContentPane().add(lblNewLabel);
		
		JLabel freeSpaceLabel = new JLabel("Free Space: $0");
		freeSpaceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		freeSpaceLabel.setBounds(380, 88, 218, 25);
		window.getContentPane().add(freeSpaceLabel);
		freeSpaceLabel.setText("Free Space: " + Integer.toString(manager.playerFarm.freeSpace));
		
		JLabel moneyLabel = new JLabel("Money: $" + Integer.toString(manager.playerFarm.money));
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		moneyLabel.setBounds(380, 56, 218, 25);
		window.getContentPane().add(moneyLabel);
		
		JLabel lblSheep = new JLabel("Sheep - $40:");
		lblSheep.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSheep.setBounds(30, 198, 180, 59);
		window.getContentPane().add(lblSheep);
		
		JTextArea feedback = new JTextArea();
		feedback.setEditable(false);
		feedback.setBounds(375, 127, 223, 229);
		window.getContentPane().add(feedback);
		
		JLabel lblCow = new JLabel("Cow - $50:");
		lblCow.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCow.setBounds(30, 321, 180, 59);
		window.getContentPane().add(lblCow);
		
		JSlider chickenSlider = new JSlider();
		chickenSlider.setPaintLabels(true);
		chickenSlider.setMajorTickSpacing(1);
		chickenSlider.setPaintTicks(true);
		chickenSlider.setSnapToTicks(true);
		chickenSlider.setMinimum(1);
		chickenSlider.setValue(1);
		chickenSlider.setMinorTickSpacing(1);
		chickenSlider.setMaximum(5);
		chickenSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chickenSlider.setBounds(20, 127, 200, 42);
		window.getContentPane().add(chickenSlider);
		
		JLabel lblNewLabel_1 = new JLabel("Which animal, and how many do you want to purchase?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 11, 606, 51);
		window.getContentPane().add(lblNewLabel_1);
		
		JButton buyChickenButton = new JButton("Buy");
		buyChickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= chickenSlider.getValue(); i += 1) {
					manager.playerFarm.buyAnimal(new Chicken());
					feedback.append("\n" + manager.playerFarm.output);
				}
				moneyLabel.setText("Money: $" + Integer.toString(manager.playerFarm.money));
				freeSpaceLabel.setText("Free Space: " + Integer.toString(manager.playerFarm.freeSpace));
			}
		});
		buyChickenButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		buyChickenButton.setBounds(230, 123, 104, 51);
		window.getContentPane().add(buyChickenButton);
		
		JSlider sheepSlider = new JSlider();
		sheepSlider.setPaintLabels(true);
		sheepSlider.setValue(1);
		sheepSlider.setSnapToTicks(true);
		sheepSlider.setPaintTicks(true);
		sheepSlider.setMinorTickSpacing(1);
		sheepSlider.setMinimum(1);
		sheepSlider.setMaximum(5);
		sheepSlider.setMajorTickSpacing(1);
		sheepSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sheepSlider.setBounds(20, 255, 200, 42);
		window.getContentPane().add(sheepSlider);
		
		JButton buySheepButton = new JButton("Buy");
		buySheepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= sheepSlider.getValue(); i += 1) {
					manager.playerFarm.buyAnimal(new Sheep());
					feedback.append("\n" + manager.playerFarm.output);
				}
				moneyLabel.setText("Money: $" + Integer.toString(manager.playerFarm.money));
				freeSpaceLabel.setText("Free Space: " + Integer.toString(manager.playerFarm.freeSpace));
			}
		});
		buySheepButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		buySheepButton.setBounds(230, 255, 104, 51);
		window.getContentPane().add(buySheepButton);
		
		JSlider cowSlider = new JSlider();
		cowSlider.setPaintLabels(true);
		cowSlider.setValue(1);
		cowSlider.setSnapToTicks(true);
		cowSlider.setPaintTicks(true);
		cowSlider.setMinorTickSpacing(1);
		cowSlider.setMinimum(1);
		cowSlider.setMaximum(5);
		cowSlider.setMajorTickSpacing(1);
		cowSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cowSlider.setBounds(20, 370, 200, 42);
		window.getContentPane().add(cowSlider);
		
		JButton buyCowButton = new JButton("Buy");
		buyCowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= cowSlider.getValue(); i += 1) {
					manager.playerFarm.buyAnimal(new Cow());
					feedback.append("\n" + manager.playerFarm.output);
				}
				moneyLabel.setText("Money: $" + Integer.toString(manager.playerFarm.money));
				freeSpaceLabel.setText("Free Space: " + Integer.toString(manager.playerFarm.freeSpace));
			}
		});
		buyCowButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		buyCowButton.setBounds(230, 370, 104, 51);
		window.getContentPane().add(buyCowButton);
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchGeneralStore();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		backButton.setBounds(484, 381, 117, 51);
		window.getContentPane().add(backButton);
	}
}
