package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Items.CropItem;
import Items.WateringCan;
import animal.Animal;
import crops.Crop;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListModel;
import javax.swing.JScrollBar;

public class TendToCrop {

	private JFrame window;
	private GameManager manager;
	
	public TendToCrop(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeTendToCrop(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TendToCrop window = new TendToCrop();
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
	public TendToCrop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Tend to crop");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		DefaultListModel<Crop> cropListModel = new DefaultListModel<Crop>();
		DefaultListModel<CropItem> itemListModel = new DefaultListModel<CropItem>();
		
		cropListModel.addAll(manager.playerFarm.listOfCrops);
		itemListModel.addAll(manager.playerFarm.listOfItems);
		
		
		JLabel headTextLabel = new JLabel("Which crop would you like to tend to?");
		headTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		headTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headTextLabel.setBounds(10, 11, 604, 25);
		window.getContentPane().add(headTextLabel);
		
		
		JLabel feedbackLabel = new JLabel("");
		feedbackLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		feedbackLabel.setBounds(81, 394, 398, 36);
		window.getContentPane().add(feedbackLabel);
		
		JLabel noCropLabel = new JLabel("\r\n");
		noCropLabel.setBounds(23, 380, 196, 14);
		window.getContentPane().add(noCropLabel);
		
		JLabel noItemLabel = new JLabel("");
		noItemLabel.setBounds(261, 380, 199, 14);
		window.getContentPane().add(noItemLabel);
		
		JList<Crop> listOfCrops = new JList<>(cropListModel);
		listOfCrops.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listOfCrops.setBounds(20, 75, 134, 280);
		window.getContentPane().add(listOfCrops);
		
		JList<CropItem> listOfItems = new JList<>(itemListModel);
		listOfItems.setBounds(290, 75, 170, 280);
		window.getContentPane().add(listOfItems);
		
		JTextArea timesRemaining = new JTextArea();
		timesRemaining.setFont(new Font("Tahoma", Font.BOLD, 13));
		timesRemaining.setBounds(154, 75, 84, 280);
		window.getContentPane().add(timesRemaining);
		for (Crop crop: manager.playerFarm.listOfCrops) {
			timesRemaining.append(" " + crop.daysToHarvest + "\n");
		}
		
		
		
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
		
		JButton btnTend = new JButton("Tend to\r\n");
		btnTend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((manager.playerFarm.listOfCrops.size() != 0) && (manager.playerFarm.listOfItems.size() != 0) 
						&& (manager.playerFarm.actionsRemaining > 0)) {
					int cropIndex = listOfCrops.getSelectedIndex();
					int itemIndex = listOfItems.getSelectedIndex();
					Crop currentCrop = manager.playerFarm.listOfCrops.get(cropIndex);
					CropItem currentItem = manager.playerFarm.listOfItems.get(itemIndex);
					
					currentCrop.useItem(currentItem, manager.playerFarm);
					if (currentItem.name != "Watering Can") {
						itemListModel.remove(itemIndex);
					}
					feedbackLabel.setText("You used " + currentItem.name + " on " + currentCrop.name);
					
					timesRemaining.setText("");
					for (Crop crop: manager.playerFarm.listOfCrops) {
						timesRemaining.append(" " + crop.daysToHarvest + "\n");
					}
				}else {
					if(manager.playerFarm.listOfCrops.size() == 0){
						noCropLabel.setText("You have no crops.");
					}

					
					if (manager.playerFarm.actionsRemaining == 0) {
						feedbackLabel.setText("You have no actions remaining today");
					}
				}
			}
			
		});
		btnTend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTend.setBounds(505, 188, 109, 44);
		window.getContentPane().add(btnTend);
		
		JLabel cropLabel = new JLabel("Crop        Time until Harvest");
		cropLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cropLabel.setBounds(20, 43, 272, 36);
		window.getContentPane().add(cropLabel);
		
		JLabel itemLabel = new JLabel("Item");
		itemLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		itemLabel.setBounds(345, 47, 56, 28);
		window.getContentPane().add(itemLabel);
		

		}
	}

