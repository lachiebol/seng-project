package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Items.CropItem;
import animal.Animal;
import crops.Crop;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TendToCrop2 {

	private JFrame window;
	private JTextField textField;
	private GameManager manager;
	private int cropIndex;
	private Crop currentCrop;
	
	public TendToCrop2(GameManager incomingManager) {
		manager = incomingManager;
		currentCrop = manager.playerFarm.listOfCrops.get(cropIndex);
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeTendToCrop2(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TendToCrop2 window = new TendToCrop2();
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
	public TendToCrop2() {
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
		
		DefaultListModel<Crop> itemListModel = new DefaultListModel<Crop>();

		itemListModel.addAll(manager.playerFarm.listOfCrops);
		
		JLabel headTextLabel = new JLabel("Which item would you like to use?");
		headTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		headTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headTextLabel.setBounds(10, 11, 604, 25);
		window.getContentPane().add(headTextLabel);
		
		
		JLabel feedbackLabel = new JLabel("");
		feedbackLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		feedbackLabel.setBounds(81, 394, 398, 36);
		window.getContentPane().add(feedbackLabel);
		
		JList<Crop> listOfItems = new JList<>(itemListModel);
		listOfItems.setBounds(168, 73, 243, 280);
		window.getContentPane().add(listOfItems);
		
		
		if(manager.playerFarm.listOfItems.size() == 0) {
			feedbackLabel.setText("You currently have no items\n\nVisit the general store to buy some");
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
				feedbackLabel.setText("You used ");
			}
		});
		btnTend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTend.setBounds(491, 222, 109, 44);
		window.getContentPane().add(btnTend);

		}
	}
