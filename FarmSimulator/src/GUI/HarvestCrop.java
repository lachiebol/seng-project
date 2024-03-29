package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import crops.Crop;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class HarvestCrop {

	private JFrame window;
	private GameManager manager;
	
	public HarvestCrop(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeHarvestCrop(this);
	}

	/**
	 * Launch the application.
	 * @param args .
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HarvestCrop window = new HarvestCrop();
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
	public HarvestCrop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Tend to Crop");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		
		DefaultListModel<Crop> cropListModel = new DefaultListModel<Crop>();

		cropListModel.addAll(manager.playerFarm.listOfCrops);
		
		JLabel feedbackLabel = new JLabel("");
		feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		feedbackLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		feedbackLabel.setBounds(60, 401, 436, 31);
		window.getContentPane().add(feedbackLabel);
		
		JTextArea remainingTimes = new JTextArea();
		remainingTimes.setFont(new Font("Tahoma", Font.BOLD, 13));
		remainingTimes.setEditable(false);
		remainingTimes.setBounds(331, 106, 87, 259);
		window.getContentPane().add(remainingTimes);
		for (Crop crop : manager.playerFarm.listOfCrops) {
			remainingTimes.append(" " + Integer.toString(crop.daysToHarvest) + "\n");
		}		
		
		
		JList<Crop> listOfCrops = new JList<>(cropListModel);
		listOfCrops.setBounds(126, 106, 205, 259);
		window.getContentPane().add(listOfCrops);
		
		JLabel moneyLabel = new JLabel("Money: $" + manager.playerFarm.money);
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		moneyLabel.setBounds(450, 130, 154, 31);
		window.getContentPane().add(moneyLabel);
		
		
		JLabel lblWhichCropWould = new JLabel("Which crop would you like to harvest?");
		lblWhichCropWould.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhichCropWould.setBounds(126, 31, 370, 31);
		window.getContentPane().add(lblWhichCropWould);
		
		if(manager.playerFarm.listOfCrops.size() == 0) {
			feedbackLabel.setText("You currently have no crops, visit the general store to buy some");
		}
		
		JButton btnHarvest = new JButton("Harvest\r\n");
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (manager.playerFarm.listOfCrops.size() != 0) {
					int cropIndex = listOfCrops.getSelectedIndex();
					Crop currentCrop = manager.playerFarm.listOfCrops.get(cropIndex);
					int initMoney = manager.playerFarm.money;
					
					if (currentCrop.daysToHarvest == 0) {
						manager.playerFarm.harvestCrop(currentCrop);
						cropListModel.remove(cropIndex);
					
						int endMoney = manager.playerFarm.money;
					
						int cost = endMoney - initMoney;
						
						remainingTimes.setText("");
						for (Crop crop : manager.playerFarm.listOfCrops) {
							remainingTimes.append(" " + Integer.toString(crop.daysToHarvest) + "\n");
						}

						feedbackLabel.setText("You harvested " + currentCrop.name + " and sold it for $" + cost);
						moneyLabel.setText("Money: $" + manager.playerFarm.money);
					}
					else {
						feedbackLabel.setText("That crop isn't fully grown yet");
					}
				}else {
					feedbackLabel.setText("You have no crops, visit the general store to buy some");
				}
			}
		});
		btnHarvest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHarvest.setBounds(474, 207, 109, 44);
		window.getContentPane().add(btnHarvest);
		

		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchCropAndAnimalStatus();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(508, 376, 96, 56);
		window.getContentPane().add(backButton);	
				
		JLabel lblNewLabel = new JLabel("  Crop                 Days until Harvest");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(126, 73, 335, 29);
		window.getContentPane().add(lblNewLabel);
				
	}
}
