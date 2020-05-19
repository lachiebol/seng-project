package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarmScreen {

	private JFrame frame;
	private GameManager manager;
	
	public FarmScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeFarmScreen(this);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmScreen window = new FarmScreen();
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
	public FarmScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnWelcomeToYour = new JTextPane();
		txtpnWelcomeToYour.setBackground(SystemColor.menu);
		txtpnWelcomeToYour.setEditable(false);
		txtpnWelcomeToYour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnWelcomeToYour.setText("Welcome to your farm " + manager.name + ", you have " 
				+ manager.playerFarm.actionsRemaining + " actions remaining. What would you like to do?");
		txtpnWelcomeToYour.setBounds(64, 46, 472, 66);
		frame.getContentPane().add(txtpnWelcomeToYour);
		
		JLabel daysLabel = new JLabel("New label");
		daysLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		daysLabel.setBounds(447, 124, 104, 31);
		frame.getContentPane().add(daysLabel);
		daysLabel.setText("Day " + Integer.toString(manager.playerFarm.dayCounter));
		
		JLabel moneyLabel = new JLabel("Money: $" + manager.playerFarm.money);
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		moneyLabel.setBounds(64, 124, 141, 30);
		frame.getContentPane().add(moneyLabel);
		
		JButton btnCropAndAnimals = new JButton("View Crop and Animal Status");
		btnCropAndAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchCropAndAnimalStatus();
				finishedWindow();
			}
		});
		btnCropAndAnimals.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCropAndAnimals.setBounds(64, 165, 201, 73);
		frame.getContentPane().add(btnCropAndAnimals);
		
		JButton btnVisitGeneralStore = new JButton("Visit General Store\r\n");
		btnVisitGeneralStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				manager.launchGeneralStore();
				finishedWindow();
			}
		});
		btnVisitGeneralStore.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVisitGeneralStore.setBounds(66, 268, 199, 73);
		frame.getContentPane().add(btnVisitGeneralStore);
		
		JButton btnMoveOntoNext = new JButton("Move on to next day\r\n");
		if (manager.playerFarm.dayCounter == manager.gameLength) {
			btnMoveOntoNext.setText("End Game");
		}
		btnMoveOntoNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.playerFarm.dayCounter < manager.gameLength) {
					manager.playerFarm.nextDay();
					daysLabel.setText("Day" + manager.playerFarm.dayCounter);
					moneyLabel.setText("Money: $" + manager.playerFarm.money);
					txtpnWelcomeToYour.setText("Welcome to your farm " + manager.name + ", you have " 
					+ manager.playerFarm.actionsRemaining + " actions remaining. What would you like to do?");
					if (manager.playerFarm.dayCounter == manager.gameLength) {
						btnMoveOntoNext.setText("End Game");
					}
				}
				else {
					manager.launchEndScreen();
					finishedWindow();
				}
			}
		});
		btnMoveOntoNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMoveOntoNext.setBounds(335, 268, 201, 73);
		frame.getContentPane().add(btnMoveOntoNext);
		
		JButton btnViewFarmStatus = new JButton("View Farm Status\r\n");
		btnViewFarmStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchFarmStatusScreen();
				finishedWindow();
			}
		});
		btnViewFarmStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewFarmStatus.setBounds(335, 165, 201, 73);
		frame.getContentPane().add(btnViewFarmStatus);
	}
}
