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

	private JFrame frmTendToAnimal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TendToAnimal window = new TendToAnimal();
					window.frmTendToAnimal.setVisible(true);
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
		frmTendToAnimal = new JFrame();
		frmTendToAnimal.setTitle("Tend to Animal");
		frmTendToAnimal.setBounds(100, 100, 640, 480);
		frmTendToAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTendToAnimal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which animal would you like to tend to?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 29, 370, 31);
		frmTendToAnimal.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Enter the number corresponding");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(310, 128, 236, 37);
		frmTendToAnimal.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("to the animal.");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(364, 149, 123, 37);
		frmTendToAnimal.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(378, 177, 96, 44);
		frmTendToAnimal.getContentPane().add(textField);
		
		JButton btnTendTo = new JButton("Tend to");
		btnTendTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendTo.setBounds(364, 232, 123, 44);
		frmTendToAnimal.getContentPane().add(btnTendTo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(329, 299, 196, 68);
		frmTendToAnimal.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(48, 98, 242, 269);
		frmTendToAnimal.getContentPane().add(textArea_1);
		
		JButton button_1 = new JButton("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(520, 376, 96, 56);
		frmTendToAnimal.getContentPane().add(button_1);
	}

}
