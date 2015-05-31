package main;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI {

	private final int width = 500;
	private final int height = 500;
	private JFrame frame;
	private JTextArea stren;
	private JTextArea weak;
	private JTextArea oper;
	private JTextArea threat;
	private JTextArea desc;
	private JButton add;
	private JButton go;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int x = 0;
		int y = 0;
		int w = 0;
		int h = 0;
		
		frame = new JFrame();
		frame.setBounds(100, 100, height, width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		x = (int)(width * .02);
		y = (int)(height * .02);
	}

}
