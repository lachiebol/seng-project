package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import animal.Animal;
import food.Food;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeedAnimal2 {

	private JFrame window;
	private JTextField input;
	private GameManager manager;
	
	public FeedAnimal2(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeFeedAnimal2(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedAnimal2 window = new FeedAnimal2();
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
	public FeedAnimal2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Feed Animal");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to feed this animal?");
		lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhatWouldYou.setBounds(25, 24, 380, 32);
		window.getContentPane().add(lblWhatWouldYou);
		
		JTextArea feedback = new JTextArea();
		feedback.setEditable(false);
		feedback.setBounds(313, 256, 196, 68);
		window.getContentPane().add(feedback);
		
		JTextArea foodList = new JTextArea();
		foodList.setEditable(false);
		foodList.setBounds(35, 67, 242, 314);
		window.getContentPane().add(foodList);
		foodList.setText("   Food        Health Boost");
		for (Food food : manager.playerFarm.listOfFood) {
			foodList.append("\n" + (manager.playerFarm.listOfFood.indexOf(food) + 1) + "  " 
					+ food.name + "          "+ food.healthBoost);
		}
		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setColumns(10);
		input.setBounds(365, 146, 96, 44);
		window.getContentPane().add(input);
		
		JButton feedButton = new JButton("Feed");
		feedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String indexInput = input.getText();
				int index = 0;
				index = Integer.parseInt(indexInput) - 1;
				if ((index <= manager.playerFarm.listOfAnimals.size()) && (index >= 0)) {
					manager.playerFarm.listOfAnimals.get(manager.feedAnimalIndex).
					feed(manager.playerFarm.listOfFood.get(index), manager.playerFarm);
					foodList.setText("   " + "Food" + "          " + "Health Boost");
					for (Food food : manager.playerFarm.listOfFood) {
						foodList.append("\n" + (manager.playerFarm.listOfFood.indexOf(food) + 1) + "  " 
								+ food.name + "          " +  food.healthBoost);
					}
					feedback.setText(manager.playerFarm.output);
					}
				else {
						feedback.setText("Please enter a valid number");
					}
				}
		});
		feedButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		feedButton.setBounds(365, 201, 96, 44);
		window.getContentPane().add(feedButton);
		
		JLabel lblNewLabel = new JLabel("Enter the number corresponding");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(297, 97, 236, 37);
		window.getContentPane().add(lblNewLabel);
		
		JLabel lblToTheFood = new JLabel("to the food.");
		lblToTheFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheFood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToTheFood.setBounds(365, 116, 96, 37);
		window.getContentPane().add(lblToTheFood);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFeedAnimal();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(507, 362, 96, 56);
		window.getContentPane().add(backButton);
	}

}
