package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FeedAnimal2 {

	private JFrame frmFeedAnimal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedAnimal2 window = new FeedAnimal2();
					window.frmFeedAnimal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FeedAnimal2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFeedAnimal = new JFrame();
		frmFeedAnimal.setTitle("Feed Animal");
		frmFeedAnimal.setBounds(100, 100, 640, 480);
		frmFeedAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeedAnimal.getContentPane().setLayout(null);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to feed this animal?");
		lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhatWouldYou.setBounds(25, 24, 380, 32);
		frmFeedAnimal.getContentPane().add(lblWhatWouldYou);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 67, 242, 314);
		frmFeedAnimal.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(365, 146, 96, 44);
		frmFeedAnimal.getContentPane().add(textField);
		
		JButton btnFeed = new JButton("Feed");
		btnFeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFeed.setBounds(365, 201, 96, 44);
		frmFeedAnimal.getContentPane().add(btnFeed);
		
		JLabel lblNewLabel = new JLabel("Enter the number corresponding");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(297, 97, 236, 37);
		frmFeedAnimal.getContentPane().add(lblNewLabel);
		
		JLabel lblToTheFood = new JLabel("to the food.");
		lblToTheFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheFood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToTheFood.setBounds(365, 116, 96, 37);
		frmFeedAnimal.getContentPane().add(lblToTheFood);
		
		JButton button_1 = new JButton("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(507, 362, 96, 56);
		frmFeedAnimal.getContentPane().add(button_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(313, 256, 196, 68);
		frmFeedAnimal.getContentPane().add(textArea_1);
	}

}
