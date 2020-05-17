package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TendToCrop2 {

	private JFrame window;
	private JTextField textField;
	private GameManager manager;
	
	public TendToCrop2(GameManager incomingManager) {
		manager = incomingManager;
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
		window.setTitle("Tend to Crop");
		window.setBounds(100, 100, 640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblWhichCropItem = new JLabel("Which crop item would you like to use?");
		lblWhichCropItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhichCropItem.setBounds(22, 11, 370, 31);
		window.getContentPane().add(lblWhichCropItem);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(48, 80, 242, 269);
		window.getContentPane().add(textArea);
		
		JLabel label_1 = new JLabel("Enter the number corresponding");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(310, 110, 236, 37);
		window.getContentPane().add(label_1);
		
		JLabel lblToTheCrop = new JLabel("to the crop item.");
		lblToTheCrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheCrop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToTheCrop.setBounds(364, 131, 123, 37);
		window.getContentPane().add(lblToTheCrop);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(378, 159, 96, 44);
		window.getContentPane().add(textField);
		
		JButton btnTendTo = new JButton("Tend To");
		btnTendTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTendTo.setBounds(364, 214, 123, 44);
		window.getContentPane().add(btnTendTo);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(329, 281, 196, 68);
		window.getContentPane().add(textArea_1);
		
		JButton button_1 = new JButton("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(520, 358, 96, 56);
		window.getContentPane().add(button_1);
	}

}
