package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import animal.*;
import crops.*;

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
		
		JTextArea animalList = new JTextArea();
		animalList.setEditable(false);
		animalList.setBounds(16, 51, 270, 151);
		window.getContentPane().add(animalList);
		animalList.setText("Animal" + "     " + "Happiness" + "     " + "Health");
		for (Animal animal : manager.playerFarm.listOfAnimals) {
			animalList.append("\n" + animal.name + "       " + animal.happiness + "                " + animal.health);
		}
		
		JLabel lblTheseAreYour = new JLabel("These are your crops:");
		lblTheseAreYour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTheseAreYour.setBounds(34, 237, 227, 33);
		window.getContentPane().add(lblTheseAreYour);
		
		JTextArea cropList = new JTextArea();
		cropList.setEditable(false);
		cropList.setBounds(20, 281, 266, 151);
		window.getContentPane().add(cropList);
		cropList.setText("Crop" + "     " + "Days Until Harvest");
		for (Crop crop : manager.playerFarm.listOfCrops) {
			cropList.append("\n" + crop.name + "     " + crop.daysToHarvest);
		}
		
		JButton playButton = new JButton("Play with Animal");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchPlayWithAnimal();
				finishedWindow();
			}
		});
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playButton.setBounds(355, 20, 206, 52);
		window.getContentPane().add(playButton);
		
		JButton feedButton = new JButton("Feed Animal");
		feedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFeedAnimal();
				finishedWindow();
			}
		});
		feedButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		feedButton.setBounds(355, 99, 206, 52);
		window.getContentPane().add(feedButton);
		
		JButton tendToCropButton = new JButton("Tend to Crop");
		tendToCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchTendToCrop();
				finishedWindow();
			}
		});
		tendToCropButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tendToCropButton.setBounds(355, 188, 206, 52);
		window.getContentPane().add(tendToCropButton);
		
		JButton harvestCropButton = new JButton("Harvest Crop");
		harvestCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchHarvestCrop();
				finishedWindow();
			}
		});
		harvestCropButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		harvestCropButton.setBounds(355, 273, 206, 52);
		window.getContentPane().add(harvestCropButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFarmScreen();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(355, 380, 206, 52);
		window.getContentPane().add(backButton);
	}

}
