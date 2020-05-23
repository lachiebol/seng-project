package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextArea;

import Items.*;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneralStoreCropItems {

	private JFrame window;
	private GameManager manager;
	
	public GeneralStoreCropItems(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGeneralStoreCropItems(this);
	}

	/**
	 * Launch the application.
	 * @param args .
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreCropItems window = new GeneralStoreCropItems();
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
	public GeneralStoreCropItems() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("General Store - Crop Items");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JTextArea feedback = new JTextArea();
		feedback.setEditable(false);
		feedback.setBounds(385, 124, 231, 246);
		window.getContentPane().add(feedback);
		
		JLabel moneyLabel = new JLabel("Money: $" + Integer.toString(manager.playerFarm.money));
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		moneyLabel.setBounds(385, 73, 218, 25);
		window.getContentPane().add(moneyLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchGeneralStore();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		backButton.setBounds(499, 381, 117, 51);
		window.getContentPane().add(backButton);
		
		JLabel lblWhichCropItem = new JLabel("Which crop item, and how many do you want to purchase?");
		lblWhichCropItem.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblWhichCropItem.setBounds(10, 11, 616, 51);
		window.getContentPane().add(lblWhichCropItem);
		
		JLabel lblAutomaticSprinkler = new JLabel("Scarecrow - $5:");
		lblAutomaticSprinkler.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAutomaticSprinkler.setBounds(20, 73, 260, 59);
		window.getContentPane().add(lblAutomaticSprinkler);
		
		JSlider scarecrowSlider = new JSlider();
		scarecrowSlider.setPaintLabels(true);
		scarecrowSlider.setValue(1);
		scarecrowSlider.setSnapToTicks(true);
		scarecrowSlider.setPaintTicks(true);
		scarecrowSlider.setMinorTickSpacing(1);
		scarecrowSlider.setMinimum(1);
		scarecrowSlider.setMaximum(5);
		scarecrowSlider.setMajorTickSpacing(1);
		scarecrowSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scarecrowSlider.setBounds(20, 130, 200, 42);
		window.getContentPane().add(scarecrowSlider);
		
		JLabel lblAutomaticSprinkler_1 = new JLabel("Automatic Sprinkler - $10:");
		lblAutomaticSprinkler_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAutomaticSprinkler_1.setBounds(20, 196, 314, 59);
		window.getContentPane().add(lblAutomaticSprinkler_1);
		
		JSlider sprinklerSlider = new JSlider();
		sprinklerSlider.setPaintLabels(true);
		sprinklerSlider.setValue(1);
		sprinklerSlider.setSnapToTicks(true);
		sprinklerSlider.setPaintTicks(true);
		sprinklerSlider.setMinorTickSpacing(1);
		sprinklerSlider.setMinimum(1);
		sprinklerSlider.setMaximum(5);
		sprinklerSlider.setMajorTickSpacing(1);
		sprinklerSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sprinklerSlider.setBounds(20, 254, 200, 42);
		window.getContentPane().add(sprinklerSlider);
		
		JLabel lblFertilizer = new JLabel("Fertilizer - $15:");
		lblFertilizer.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblFertilizer.setBounds(20, 319, 218, 59);
		window.getContentPane().add(lblFertilizer);
		
		JSlider fertilizerSlider = new JSlider();
		fertilizerSlider.setPaintLabels(true);
		fertilizerSlider.setValue(1);
		fertilizerSlider.setSnapToTicks(true);
		fertilizerSlider.setPaintTicks(true);
		fertilizerSlider.setMinorTickSpacing(1);
		fertilizerSlider.setMinimum(1);
		fertilizerSlider.setMaximum(5);
		fertilizerSlider.setMajorTickSpacing(1);
		fertilizerSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		fertilizerSlider.setBounds(20, 378, 200, 42);
		window.getContentPane().add(fertilizerSlider);
		
		JButton fertilizerButton = new JButton("Buy");
		fertilizerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= fertilizerSlider.getValue(); i += 1) {
					manager.playerFarm.buyCropItem(new Fertilizer());
					feedback.append("\n" + manager.playerFarm.output);
				}
				moneyLabel.setText("Money: $" + Integer.toString(manager.playerFarm.money));
			}
		});
		fertilizerButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		fertilizerButton.setBounds(230, 378, 104, 51);
		window.getContentPane().add(fertilizerButton);
		
		JButton sprinklerButton = new JButton("Buy");
		sprinklerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= sprinklerSlider.getValue(); i += 1) {
					manager.playerFarm.buyCropItem(new AutomaticSprinkler());
					feedback.append("\n" + manager.playerFarm.output);
				}
				moneyLabel.setText("Money: $" + Integer.toString(manager.playerFarm.money));
			}
		});
		sprinklerButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		sprinklerButton.setBounds(230, 254, 104, 51);
		window.getContentPane().add(sprinklerButton);
		
		JButton scarecrowButton = new JButton("Buy");
		scarecrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= scarecrowSlider.getValue(); i += 1) {
					manager.playerFarm.buyCropItem(new ScareCrow());
					feedback.append("\n" + manager.playerFarm.output);
				}
				moneyLabel.setText("Money: $" + Integer.toString(manager.playerFarm.money));
			}
		});
		scarecrowButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		scarecrowButton.setBounds(230, 121, 104, 51);
		window.getContentPane().add(scarecrowButton);
	}

}
