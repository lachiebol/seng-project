package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndScreen {

	private JFrame window;
	private GameManager manager;
	
	public EndScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeEndScreen(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndScreen window = new EndScreen();
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
	public EndScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Congratulations, you have clocked Farm Game!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(90, 58, 446, 48);
		window.getContentPane().add(lblNewLabel);
		
		JLabel profitLabel = new JLabel("");
		profitLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profitLabel.setBounds(153, 148, 370, 48);
		window.getContentPane().add(profitLabel);
		profitLabel.setText("You finished the game with $" + Integer.toString(manager.playerFarm.money));
		
		JButton closeGameButton = new JButton("Close Game");
		closeGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		closeGameButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		closeGameButton.setBounds(235, 244, 154, 68);
		window.getContentPane().add(closeGameButton);
	}

}
