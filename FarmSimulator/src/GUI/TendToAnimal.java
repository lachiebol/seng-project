package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TendToAnimal {

	private JFrame window;
	private JTextField textField;
	private GameManager manager;
	
	public TendToAnimal(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeTendToAnimal(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TendToAnimal window = new TendToAnimal();
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
	public TendToAnimal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Tend to Animal");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which animal would you like to tend to?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 29, 370, 31);
		window.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Enter the number corresponding");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(310, 128, 236, 37);
		window.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("to the animal.");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(364, 149, 123, 37);
		window.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(378, 177, 96, 44);
		window.getContentPane().add(textField);
		
		JButton btnTendTo = new JButton("Tend to");
		btnTendTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendTo.setBounds(364, 232, 123, 44);
		window.getContentPane().add(btnTendTo);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(329, 299, 196, 68);
		window.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(48, 98, 242, 269);
		window.getContentPane().add(textArea_1);
		
		JButton button_1 = new JButton("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(520, 376, 96, 56);
		window.getContentPane().add(button_1);
	}

}
