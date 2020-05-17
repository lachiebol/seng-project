package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import crops.*;


public class GeneralStoreCrops {

	private JFrame window;
	private GameManager manager;
	
	public GeneralStoreCrops(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGeneralStoreCrops(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralStoreCrops window = new GeneralStoreCrops();
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
	public GeneralStoreCrops() {
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
		
		JLabel lblWhichCropAnd = new JLabel("Which crop, and how many do you want to purchase?");
		lblWhichCropAnd.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblWhichCropAnd.setBounds(40, 11, 558, 51);
		window.getContentPane().add(lblWhichCropAnd);
		
		JLabel lblCarrot = new JLabel("Carrot:");
		lblCarrot.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCarrot.setBounds(40, 125, 110, 59);
		window.getContentPane().add(lblCarrot);
		
		JLabel lblBeetroot = new JLabel("Beetroot:");
		lblBeetroot.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblBeetroot.setBounds(40, 58, 110, 32);
		window.getContentPane().add(lblBeetroot);
		
		JTextArea feedback = new JTextArea();
		feedback.setEditable(false);
		feedback.setBounds(23, 309, 387, 123);
		window.getContentPane().add(feedback);
		
		JSlider parsnipSlider = new JSlider();
		parsnipSlider.setValue(1);
		parsnipSlider.setSnapToTicks(true);
		parsnipSlider.setPaintTicks(true);
		parsnipSlider.setMinorTickSpacing(1);
		parsnipSlider.setMinimum(1);
		parsnipSlider.setMaximum(5);
		parsnipSlider.setMajorTickSpacing(2);
		parsnipSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		parsnipSlider.setBounds(349, 95, 156, 19);
		window.getContentPane().add(parsnipSlider);
		
		JSlider beetrootSlider = new JSlider();
		beetrootSlider.setValue(1);
		beetrootSlider.setSnapToTicks(true);
		beetrootSlider.setPaintTicks(true);
		beetrootSlider.setMinorTickSpacing(1);
		beetrootSlider.setMinimum(1);
		beetrootSlider.setMaximum(5);
		beetrootSlider.setMajorTickSpacing(2);
		beetrootSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		beetrootSlider.setBounds(23, 95, 156, 19);
		window.getContentPane().add(beetrootSlider);
		
		JSlider carrotSlider = new JSlider();
		carrotSlider.setValue(1);
		carrotSlider.setSnapToTicks(true);
		carrotSlider.setPaintTicks(true);
		carrotSlider.setMinorTickSpacing(1);
		carrotSlider.setMinimum(1);
		carrotSlider.setMaximum(5);
		carrotSlider.setMajorTickSpacing(2);
		carrotSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		carrotSlider.setBounds(23, 175, 156, 19);
		window.getContentPane().add(carrotSlider);
		
		JLabel lblCorn = new JLabel("Corn:");
		lblCorn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCorn.setBounds(40, 205, 110, 59);
		window.getContentPane().add(lblCorn);
		
		JSlider cornSlider = new JSlider();
		cornSlider.setValue(1);
		cornSlider.setSnapToTicks(true);
		cornSlider.setPaintTicks(true);
		cornSlider.setMinorTickSpacing(1);
		cornSlider.setMinimum(1);
		cornSlider.setMaximum(5);
		cornSlider.setMajorTickSpacing(2);
		cornSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cornSlider.setBounds(23, 256, 156, 19);
		window.getContentPane().add(cornSlider);
		
		JButton cornButton = new JButton("Buy");
		cornButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= cornSlider.getValue(); i += 1) {
					manager.playerFarm.buyCrop(new Corn());
					feedback.append(manager.playerFarm.output);
				}
			}
		});
		cornButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cornButton.setBounds(189, 237, 83, 51);
		window.getContentPane().add(cornButton);
		
		JButton carrotButton = new JButton("Buy");
		carrotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= carrotSlider.getValue(); i += 1) {
					manager.playerFarm.buyCrop(new Carrot());
					feedback.append(manager.playerFarm.output);
				}
			}
		});
		carrotButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		carrotButton.setBounds(189, 156, 83, 51);
		window.getContentPane().add(carrotButton);
		
		JButton beetrootButton = new JButton("Buy");
		beetrootButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= beetrootSlider.getValue(); i += 1) {
					manager.playerFarm.buyCrop(new Beetroot());
					feedback.append(manager.playerFarm.output);
				}
			}
		});
		beetrootButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		beetrootButton.setBounds(189, 74, 83, 51);
		window.getContentPane().add(beetrootButton);
		
		JSlider wheatSlider = new JSlider();
		wheatSlider.setValue(1);
		wheatSlider.setSnapToTicks(true);
		wheatSlider.setPaintTicks(true);
		wheatSlider.setMinorTickSpacing(1);
		wheatSlider.setMinimum(1);
		wheatSlider.setMaximum(5);
		wheatSlider.setMajorTickSpacing(2);
		wheatSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		wheatSlider.setBounds(349, 256, 156, 19);
		window.getContentPane().add(wheatSlider);
		
		JButton wheatButton = new JButton("Buy");
		wheatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= wheatSlider.getValue(); i += 1) {
					manager.playerFarm.buyCrop(new Wheat());
					feedback.append(manager.playerFarm.output);
				}
			}
		});
		wheatButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		wheatButton.setBounds(515, 237, 83, 51);
		window.getContentPane().add(wheatButton);
		
		JLabel lblWheat = new JLabel("Wheat:");
		lblWheat.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWheat.setBounds(366, 205, 110, 59);
		window.getContentPane().add(lblWheat);
		
		JLabel lblPotato = new JLabel("Potato:");
		lblPotato.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPotato.setBounds(366, 125, 110, 59);
		window.getContentPane().add(lblPotato);
		
		JSlider potatoSlider = new JSlider();
		potatoSlider.setValue(1);
		potatoSlider.setSnapToTicks(true);
		potatoSlider.setPaintTicks(true);
		potatoSlider.setMinorTickSpacing(1);
		potatoSlider.setMinimum(1);
		potatoSlider.setMaximum(5);
		potatoSlider.setMajorTickSpacing(2);
		potatoSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		potatoSlider.setBounds(349, 175, 156, 19);
		window.getContentPane().add(potatoSlider);
		
		JButton potatoButton = new JButton("Buy");
		potatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= potatoSlider.getValue(); i += 1) {
					manager.playerFarm.buyCrop(new Potato());
					feedback.append(manager.playerFarm.output);
				}
			}
		});
		potatoButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		potatoButton.setBounds(515, 156, 83, 51);
		window.getContentPane().add(potatoButton);
		
		JButton parsnipButton = new JButton("Buy");
		parsnipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback.setText("");
				for (int i = 1 ; i <= parsnipSlider.getValue(); i += 1) {
					manager.playerFarm.buyCrop(new Parsnip());
					feedback.append(manager.playerFarm.output);
				}
			}
		});
		parsnipButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		parsnipButton.setBounds(515, 74, 83, 51);
		window.getContentPane().add(parsnipButton);
		
		
		JLabel lblParsnip = new JLabel("Parsnip:");
		lblParsnip.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblParsnip.setBounds(366, 58, 110, 32);
		window.getContentPane().add(lblParsnip);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchGeneralStore();
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		backButton.setBounds(481, 381, 117, 51);
		window.getContentPane().add(backButton);
	}

}
