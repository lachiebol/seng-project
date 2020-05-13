package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TendToCrop {

	private JFrame frmTendToCrop;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TendToCrop window = new TendToCrop();
					window.frmTendToCrop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TendToCrop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTendToCrop = new JFrame();
		frmTendToCrop.setTitle("Tend to Crop");
		frmTendToCrop.setBounds(100, 100, 640, 480);
		frmTendToCrop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTendToCrop.getContentPane().setLayout(null);
		
		JLabel lblWhichCropWould = new JLabel("Which crop would you like to tend to?");
		lblWhichCropWould.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhichCropWould.setBounds(10, 29, 370, 31);
		frmTendToCrop.getContentPane().add(lblWhichCropWould);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(36, 98, 242, 269);
		frmTendToCrop.getContentPane().add(textArea);
		
		JLabel label_1 = new JLabel("Enter the number corresponding");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(298, 128, 236, 37);
		frmTendToCrop.getContentPane().add(label_1);
		
		JLabel lblToTheCrop = new JLabel("to the crop.");
		lblToTheCrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheCrop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToTheCrop.setBounds(352, 149, 123, 37);
		frmTendToCrop.getContentPane().add(lblToTheCrop);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(366, 177, 96, 44);
		frmTendToCrop.getContentPane().add(textField);
		
		JButton button = new JButton("Next");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(366, 232, 96, 44);
		frmTendToCrop.getContentPane().add(button);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(317, 299, 196, 68);
		frmTendToCrop.getContentPane().add(textArea_1);
		
		JButton button_1 = new JButton("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(508, 376, 96, 56);
		frmTendToCrop.getContentPane().add(button_1);
	}

}
