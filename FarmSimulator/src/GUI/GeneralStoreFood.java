package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextArea;

import food.Carrots;
import food.Hay;
import food.Seeds;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneralStoreFood {

	private JFrame window;
	private GameManager manager;
	
	public GeneralStoreFood(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGeneralStoreFood(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreFood window = new GeneralStoreFood();
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
	public GeneralStoreFood() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("General Store - Food");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblCarrot = new JLabel("Carrot:");
		lblCarrot.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCarrot.setBounds(58, 84, 110, 59);
		window.getContentPane().add(lblCarrot);
		
		JSlider carrotSlider = new JSlider();
		carrotSlider.setValue(1);
		carrotSlider.setSnapToTicks(true);
		carrotSlider.setPaintTicks(true);
		carrotSlider.setMinorTickSpacing(1);
		carrotSlider.setMinimum(1);
		carrotSlider.setMaximum(5);
		carrotSlider.setMajorTickSpacing(2);
		carrotSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		carrotSlider.setBounds(23, 154, 200, 19);
		window.getContentPane().add(carrotSlider);
		
		JTextArea feedback = new JTextArea();
		feedback.setEditable(false);
		feedback.setBounds(385, 96, 231, 246);
		window.getContentPane().add(feedback);
		
		JLabel lblSeeds = new JLabel("Seeds:");
		lblSeeds.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSeeds.setBounds(58, 209, 110, 59);
		window.getContentPane().add(lblSeeds);
		
		JSlider seedsSlider = new JSlider();
		seedsSlider.setValue(1);
		seedsSlider.setSnapToTicks(true);
		seedsSlider.setPaintTicks(true);
		seedsSlider.setMinorTickSpacing(1);
		seedsSlider.setMinimum(1);
		seedsSlider.setMaximum(5);
		seedsSlider.setMajorTickSpacing(2);
		seedsSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		seedsSlider.setBounds(23, 279, 200, 19);
		window.getContentPane().add(seedsSlider);
		
		JLabel lblHay = new JLabel("Hay:");
		lblHay.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHay.setBounds(58, 332, 110, 59);
		window.getContentPane().add(lblHay);
		
		JSlider haySlider = new JSlider();
		haySlider.setValue(1);
		haySlider.setSnapToTicks(true);
		haySlider.setPaintTicks(true);
		haySlider.setMinorTickSpacing(1);
		haySlider.setMinimum(1);
		haySlider.setMaximum(5);
		haySlider.setMajorTickSpacing(2);
		haySlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		haySlider.setBounds(23, 402, 200, 19);
		window.getContentPane().add(haySlider);
		
		JButton hayButton = new JButton("Buy");
		hayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= haySlider.getValue(); i += 1) {
					manager.playerFarm.buyFood(new Hay());
					feedback.append("\n" + manager.playerFarm.output);
				}
			}
		});
		hayButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		hayButton.setBounds(233, 381, 104, 51);
		window.getContentPane().add(hayButton);
		
		JButton seedsButton = new JButton("Buy");
		seedsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= seedsSlider.getValue(); i += 1) {
					manager.playerFarm.buyFood(new Seeds());
					feedback.append("\n" + manager.playerFarm.output);
				}
			}
		});
		seedsButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		seedsButton.setBounds(233, 257, 104, 51);
		window.getContentPane().add(seedsButton);
		
		JButton carrotButton = new JButton("Buy");
		carrotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= carrotSlider.getValue(); i += 1) {
					manager.playerFarm.buyFood(new Carrots());
					feedback.append("\n" + manager.playerFarm.output);
				}
			}
		});
		carrotButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		carrotButton.setBounds(233, 134, 104, 51);
		window.getContentPane().add(carrotButton);
		
		JLabel lblWhichFoodAnd = new JLabel("Which food, and how much do you want to purchase?");
		lblWhichFoodAnd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWhichFoodAnd.setBounds(20, 11, 606, 51);
		window.getContentPane().add(lblWhichFoodAnd);
		
		
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
	}

}
