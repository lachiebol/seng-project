package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PlayWithAnimal {

	private JFrame frmPlayWithAnimal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayWithAnimal window = new PlayWithAnimal();
					window.frmPlayWithAnimal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayWithAnimal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayWithAnimal = new JFrame();
		frmPlayWithAnimal.setTitle("Play with Animal");
		frmPlayWithAnimal.setBounds(100, 100, 640, 480);
		frmPlayWithAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayWithAnimal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which animal would you like to play with?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 27, 384, 44);
		frmPlayWithAnimal.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(41, 82, 267, 309);
		frmPlayWithAnimal.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(404, 169, 96, 44);
		frmPlayWithAnimal.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Play!");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(404, 224, 96, 44);
		frmPlayWithAnimal.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(502, 364, 96, 56);
		frmPlayWithAnimal.getContentPane().add(btnNewButton_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(355, 279, 196, 68);
		frmPlayWithAnimal.getContentPane().add(textArea_1);
	}
}
