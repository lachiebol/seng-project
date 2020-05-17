package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import animal.Animal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeedAnimal {

	private JFrame window;
	private JTextField input;
	private GameManager manager;
	
	public FeedAnimal(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeFeedAnimal(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedAnimal window = new FeedAnimal();
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
	public FeedAnimal() {
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
		
		JLabel lblNewLabel = new JLabel("Which animal would you like to feed?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(25, 24, 343, 32);
		window.getContentPane().add(lblNewLabel);
		
		JTextArea feedback = new JTextArea();
		feedback.setEditable(false);
		feedback.setBounds(316, 268, 196, 68);
		window.getContentPane().add(feedback);
		
		JTextArea animalList = new JTextArea();
		animalList.setEditable(false);
		animalList.setBounds(35, 67, 242, 269);
		window.getContentPane().add(animalList);
		animalList.setText("   " + "Animal" + "         " + "Health");
		for (Animal animal : manager.playerFarm.listOfAnimals) {
			animalList.append("\n" + (manager.playerFarm.listOfAnimals.indexOf(animal) + 1) + "  " + animal.name + animal.health);
		
		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setColumns(10);
		input.setBounds(365, 146, 96, 44);
		window.getContentPane().add(input);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String indexInput = input.getText();
				int index = 0;
				index = Integer.parseInt(indexInput) - 1;
				if ((index < manager.playerFarm.listOfAnimals.size()) && (index >= 0)) {
					if (manager.playerFarm.listOfAnimals.get(index).health == 100) {
						feedback.setText("That animal isn't hungry");
					}
					else {
						manager.feedAnimalIndex = index;
						manager.launchFeedAnimal2();
						finishedWindow();
					}
				}
				else {
						feedback.setText("Please enter a valid number");
					}
				}
			});
		
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nextButton.setBounds(365, 201, 96, 44);
		window.getContentPane().add(nextButton);
		
		JLabel label = new JLabel("Enter the number corresponding");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(297, 97, 236, 37);
		window.getContentPane().add(label);
		
		JLabel lblToTheAnimal = new JLabel("to the animal.");
		lblToTheAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheAnimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToTheAnimal.setBounds(351, 118, 123, 37);
		window.getContentPane().add(lblToTheAnimal);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchCropAndAnimalStatus();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(504, 376, 96, 56);
		window.getContentPane().add(backButton);
		}
	}
}
