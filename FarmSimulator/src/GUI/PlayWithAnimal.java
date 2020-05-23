package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import animal.Animal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayWithAnimal {

	private JFrame window;
	private GameManager manager;
	private JTextField input;
	
	public PlayWithAnimal(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closePlayWithAnimal(this);
	}
	/**
	 * Launch the application.
	 * @param args .
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayWithAnimal window = new PlayWithAnimal();
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
	public PlayWithAnimal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Play with Animal");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which animal would you like to play with?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 27, 384, 44);
		window.getContentPane().add(lblNewLabel);
		
		JTextArea animalList = new JTextArea();
		animalList.setEditable(false);
		animalList.setBounds(41, 104, 170, 287);
		window.getContentPane().add(animalList);
		int i = 1;
		for (Animal animal : manager.playerFarm.listOfAnimals) {
			animalList.append(Integer.toString(i) + "     " + animal.name + "\n");
			i += 1;
		}
		
		JTextArea feedback = new JTextArea();
		feedback.setEditable(false);
		feedback.setBounds(355, 279, 196, 68);
		window.getContentPane().add(feedback);
		
		JTextArea happinessList = new JTextArea();
		happinessList.setEditable(false);
		happinessList.setBounds(211, 104, 107, 287);
		window.getContentPane().add(happinessList);
		for (Animal animal : manager.playerFarm.listOfAnimals) {
			happinessList.append(animal.happiness + "\n");
		}
		
		JButton playButton = new JButton("Play!");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String indexInput = input.getText();
				int index = 0;
				index = Integer.parseInt(indexInput) - 1;
				if ((index < manager.playerFarm.listOfAnimals.size()) && (index >= 0)) {
					manager.playerFarm.listOfAnimals.get(index).playWith(manager.playerFarm);
					feedback.setText(manager.playerFarm.listOfAnimals.get(index).output);
					happinessList.setText("");
					for (Animal animal : manager.playerFarm.listOfAnimals) {
						happinessList.append(animal.happiness + "\n");
					}
				}	
				else {
						feedback.setText("Please enter a valid number");
					}
				}
		});
		
		
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playButton.setBounds(404, 224, 96, 44);
		window.getContentPane().add(playButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchCropAndAnimalStatus();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(502, 364, 96, 56);
		window.getContentPane().add(backButton);
		
		input = new JTextField();
		input.setBounds(404, 169, 96, 44);
		window.getContentPane().add(input);
		input.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Happiness");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(222, 82, 69, 17);
		window.getContentPane().add(lblNewLabel_1);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnimal.setBounds(81, 82, 69, 17);
		window.getContentPane().add(lblAnimal);
	}
}
