package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FeedAnimal {

	private JFrame window;
	private JTextField textField;
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
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(35, 67, 242, 269);
		window.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(365, 146, 96, 44);
		window.getContentPane().add(textField);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNext.setBounds(365, 201, 96, 44);
		window.getContentPane().add(btnNext);
		
		JLabel label = new JLabel("Enter the number corresponding");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(297, 97, 236, 37);
		window.getContentPane().add(label);
		
		JLabel lblToTheAnimal = new JLabel("to the animal.");
		lblToTheAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheAnimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToTheAnimal.setBounds(351, 118, 123, 37);
		window.getContentPane().add(lblToTheAnimal);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(316, 268, 196, 68);
		window.getContentPane().add(textArea_1);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(504, 376, 96, 56);
		window.getContentPane().add(button);
	}

}
